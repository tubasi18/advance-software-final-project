package edu.najah.cap.data.exportdatafeature.userservices.impl;

import edu.najah.cap.activity.IUserActivityService;
import edu.najah.cap.activity.UserActivity;
import edu.najah.cap.data.exportdatafeature.userservices.abst.ICreateDataObjectUser;
import edu.najah.cap.exceptions.BadRequestException;
import edu.najah.cap.exceptions.NotFoundException;
import edu.najah.cap.exceptions.SystemBusyException;
import edu.najah.cap.iam.IUserService;
import edu.najah.cap.posts.IPostService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class RegularUserServices extends ICreateDataObjectUser {
   private final IUserActivityService userActivityService;
    private static final Logger logger = LogManager.getLogger(RegularUserServices.class);
    public RegularUserServices(String userName,
                               IPostService postService,
                               IUserService userService,
                               IUserActivityService userActivityService) {
        super(userName, userService, postService);
        this.userActivityService = userActivityService;
    }

    @Override
    public String getDataUser() throws SystemBusyException, BadRequestException, NotFoundException {
        logger.info(String.format("Data generated Successfully for the regular user: %s", getUserName()));
        return super.getDataProfile()
                + super.getPostsDetails()
                + getActivityData();
    }

    public String getActivityData() throws SystemBusyException, BadRequestException, NotFoundException {
        List<UserActivity> userActivities =
                userActivityService.getUserActivity(super.getUserName());

        StringBuilder result = new StringBuilder();
        for (UserActivity userActivity : userActivities) {
            result.append("Activity ID: ").append(userActivity.getId()).append("\n")
                    .append("Activity Date: ").append(userActivity.getActivityDate()).append("\n")
                    .append("Activity Type: ").append(userActivity.getActivityType()).append("\n\n");
        }
        logger.info(String.format("Activity data generated Successfully for the regular user: %s", getUserName()));
        return result.toString();
    }
}
