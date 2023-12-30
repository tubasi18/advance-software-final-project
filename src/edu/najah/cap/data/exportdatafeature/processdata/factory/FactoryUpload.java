package edu.najah.cap.data.exportdatafeature.processdata.factory;

import edu.najah.cap.data.enums.UploadType;
import edu.najah.cap.data.exportdatafeature.processdata.intf.IUploadService;
import edu.najah.cap.data.exportdatafeature.processdata.typesupload.DropboxUploader;
import edu.najah.cap.exceptions.InvalidUploadTypeException;

public class FactoryUpload {
    private FactoryUpload(){}

    public static IUploadService createUploader(UploadType type) throws InvalidUploadTypeException {
        if (UploadType.DROPBOX.equals(type)) {
           return new DropboxUploader();
        }
        throw new InvalidUploadTypeException("Unsupported this upload type .");
    }
}