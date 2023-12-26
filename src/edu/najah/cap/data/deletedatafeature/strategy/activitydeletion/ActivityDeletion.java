package edu.najah.cap.data.deletedatafeature.strategy.activitydeletion;
import edu.najah.cap.activity.UserActivity;
import edu.najah.cap.data.Services;
import edu.najah.cap.iam.UserService;
import java.util.List;
public class ActivityDeletion implements ActivityDeletionBehavior {
    @Override
    public void deleteActivities(UserService user) {
        List<UserActivity> userActivities= Services.getUserActivityServiceInstance().getUserActivity(user.getUserName());
        for( UserActivity activity:userActivities){
            Services.getUserActivityServiceInstance().removeUserActivity(user.getUserName(),activity.getId());
        }
    }
}
