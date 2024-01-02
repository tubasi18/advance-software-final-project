package edu.najah.cap.data.deletedatafeature;

import edu.najah.cap.data.deletedatafeature.factory.FactoryDeletionType;
import edu.najah.cap.data.deletedatafeature.factory.intf.IDeleteType;
import edu.najah.cap.data.enums.DeleteType;
import edu.najah.cap.exceptions.*;
import edu.najah.cap.iam.UserProfile;

public class MangerDeletion {

    public  void delete(UserProfile user , DeleteType type) throws SystemBusyException, BadRequestException, NotFoundException, InterruptedException, InvaildDeleteTypeException, InvalidUserTypeException {
        IDeleteType deleteType = FactoryDeletionType.factoryProcess(type);
        deleteType.delete(user);
    }
}
