package com.yla.controller;

import com.yla.security.PrincipalController;
import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Yusuf on 29/12/2016.
 */
@Controller
@Service
public class LoginController {

    private static org.slf4j.Logger slogger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(value = "/login.do", method = {RequestMethod.GET, RequestMethod.POST})
    public String loginPage2() {
        return "login";
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }

    @RequestMapping(value = "/admin.do", method = RequestMethod.GET)
    public String adminPage(ModelMap model) {
        model.addAttribute("user", PrincipalController.getPrincipal());
        return "/admin/admin";
    }



    @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        model.addAttribute("user", PrincipalController.getPrincipal());
        return "accessDenied";
    }

    @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
    public String loginPage(ModelMap model) {
        model.addAttribute("user", PrincipalController.getPrincipal());
        return "login";
    }
}
