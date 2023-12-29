package edu.najah.cap.data.exportdatafeature.userservices.impl;

import edu.najah.cap.activity.IUserActivityService;
import edu.najah.cap.activity.UserActivity;
import edu.najah.cap.data.exportdatafeature.userservices.intf.ICreateDataObjectUser;
import edu.najah.cap.exceptions.BadRequestException;
import edu.najah.cap.exceptions.NotFoundException;
import edu.najah.cap.exceptions.SystemBusyException;
import edu.najah.cap.iam.IUserService;
import edu.najah.cap.iam.UserProfile;
import edu.najah.cap.payment.IPayment;
import edu.najah.cap.posts.IPostService;

import java.util.List;

public class PremiumUserServices extends ICreateDataObjectUser {
    IUserActivityService userActivityService;
    IPayment paymentService;

    public PremiumUserServices(String userName,
                               IUserActivityService userActivityService,
                               IPayment paymentService,
                               IUserService userService,
                               IPostService postService) {
        super(userName,userService, postService);
        this.userActivityService = userActivityService;
        this.paymentService = paymentService;

    }

    @Override
    public String getDataUser() throws SystemBusyException, BadRequestException, NotFoundException {

                 return super.getDataProfile()
                    + super.getPostsDetails()
                    + "Activity Data: " + getActivityData() +
                    "/"
                    + "Payment Data: " + getPaymentData();

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

    public Double getPaymentData() throws SystemBusyException, NotFoundException, BadRequestException {
        return paymentService.getBalance(super.getUserName());
    }
}
