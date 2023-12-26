package edu.najah.cap.data.exportdatafeature.strategy;

import edu.najah.cap.data.exportdatafeature.strategy.implementation.DownloadDirectly;
import edu.najah.cap.data.exportdatafeature.strategy.implementation.UploadToStorage;
import edu.najah.cap.data.exportdatafeature.strategy.enumaction.EnumAction;
import edu.najah.cap.exceptions.FileFiledException;

public class StrategyAction {
    private  StrategyAction(){}

    public static void typeAction(EnumAction action, byte[] zipFile) throws FileFiledException {
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
