package edu.najah.cap.data.exportdatafeature.strategy.interfaces;

import edu.najah.cap.exceptions.FileFiledException;

public interface IFileProcess {


     void actionFileProcess(byte[] data) throws FileFiledException;
}
