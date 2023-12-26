package edu.najah.cap.data.deletedatafeature.strategy.interfaces;

import edu.najah.cap.data.deletedatafeature.strategy.activitydeletion.ActivityDeletionBehavior;
import edu.najah.cap.data.deletedatafeature.strategy.paymentdeletion.PaymentDeletionBehavior;
import edu.najah.cap.data.deletedatafeature.strategy.postdeletion.PostDeletionBehavior;
import edu.najah.cap.data.deletedatafeature.strategy.profiledeltion.ProfileDeletionBehavior;

public interface IDeleteContext {
    ProfileDeletionBehavior getProfileDeletionBehavior();

    PaymentDeletionBehavior getPaymentDeletionBehavior();

    ActivityDeletionBehavior getActivityDeletionBehavior();

    PostDeletionBehavior getPostDeletionBehavior();

    void setActivityDeletionBehavior(ActivityDeletionBehavior activityDeletionBehavior);

    void setPostDeletionBehavior(PostDeletionBehavior postDeletionBehavior);

    void setPaymentDeletionBehavior(PaymentDeletionBehavior paymentDeletionBehavior);

    void setProfileDeletionBehavior(ProfileDeletionBehavior profileDeletionBehavior);
}
