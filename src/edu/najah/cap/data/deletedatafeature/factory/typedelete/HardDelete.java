package edu.najah.cap.data.deletedatafeature.factory.typedelete;

import edu.najah.cap.data.deletedatafeature.factory.FactoryDeletionBehavior;
import edu.najah.cap.data.deletedatafeature.factory.deletionbehavior.ProfileDeletion;
import edu.najah.cap.data.deletedatafeature.factory.intf.IDeleteType;
import edu.najah.cap.data.deletedatafeature.factory.intf.IDeletionBehavior;
import edu.najah.cap.exceptions.BadRequestException;
import edu.najah.cap.exceptions.InvalidUserTypeException;
import edu.najah.cap.exceptions.NotFoundException;
import edu.najah.cap.exceptions.SystemBusyException;
import edu.najah.cap.iam.UserProfile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class HardDelete implements IDeleteType {
    private static final Logger logger = LogManager.getLogger(HardDelete.class);

    @Override
    public void delete(UserProfile user) throws InvalidUserTypeException, SystemBusyException, BadRequestException, NotFoundException, InterruptedException {
         List<IDeletionBehavior> list =  FactoryDeletionBehavior.deletionBehavior(user);
         list.add(new ProfileDeletion());
        logger.info("Returned Behavior List with behaviors Associated with This Account for Deletion");
        logger.info("Deletion Type is Hard; Profile Deletion is returned");

        for (IDeletionBehavior iDeletionBehavior : list) {
            iDeletionBehavior.delete(user);
        }
    }
}