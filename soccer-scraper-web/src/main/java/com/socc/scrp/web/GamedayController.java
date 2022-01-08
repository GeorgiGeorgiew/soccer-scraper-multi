package com.socc.scrp.web;

import com.socc.scrp.data.MatchdayDataAccess;
import com.socc.scrp.model.Matchday;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/gameday")
public class GamedayController {

    MatchdayDataAccess matchdayDataAccess;

    @Autowired
    public GamedayController(final MatchdayDataAccess matchdayDataAccess) {
        this.matchdayDataAccess = matchdayDataAccess;
    }

    @GetMapping("/{season}/{gameday}")
    public String gameday(@PathVariable("season") final String season, @PathVariable("gameday") final String gameday, Model model) {
        final Matchday matchday = matchdayDataAccess.getMatchday(season, gameday);
        model.addAttribute("matchday", matchday);
        model.addAttribute("season", season);
        model.addAttribute("gameday", gameday);
        return "gameday";
    }
}
