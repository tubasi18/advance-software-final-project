package edu.najah.cap.data.deletedatafeature.factory.impl;
import edu.najah.cap.data.deletedatafeature.factory.intf.IDeletionBehavior;
import edu.najah.cap.data.helpers.UsersDeletedTracker;
import edu.najah.cap.data.helpers.Services;
import edu.najah.cap.exceptions.BadRequestException;
import edu.najah.cap.exceptions.NotFoundException;
import edu.najah.cap.exceptions.SystemBusyException;
import edu.najah.cap.iam.UserProfile;

public class ProfileDeletion implements IDeletionBehavior {
    @Override
    public void delete(UserProfile user) throws  SystemBusyException, NotFoundException, BadRequestException {
        UsersDeletedTracker.archiveUsername(user.getUserName());
        Services.getUserServiceInstance().deleteUser(user.getUserName());
    }
}
