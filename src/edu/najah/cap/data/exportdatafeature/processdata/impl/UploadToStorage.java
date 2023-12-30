package edu.najah.cap.data.exportdatafeature.processdata.impl;

import com.dropbox.core.DbxException;
import edu.najah.cap.data.enums.UploadType;
import edu.najah.cap.data.exportdatafeature.processdata.factory.FactoryUpload;
import edu.najah.cap.data.exportdatafeature.processdata.intf.IUploadService;
import edu.najah.cap.data.exportdatafeature.processdata.intf.IActionable;
import edu.najah.cap.exceptions.InvalidUploadTypeException;
import java.io.*;
import java.util.Scanner;

public class UploadToStorage implements IActionable {
    @Override
    public void actionProcess(byte[] data, String fileName) throws IOException, DbxException, InvalidUploadTypeException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the upload type (e.g., DROPBOX): ");
        String inputType = scanner.nextLine();
        IUploadService uploadStorage;
        try {
            UploadType type = UploadType.valueOf(inputType.toUpperCase());
            uploadStorage = FactoryUpload.createUploader(type);
        } catch (Exception e) {
            throw new InvalidUploadTypeException("Unsupported upload type: " + inputType);
        }
        uploadStorage.upload(data, fileName);
    }
}