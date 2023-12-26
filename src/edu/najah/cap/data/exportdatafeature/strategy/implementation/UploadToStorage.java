package edu.najah.cap.data.exportdatafeature.strategy.implementation;

import edu.najah.cap.data.exportdatafeature.strategy.interfaces.IActionable;
import edu.najah.cap.data.exportdatafeature.strategy.interfaces.IFileProcess;
import edu.najah.cap.exceptions.FileFiledException;


public class UploadToStorage implements IActionable {
    private final IFileProcess fileProcessor;

    public UploadToStorage() {
        this.fileProcessor = new FileProcessor("output_UploadToStorage", "output.zip");
    }

    @Override
    public void actionProcess(byte[] data) throws FileFiledException {
        fileProcessor.actionFileProcess(data);
    }
}
