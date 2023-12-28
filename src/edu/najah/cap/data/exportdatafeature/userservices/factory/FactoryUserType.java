package edu.najah.cap.data.exportdatafeature.userservices.factory;
import edu.najah.cap.data.helpers.Services;
import edu.najah.cap.data.exportdatafeature.userservices.intf.ICreateDataObjectUser;
import edu.najah.cap.data.exportdatafeature.userservices.impl.NewUserServices;
import edu.najah.cap.data.exportdatafeature.userservices.impl.PremiumUserServices;
import edu.najah.cap.data.exportdatafeature.userservices.impl.RegularUserServices;
import edu.najah.cap.exceptions.InvalidUserTypeException;
import edu.najah.cap.iam.UserProfile;


public class FactoryUserType {

    private FactoryUserType() {
    }

    public static ICreateDataObjectUser creationUserDataObject(UserProfile user) throws InvalidUserTypeException {
        return switch (user.getUserType()) {
            case NEW_USER ->
                    new NewUserServices(user, Services.getUserPostServiceInstance(), Services.getUserServiceInstance());
            case REGULAR_USER -> new RegularUserServices(user,
                    Services.getUserPostServiceInstance(),
                    Services.getUserServiceInstance(),
                    Services.getUserActivityServiceInstance());
            case PREMIUM_USER -> new PremiumUserServices(user,
                    Services.getUserActivityServiceInstance(),
                    Services.getUserPaymentServiceInstance(),
                    Services.getUserServiceInstance(),
                    Services.getUserPostServiceInstance());
            default ->  throw new InvalidUserTypeException("Unsupported this user type .");
        };
    }
}