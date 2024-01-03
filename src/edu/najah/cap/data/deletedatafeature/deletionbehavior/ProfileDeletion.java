package edu.najah.cap.data.deletedatafeature.deletionbehavior;
import edu.najah.cap.data.deletedatafeature.intf.IDeletionBehavior;
import edu.najah.cap.data.helpers.UsersDeletedTracker;
import edu.najah.cap.data.helpers.Services;
import edu.najah.cap.exceptions.BadRequestException;
import edu.najah.cap.exceptions.NotFoundException;
import edu.najah.cap.exceptions.SystemBusyException;
import edu.najah.cap.iam.UserProfile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ProfileDeletion implements IDeletionBehavior {
    private static final Logger logger = LogManager.getLogger(ProfileDeletion.class);

    @Override
    public void delete(UserProfile user) throws  SystemBusyException, NotFoundException, BadRequestException {
        logger.info("User Profile deletion for Hard Delete");
        UsersDeletedTracker.archiveUsername(user.getUserName());
        logger.info("Archived Username for Future accounts");
        Services.getUserServiceInstance().deleteUser(user.getUserName());
    }
}
