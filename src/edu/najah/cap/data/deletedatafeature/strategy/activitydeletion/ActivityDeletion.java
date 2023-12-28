package edu.najah.cap.data.deletedatafeature.strategy.activitydeletion;

import edu.najah.cap.activity.UserActivity;
import edu.najah.cap.data.helpers.Services;
import edu.najah.cap.exceptions.BadRequestException;
import edu.najah.cap.exceptions.NotFoundException;
import edu.najah.cap.exceptions.SystemBusyException;
import edu.najah.cap.iam.UserProfile;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ActivityDeletion implements ActivityDeletionBehavior {
    @Override

    public void deleteActivities(UserProfile user) throws SystemBusyException, BadRequestException, NotFoundException {
        List<UserActivity> userActivities = Services.getUserActivityServiceInstance().getUserActivity(user.getUserName());

        ExecutorService executor = Executors.newFixedThreadPool(5);

        try {
            for (UserActivity activity : userActivities) {
                executor.submit(() -> {
                    try {
                        Services.getUserActivityServiceInstance().removeUserActivity(user.getUserName(), activity.getId());
                    } catch (SystemBusyException | BadRequestException | NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
        } finally {
            executor.shutdown();
        }
    }
}
