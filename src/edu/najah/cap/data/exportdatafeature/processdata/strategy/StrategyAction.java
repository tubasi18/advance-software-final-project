package edu.najah.cap.data.exportdatafeature.processdata.strategy;

import com.dropbox.core.DbxException;
import edu.najah.cap.data.helpers.ValidationActionType;
import edu.najah.cap.data.exportdatafeature.processdata.impl.DownloadDirectly;
import edu.najah.cap.data.exportdatafeature.processdata.impl.UploadToStorage;
import edu.najah.cap.data.enums.EnumAction;
import edu.najah.cap.exceptions.FileFiledException;
import edu.najah.cap.exceptions.InvalidActionTypeException;
import edu.najah.cap.exceptions.InvalidUploadTypeException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class StrategyAction {
    private static final Logger logger = LogManager.getLogger(StrategyAction.class);
    private  StrategyAction(){}

    public static void typeAction(EnumAction action, byte[] zipFile) throws InvalidUploadTypeException, FileFiledException, IOException, DbxException, InvalidActionTypeException {
        ActionContext actionContext = new ActionContext();

        if(ValidationActionType.isDownload(action)){
            logger.info(String.format("The user take action for download his files %s.", action));
            actionContext.setActionable(new DownloadDirectly());
            actionContext.actionProcess(zipFile);
        }
        else if (ValidationActionType.isUpload(action)) {
            logger.info(String.format("The user take action for download his files %s.", action));
            actionContext.setActionable(new UploadToStorage());
            actionContext.actionProcess(zipFile);
        }
        else {
            logger.error(String.format("Invalid Action type %s.", action));
            throw new InvalidActionTypeException(String.format("Invalid Action type %s.", action));
        }
    }
}
