package com.example.demo.riotapi;


import com.merakianalytics.orianna.Orianna;
import com.merakianalytics.orianna.types.core.summoner.Summoner;
import com.merakianalytics.orianna.types.core.summoner.Summoners;

public class SummonerInfo {
    private Summoner summoner;

    public SummonerInfo(){}

    public SummonerInfo(String summonerName){
        this.summoner = Orianna.summonerNamed(summonerName).get();
    }

    public Summoner getSummoner(){ return this.summoner;}

    public void setSummoner(String summonerName){this.summoner = Orianna.summonerNamed(summonerName).get();}

}
