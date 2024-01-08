package edu.najah.cap.data.deletedatafeature.typedelete;

import edu.najah.cap.data.deletedatafeature.factory.FactoryDeletionBehavior;
import edu.najah.cap.data.deletedatafeature.deletionbehavior.ProfileDeletion;
import edu.najah.cap.data.deletedatafeature.intf.IDeleteType;
import edu.najah.cap.data.deletedatafeature.intf.IDeletionBehavior;
import edu.najah.cap.exceptions.*;
import edu.najah.cap.iam.UserProfile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class HardDelete implements IDeleteType {
    private static final Logger logger = LogManager.getLogger(HardDelete.class);

    @Override
    public void delete(UserProfile user) throws InvalidUserTypeException, SystemBusyException, BadRequestException, NotFoundException, InterruptedException, InvalidUserNameException, FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your username to delete all your data ? ");
        String userName = scanner.next();
        if (userName.equals(user.getUserName())) {
            List<IDeletionBehavior> list = FactoryDeletionBehavior.deletionBehavior(user);
            list.add(new ProfileDeletion());
            logger.info("Returned Behavior List with behaviors Associated with This Account for Deletion");
            logger.info("Deletion Type is Hard; Profile Deletion is returned");
            for (IDeletionBehavior iDeletionBehavior : list) {
                iDeletionBehavior.delete(user);
            }
            System.out.println("hard Deleted is  successfully , have a good day ");
            logger.info(String.format("Deleted successfully for user : %s" , user.getUserName()));
        } else {
            logger.error("not the same owner as account {}", userName);
            throw new InvalidUserNameException("You are not the same owner as account " + userName);
        }
    }
}