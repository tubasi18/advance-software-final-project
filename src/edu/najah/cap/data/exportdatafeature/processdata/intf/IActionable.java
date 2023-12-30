package edu.najah.cap.data.exportdatafeature.processdata.intf;

import com.dropbox.core.DbxException;
import edu.najah.cap.exceptions.FileFiledException;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface IActionable {

     void actionProcess(byte[] data,String fileName) throws FileFiledException, IOException, DbxException;
}
