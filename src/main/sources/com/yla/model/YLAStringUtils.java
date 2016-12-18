package com.yla.model;

/**
 * Created by Yusuf on 03/12/2016.
 */
public class YLAStringUtils {
    @org.jetbrains.annotations.NotNull
    public static String getFileType(String fileName) {

        return fileName.substring(fileName.lastIndexOf(".")+1);
    }

    public static String getFilename(String fileName) {
        return fileName.substring(0,fileName.lastIndexOf("."));
    }

    public static String replaceSpaces(String text){
        return text.replace(' ','_');
    }
    
}
