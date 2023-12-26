package edu.najah.cap.data.deletedatafeature;

import edu.najah.cap.data.deletedatafeature.strategy.DeleteContext;
import edu.najah.cap.data.deletedatafeature.strategy.interfaces.IDeleteContext;
import edu.najah.cap.iam.UserProfile;

public class MangerDeletion {
    private IDeleteContext deleteContext;

    public MangerDeletion(DeleteContext deleteContext) {
        this.deleteContext = deleteContext;
    }

    public void processDelete(UserProfile user) {
        if (deleteContext.getActivityDeletionBehavior() != null) {
            deleteContext.getActivityDeletionBehavior().deleteActivities(user);
        }
        if (deleteContext.getPaymentDeletionBehavior() != null) {
            deleteContext.getProfileDeletionBehavior().deleteProfile(user);
        }
        if (deleteContext.getProfileDeletionBehavior() != null) {
            deleteContext.getProfileDeletionBehavior().deleteProfile(user);
        }
        if (deleteContext.getPostDeletionBehavior() != null) {
            deleteContext.getPostDeletionBehavior().deletePost(user);
        }
    }
}


