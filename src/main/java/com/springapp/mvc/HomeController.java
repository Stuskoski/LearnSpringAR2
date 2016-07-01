package com.springapp.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/assignment2")
public class HomeController {
    @RequestMapping(method = RequestMethod.GET)
    public String getHomePage(final RedirectAttributes redirectAttributes) {

        redirectAttributes.addFlashAttribute("page", "home");
        return "redirect:/login/checkUser";

        //return "home";
    }
}
