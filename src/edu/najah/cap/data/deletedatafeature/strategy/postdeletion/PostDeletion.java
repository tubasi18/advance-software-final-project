package edu.najah.cap.data.deletedatafeature.strategy.postdeletion;

import edu.najah.cap.data.Services;
import edu.najah.cap.iam.UserProfile;

public class PostDeletion implements PostDeletionBehavior{

    @Override
    public void deletePost(UserProfile user) {
        Services.getUserPostServiceInstance().deletePost(user.getUserName(),user.getUserName());
    }
}
