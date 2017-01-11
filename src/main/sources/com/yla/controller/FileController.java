package com.yla.controller;


import com.yla.model.YLAFile;
import com.yla.model.YLAParameters;
import com.yla.model.YLAStringUtils;
import com.yla.queue.JmsMessageSender;
import com.yla.utils.DownloadFile;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * Created by Yusuf on 06/11/2016.
 */
@Controller
@Service
public class FileController implements FileControllerInt{

   // private static org.slf4j.Logger slogger = LoggerFactory.getLogger(FileController.class);

    private Logger logger = Logger.getLogger(FileController.class);


    @RequestMapping("/")
    public ModelAndView checkFileURLex() {
        //slogger.info("Logger Name: "+slogger.getName() + " method: checkFileURLex + request /url ");

        String message = "<br><div style='text-align:center;'>"
                + "<h3>***Please upload the file to convert***</h3></div><br><br>";


        return new ModelAndView("welcome","message",message);

    }

    @RequestMapping("/welcome")//(value ="/welcome", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView welcome(HttpServletRequest request,
                                     @RequestParam(value="texturl", required=false) String texturl) {
     //   slogger.info("Logger Name: "+slogger.getName() + " method: welcome() + request /welcome  ");

        String message = "<br><div style='text-align:center;'>"
                + "<h3>***Please upload the file to convert***</h3></div><br><br>";

        //resolve to /WEb-INF/jsp/welcome1.0.jsp
        logger.info(logger.getName()+ " /welcome");

        return new ModelAndView("welcome","message",message);

    }




    //file upload
    @Autowired
    JmsMessageSender  jmsMessageSender;

    @RequestMapping("/upload.do")
    @ResponseBody
    public ModelAndView uploadFile(HttpServletRequest request, HttpServletResponse response,ModelMap model) throws IOException{
       logger.info(logger.getName()+"  /upload.do ");
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        String message ="";
        String fileName="";
        // process only if its multipart content
        if (isMultipart) {
            // Create a factory for disk-based file items
            FileItemFactory factory = new DiskFileItemFactory();

            // Create a new file upload handler
            ServletFileUpload upload = new ServletFileUpload(factory);
            try {
                // Parse the request
                List<FileItem> multiparts = upload.parseRequest(request);

                for (FileItem item : multiparts) {
                    if (!item.isFormField()) {
                        fileName = new File(item.getName()).getName();
                        item.write(new File(YLAParameters.getUploadDir(request) + File.separator + fileName));
                    }
                }
                 message = "File Uploaded, Now it will be converted and ready for Download!...";
                //put the converted file ınto queue
                // get bean from context
                // send to default destination
                YLAFile ylaFile;
                String fileType = YLAStringUtils.getFileType(fileName);
                String hfileName =  YLAStringUtils.replaceSpaces(YLAStringUtils.getFilename(fileName));
                String convertType = request.getParameter("format_choice");
                ylaFile = new YLAFile(hfileName,fileType,convertType, YLAParameters.getUploadDir(request),YLAParameters.getDestinationDir(request));
                request.getSession().setAttribute("fileObj",ylaFile);
                model.addAttribute("fileName",hfileName+"."+fileType);
                //jmsMessageSender.sendToFileQueue(ylaFile);
            }
            catch (Exception e)
            {
                e.printStackTrace();
                logger.error(logger.getName());
                logger.error(e);
                 message ="File upload failed";
            }
        }

        return new ModelAndView("welcome","message2",message);
    }




    //file download
    private static final int BUFFER_SIZE = 4096;
    @RequestMapping("/downloadex.do")//method = RequestMethod.GET)
    public void doDownloadex(HttpServletRequest request,
                           HttpServletResponse response) throws IOException {
        //slogger.info("Logger Name: "+slogger.getName() + " method: download + request /download  ");

        String filePath = "";//"/upLoadFiles/32.Essential Russian Grammar.pdf";

        // get absolute path of the application
        ServletContext context = request.getSession().getServletContext();
        String appPath = context.getRealPath("");
        System.out.println("appPath = " + appPath);

        // construct the complete absolute path of the file
        String fullPath = appPath + filePath;
        File downloadFile = new File(fullPath);
        FileInputStream inputStream = new FileInputStream(downloadFile);

        // get MIME type of the file
        String mimeType = context.getMimeType(fullPath);
        if (mimeType == null) {
            // set to binary type if MIME mapping not found
            mimeType = "application/octet-stream";
        }
        System.out.println("MIME type: " + mimeType);

        // set content attributes for the response
        response.setContentType(mimeType);
        response.setContentLength((int) downloadFile.length());

        // set headers for the response
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"",
                downloadFile.getName());
        response.setHeader(headerKey, headerValue);

        // get output stream of the response
        OutputStream outStream = response.getOutputStream();

        byte[] buffer = new byte[BUFFER_SIZE];
        int bytesRead = -1;

        // write bytes read from the input stream into the output stream
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, bytesRead);
        }

        inputStream.close();
        outStream.close();

    }
    @RequestMapping("/convert.do")
     public ModelAndView convertFile(HttpServletRequest request, HttpServletResponse response){
        String message = "Conversion completed";
        YLAFile ylaFile = (YLAFile) request.getSession().getAttribute("fileObj");;
        String convertType = request.getParameter("format_choice");
       // slogger.info("Logger Name: "+slogger.getName() +" convert type is"+ convertType);
        if (ylaFile != null) {
            ylaFile.setFileDestinationType(convertType);
        }
        else{
      //      slogger.info("Please select a file and upload");
            message = "Please select a file and upload";
        }
        jmsMessageSender.sendToFileQueue(ylaFile);
        return new ModelAndView("welcome","message2",message);

    }

    @RequestMapping("/download.do")//method = RequestMethod.GET)
    public void doDownload(HttpServletRequest request,
                           HttpServletResponse response) throws IOException {
      //  slogger.info("Logger Name: " + slogger.getName() + " method: download + request /download  ");
        try {
            DownloadFile.download(request,response);
        } catch (Exception e) {
       //     slogger.error(e.toString());
            e.printStackTrace();
           String message = "Still in progress";
           // return new ModelAndView("welcome","message",message);
        }
        String message = "download completed";
       // return new ModelAndView("welcome","message2",message);
    }

    @RequestMapping("/videoformats.do")//(value ="/welcome", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView videoFormats(HttpServletRequest request,
                                @RequestParam(value="texturl", required=false) String texturl) {
      //  slogger.info("Logger Name: "+slogger.getName() + " method: welcome() + request /welcome  ");

        String message = "<br><div style='text-align:center;'>"
                + "<h3>***Please upload the file to convert***</h3></div><br><br>";

        //resolve to /WEb-INF/jsp/welcome1.0.jsp
       return new ModelAndView("videoformats","message",message);

    }

    @RequestMapping("/faq.do")//(value ="/welcome", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView faq(HttpServletRequest request,
                                     @RequestParam(value="texturl", required=false) String texturl) {
     //   slogger.info("Logger Name: "+slogger.getName() + " method: welcome() + request /welcome  ");

        String message = "<br><div style='text-align:center;'>"
                + "<h3>***Please upload the file to convert***</h3></div><br><br>";

        //resolve to /WEb-INF/jsp/welcome1.0.jsp
        return new ModelAndView("FAQ","message",message);

    }

    @RequestMapping("/contact.do")//(value ="/welcome", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView welcomev2(HttpServletRequest request,
                            @RequestParam(value="texturl", required=false) String texturl) {
    //    slogger.info("Logger Name: "+slogger.getName() + " method: welcome() + request /welcome  ");

        String message = "<br><div style='text-align:center;'>"
                + "<h3>***Please upload the file to convert***</h3></div><br><br>";

        //resolve to /WEb-INF/jsp/welcome1.0.jsp
        return new ModelAndView("contact","message",message);

    }
}
