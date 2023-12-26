package edu.najah.cap.data.deletedatafeature.strategy.postdeletion;

import edu.najah.cap.data.Services;
<<<<<<< Updated upstream
=======
import edu.najah.cap.exceptions.BadRequestException;
import edu.najah.cap.exceptions.NotFoundException;
import edu.najah.cap.exceptions.SystemBusyException;
>>>>>>> Stashed changes
import edu.najah.cap.iam.UserProfile;

public class PostDeletion implements PostDeletionBehavior{

    @Override
<<<<<<< Updated upstream
    public void deletePost(UserProfile user) {
=======
    public void deletePost(UserProfile user) throws SystemBusyException, BadRequestException, NotFoundException {
>>>>>>> Stashed changes
        Services.getUserPostServiceInstance().deletePost(user.getUserName(),user.getUserName());
    }
}
