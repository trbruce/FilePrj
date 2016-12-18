package com.yla.model;

import java.io.Serializable;

/**
 * Created by Yusuf on 27/11/2016.
 */
public class YLAFile implements Serializable {
    String fileName;
    String fileType;
    String fileDestinationType;
    String uploadDirectory;

    public String getConvertDirectory() {
        return convertDirectory;
    }

    public void setConvertDirectory(String convertDirectory) {
        this.convertDirectory = convertDirectory;
    }

    String convertDirectory;

    public String getUploadDirectory() {
        return uploadDirectory;
    }

    public void setUploadDirectory(String uploadDirectory) {
        this.uploadDirectory = uploadDirectory;
    }



    public YLAFile(String fileName, String fileType, String fileDestinationType, String uploadDirectory,String convertDirectory) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.fileDestinationType = fileDestinationType;
        this.uploadDirectory = uploadDirectory;
        this.convertDirectory = convertDirectory;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileDestinationType() {
        return fileDestinationType;
    }

    public void setFileDestinationType(String fileDestinationType) {
        this.fileDestinationType = fileDestinationType;
    }
}
