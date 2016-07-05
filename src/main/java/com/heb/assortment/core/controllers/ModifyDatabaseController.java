package com.heb.assortment.core.controllers;

import com.heb.assortment.util.databaseActions.ModifyDatabaseMethods;
import com.heb.assortment.util.enums.DatabaseCommands;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by r730819 on 6/22/2016.
 *
 * Modify Database controller that handles
 * the three types of requests when attempting
 * to modify the database.
 *
 * 1) Create the database
 * 2) Clear or truncate the database
 * 3) Delete or drop the database
 */


@Controller
@RequestMapping("/modifyDB")
public class ModifyDatabaseController {

    /**
     * Base controller to simply
     * display the page with the 3
     * buttons for modify database
     * actions
     *
     * @param request Check for user session
     * @return The page view for modify Database
     *         methods
     */
    @RequestMapping(method = RequestMethod.GET)
    public String getModifyDBPage(HttpServletRequest request) {
        if(request.getSession().getAttribute("userLoggedIn") != null){
            return "modify";
        }else{
            return "redirect:/login";
        }
    }

    /**
     * Controller to create the database
     *
     * @param request User session check
     * @return Back to base modify page
     *         or a redirect to login page
     */
    @RequestMapping("/createDB")
    public String  createDatabase(HttpServletRequest request){
        if(request.getSession().getAttribute("userLoggedIn") != null){
            ModifyDatabaseMethods.makeClearDeleteDB(DatabaseCommands.CREATE);
            return "modify";
        }else{
            return "redirect:/login";
        }
    }

    /**
     * Controller to clear or truncate
     * the database
     *
     * @param request Check for user session
     * @return Returns base page view or a direct
     *         to login page
     */
    @RequestMapping("/clearDB")
    public String clearDatabase(HttpServletRequest request){
        if(request.getSession().getAttribute("userLoggedIn") != null){
            ModifyDatabaseMethods.makeClearDeleteDB(DatabaseCommands.CLEAR);
            return "modify";
        }else{
            return "redirect:/login";
        }
    }

    /**
     * Controller to delete or drop the
     * customer database
     *
     * @param request User session check ... Should of use spring security, less typing
     * @return Page view or redirect based on user session availability
     */
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
