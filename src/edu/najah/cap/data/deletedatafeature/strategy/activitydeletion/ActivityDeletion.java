package edu.najah.cap.data.deletedatafeature.strategy.activitydeletion;

import edu.najah.cap.activity.UserActivity;
import edu.najah.cap.data.Services;
import edu.najah.cap.exceptions.BadRequestException;
import edu.najah.cap.exceptions.NotFoundException;
import edu.najah.cap.exceptions.SystemBusyException;
import edu.najah.cap.iam.UserProfile;

import java.util.Iterator;
import java.util.List;

public class ActivityDeletion implements ActivityDeletionBehavior {
    @Override

    public void deleteActivities(UserProfile user) throws SystemBusyException, BadRequestException, NotFoundException {

        List<UserActivity> userActivities = Services.getUserActivityServiceInstance().getUserActivity(user.getUserName());
        Iterator<UserActivity> iterator = userActivities.iterator();

        while (iterator.hasNext()) {
            UserActivity activity = iterator.next();
            Services.getUserActivityServiceInstance().removeUserActivity(user.getUserName(), activity.getId());
            iterator.remove();
        }
    }
}
