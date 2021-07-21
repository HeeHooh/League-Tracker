package com.example.demo.riotapi;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

import com.merakianalytics.orianna.Orianna;
import com.merakianalytics.orianna.types.common.Region;

public class RegionSelectorController {
    public RegionSelectorController(){
        Orianna.setDefaultRegion(Region.NORTH_AMERICA);
    }
    
    protected HashMap regionData(HttpServletRequest request) throws Exception{
        Map regionMap = new HashMap();
        Map<String, String> region = new LinkedHashMap<String, String>();
        return null;
    }
}
