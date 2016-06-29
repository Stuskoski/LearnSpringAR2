package com.springapp.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by r730819 on 6/29/2016.
 */
@Controller
@RequestMapping(value = "/stats")
public class StatsController {

    @RequestMapping(method = RequestMethod.GET)
    public String getStats(){
        return "stats";
    }
}
