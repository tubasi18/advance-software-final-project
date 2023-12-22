package edu.najah.cap.data.exportdatafeature.factory.SubClasses;

import edu.najah.cap.activity.IUserActivityService;
import edu.najah.cap.activity.UserActivity;
import edu.najah.cap.data.exportdatafeature.factory.Interfaces.ICreateDataObjectUser;
import edu.najah.cap.iam.IUserService;
import edu.najah.cap.iam.UserProfile;
import edu.najah.cap.payment.IPayment;
import edu.najah.cap.posts.IPostService;
import edu.najah.cap.posts.Post;

import java.util.List;

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
        return super.getDataProfile()
                + super.getPostsDetails()
                + "Activity Data: " + getActivityData()
                + "Payment Data: " + getPaymentData();
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

    public Double getPaymentData() {
        return paymentService.getBalance(super.getUserName());
    }
}
