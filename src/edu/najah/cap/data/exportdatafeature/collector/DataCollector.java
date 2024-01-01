package edu.najah.cap.data.exportdatafeature.collector;

import edu.najah.cap.data.exportdatafeature.userservices.factory.FactoryUserType;
import edu.najah.cap.data.exportdatafeature.userservices.abst.ICreateDataObjectUser;
import edu.najah.cap.data.helpers.ValidationDataCollector;
import edu.najah.cap.exceptions.*;
import edu.najah.cap.iam.UserProfile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class DataCollector implements IDataCollector {
    private static final Logger logger = LogManager.getLogger(DataCollector.class);

    public String collectData(UserProfile user) throws SystemBusyException, BadRequestException, NotFoundException, NullValueException, InvalidUserTypeException {

        ICreateDataObjectUser userData = FactoryUserType.creationUserDataObject(user);
        if (ValidationDataCollector.isUserDataNull(userData)) {
            logger.error(String.format("User data is null for : %s", user.getUserName()));
            throw new NullValueException(" Null value for User");
        }
        return userData.getDataUser();
    }
}
