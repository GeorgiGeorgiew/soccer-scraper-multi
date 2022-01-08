package com.socc.scrp.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Getter
public class Matchday {
    private final List<Match> matches;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Match match : matches) {
            sb.append(match);
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}
