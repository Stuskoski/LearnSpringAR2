package com.springapp.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import util.PopulateStats;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping(value = "/stats")
public class StatsController {

    @RequestMapping(method = RequestMethod.GET)
    public String getStatsPage(ModelMap modelMap, HttpServletRequest request){

        if(request.getSession().getAttribute("userLoggedIn") != null){
            modelMap.addAttribute("stats", PopulateStats.getStats());
            return "stats";
        }else{
            return "redirect:/login";
        }
    }
}
