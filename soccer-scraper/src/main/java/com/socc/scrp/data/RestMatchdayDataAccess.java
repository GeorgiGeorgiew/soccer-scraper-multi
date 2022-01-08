package com.socc.scrp.data;

import com.socc.scrp.model.Match;
import com.socc.scrp.model.Matchday;
import com.socc.scrp.model.Result;
import com.socc.scrp.model.Team;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RestMatchdayDataAccess implements MatchdayDataAccess {

    private static final String BASE_URI = "https://www.kicker.de/bundesliga/spieltag";

    private static final String DIV_TEAM_NAME = "div.kick__v100-gameCell__team__name";

    private static final String DIV_SCORE = "div.kick__v100-scoreBoard__scoreHolder__score";

    @Override
    public Matchday getMatchday(String season, String gameday) {
        List<Match> matches = new ArrayList<>();
        List<Team> teams = new ArrayList<>();
        List<String> scores = new ArrayList<>();
        List<Result> results = new ArrayList<>();
        String uri = BASE_URI + "/" + season + "/" + gameday;
        try {
            Connection.Response resp = Jsoup.connect(uri).followRedirects(false).execute();
            if(resp.statusCode() != 200) {
                return new Matchday(new ArrayList<>());
            }
            Document doc = resp.parse();
            doc.select(DIV_TEAM_NAME).forEach(e -> teams.add(new Team(e.text())));
            doc.select(DIV_SCORE).forEach(e -> scores.add(e.text()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(int i = 0; i < scores.size(); i = i + 4) {
            Result result = new Result(Integer.valueOf(scores.get(i)), Integer.valueOf(scores.get(i + 1)),
                    Integer.valueOf(scores.get(i + 2)), Integer.valueOf(scores.get(i+3)));
            results.add(result);
        }

        int resultsCounter = 0;
        for(int i = 0; i < teams.size(); i = i + 2) {
            Match match = new Match(teams.get(i), teams.get(i+1), null,
                    resultsCounter < results.size() ? results.get(resultsCounter) : null);
            resultsCounter = resultsCounter + 1;
            matches.add(match);
        }
        return new Matchday(matches);
    }
}
