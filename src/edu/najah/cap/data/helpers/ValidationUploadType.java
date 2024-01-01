package edu.najah.cap.data.helpers;

import edu.najah.cap.data.enums.UploadType;

public class ValidationUploadType {

    private  ValidationUploadType(){}
    public static boolean isDropbox(UploadType type) {
        return type.equals(UploadType.DROPBOX);
    }
}
