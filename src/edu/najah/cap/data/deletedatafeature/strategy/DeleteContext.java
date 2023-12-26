package edu.najah.cap.data.deletedatafeature.strategy;

import edu.najah.cap.data.deletedatafeature.strategy.activitydeletion.ActivityDeletionBehavior;
import edu.najah.cap.data.deletedatafeature.strategy.interfaces.IDeleteContext;
import edu.najah.cap.data.deletedatafeature.strategy.paymentdeletion.PaymentDeletionBehavior;
import edu.najah.cap.data.deletedatafeature.strategy.postdeletion.PostDeletionBehavior;
import edu.najah.cap.data.deletedatafeature.strategy.profiledeltion.ProfileDeletionBehavior;

public class DeleteContext implements IDeleteContext {
    private ActivityDeletionBehavior activityDeletionBehavior;
    private PaymentDeletionBehavior paymentDeletionBehavior;
    private ProfileDeletionBehavior profileDeletionBehavior;
    private PostDeletionBehavior postDeletionBehavior;

    public DeleteContext(ActivityDeletionBehavior activityDeletionBehavior,
                         PaymentDeletionBehavior paymentDeletionBehavior,
                         ProfileDeletionBehavior profileDeletionBehavior, PostDeletionBehavior postDeletionBehavior) {
        this.activityDeletionBehavior = activityDeletionBehavior;
        this.paymentDeletionBehavior = paymentDeletionBehavior;
        this.profileDeletionBehavior = profileDeletionBehavior;
        this.postDeletionBehavior = postDeletionBehavior;
    }

    public DeleteContext() {
        activityDeletionBehavior = null;
        paymentDeletionBehavior = null;
        profileDeletionBehavior = null;
        postDeletionBehavior = null;
    }

    public ActivityDeletionBehavior getActivityDeletionBehavior() {
        return activityDeletionBehavior;
    }

    public void setActivityDeletionBehavior(ActivityDeletionBehavior activityDeletionBehavior) {
        this.activityDeletionBehavior = activityDeletionBehavior;
    }

    public PaymentDeletionBehavior getPaymentDeletionBehavior() {
        return paymentDeletionBehavior;
    }

    public void setPaymentDeletionBehavior(PaymentDeletionBehavior paymentDeletionBehavior) {
        this.paymentDeletionBehavior = paymentDeletionBehavior;
    }

    public ProfileDeletionBehavior getProfileDeletionBehavior() {
        return profileDeletionBehavior;
    }

    public PostDeletionBehavior getPostDeletionBehavior() {
        return postDeletionBehavior;
    }

    public void setPostDeletionBehavior(PostDeletionBehavior postDeletionBehavior) {
        this.postDeletionBehavior = postDeletionBehavior;
    }

    public void setProfileDeletionBehavior(ProfileDeletionBehavior profileDeletionBehavior) {
        this.profileDeletionBehavior = profileDeletionBehavior;
    }
}
