package edu.najah.cap.data.deletedatafeature.strategy;

import edu.najah.cap.data.deletedatafeature.strategy.activitydeletion.ActivityDeletionBehavior;
import edu.najah.cap.data.deletedatafeature.strategy.paymentdeletion.PaymentDeletionBehavior;
import edu.najah.cap.data.deletedatafeature.strategy.postdeletion.PostDeletionBehavior;
import edu.najah.cap.data.deletedatafeature.strategy.profiledeltion.ProfileDeletionBehavior;
import edu.najah.cap.exceptions.BadRequestException;
import edu.najah.cap.exceptions.NotFoundException;
import edu.najah.cap.exceptions.SystemBusyException;
import edu.najah.cap.iam.UserProfile;

public class DeleteContext  {
    private ActivityDeletionBehavior activityDeletionBehavior;
    private PaymentDeletionBehavior paymentDeletionBehavior;
    private ProfileDeletionBehavior profileDeletionBehavior;
    private PostDeletionBehavior postDeletionBehavior;

    public DeleteContext(ActivityDeletionBehavior activityDeletionBehavior,
                         PaymentDeletionBehavior paymentDeletionBehavior,
                         ProfileDeletionBehavior profileDeletionBehavior,
                         PostDeletionBehavior postDeletionBehavior) {
        this.activityDeletionBehavior = activityDeletionBehavior;
        this.paymentDeletionBehavior = paymentDeletionBehavior;
        this.profileDeletionBehavior = profileDeletionBehavior;
        this.postDeletionBehavior = postDeletionBehavior;
    }

    public void executeDeletion(UserProfile user, boolean isHardDelete) throws SystemBusyException, NotFoundException, BadRequestException {
        if (postDeletionBehavior != null) {
            postDeletionBehavior.deletePost(user);
        }
        if (activityDeletionBehavior != null) {
            activityDeletionBehavior.deleteActivities(user);
        }
        if (paymentDeletionBehavior != null) {
            paymentDeletionBehavior.deletePayment(user);
        }
        if (profileDeletionBehavior != null) {
            profileDeletionBehavior.deleteProfile(user);
        }
    }

}
