package edu.najah.cap.data.exportdatafeature.processdata.strategy;

import com.dropbox.core.DbxException;
import edu.najah.cap.data.exportdatafeature.processdata.impl.DownloadDirectly;
import edu.najah.cap.data.exportdatafeature.processdata.impl.UploadToStorage;
import edu.najah.cap.data.enums.EnumAction;
import edu.najah.cap.exceptions.FileFiledException;

import java.io.IOException;
import java.nio.file.*;

public class StrategyAction {
    private  StrategyAction(){}

    public static void typeAction(EnumAction action, byte[] zipFile) throws Exception {
        ActionContext actionContext = new ActionContext();

        if(action.equals(EnumAction.DOWNLOAD_DIRECTLY)){
            actionContext.setActionable(new DownloadDirectly());
            actionContext.actionProcess(zipFile);
        }
        else {
            actionContext.setActionable(new UploadToStorage());
            actionContext.actionProcess(zipFile);
        }
    }
}
