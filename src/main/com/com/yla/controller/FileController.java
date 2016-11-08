package com.yla.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Yusuf on 06/11/2016.
 */
@Controller
public class FileController {

    @RequestMapping("/")
    public ModelAndView checkFileURLex() {
        String message = "<br><div style='text-align:center;'>"
                + "<h3>********** 2Hello World, Spring MVC Tutorial</h3>This message is coming from FileController.java **********</div><br><br>";

        //resolve to /WEb-INF/jsp/welcome.jsp
        System.out.println("checkFileURLex method");
        return new ModelAndView("welcome","message",message);

    }

    @RequestMapping("/welcome")
    public ModelAndView checkFileURL() {
        String message = "<br><div style='text-align:center;'>"
                + "<h3>! Hello World, Spring MVC Tutorial</h3>This message is coming from FileController.java !</div><br><br>";

        //resolve to /WEb-INF/jsp/welcome.jsp
        System.out.println("welcome method");
        return new ModelAndView("welcome","message",message);

    }
    @RequestMapping("/checkFileURL")
    public ModelAndView checkFileURL2() {
        String message = "<br><div style='text-align:center;'>"
                + "<h3>! checkFileURL</h3>!<br><br>";

        //resolve to /WEb-INF/jsp/welcome.jsp
        System.out.println("checkFileURL method");
        return new ModelAndView("welcome","message",message);

    }
    @RequestMapping("/test")
    public ModelAndView test() {
        String message = "<br><div style='text-align:center;'>"
                + "<h3>! Test !</div><br><br>";

        //resolve to /WEb-INF/jsp/welcome.jsp
        System.out.println("test method");
        return new ModelAndView("test","message",message);

    }
}
