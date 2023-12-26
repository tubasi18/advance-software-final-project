package edu.najah.cap.data.exportdatafeature.strategy.implementation;


import edu.najah.cap.data.exportdatafeature.strategy.interfaces.IFileProcess;
import edu.najah.cap.exceptions.FileFiledException;

import java.io.*;
public class FileProcessor implements IFileProcess {
    private final String outputFilePath;
    private final String zipFileName;

    public FileProcessor(String outputFilePath, String zipFileName) {
        this.outputFilePath = outputFilePath;
        this.zipFileName = zipFileName;
    }

//    @Override
//    public void actionFileProcess(byte[] data) {
//        File directory = new File(outputDirectory);
//        if (!directory.exists()) {
//            directory.mkdirs();
//        }
//        String outputPath = outputDirectory + File.separator + zipFileName;
//        try (FileOutputStream fileOutputStream = new FileOutputStream(outputPath)) {
//            fileOutputStream.write(data);
//            System.out.println("ZIP file saved successfully: " + outputPath);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
    @Override
public void actionFileProcess(byte[] data) throws FileFiledException {

    String desktopPath = System.getProperty("user.home") + File.separator + "Desktop";
    File directory = new File(desktopPath + File.separator + outputFilePath);
    if (!directory.exists()) {
        directory.mkdirs();
    }
    String outputPath = directory.getAbsolutePath() + File.separator + zipFileName;
    try (FileOutputStream fileOutputStream = new FileOutputStream(outputPath)) {
        fileOutputStream.write(data);
        System.out.println("ZIP file saved successfully: " + outputPath);
    } catch (IOException e) {
        throw new FileFiledException(e.getMessage());
    }
}

}