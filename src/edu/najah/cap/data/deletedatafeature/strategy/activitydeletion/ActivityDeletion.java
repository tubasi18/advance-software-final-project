package edu.najah.cap.data.deletedatafeature.strategy.activitydeletion;
import edu.najah.cap.activity.UserActivity;
import edu.najah.cap.data.Services;
import edu.najah.cap.iam.UserProfile;
import java.util.List;
public class ActivityDeletion implements ActivityDeletionBehavior {
    @Override
    public void deleteActivities(UserProfile user) {
        List<UserActivity> userActivities= Services.getUserActivityServiceInstance().getUserActivity(user.getUserName());
        for( UserActivity activity:userActivities){
            Services.getUserActivityServiceInstance().removeUserActivity(user.getUserName(),activity.getId());
        }
    }
}
