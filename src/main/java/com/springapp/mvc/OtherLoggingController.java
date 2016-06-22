package com.springapp.mvc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by r730819 on 6/22/2016.
 */

@Controller
@RequestMapping("/logging")
public class OtherLoggingController {
    @RequestMapping(method = RequestMethod.GET)
    public String getLoggingPage(){return "logging";}
}
