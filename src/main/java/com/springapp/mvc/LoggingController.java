package com.springapp.mvc;

import fileActions.CustomLogger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;

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
    public String getLoggingPage(HttpServletRequest request){

        if(request.getSession().getAttribute("userLoggedIn") != null){
            return "logging";
        }else{
            return "redirect:/login";
        }
    }


    /**
     * Pulls all the logs from the custom logger
     * and outputs them with response body
     *
     * @return All logs
     */
    @RequestMapping(method = RequestMethod.GET, value = "/getLogs")
    public @ResponseBody
    String getAllLogs(HttpServletRequest request){

        if(request.getSession().getAttribute("userLoggedIn") != null){
            return CustomLogger.getLogStringBuilderContentsAsHtml();
        }else{
            return "please log in";
        }
    }


    /**
     * Controller to handle a get call to clear all logs
     *
     * @return returns a message stating logs were cleared
     */
    @RequestMapping(method = RequestMethod.GET, value = "/clearLogs")
    public @ResponseBody
    String clearLogs(HttpServletRequest request){

        if(request.getSession().getAttribute("userLoggedIn") != null){
            CustomLogger.clearLogs();
            return "Logs cleared";
        }else{
            return "please log in";
        }
    }
}
