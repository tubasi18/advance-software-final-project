package edu.najah.cap.data.deletedatafeature.strategy.activitydeletion;

import edu.najah.cap.iam.UserService;

public interface ActivityDeletionBehavior {
    void deleteActivities(UserService user);
}
