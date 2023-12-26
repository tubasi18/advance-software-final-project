package edu.najah.cap.data.deletedatafeature.strategy.profiledeltion;

import edu.najah.cap.iam.UserProfile;
import edu.najah.cap.iam.UserService;

public interface ProfileDeletionBehavior {
    void deleteProfile(UserProfile user);
}
