package edu.najah.cap.data.deletedatafeature.deletionbehavior;

import edu.najah.cap.activity.UserActivity;
import edu.najah.cap.data.deletedatafeature.intf.IDeletionBehavior;
import edu.najah.cap.data.helpers.Services;
import edu.najah.cap.data.helpers.YmlHandler;
import edu.najah.cap.exceptions.BadRequestException;
import edu.najah.cap.exceptions.NotFoundException;
import edu.najah.cap.exceptions.SystemBusyException;
import edu.najah.cap.iam.UserProfile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ActivityDeletion implements IDeletionBehavior {
    private static final Logger logger = LogManager.getLogger(ActivityDeletion.class);

    @Override
    public void delete(UserProfile user) throws SystemBusyException, BadRequestException, NotFoundException, FileNotFoundException {
        List<UserActivity> activity = new ArrayList<>(Services.getUserActivityServiceInstance().getUserActivity(user.getUserName()));
        ExecutorService executor = Executors.newFixedThreadPool(Integer.parseInt(YmlHandler.getValue("threads")));
        executor.submit(() -> {
            try {
                logger.info(String.format("Deleting Activity is running for user :  %s", user.getUserName()));
                for (Iterator<UserActivity> iterator = activity.iterator(); iterator.hasNext(); ) {
                    UserActivity activities = iterator.next();
                    Services.getUserActivityServiceInstance().removeUserActivity(user.getUserName(), activities.getId());
                    iterator.remove();
                }
            } catch (NotFoundException | BadRequestException | SystemBusyException e) {
                logger.error(String.format("Activity are not found for user: %s", user.getUserName()));
            }
        });
        executor.shutdown();
    }
}


