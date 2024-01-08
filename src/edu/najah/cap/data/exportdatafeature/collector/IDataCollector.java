package edu.najah.cap.data.exportdatafeature.collector;

import edu.najah.cap.exceptions.*;
import edu.najah.cap.iam.UserProfile;

public interface IDataCollector {
    String collectData(UserProfile user) throws SystemBusyException, BadRequestException, NotFoundException, InvalidUserDataException, InvalidUserTypeException;
}
