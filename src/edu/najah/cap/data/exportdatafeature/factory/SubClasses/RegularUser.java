package edu.najah.cap.data.exportdatafeature.factory.SubClasses;

import edu.najah.cap.activity.IUserActivityService;
import edu.najah.cap.data.exportdatafeature.factory.Interfaces.ICreateDataObjectUser;
import edu.najah.cap.iam.IUserService;
import edu.najah.cap.iam.UserProfile;
import edu.najah.cap.posts.IPostService;

public class RegularUser extends ICreateDataObjectUser {
    IUserActivityService userActivityService;

    public RegularUser(UserProfile userProfile, IPostService postService, IUserService userService, IUserActivityService userActivityService) {
        super(userService, userProfile, postService);
        this.userActivityService = userActivityService;
    }

    @Override
    public String getDataUser() {
        return null;
    }
}
