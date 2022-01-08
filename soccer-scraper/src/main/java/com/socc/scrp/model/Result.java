package com.socc.scrp.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Result {
    private final Integer homeTeamGoals;
    private final Integer awayTeamGoals;
    private final Integer homeTeamGoalsAtHalfTime;
    private final Integer awayTeamGoalsAtHalfTime;

    @Override
    public String toString() {
        return homeTeamGoals + ":" + awayTeamGoals + " (" + homeTeamGoalsAtHalfTime + ":" + awayTeamGoalsAtHalfTime + ")";
    }
}
