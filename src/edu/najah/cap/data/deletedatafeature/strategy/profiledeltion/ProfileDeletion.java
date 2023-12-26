package edu.najah.cap.data.deletedatafeature.strategy.profiledeltion;
import edu.najah.cap.data.Helpers.DeletedUsernamesTracker;
import edu.najah.cap.data.Services;
import edu.najah.cap.iam.UserProfile;
public class ProfileDeletion implements ProfileDeletionBehavior{
    @Override
    public void deleteProfile(UserProfile user) {
        DeletedUsernamesTracker.archiveUsername(user.getUserName());
        Services.getUserServiceInstance().deleteUser(user.getUserName());
    }
}
