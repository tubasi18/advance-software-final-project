package edu.najah.cap.data.exportdatafeature.factory;

import edu.najah.cap.activity.IUserActivityService;
import edu.najah.cap.activity.UserActivityService;
import edu.najah.cap.data.exportdatafeature.factory.Interfaces.ICreateDataObjectUser;
import edu.najah.cap.data.exportdatafeature.factory.SubClasses.NewUser;
import edu.najah.cap.data.exportdatafeature.factory.SubClasses.PremiumUser;
import edu.najah.cap.data.exportdatafeature.factory.SubClasses.RegularUser;
import edu.najah.cap.iam.IUserService;
import edu.najah.cap.iam.UserProfile;
import edu.najah.cap.iam.UserService;
import edu.najah.cap.payment.IPayment;
import edu.najah.cap.payment.PaymentService;
import edu.najah.cap.posts.IPostService;
import edu.najah.cap.posts.PostService;

public class FactoryUserType {
    public static ICreateDataObjectUser creationUserDataObject(UserProfile user) {
        return switch (user.getUserType()) {
            case NEW_USER -> new NewUser(user, new PostService(), new UserService());
            case REGULAR_USER -> new RegularUser(user,
                    new PostService(),
                    new UserService(),
                    new UserActivityService());
            case PREMIUM_USER -> new PremiumUser(user,
                    new UserActivityService(),
                    new PaymentService(),
                    new UserService(),
                    new PostService());
            default -> throw new IllegalArgumentException("Unsupported this user type . ");
        };
    }
}