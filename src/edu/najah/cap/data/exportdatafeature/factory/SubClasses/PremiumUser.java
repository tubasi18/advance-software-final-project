package edu.najah.cap.data.exportdatafeature.factory.SubClasses;

import edu.najah.cap.activity.IUserActivityService;
import edu.najah.cap.data.exportdatafeature.factory.Interfaces.ICreateDataObjectUser;
import edu.najah.cap.iam.IUserService;
import edu.najah.cap.iam.UserProfile;
import edu.najah.cap.payment.IPayment;
import edu.najah.cap.posts.IPostService;

public class PremiumUser extends ICreateDataObjectUser {
    IUserActivityService userActivityService;
    IPayment paymentService;

    public PremiumUser(UserProfile userProfile, IUserActivityService userActivityService, IPayment paymentService, IUserService userService, IPostService postService) {
       super(userService, userProfile, postService);
        this.userActivityService = userActivityService;
        this.paymentService = paymentService;

    }
    @Override
    public String getDataUser() {
        return null;
    }
}
