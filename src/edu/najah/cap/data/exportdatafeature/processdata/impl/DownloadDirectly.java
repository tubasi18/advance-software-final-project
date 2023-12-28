package edu.najah.cap.data.exportdatafeature.processdata.impl;

import edu.najah.cap.data.exportdatafeature.processdata.intf.IActionable;
import edu.najah.cap.data.exportdatafeature.processdata.intf.IFileProcess;
import edu.najah.cap.exceptions.FileFiledException;


public class DownloadDirectly implements IActionable {
    private final IFileProcess fileProcessor;

    public DownloadDirectly() {
        this.fileProcessor = new FileProcessor("output_DownloadDirectly", "output.zip");
    }

    @Override
    public void actionProcess(byte[] data) throws FileFiledException {
        fileProcessor.actionFileProcess(data);
    }
}
