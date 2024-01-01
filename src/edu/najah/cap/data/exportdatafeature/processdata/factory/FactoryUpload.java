package edu.najah.cap.data.exportdatafeature.processdata.factory;

import edu.najah.cap.data.enums.UploadType;
import edu.najah.cap.data.exportdatafeature.processdata.intf.IUploadService;
import edu.najah.cap.data.exportdatafeature.processdata.typesupload.DropboxUploader;
import edu.najah.cap.data.helpers.ValidationUploadType;
import edu.najah.cap.exceptions.InvalidUploadTypeException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FactoryUpload {
    private FactoryUpload(){}
    private static final Logger logger = LogManager.getLogger(FactoryUpload.class);


    public static IUploadService createUploader(UploadType type) throws InvalidUploadTypeException {
        if (ValidationUploadType.isDropbox(type)) {
            logger.info(String.format("The User chose the type of upload: %s", type));
           return new DropboxUploader();
        }
        logger.error(String.format("Unsupported this upload type : %s", type));
        throw new InvalidUploadTypeException("Unsupported this upload type .");
    }
}