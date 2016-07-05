package com.springapp.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import util.PopulateStats;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/stats")
public class StatsController {

    /**
     * Stats controller to populate the stats model
     * and send the model to the page to be displayed
     *
     * @param modelMap where the stats model is contained
     * @param request User session check
     * @return Stats page view or redirect to login
     */
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
