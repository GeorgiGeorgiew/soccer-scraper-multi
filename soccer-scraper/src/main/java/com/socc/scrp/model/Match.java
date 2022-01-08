package com.socc.scrp.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.ZonedDateTime;

@RequiredArgsConstructor
@Getter
public class Match {
    private final Team homeTeam;
    private final Team awayTeam;
    private final ZonedDateTime kickoff;
    private final Result result;

    @Override
    public String toString() {
        return (result != null ? result.toString() + " " : "") + homeTeam + " - " + awayTeam;
    }
}
