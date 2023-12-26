package edu.najah.cap.data.deletedatafeature.strategy.postdeletion;

import edu.najah.cap.data.Services;
import edu.najah.cap.exceptions.BadRequestException;
import edu.najah.cap.exceptions.NotFoundException;
import edu.najah.cap.exceptions.SystemBusyException;
import edu.najah.cap.iam.UserProfile;

public class PostDeletion implements PostDeletionBehavior {

    @Override

    public void deletePost(UserProfile user) throws SystemBusyException, BadRequestException, NotFoundException {

        Services.getUserPostServiceInstance().deletePost(user.getUserName(), user.getUserName());
    }
}

