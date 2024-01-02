package edu.najah.cap.data.deletedatafeature.factory.typedelete;

import edu.najah.cap.data.deletedatafeature.factory.FactoryDeletionBehavior;
import edu.najah.cap.data.deletedatafeature.factory.intf.IDeleteType;
import edu.najah.cap.data.deletedatafeature.factory.intf.IDeletionBehavior;
import edu.najah.cap.exceptions.BadRequestException;
import edu.najah.cap.exceptions.InvalidUserTypeException;
import edu.najah.cap.exceptions.NotFoundException;
import edu.najah.cap.exceptions.SystemBusyException;
import edu.najah.cap.iam.UserProfile;

import java.util.List;

public class SoftDelete implements IDeleteType {
    @Override
    public void delete(UserProfile user) throws InvalidUserTypeException, SystemBusyException, BadRequestException, NotFoundException, InterruptedException {
        List<IDeletionBehavior> list =  FactoryDeletionBehavior.deletionBehavior(user);
        for (IDeletionBehavior iDeletionBehavior : list) {
            iDeletionBehavior.delete(user);
        }
    }
}

