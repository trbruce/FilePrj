package com.yla.controller;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

/**
 * Created by Yusuf on 28/12/2016.
 */
public interface FileControllerInt {
    public ModelAndView checkFileURLex();
    public ModelAndView welcome(Locale locale, Model model);//HttpServletRequest request,
                                //@RequestParam(value="texturl", required=false) String texturl);
    public ModelAndView uploadFile(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws IOException;

    public ModelAndView convertFile(HttpServletRequest request, HttpServletResponse response);
    public void doDownload(HttpServletRequest request,
                           HttpServletResponse response) throws IOException;

}
