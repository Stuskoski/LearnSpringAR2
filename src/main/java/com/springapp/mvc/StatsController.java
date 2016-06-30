package com.springapp.mvc;

import models.StatsModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import util.GetDatabaseStats;

/**
 * Created by r730819 on 6/29/2016.
 */
@Controller
@RequestMapping(value = "/stats")
public class StatsController {

    @RequestMapping(method = RequestMethod.GET)
    public String getStatsPage(ModelMap modelMap){

        modelMap.addAttribute("stats", GetDatabaseStats.getStatsFromDB());

        return "stats";
    }
}
