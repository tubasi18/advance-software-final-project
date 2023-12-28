package edu.najah.cap.data.deletedatafeature.strategy;

import edu.najah.cap.data.deletedatafeature.strategy.activitydeletion.ActivityDeletion;
import edu.najah.cap.data.deletedatafeature.strategy.activitydeletion.ActivityDeletionBehavior;
import edu.najah.cap.data.deletedatafeature.strategy.paymentdeletion.PaymentDeletion;
import edu.najah.cap.data.deletedatafeature.strategy.paymentdeletion.PaymentDeletionBehavior;
import edu.najah.cap.data.deletedatafeature.strategy.postdeletion.PostDeletion;
import edu.najah.cap.data.deletedatafeature.strategy.postdeletion.PostDeletionBehavior;
import edu.najah.cap.data.deletedatafeature.strategy.profiledeltion.ProfileDeletion;
import edu.najah.cap.data.deletedatafeature.strategy.profiledeltion.ProfileDeletionBehavior;
import edu.najah.cap.exceptions.BadRequestException;
import edu.najah.cap.exceptions.NotFoundException;
import edu.najah.cap.exceptions.SystemBusyException;
import edu.najah.cap.iam.UserProfile;


public class FactoryContext {
    public static void factoryProcess(UserProfile user, boolean isHardDelete) throws SystemBusyException, BadRequestException, NotFoundException {
        ActivityDeletionBehavior activityDeletion = null;
        PaymentDeletionBehavior paymentDeletion = null;
        ProfileDeletionBehavior profileDeletion = null;
        PostDeletionBehavior postDeletion = new PostDeletion();
        switch (user.getUserType()) {
            case NEW_USER:
                break;
            case REGULAR_USER:
                activityDeletion = new ActivityDeletion();
                break;
            case PREMIUM_USER:
                activityDeletion = new ActivityDeletion();
                paymentDeletion = new PaymentDeletion();
                break;
        }
        if (isHardDelete) {
            profileDeletion = new ProfileDeletion();
        }

        DeleteContext deletionContext = new DeleteContext(activityDeletion, paymentDeletion, profileDeletion, postDeletion);
        deletionContext.executeDeletion(user, isHardDelete);
    }
}
