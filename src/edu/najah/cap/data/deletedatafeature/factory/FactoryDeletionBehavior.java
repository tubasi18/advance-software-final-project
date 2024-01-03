package edu.najah.cap.data.deletedatafeature.factory;

import edu.najah.cap.data.deletedatafeature.factory.intf.IDeletionBehavior;
import edu.najah.cap.data.deletedatafeature.factory.deletionbehavior.ActivityDeletion;
import edu.najah.cap.data.deletedatafeature.factory.deletionbehavior.PaymentDeletion;
import edu.najah.cap.data.deletedatafeature.factory.deletionbehavior.PostDeletion;
import edu.najah.cap.exceptions.InvalidUserTypeException;
import edu.najah.cap.iam.UserProfile;
import java.util.ArrayList;
import java.util.List;

public class FactoryDeletionBehavior {

    private FactoryDeletionBehavior(){}
    public static List<IDeletionBehavior> deletionBehavior(UserProfile user) throws InvalidUserTypeException {
        List< IDeletionBehavior> deletionBehaviors=new ArrayList<>();
        deletionBehaviors.add(new PostDeletion());
        switch (user.getUserType()) {
            case NEW_USER:
                return deletionBehaviors;
            case REGULAR_USER:
                deletionBehaviors.add(new ActivityDeletion());
                return deletionBehaviors;
            case PREMIUM_USER:
                deletionBehaviors.add(new ActivityDeletion());
                deletionBehaviors.add(new PaymentDeletion());
                return deletionBehaviors;
        }
        throw new InvalidUserTypeException("Unsupported user type." + user);
    }
}
