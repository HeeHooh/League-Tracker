package com.example.demo.riotapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.couchbase.CouchbaseProperties.Env;
import org.springframework.context.expression.EnvironmentAccessor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.merakianalytics.orianna.Orianna;
import com.merakianalytics.orianna.datapipeline.riotapi.RiotAPI;
import com.merakianalytics.orianna.types.common.Queue;
import com.merakianalytics.orianna.types.common.Region;
import com.merakianalytics.orianna.types.core.league.League;
import com.merakianalytics.orianna.types.core.league.LeaguePositions;
import com.merakianalytics.orianna.types.core.league.Leagues;
import com.merakianalytics.orianna.types.core.summoner.Summoner;
import com.merakianalytics.orianna.types.core.summoner.Summoners;
import com.merakianalytics.orianna.types.dto.league.LeagueEntries;

@RestController
@RequestMapping(path = "summoner")
public class SummonerInfoController {
	@Autowired
	private Environment env;


    @GetMapping
	public Summoner getSummonerInfo(){
		String api_key = env.getProperty("riot.apikey");
		Orianna.setRiotAPIKey(api_key);
		Orianna.setDefaultRegion(Region.NORTH_AMERICA);

		Summoner summoner = Orianna.summonerNamed("watar").get();
		System.out.println(summoner.getName() + " is level " + summoner.getLevel() + " on the " + summoner.getRegion() + " server.");

		return summoner;
	}
}
