package edu.najah.cap.data.deletedatafeature.factory;

import edu.najah.cap.data.deletedatafeature.factory.intf.IDeletionBehavior;
import edu.najah.cap.data.deletedatafeature.factory.deletionbehavior.ActivityDeletion;
import edu.najah.cap.data.deletedatafeature.factory.deletionbehavior.PaymentDeletion;
import edu.najah.cap.data.deletedatafeature.factory.deletionbehavior.PostDeletion;
import edu.najah.cap.data.deletedatafeature.factory.typedelete.HardDelete;
import edu.najah.cap.exceptions.InvalidUserTypeException;
import edu.najah.cap.iam.UserProfile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class FactoryDeletionBehavior {
    private static final Logger logger = LogManager.getLogger(FactoryDeletionBehavior.class);

    private FactoryDeletionBehavior(){}
    public static List<IDeletionBehavior> deletionBehavior(UserProfile user) throws InvalidUserTypeException {
        List< IDeletionBehavior> deletionBehaviors=new ArrayList<>();
        deletionBehaviors.add(new PostDeletion());
        switch (user.getUserType()) {
            case NEW_USER:
                logger.info("User Type is New; Post Deletion is Returned");
                return deletionBehaviors;
            case REGULAR_USER:
                deletionBehaviors.add(new ActivityDeletion());
                logger.info("User Type is Regular; Post and Activity deletions are Returned");
                return deletionBehaviors;
            case PREMIUM_USER:
                deletionBehaviors.add(new ActivityDeletion());
                deletionBehaviors.add(new PaymentDeletion());
                logger.info("User Type is Premium; Post, Activity and Payment deletions are Returned");
                return deletionBehaviors;
        }
        logger.error("Unsupported user type" + user.getUserType());
        throw new InvalidUserTypeException("Unsupported user type." + user.getUserType());
    }
}
