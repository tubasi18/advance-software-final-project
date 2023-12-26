package edu.najah.cap.data.deletedatafeature.strategy;

import edu.najah.cap.data.deletedatafeature.strategy.activitydeletion.ActivityDeletionBehavior;
import edu.najah.cap.data.deletedatafeature.strategy.interfaces.IDeleteContext;
import edu.najah.cap.data.deletedatafeature.strategy.paymentdeletion.PaymentDeletionBehavior;
import edu.najah.cap.data.deletedatafeature.strategy.postdeletion.PostDeletionBehavior;
import edu.najah.cap.data.deletedatafeature.strategy.profiledeltion.ProfileDeletionBehavior;
import edu.najah.cap.iam.UserProfile;

public class DeleteContext implements IDeleteContext {
    private ActivityDeletionBehavior activityDeletionBehavior;
    private PaymentDeletionBehavior paymentDeletionBehavior;
    private ProfileDeletionBehavior profileDeletionBehavior;
    private PostDeletionBehavior postDeletionBehavior;

    // Constructor with all behaviors
    public DeleteContext(ActivityDeletionBehavior activityDeletionBehavior,
                         PaymentDeletionBehavior paymentDeletionBehavior,
                         ProfileDeletionBehavior profileDeletionBehavior,
                         PostDeletionBehavior postDeletionBehavior) {
        this.activityDeletionBehavior = activityDeletionBehavior;
        this.paymentDeletionBehavior = paymentDeletionBehavior;
        this.profileDeletionBehavior = profileDeletionBehavior;
        this.postDeletionBehavior = postDeletionBehavior;
    }

    // Execute the deletion process
    public void executeDeletion(UserProfile user, boolean isHardDelete) {
        if (postDeletionBehavior != null) {
            postDeletionBehavior.deletePost(user);
        }
        if (activityDeletionBehavior != null) {
            activityDeletionBehavior.deleteActivities(user);
        }
        if (paymentDeletionBehavior != null) {
            paymentDeletionBehavior.deletePayment(user);
        }
        if (isHardDelete && profileDeletionBehavior != null) {
            profileDeletionBehavior.deleteProfile(user);
        }
    }


    @Override
    public ProfileDeletionBehavior getProfileDeletionBehavior() {
        return null;
    }

    @Override
    public PaymentDeletionBehavior getPaymentDeletionBehavior() {
        return null;
    }

    @Override
    public ActivityDeletionBehavior getActivityDeletionBehavior() {
        return null;
    }

    @Override
    public PostDeletionBehavior getPostDeletionBehavior() {
        return null;
    }
}
