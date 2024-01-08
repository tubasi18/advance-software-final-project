package edu.najah.cap.data.exportdatafeature.processdata.impl;

import edu.najah.cap.data.exportdatafeature.processdata.intf.IActionable;
import edu.najah.cap.exceptions.FileFiledException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


public class DownloadDirectly implements IActionable {
    private static final Logger logger = LogManager.getLogger(DownloadDirectly.class);

    @Override
    public void actionProcess(byte[] data,String fileName) throws FileFiledException {
        String desktopPath = System.getProperty("user.home") + File.separator + "Desktop";
        String outputPath = desktopPath + File.separator + fileName+".zip";
        try (FileOutputStream fileOutputStream = new FileOutputStream(outputPath)) {
            fileOutputStream.write(data);
            System.out.println("ZIP file saved successfully: " + outputPath + ", have a good day \uD83D\uDC9A. ");
            logger.info(String.format("ZIP file saved successfully: %s, name of file: %s", outputPath, fileName));
        } catch (IOException e) {
            logger.error(String.format("Error in class Download Directly :  %s" , e.getMessage()));
            throw new FileFiledException(e.getMessage());

        }
    }
}
