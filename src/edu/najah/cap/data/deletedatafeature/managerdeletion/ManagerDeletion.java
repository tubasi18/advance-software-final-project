package edu.najah.cap.data.deletedatafeature.managerdeletion;

import edu.najah.cap.data.deletedatafeature.factory.FactoryDeletionType;
import edu.najah.cap.data.deletedatafeature.intf.IDeleteType;
import edu.najah.cap.data.enums.DeleteType;
import edu.najah.cap.exceptions.*;
import edu.najah.cap.iam.UserProfile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ManagerDeletion implements IManagerDeletion {
    private static final Logger logger = LogManager.getLogger(ManagerDeletion.class);
    @Override
    public  void delete(UserProfile user , DeleteType type) throws SystemBusyException, BadRequestException, NotFoundException, InterruptedException, InvalidDeleteTypeException, InvalidUserTypeException, InvalidUserNameException {
        IDeleteType deleteType = FactoryDeletionType.factoryProcess(type);
        logger.info(String.format("Return Deletion Type for User %s" , user.getUserName()));
        deleteType.delete(user);
    }
}
