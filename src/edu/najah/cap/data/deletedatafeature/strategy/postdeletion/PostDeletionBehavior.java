package edu.najah.cap.data.deletedatafeature.strategy.postdeletion;

import edu.najah.cap.iam.UserProfile;

public interface PostDeletionBehavior {
    void deletePost(UserProfile user);
}
