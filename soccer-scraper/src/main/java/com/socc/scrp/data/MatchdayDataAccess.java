package com.socc.scrp.data;

import com.socc.scrp.model.Matchday;

public interface MatchdayDataAccess {

    Matchday getMatchday(String season, String gameday);
}
