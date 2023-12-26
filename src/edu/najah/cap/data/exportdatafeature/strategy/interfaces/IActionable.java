package edu.najah.cap.data.exportdatafeature.strategy.interfaces;

import edu.najah.cap.exceptions.FileFiledException;

public interface IActionable {

     void actionProcess(byte[] data) throws FileFiledException;
}
