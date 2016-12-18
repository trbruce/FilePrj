package com.yla.utils;

import com.yla.model.YLAFile;
import com.yla.model.YLAParameters;
import org.apache.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Created by Yusuf on 06/12/2016.
 */
public class DownloadFile {
    private static Logger logger = Logger.getLogger(DownloadFile.class);
    public static void download(HttpServletRequest request,
                                HttpServletResponse response) throws Exception{

        YLAFile ylaFile = (YLAFile)request.getSession().getAttribute("fileObj");
        String fileName =  ylaFile.getFileName()+"."+ylaFile.getFileDestinationType();//request.getParameter("fileName");
        logger.warn("Filename is!!!!!!!!!!!!! "+ fileName );
        logger.warn("download is  starting!!!!!!!!!!!!!" );
        if(fileName == null || fileName.equals("")){
            throw new ServletException("File Name can't be null or empty");
        }
        File file = new File(YLAParameters.getDestinationDir(request)+File.separator+fileName);
        if(!file.exists()){
            throw new ServletException("File doesn't exists on server.");
        }
        System.out.println("File location on server::"+file.getAbsolutePath());
        ServletContext ctx = request.getSession().getServletContext();
        InputStream fis = new FileInputStream(file);
        String mimeType = ctx.getMimeType(file.getAbsolutePath());
        response.setContentType(mimeType != null? mimeType:"application/octet-stream");
        response.setContentLength((int) file.length());
        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

        ServletOutputStream os       = response.getOutputStream();
        byte[] bufferData = new byte[1024];
        int read=0;
        while((read = fis.read(bufferData))!= -1){
            os.write(bufferData, 0, read);
        }
        os.flush();
        os.close();
        fis.close();
        System.out.println("File downloaded at client successfully");

    }
}
