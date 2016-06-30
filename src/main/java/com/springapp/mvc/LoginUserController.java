package com.springapp.mvc;

import databaseActions.DatabaseConnections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import persistance.hibernateObjects.customer.CustomerSpringService;
import persistance.hibernateObjects.user.UserEntity;
import persistance.hibernateObjects.user.UserSpringService;

/**
 * Created by r730819 on 6/22/2016.
 */

@Controller
@RequestMapping("/login")
public class LoginUserController {

    private UserSpringService userSpringService;

    @Autowired(required = true)
    @Qualifier(value = "userSpringService")
    public void setCustomerSpringService(UserSpringService userSpringService){
        this.userSpringService = userSpringService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getLoginPage(ModelMap modelMap, @ModelAttribute("userLoginError")final String userLoginError,
                               final Model model){

        modelMap.addAttribute("userEntity", new UserEntity());
        model.addAttribute("userLoginError", userLoginError);

        return "login";
    }

    @RequestMapping(method = RequestMethod.POST, value = "getUser")
    public String getUser(@ModelAttribute("user") UserEntity user, final RedirectAttributes redirectAttributes){

        if(doesUserExist(user.getUserName(), user.getPassword())){
            //create user session
            return "redirect:/";
        }else{
            //throw error
            redirectAttributes.addFlashAttribute("userLoginError", "Unable to login user");
            return "redirect:/login";

        }
    }

    private boolean doesUserExist(String userName, String password){
        try{
            if(DatabaseConnections.getDB()!=null){
                UserEntity user = this.userSpringService.getUser(userName, password);
                return user != null;
            }else{
                return false;
            }
        }catch (Exception e){
            return false;
        }

    }



}
