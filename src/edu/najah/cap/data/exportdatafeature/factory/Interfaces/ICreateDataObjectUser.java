package edu.najah.cap.data.exportdatafeature.factory.Interfaces;

import edu.najah.cap.activity.IUserActivityService;
import edu.najah.cap.iam.IUserService;
import edu.najah.cap.iam.UserProfile;
import edu.najah.cap.payment.IPayment;
import edu.najah.cap.posts.IPostService;
import edu.najah.cap.posts.Post;

import java.util.List;

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

    public String getPostsDetails() {
        List<Post> posts = getPostService()
                .getPosts(getUserProfile()
                        .getUserName());

        StringBuilder result = new StringBuilder();
        for (Post post : posts) {
            result.append("Post ID: ").append(post.getId()).append("\n")
                    .append("Title: ").append(post.getTitle()).append("\n")
                    .append("Body: ").append(post.getBody()).append("\n\n");
        }
        return result.toString();
    }

    public String getDataProfile() {
        return "Name: " + getUserProfile().getUserName()
                + " " + getUserProfile().getLastName()
                + "\n" + "City: " + getUserProfile().getCity() + "\n";
    }

    public String getUserName() {
        return getUserProfile().getUserName();
    }

    public abstract String getDataUser();
}
