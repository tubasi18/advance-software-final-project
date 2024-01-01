package edu.najah.cap.data.exportdatafeature.processdata.strategy;

import com.dropbox.core.DbxException;
import edu.najah.cap.data.exportdatafeature.processdata.intf.IActionable;
import edu.najah.cap.exceptions.FileFiledException;
import edu.najah.cap.exceptions.InvalidUploadTypeException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Scanner;


public class ActionContext {

    private IActionable actionable;
    private static final Logger logger = LogManager.getLogger(ActionContext.class);

    public void setActionable(IActionable actionable) {
        this.actionable = actionable;
    }
    public void  actionProcess(byte[] data) throws InvalidUploadTypeException, FileFiledException, IOException, DbxException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter ur file name \uD83D\uDE42 ?");
        String fileName = scanner.next();
        logger.info(String.format("The user write the name of files :  %s.", fileName));
        actionable.actionProcess(data,fileName);
    }
}
