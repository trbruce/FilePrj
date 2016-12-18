package com.yla.model;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Yusuf on 03/12/2016.
 */
public class YLAParameters {
    public static final String UPLOAD_DIRECTORY = "C:\\Development\\UploadFiles";
    public static final String CONVERT_DIRECTORY = "C:\\Development\\Data";
    public static final String FFMPEG_PATH = "C:\\Development\\ffmpeg\\bin\\";

    /*
    web.xml and FileLocationContextListeer is used
    <context-param>
        <param-name>tempfile.dir</param-name>
        <param-value>tmpfiles</param-value>
    </context-param>

    <context-param>
        <param-name>upload.dir</param-name>
        <param-value>uploadfiles</param-value>
    </context-param>

     */

    public static final String getDestinationDir(HttpServletRequest request){
        String destinationDir=  (String) request.getSession().getServletContext().getAttribute("FILES_DIR");
        return destinationDir;
    }

    public static final String getUploadDir(HttpServletRequest request){
        String uploadDir=  (String) request.getSession().getServletContext().getAttribute("UPLOAD_FILES_DIR");
        return uploadDir;
    }
}
