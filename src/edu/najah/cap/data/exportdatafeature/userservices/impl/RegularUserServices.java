package edu.najah.cap.data.exportdatafeature.userservices.impl;

import edu.najah.cap.activity.IUserActivityService;
import edu.najah.cap.activity.UserActivity;
import edu.najah.cap.data.exportdatafeature.userservices.intf.ICreateDataObjectUser;
import edu.najah.cap.exceptions.BadRequestException;
import edu.najah.cap.exceptions.NotFoundException;
import edu.najah.cap.exceptions.SystemBusyException;
import edu.najah.cap.iam.IUserService;
import edu.najah.cap.iam.UserProfile;
import edu.najah.cap.posts.IPostService;

import java.util.List;

public class RegularUserServices extends ICreateDataObjectUser {
    IUserActivityService userActivityService;

    public RegularUserServices(String userName,
                               IPostService postService,
                               IUserService userService,
                               IUserActivityService userActivityService) {
        super(userName, userService, postService);
        this.userActivityService = userActivityService;
    }

    @Override
    public String getDataUser() throws SystemBusyException, BadRequestException, NotFoundException {
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
        return result.toString();
    }
}
