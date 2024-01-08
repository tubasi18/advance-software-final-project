package edu.najah.cap.data.deletedatafeature.typedelete;

import edu.najah.cap.data.deletedatafeature.factory.FactoryDeletionBehavior;
import edu.najah.cap.data.deletedatafeature.intf.IDeleteType;
import edu.najah.cap.data.deletedatafeature.intf.IDeletionBehavior;
import edu.najah.cap.exceptions.BadRequestException;
import edu.najah.cap.exceptions.InvalidUserTypeException;
import edu.najah.cap.exceptions.NotFoundException;
import edu.najah.cap.exceptions.SystemBusyException;
import edu.najah.cap.iam.UserProfile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.util.List;

public class SoftDelete implements IDeleteType {
    private static final Logger logger = LogManager.getLogger(SoftDelete.class);

    @Override
    public void delete(UserProfile user) throws InvalidUserTypeException, SystemBusyException, BadRequestException, NotFoundException, InterruptedException, FileNotFoundException {
        List<IDeletionBehavior> list =  FactoryDeletionBehavior.deletionBehavior(user);
        logger.info("Returned Behavior List with behaviors Associated with This Account for Deletion");
        for (IDeletionBehavior iDeletionBehavior : list) {
            iDeletionBehavior.delete(user);
        }
        System.out.println("Soft Deleted is  successfully , have a good day ");
        logger.info(String.format("Deleted successfully for user : %s" , user.getUserName() ));
    }
}

