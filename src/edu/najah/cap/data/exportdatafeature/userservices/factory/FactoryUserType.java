package edu.najah.cap.data.exportdatafeature.userservices.factory;

import com.itextpdf.text.log.LoggerFactory;
import edu.najah.cap.data.helpers.Services;
import edu.najah.cap.data.exportdatafeature.userservices.abst.ICreateDataObjectUser;
import edu.najah.cap.data.exportdatafeature.userservices.impl.NewUserServices;
import edu.najah.cap.data.exportdatafeature.userservices.impl.PremiumUserServices;
import edu.najah.cap.data.exportdatafeature.userservices.impl.RegularUserServices;
import edu.najah.cap.exceptions.InvalidUserTypeException;
import edu.najah.cap.iam.UserProfile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class FactoryUserType {

    private static final Logger logger = LogManager.getLogger(FactoryUserType.class);

    private FactoryUserType() {
    }

    public static ICreateDataObjectUser creationUserDataObject(UserProfile user) throws InvalidUserTypeException {
        String userName = user.getUserName();
        return switch (user.getUserType()) {
            case NEW_USER -> {
                logger.info("Creating NewUserServices for user: {}", userName);
                yield new NewUserServices(userName, Services.getUserPostServiceInstance(), Services.getUserServiceInstance());
            }
            case REGULAR_USER -> {
                logger.info("Creating RegularUserServices for user: {}", userName);
                yield new RegularUserServices(userName,
                        Services.getUserPostServiceInstance(),
                        Services.getUserServiceInstance(),
                        Services.getUserActivityServiceInstance());
            }
            case PREMIUM_USER -> {
                logger.info("Creating PremiumUserServices for user: {}", userName);
                yield new PremiumUserServices(userName,
                        Services.getUserActivityServiceInstance(),
                        Services.getUserPaymentServiceInstance(),
                        Services.getUserServiceInstance(),
                        Services.getUserPostServiceInstance());
            }
            default -> {
                logger.error("Unsupported user type: {}", user.getUserType());
                throw new InvalidUserTypeException("Unsupported user type.");
            }
        };
    }
}
