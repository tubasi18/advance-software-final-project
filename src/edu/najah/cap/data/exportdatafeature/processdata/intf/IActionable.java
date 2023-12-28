package edu.najah.cap.data.exportdatafeature.processdata.intf;

import edu.najah.cap.exceptions.FileFiledException;

public interface IActionable {

     void actionProcess(byte[] data) throws FileFiledException;
}
