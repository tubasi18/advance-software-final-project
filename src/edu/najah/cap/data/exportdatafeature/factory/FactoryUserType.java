package edu.najah.cap.data.exportdatafeature.factory;

import edu.najah.cap.activity.IUserActivityService;
import edu.najah.cap.data.exportdatafeature.factory.Interfaces.ICreateDataObjectUser;
import edu.najah.cap.data.exportdatafeature.factory.SubClasses.NewUser;
import edu.najah.cap.data.exportdatafeature.factory.SubClasses.PremiumUser;
import edu.najah.cap.data.exportdatafeature.factory.SubClasses.RegularUser;
import edu.najah.cap.iam.IUserService;
import edu.najah.cap.iam.UserProfile;
import edu.najah.cap.payment.IPayment;
import edu.najah.cap.posts.IPostService;

public class FactoryUserType {
    public static ICreateDataObjectUser creationUserDataObject(UserProfile user,
                                                               IUserActivityService userActivityService,
                                                               IPayment paymentService,
                                                               IUserService userService,
                                                               IPostService postService) {
        return switch (user.getUserType()) {
            case NEW_USER -> new NewUser(user, postService, userService);
            case REGULAR_USER -> new RegularUser(user, postService, userService, userActivityService);
            case PREMIUM_USER -> new PremiumUser(user, userActivityService, paymentService, userService, postService);
            default -> throw new IllegalArgumentException("Unsupported this user type . ");
        };
    }
}