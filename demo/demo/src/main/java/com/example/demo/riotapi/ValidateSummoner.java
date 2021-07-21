package com.example.demo.riotapi;

import com.merakianalytics.orianna.types.common.Region;
import com.merakianalytics.orianna.types.core.summoner.Summoner;
import com.merakianalytics.orianna.types.core.summoner.Summoners;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

public class ValidateSummoner {
    
    public boolean isValidSummoner(String summonerID){
        Summoner summoner = Summoner.named(summonerID).withRegion(Region.NORTH_AMERICA).get();
        if(summoner.getPuuid() == null)
            return false;
        return true;
    }
}
