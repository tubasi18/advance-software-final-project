package edu.najah.cap.data.deletedatafeature.strategy.activitydeletion;

import edu.najah.cap.iam.UserProfile;

public interface ActivityDeletionBehavior {
    void deleteActivities(UserProfile user);
}
