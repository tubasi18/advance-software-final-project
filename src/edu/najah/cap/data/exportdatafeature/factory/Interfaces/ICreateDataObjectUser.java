package edu.najah.cap.data.exportdatafeature.factory.Interfaces;

import edu.najah.cap.activity.IUserActivityService;
import edu.najah.cap.iam.IUserService;
import edu.najah.cap.iam.UserProfile;
import edu.najah.cap.payment.IPayment;
import edu.najah.cap.posts.IPostService;

public abstract class ICreateDataObjectUser {
    IUserService userService;
    UserProfile userProfile;
    IPostService postService;

    public IUserService getUserService() {
        return userService;
    }

    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    public IPostService getPostService() {
        return postService;
    }

    public void setPostService(IPostService postService) {
        this.postService = postService;
    }

    public ICreateDataObjectUser(IUserService userService, UserProfile userProfile, IPostService postService) {
        this.userService = userService;
        this.userProfile = userProfile;
        this.postService = postService;
    }

    public abstract String getDataUser();

}
