package edu.najah.cap.data.exportdatafeature.exportdata;

import com.dropbox.core.DbxException;
import edu.najah.cap.data.enums.EnumAction;
import edu.najah.cap.exceptions.*;
import edu.najah.cap.iam.UserProfile;

import java.io.IOException;

public interface IExport {
    void exportData(UserProfile user, EnumAction action)throws SystemBusyException, InvalidUserTypeException, BadRequestException, NotFoundException, NullValueException, InvalidUploadTypeException, FileFiledException, IOException, DbxException, InvalidActionTypeException, InvalidConvertTypeException;
}
