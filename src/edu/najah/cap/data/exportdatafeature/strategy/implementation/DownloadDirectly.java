package edu.najah.cap.data.exportdatafeature.strategy.implementation;

import edu.najah.cap.data.exportdatafeature.strategy.interfaces.IActionable;
import edu.najah.cap.data.exportdatafeature.strategy.interfaces.IFileProcess;


public class DownloadDirectly implements IActionable {
    private final IFileProcess fileProcessor;

    public DownloadDirectly() {
        this.fileProcessor = new FileProcessor("output_DownloadDirectly", "output.zip");
    }

    @Override
    public void actionProcess(byte[] data) {
        fileProcessor.actionFileProcess(data);
    }
}
