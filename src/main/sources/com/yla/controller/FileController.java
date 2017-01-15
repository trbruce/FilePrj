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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
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
import java.util.Locale;

/**
 * Created by Yusuf on 06/11/2016.
 */
@Controller
@Service
public class FileController implements FileControllerInt {


    private Logger logger = Logger.getLogger(FileController.class);


    @RequestMapping("/")
    public ModelAndView checkFileURLex() {

        String message = "<br><div style='text-align:center;'>"
                + "<h3>***Please upload the file to convert***</h3></div><br><br>";


        return new ModelAndView("welcome", "message", message);

    }

    @RequestMapping("/welcome")//(value ="/welcome", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView welcome(Locale locale, Model model) {//     HttpServletRequest request,@RequestParam(value="texturl", required=false) String texturl) {


        //resolve to /WEb-INF/jsp/welcome1.0.jsp
        logger.info(logger.getName() + " /welcome");

        String msg2 = messageSource.getMessage("welcome.message", new Object[]{"John Doe"}, locale);
        model.addAttribute("message", msg2);

        // obtain locale from LocaleContextHolder
        Locale currentLocale = LocaleContextHolder.getLocale();
        model.addAttribute("locale", currentLocale);

        model.addAttribute("startMeeting", "10:30");

        String message = messageSource.getMessage(
                "welcome.message",
                new Object[]{"John Doe"},
                locale);

        return new ModelAndView("welcome", "message", message);

    }

    @Autowired
    private MessageSource messageSource;


    //file upload
    @Autowired
    JmsMessageSender jmsMessageSender;

    @RequestMapping("/upload.do")
    @ResponseBody
    public ModelAndView uploadFile(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws IOException {
        logger.info(logger.getName() + "  /upload.do ");
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        String message = "";
        String fileName = "";
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
                String hfileName = YLAStringUtils.replaceSpaces(YLAStringUtils.getFilename(fileName));
                String convertType = request.getParameter("format_choice");
                ylaFile = new YLAFile(hfileName, fileType, convertType, YLAParameters.getUploadDir(request), YLAParameters.getDestinationDir(request));
                request.getSession().setAttribute("fileObj", ylaFile);
                model.addAttribute("fileName", hfileName + "." + fileType);
                //jmsMessageSender.sendToFileQueue(ylaFile);
            } catch (Exception e) {
                e.printStackTrace();
                logger.error(logger.getName());
                logger.error(e);
                message = "File upload failed";
            }
        }

        return new ModelAndView("welcome", "message2", message);
    }


    //file download
    private static final int BUFFER_SIZE = 4096;



    @RequestMapping("/convert.do")
    public ModelAndView convertFile(HttpServletRequest request, HttpServletResponse response) {
        String message = "Conversion completed";
        YLAFile ylaFile = (YLAFile) request.getSession().getAttribute("fileObj");
        ;
        String convertType = request.getParameter("format_choice");
        if (ylaFile != null) {
            ylaFile.setFileDestinationType(convertType);
        } else {
            message = "Please select a file and upload";
        }
        jmsMessageSender.sendToFileQueue(ylaFile);
        return new ModelAndView("welcome", "message2", message);

    }

    @RequestMapping("/download.do")//method = RequestMethod.GET)
    public void doDownload(HttpServletRequest request,
                           HttpServletResponse response) throws IOException {

        logger.info(logger.getName() + " /download  BEGIN");
        try {
            //check whether the file is selected in the app
            if (request.getSession().getAttribute("fileObj")!= null) {
                DownloadFile.download(request, response);
            }
            else{
                //The file is not attached yet to the session
                response.sendRedirect(request.getRequestURI().substring(0,request.getRequestURI().indexOf("/",2))+"/welcome.do");
                //response.sendRedirect("welcome.do");
                //return new ModelAndView("redirect:/myURL");
            }
        } catch (Exception e) {
            //     slogger.error(e.toString());
            e.printStackTrace();
            String message = "Still in progress";
            response.sendRedirect(request.getRequestURI().substring(0,request.getRequestURI().indexOf("/",2))+"/welcome.do");
            // return new ModelAndView("welcome","message",message);
        }
        String message = "download completed";
        logger.info(logger.getName() + " /download  END");
        // return new ModelAndView("welcome","message2",message);
    }

    @RequestMapping("/videoformats.do")//(value ="/welcome", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView videoFormats(HttpServletRequest request,
                                     @RequestParam(value = "texturl", required = false) String texturl) {

        String message = "<br><div style='text-align:center;'>"
                + "<h3>***Please upload the file to convert***</h3></div><br><br>";

        //resolve to /WEb-INF/jsp/welcome1.0.jsp
        return new ModelAndView("videoformats", "message", message);

    }

    @RequestMapping("/faq.do")//(value ="/welcome", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView faq(HttpServletRequest request,
                            @RequestParam(value = "texturl", required = false) String texturl) {

        String message = "<br><div style='text-align:center;'>"
                + "<h3>***Please upload the file to convert***</h3></div><br><br>";

        //resolve to /WEb-INF/jsp/welcome1.0.jsp
        return new ModelAndView("FAQ", "message", message);

    }

    @RequestMapping("/contact.do")//(value ="/welcome", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView welcomev2(HttpServletRequest request,
                                  @RequestParam(value = "texturl", required = false) String texturl) {

        String message = "<br><div style='text-align:center;'>"
                + "<h3>***Please upload the file to convert***</h3></div><br><br>";

        //resolve to /WEb-INF/jsp/welcome1.0.jsp
        return new ModelAndView("contact", "message", message);

    }
}
