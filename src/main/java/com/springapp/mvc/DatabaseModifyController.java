package com.springapp.mvc;

import databaseActions.GetCustomersFromDatabase;
import databaseActions.ModifyDatabaseMethods;
import enums.DatabaseCommands;
import fileActions.CustomLogger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by r730819 on 6/22/2016.
 */

@Controller
@RequestMapping("/modifyDB")
public class DatabaseModifyController {
    @RequestMapping(method = RequestMethod.GET)
    public String getModifyDBPage() {
        return "modify";
    }

    @RequestMapping("/createDB")
    public String  createDatabase(){
        //GetCustomersFromDatabase.getCustomers();
        ModifyDatabaseMethods.makeClearDeleteDB(DatabaseCommands.CREATE);

        return "modify";
    }

    @RequestMapping("/clearDB")
    public String clearDatabase(){
        ModifyDatabaseMethods.makeClearDeleteDB(DatabaseCommands.CLEAR);

        return "modify";
    }

    @RequestMapping("/deleteDB")
    public String deleteDatabase(){
        ModifyDatabaseMethods.makeClearDeleteDB(DatabaseCommands.DELETE);

        return "modify";
    }
}
