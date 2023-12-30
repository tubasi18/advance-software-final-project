package edu.najah.cap.data.exportdatafeature.processdata.impl;

import edu.najah.cap.data.exportdatafeature.processdata.intf.IActionable;
import edu.najah.cap.exceptions.FileFiledException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


public class DownloadDirectly implements IActionable {
    @Override
    public void actionProcess(byte[] data,String fileName) throws FileFiledException {
        String desktopPath = System.getProperty("user.home") + File.separator + "Desktop";
        String outputPath = desktopPath + File.separator + fileName+".zip";
        try (FileOutputStream fileOutputStream = new FileOutputStream(outputPath)) {
            fileOutputStream.write(data);
            System.out.println("ZIP file saved successfully: " + outputPath + ", have a good day \uD83D\uDC9A. ");

        } catch (IOException e) {
            throw new FileFiledException(e.getMessage());
        }
    }
}
