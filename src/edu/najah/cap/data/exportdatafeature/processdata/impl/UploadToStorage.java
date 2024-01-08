package edu.najah.cap.data.exportdatafeature.processdata.impl;

import edu.najah.cap.data.enums.UploadType;
import edu.najah.cap.data.exportdatafeature.processdata.factory.FactoryUpload;
import com.dropbox.core.DbxException;
import edu.najah.cap.data.exportdatafeature.processdata.intf.IUploadService;
import edu.najah.cap.data.exportdatafeature.processdata.intf.IActionable;
import edu.najah.cap.exceptions.InvalidUploadTypeException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.*;
import java.util.Scanner;

public class UploadToStorage implements IActionable {
    private static final Logger logger = LogManager.getLogger(UploadToStorage.class);
    @Override
    public void actionProcess(byte[] data, String fileName) throws InvalidUploadTypeException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the upload type (e.g., DROPBOX): ");
        String inputType = scanner.nextLine();
        IUploadService uploadStorage;
        try {
            UploadType type = UploadType.valueOf(inputType.toUpperCase());
            uploadStorage = FactoryUpload.createUploader(type);
            uploadStorage.upload(data, fileName);
            logger.info(String.format("The user enter the type of upload : %s, name of file: %s", inputType, fileName));
        }  catch (IOException | DbxException e) {
            logger.error(e.getMessage());
            throw new InvalidUploadTypeException(e.getMessage());

        }

    }
}