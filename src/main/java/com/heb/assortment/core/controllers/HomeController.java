package com.heb.assortment.core.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;

/**
 * Home controller that will grab various
 * base URLs to redirect to the blank
 * home page
 */
@Controller
@RequestMapping(value={"", "/", "/assignment2", "assignment2", "home", "/home"})
public class HomeController {

    /**
     * Controller for home.
     * Receives GET request
     *
     * @param request Check if user has session variable
     * @return Home page view or redirect to login
     */
    @RequestMapping(method = RequestMethod.GET)
    public String getHomePage(HttpServletRequest request) {

        if(request.getSession().getAttribute("userLoggedIn") != null){
            return "home";
        }else{
            return "redirect:/login";
        }

    }
}
