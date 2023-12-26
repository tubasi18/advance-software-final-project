package edu.najah.cap.data.deletedatafeature.strategy;

import edu.najah.cap.data.deletedatafeature.strategy.activitydeletion.ActivityDeletion;
import edu.najah.cap.data.deletedatafeature.strategy.activitydeletion.ActivityDeletionBehavior;
import edu.najah.cap.data.deletedatafeature.strategy.paymentdeletion.PaymentDeletion;
import edu.najah.cap.data.deletedatafeature.strategy.paymentdeletion.PaymentDeletionBehavior;
import edu.najah.cap.data.deletedatafeature.strategy.postdeletion.PostDeletion;
import edu.najah.cap.data.deletedatafeature.strategy.postdeletion.PostDeletionBehavior;
import edu.najah.cap.data.deletedatafeature.strategy.profiledeltion.ProfileDeletion;
import edu.najah.cap.data.deletedatafeature.strategy.profiledeltion.ProfileDeletionBehavior;
import edu.najah.cap.iam.UserProfile;
import edu.najah.cap.iam.UserType;

public class FactoryContext {
    public void factoryProcess(UserProfile user, boolean isHardDelete) {
        PostDeletionBehavior postDeletion =  new PostDeletion();
        ActivityDeletionBehavior activityDeletion = (user.getUserType() == UserType.REGULAR_USER || user.getUserType() == UserType.PREMIUM_USER) ? new ActivityDeletion() : null;
        PaymentDeletionBehavior paymentDeletion = (user.getUserType() == UserType.PREMIUM_USER) ? new PaymentDeletion() : null;
        ProfileDeletionBehavior profileDeletion = isHardDelete ? new ProfileDeletion() : null;

        DeleteContext deletionContext = new DeleteContext(activityDeletion, paymentDeletion, profileDeletion, postDeletion);

        deletionContext.executeDeletion(user, isHardDelete);
    }
}
