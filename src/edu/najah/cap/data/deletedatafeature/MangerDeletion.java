package edu.najah.cap.data.deletedatafeature;

import edu.najah.cap.data.deletedatafeature.strategy.DeleteContext;
import edu.najah.cap.data.deletedatafeature.strategy.interfaces.IDeleteContext;
<<<<<<< Updated upstream
=======
import edu.najah.cap.exceptions.BadRequestException;
import edu.najah.cap.exceptions.NotFoundException;
import edu.najah.cap.exceptions.SystemBusyException;
>>>>>>> Stashed changes
import edu.najah.cap.iam.UserProfile;

public class MangerDeletion {
    private IDeleteContext deleteContext;

    public MangerDeletion(DeleteContext deleteContext) {
        this.deleteContext = deleteContext;
    }

<<<<<<< Updated upstream
    public void processDelete(UserProfile user) {
=======
    public void processDelete(UserProfile user) throws SystemBusyException, NotFoundException, BadRequestException {
>>>>>>> Stashed changes
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
    public void setDeletionContext(DeleteContext deletionContext) {
        this.deleteContext = deletionContext;
    }

}


