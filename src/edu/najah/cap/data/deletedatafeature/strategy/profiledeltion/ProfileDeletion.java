package edu.najah.cap.data.deletedatafeature.strategy.profiledeltion;
import edu.najah.cap.data.Helpers.DeletedUsernamesTracker;
import edu.najah.cap.data.Services;
import edu.najah.cap.exceptions.BadRequestException;
import edu.najah.cap.exceptions.NotFoundException;
import edu.najah.cap.exceptions.SystemBusyException;
import edu.najah.cap.iam.UserProfile;

public class ProfileDeletion implements ProfileDeletionBehavior{
    @Override
    public void deleteProfile(UserProfile user) throws  SystemBusyException, NotFoundException, BadRequestException {
        DeletedUsernamesTracker.archiveUsername(user.getUserName());
        Services.getUserServiceInstance().deleteUser(user.getUserName());
    }
}
