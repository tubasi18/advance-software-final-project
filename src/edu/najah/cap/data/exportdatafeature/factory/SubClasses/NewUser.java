package edu.najah.cap.data.exportdatafeature.factory.SubClasses;

import edu.najah.cap.activity.IUserActivityService;
import edu.najah.cap.data.exportdatafeature.factory.Interfaces.ICreateDataObjectUser;
import edu.najah.cap.iam.IUserService;
import edu.najah.cap.iam.UserProfile;
import edu.najah.cap.payment.IPayment;
import edu.najah.cap.posts.IPostService;

public class NewUser extends ICreateDataObjectUser {

    public NewUser(UserProfile userProfile, IPostService postService, IUserService userService) {
        super(userService, userProfile, postService);
    }

    @Override
    public String getDataUser() {
        return getUserProfile().getUserName() + "  " +  getUserProfile().getCity();
    }
}
