package com.yla.controller;

/**
 * Created by Yusuf on 06/12/2016.
 */
import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class FileLocationContextListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        String rootPath = System.getProperty("catalina.home");
        ServletContext ctx = servletContextEvent.getServletContext();
        String relativePath = ctx.getInitParameter("tempfile.dir");
        File file = new File(rootPath + File.separator + relativePath);
        if(!file.exists()) file.mkdirs();
        System.out.println("File Directory created to be used for storing files rootPath is : "+ rootPath);
        ctx.setAttribute("FILES_DIR_FILE", file);
        ctx.setAttribute("FILES_DIR", rootPath + File.separator + relativePath);

        // create upload directory
        String uploadPath = ctx.getInitParameter("upload.dir");
        File file2 = new File(rootPath + File.separator + uploadPath);
        if(!file2.exists()) file2.mkdirs();
        System.out.println("File2 upload Directory created to be used for storing files rootPath is : "+ rootPath);
        ctx.setAttribute("FILES_DIR_FILE2", file2);
        ctx.setAttribute("UPLOAD_FILES_DIR", rootPath + File.separator + uploadPath);
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        //do cleanup if needed
    }

}