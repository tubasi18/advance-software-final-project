package edu.najah.cap.data.exportdatafeature.factory.implementation;

import edu.najah.cap.activity.IUserActivityService;
import edu.najah.cap.activity.UserActivity;
import edu.najah.cap.data.exportdatafeature.factory.interfaces.ICreateDataObjectUser;
import edu.najah.cap.iam.IUserService;
import edu.najah.cap.iam.UserProfile;
import edu.najah.cap.posts.IPostService;

import java.util.List;

public class RegularUser extends ICreateDataObjectUser {
    IUserActivityService userActivityService;

    public RegularUser(UserProfile userProfile, IPostService postService, IUserService userService, IUserActivityService userActivityService) {
        super(userService, userProfile, postService);
        this.userActivityService = userActivityService;
    }

    @Override
    public String getDataUser() {
        return super.getDataProfile()
                + super.getPostsDetails()
                + getActivityData();
    }

    public String getActivityData() {
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
