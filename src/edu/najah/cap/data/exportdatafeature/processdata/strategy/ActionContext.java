package edu.najah.cap.data.exportdatafeature.processdata.strategy;

import com.dropbox.core.DbxException;
import edu.najah.cap.data.exportdatafeature.processdata.intf.IActionable;
import edu.najah.cap.exceptions.FileFiledException;

import java.io.IOException;
import java.util.Scanner;


public class ActionContext {

    private IActionable actionable;

    public void setActionable(IActionable actionable) {
        this.actionable = actionable;
    }
    public void  actionProcess(byte[] data) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter ur file name \uD83D\uDE42 ?");
        String fileName = scanner.next();
        actionable.actionProcess(data,fileName);
    }
}
