package com.socc.scrp.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Team {
    private final String name;

    @Override
    public String toString() {
        return name;
    }
}
