package edu.najah.cap.data.exportdatafeature.processdata.intf;

import edu.najah.cap.exceptions.FileFiledException;

public interface IFileProcess {


     void actionFileProcess(byte[] data) throws FileFiledException;
}
