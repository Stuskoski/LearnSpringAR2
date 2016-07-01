package com.springapp.mvc;

import databaseActions.ModifyDatabaseMethods;
import enums.DatabaseCommands;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by r730819 on 6/22/2016.
 */

@Controller
@RequestMapping("/modifyDB")
public class ModifyDatabaseController {
    @RequestMapping(method = RequestMethod.GET)
    public String getModifyDBPage(HttpServletRequest request) {
        if(request.getSession().getAttribute("userLoggedIn") != null){
            return "modify";
        }else{
            return "redirect:/login";
        }
    }

    @RequestMapping("/createDB")
    public String  createDatabase(HttpServletRequest request){
        if(request.getSession().getAttribute("userLoggedIn") != null){
            ModifyDatabaseMethods.makeClearDeleteDB(DatabaseCommands.CREATE);
            return "modify";
        }else{
            return "redirect:/login";
        }
    }

    @RequestMapping("/clearDB")
    public String clearDatabase(HttpServletRequest request){
        if(request.getSession().getAttribute("userLoggedIn") != null){
            ModifyDatabaseMethods.makeClearDeleteDB(DatabaseCommands.CLEAR);
            return "modify";
        }else{
            return "redirect:/login";
        }
    }

    @RequestMapping("/deleteDB")
    public String deleteDatabase(HttpServletRequest request){
        if(request.getSession().getAttribute("userLoggedIn") != null){
            ModifyDatabaseMethods.makeClearDeleteDB(DatabaseCommands.DELETE);
            return "modify";
        }else{
            return "redirect:/login";
        }
    }
}
