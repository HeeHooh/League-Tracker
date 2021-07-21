package com.example.demo.riotapi;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.couchbase.CouchbaseProperties.Env;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;


import jdk.jfr.ValueDescriptor;


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

@Controller
public class SummonerInfoController {
	
	@Autowired
	private Environment env;

	private ValidateSummoner validateSummoner;

	@GetMapping("/summoner")
	public String findSummoner(Model model){
		Orianna.setRiotAPIKey(env.getProperty("riot.apikey"));
		Orianna.setDefaultRegion(Region.NORTH_AMERICA);
		model.addAttribute("summoner", new SummonerInfo());
		return "summoner";
	}

	@PostMapping("/summoner")
	public String searchSummoner(Model model, @ModelAttribute SummonerInfo summonerInfo){

		model.addAttribute("summoner", summonerInfo);
		
		return "results";
	}
}
