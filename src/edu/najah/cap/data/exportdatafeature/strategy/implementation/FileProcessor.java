package edu.najah.cap.data.exportdatafeature.strategy.implementation;


import edu.najah.cap.data.exportdatafeature.strategy.interfaces.IFileProcess;

import java.io.*;
public class FileProcessor implements IFileProcess {
    private final String outputDirectory;
    private final String zipFileName;

    public FileProcessor(String outputDirectory, String zipFileName) {
        this.outputDirectory = outputDirectory;
        this.zipFileName = zipFileName;
    }

    @Override
    public void actionFileProcess(byte[] data) {
        File directory = new File(outputDirectory);
        if (!directory.exists()) {
            directory.mkdirs();
        }
        String outputPath = outputDirectory + File.separator + zipFileName;
        try (FileOutputStream fileOutputStream = new FileOutputStream(outputPath)) {
            fileOutputStream.write(data);
            System.out.println("ZIP file saved successfully: " + outputPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}