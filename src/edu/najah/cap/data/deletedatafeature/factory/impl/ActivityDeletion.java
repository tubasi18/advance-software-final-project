package edu.najah.cap.data.deletedatafeature.factory.impl;

import edu.najah.cap.activity.UserActivity;
import edu.najah.cap.data.deletedatafeature.factory.intf.IDeletionBehavior;
import edu.najah.cap.data.helpers.Services;
import edu.najah.cap.exceptions.BadRequestException;
import edu.najah.cap.exceptions.NotFoundException;
import edu.najah.cap.exceptions.SystemBusyException;
import edu.najah.cap.iam.UserProfile;
import edu.najah.cap.payment.Transaction;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ActivityDeletion implements IDeletionBehavior {
    @Override
    public void delete(UserProfile user) throws SystemBusyException, BadRequestException, NotFoundException {
        List<UserActivity> userActivities = Services.getUserActivityServiceInstance().getUserActivity(user.getUserName());


        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (UserActivity activity : userActivities) {
            executor.submit(() -> {
                try {
                      Services.getUserPostServiceInstance().deletePost(user.getUserName(), activity.getId());
                } catch (NotFoundException | SystemBusyException | BadRequestException e) {
                    e.printStackTrace();
                }
            });
        }
        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

