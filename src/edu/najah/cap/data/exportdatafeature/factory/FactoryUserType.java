package edu.najah.cap.data.exportdatafeature.factory;

import edu.najah.cap.activity.UserActivityService;
import edu.najah.cap.data.exportdatafeature.factory.interfaces.ICreateDataObjectUser;
import edu.najah.cap.data.exportdatafeature.factory.implementation.NewUser;
import edu.najah.cap.data.exportdatafeature.factory.implementation.PremiumUser;
import edu.najah.cap.data.exportdatafeature.factory.implementation.RegularUser;
import edu.najah.cap.iam.UserProfile;
import edu.najah.cap.iam.UserService;
import edu.najah.cap.payment.PaymentService;
import edu.najah.cap.posts.PostService;

public class FactoryUserType {

    private FactoryUserType(){}
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
            default -> throw new IllegalArgumentException("Unsupported this user type .");
        };
    }
}