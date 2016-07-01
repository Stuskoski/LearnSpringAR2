package com.springapp.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * Created by r730819 on 6/22/2016.
 */

@Controller
@RequestMapping("/viewCustomers")
public class DatabaseViewCustomersController {
    @RequestMapping(method = RequestMethod.GET)
    public String getViewCustomersPage(HttpServletRequest request){

        if(request.getSession().getAttribute("userLoggedIn") != null){
            return "viewCustomers";
        }else{
            return "redirect:/login";
        }
    }
}
