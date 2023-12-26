package edu.najah.cap.data.deletedatafeature.strategy.activitydeletion;

<<<<<<< Updated upstream
import edu.najah.cap.iam.UserProfile;

public interface ActivityDeletionBehavior {
    void deleteActivities(UserProfile user);
=======
import edu.najah.cap.exceptions.BadRequestException;
import edu.najah.cap.exceptions.NotFoundException;
import edu.najah.cap.exceptions.SystemBusyException;
import edu.najah.cap.iam.UserProfile;

public interface ActivityDeletionBehavior {
    void deleteActivities(UserProfile user) throws SystemBusyException, BadRequestException, NotFoundException;
>>>>>>> Stashed changes
}
