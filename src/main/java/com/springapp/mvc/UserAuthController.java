package com.springapp.mvc;

import databaseActions.DatabaseConnections;
import fileActions.CustomLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import persistance.hibernateObjects.user.UserEntity;
import persistance.hibernateObjects.user.UserSpringService;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by r730819 on 6/22/2016.
 *
 * User authentication controller to handle
 * user login, retrieval, and logout functions
 */

@Controller
public class UserAuthController {

    private UserSpringService userSpringService;

    /**
     * Auto wire the spring service
     * @param userSpringService service to be autowired with beans
     */
    @Autowired(required = true)
    @Qualifier(value = "userSpringService")
    public void setCustomerSpringService(UserSpringService userSpringService){
        this.userSpringService = userSpringService;
    }

    /**
     * GET request for the user login page
     *
     * @param modelMap User entity to be mapped to the user login form
     * @param userLoginError Error to be displayed if available
     * @param model Model added to be reference in jsp file
     * @return The view for login page.  No check for user session necessary
     */
    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public String getLoginPage(ModelMap modelMap, @ModelAttribute("userLoginError")final String userLoginError,
                               final Model model){

        modelMap.addAttribute("userEntity", new UserEntity());
        model.addAttribute("userLoginError", userLoginError);

        return "login";
    }

    /**
     * A GET request to destroy the user
     * session and redirect back to the login
     * page
     *
     * @param request Check for user session
     * @return A redirect to login page
     */
    @RequestMapping(method = RequestMethod.GET, value = "/logout")
    public String logoutUser(HttpServletRequest request){

        Object userName = request.getAttribute("userLoggedIn");
        if(userName!=null){
            CustomLogger.createLogMsgAndSave(userName.toString() + " has been logged out");
        }

        request.getSession().invalidate();

        return "redirect:/login";
    }

    /**
     * POST request to attempt to get
     * and login the user
     *
     * @param user UserEntity that contains user credentials
     * @param redirectAttributes A way to redirect with objects, error message in this case
     * @param request Request to set the user session
     * @return A redirect to either home on success or login on failure
     */
    @RequestMapping(method = RequestMethod.POST, value = "/login/getUser")
    public String getUser(@ModelAttribute("user") UserEntity user, final RedirectAttributes redirectAttributes,
                          HttpServletRequest request){

        if(doesUserExist(user.getUserName(), user.getPassword())){
            //create user session
            request.getSession().setAttribute("userLoggedIn", user.getUserName());
            CustomLogger.createLogMsgAndSave(user.getUserName() + " has been logged in");
            return "redirect:/assignment2";
        }else{
            //throw error
            redirectAttributes.addFlashAttribute("userLoginError", "Unable to login user");
            return "redirect:/login";
        }
    }

    /**
     * Private helper function
     * that attempts to retrieve the
     * user with the passed credentials
     *
     * @param userName Credential
     * @param password Credential
     * @return boolean.  True if user exists,
     * else false.
     */
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
