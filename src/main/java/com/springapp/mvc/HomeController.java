package com.springapp.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import util.PopulateStats;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/assignment2")
public class HomeController {

    @RequestMapping(method = RequestMethod.GET)
    public String getHomePage(HttpServletRequest request) {

        if(request.getSession().getAttribute("userLoggedIn") != null){
            return "home";
        }else{
            return "redirect:/login";
        }

    }
}
