package edu.najah.cap.data.exportdatafeature.factory;

import edu.najah.cap.activity.IUserActivityService;
import edu.najah.cap.iam.IUserService;
import edu.najah.cap.iam.UserProfile;
import edu.najah.cap.payment.IPayment;
import edu.najah.cap.posts.IPostService;

public class FactoryUserType {
    public static void creationUserDataObject(UserProfile user, IUserActivityService userActivityService, IPayment paymentService, IUserService userService, IPostService postService) {
        switch (user.getUserType()) {
            case NEW_USER:
                // return NEW_USER data object
                break;
            case REGULAR_USER:
                // return   REGULAR USER  data object
                break;
            case PREMIUM_USER:
                // return   PREMIUM USER  data object
                break;
            default:
                throw new IllegalArgumentException("Unsupported this user type . ");
        }

    }
}