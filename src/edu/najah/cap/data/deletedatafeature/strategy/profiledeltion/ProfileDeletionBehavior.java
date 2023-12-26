package edu.najah.cap.data.deletedatafeature.strategy.profiledeltion;

<<<<<<< Updated upstream
=======
import edu.najah.cap.exceptions.BadRequestException;
import edu.najah.cap.exceptions.NotFoundException;
import edu.najah.cap.exceptions.SystemBusyException;
>>>>>>> Stashed changes
import edu.najah.cap.iam.UserProfile;
import edu.najah.cap.iam.UserService;

public interface ProfileDeletionBehavior {
<<<<<<< Updated upstream
    void deleteProfile(UserProfile user);
=======
    void deleteProfile(UserProfile user) throws SystemBusyException, NotFoundException, BadRequestException;
>>>>>>> Stashed changes
}
