package edu.najah.cap.data.exportdatafeature.factory;
import edu.najah.cap.data.Services;
import edu.najah.cap.data.exportdatafeature.factory.interfaces.ICreateDataObjectUser;
import edu.najah.cap.data.exportdatafeature.factory.implementation.NewUser;
import edu.najah.cap.data.exportdatafeature.factory.implementation.PremiumUser;
import edu.najah.cap.data.exportdatafeature.factory.implementation.RegularUser;
import edu.najah.cap.iam.UserProfile;


public class FactoryUserType {
    public static ICreateDataObjectUser creationUserDataObject(UserProfile user) {
        return switch (user.getUserType()) {
            case NEW_USER ->
                    new NewUser(user, Services.getUserPostServiceInstance(), Services.getUserServiceInstance());
            case REGULAR_USER -> new RegularUser(user,
                    Services.getUserPostServiceInstance(),
                    Services.getUserServiceInstance(),
                    Services.getUserActivityServiceInstance());
            case PREMIUM_USER -> new PremiumUser(user,
                    Services.getUserActivityServiceInstance(),
                    Services.getUserPaymentServiceInstance(),
                    Services.getUserServiceInstance(),
                    Services.getUserPostServiceInstance());
            default -> throw new IllegalArgumentException("Unsupported this user type .");
        };
    }
}