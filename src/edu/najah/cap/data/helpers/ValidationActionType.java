package edu.najah.cap.data.helpers;

import edu.najah.cap.data.enums.EnumAction;

public class ValidationActionType {
    private ValidationActionType() {}

    public static boolean isDownload(EnumAction action) {
        return action.equals(EnumAction.DOWNLOAD);
    }
    public static boolean isUpload(EnumAction action) {
        return action.equals(EnumAction.UPLOAD);
    }
}