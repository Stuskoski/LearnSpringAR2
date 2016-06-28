package com.springapp.mvc;

import fileActions.CustomLogger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Logging controller to handle
 * all the logging methods
 *
 * Created by r730819 on 6/22/2016.
 */

@Controller
@RequestMapping("/logging")
public class LoggingController {

    /**
     * Controller to display the
     * logging page.
     *
     * @return "logging" string to display the
     *          correct page
     */
    @RequestMapping(method = RequestMethod.GET)
    public String getLoggingPage(){return "logging";}


    /**
     * Pulls all the logs from the custom logger
     * and outputs them with response body
     *
     * @return All logs
     */
    @RequestMapping(method = RequestMethod.GET, value = "/getLogs")
    public @ResponseBody
    String getAllLogs(){
        return CustomLogger.getLogStringBuilderContentsAsHtml();
    }


    /**
     * Controller to handle a get call to clear all logs
     *
     * @return returns a message stating logs were cleared
     */
    @RequestMapping(method = RequestMethod.GET, value = "/clearLogs")
    public @ResponseBody
    String clearLogs(){
        CustomLogger.clearLogs();
        return "Logs cleared";
    }
}
