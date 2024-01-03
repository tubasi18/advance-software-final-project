package edu.najah.cap.data.deletedatafeature;

import edu.najah.cap.data.deletedatafeature.factory.FactoryDeletionType;
import edu.najah.cap.data.deletedatafeature.factory.intf.IDeleteType;
import edu.najah.cap.data.enums.DeleteType;
import edu.najah.cap.data.exportdatafeature.ExportData;
import edu.najah.cap.exceptions.*;
import edu.najah.cap.iam.UserProfile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MangerDeletion {
    private static final Logger logger = LogManager.getLogger(MangerDeletion.class);

    public  void delete(UserProfile user , DeleteType type) throws SystemBusyException, BadRequestException, NotFoundException, InterruptedException, InvalidDeleteTypeException, InvalidUserTypeException {
        IDeleteType deleteType = FactoryDeletionType.factoryProcess(type);
        logger.info("Return Deletion Type for User." + user.getUserName() );
        deleteType.delete(user);
    }
}
