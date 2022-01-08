package com.socc.scrp.web;

import com.socc.scrp.data.MatchdayDataAccess;
import com.socc.scrp.data.RestMatchdayDataAccess;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GamedayConfig {

    @Bean
    public MatchdayDataAccess matchdayDataAccess() {
        return new RestMatchdayDataAccess();
    }

}
