package com.yla.utils;

import com.yla.model.YLAFile;
import com.yla.model.YLAParameters;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

/**
 * Created by Yusuf on 03/12/2016.
 */
public class Execffmpeg {
    private static org.slf4j.Logger slogger = LoggerFactory.getLogger(Execffmpeg.class);

    public static void convert(YLAFile fileObj){
        //convertFile(fileObj);

        //convertTompg(fileObj);

        convertFlvtompg(fileObj);
    }
    public static boolean convertFile(YLAFile fileObj){
        //ffmpeg -i video.flv -vn -ar 44100 -ac 2 -ab 192 -f mp3 audio.mp3
        // convert video to mp3
        String runCommand = "ffmpeg -i "+
                             fileObj.getUploadDirectory()+ File.separator+
                             fileObj.getFileName()+"."+fileObj.getFileType()+
                             " -vn -ar 44100 -ac 2 -ab 192 -f " +
                             fileObj.getFileDestinationType() + " "+
                             fileObj.getConvertDirectory()+ File.separator+
                             fileObj.getFileName()+"."+ fileObj.getFileDestinationType() ;
        slogger.debug("..."+runCommand);

        try {
            Runtime.getRuntime().exec(runCommand);//"ffmpeg -r 1 -i sample%d.png -s 320x240 -aspect 4:3 output.flv");
        } catch (IOException e) {
            e.printStackTrace();
            slogger.error(e.toString(),e.getCause());
            return false;
        }
        return true;


    }

    public static boolean convertTompg(YLAFile fileObj){
        //ffmpeg -i video.flv video.mpg
        String runCommand = "ffmpeg -i "+
                fileObj.getUploadDirectory()+ File.separator+
                fileObj.getFileName()+"."+fileObj.getFileType()+
                "  " +
                fileObj.getConvertDirectory()+ File.separator+
                fileObj.getFileName()+"."+ fileObj.getFileDestinationType() ;
        slogger.debug("..."+runCommand);

        try {
            Runtime.getRuntime().exec(runCommand);//"ffmpeg -r 1 -i sample%d.png -s 320x240 -aspect 4:3 output.flv");
        } catch (IOException e) {
            e.printStackTrace();
            slogger.error(e.toString(),e.getCause());
            return false;
        }
        return true;

    }

    //ffmpeg -i C:\Development\UploadFiles\20051210-w50s.flv  C:\Development\UploadFiles\20051210-w50s.mpg
    public static boolean convertFlvtompg(YLAFile fileObj){
        String runCommand = //YLAParameters.FFMPEG_PATH+
                "ffmpeg -i "+
                fileObj.getUploadDirectory()+ File.separator+
                fileObj.getFileName()+"."+fileObj.getFileType()+
                "  " +
                fileObj.getConvertDirectory()+ File.separator+
                fileObj.getFileName()+"."+ fileObj.getFileDestinationType() ;
        slogger.debug("..."+runCommand);

        try {
            Runtime.getRuntime().exec(runCommand);//"ffmpeg -r 1 -i sample%d.png -s 320x240 -aspect 4:3 output.flv");
        } catch (IOException e) {
            e.printStackTrace();
            slogger.error(e.toString(),e.getCause());
            return false;
        }
        return true;

    }

}
