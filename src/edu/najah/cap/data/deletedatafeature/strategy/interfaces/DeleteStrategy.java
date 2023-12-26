package edu.najah.cap.data.deletedatafeature.strategy.interfaces;

<<<<<<< Updated upstream
=======
import edu.najah.cap.exceptions.BadRequestException;
import edu.najah.cap.exceptions.NotFoundException;
import edu.najah.cap.exceptions.SystemBusyException;
>>>>>>> Stashed changes
import edu.najah.cap.iam.IUserService;
import edu.najah.cap.iam.UserProfile;

public interface DeleteStrategy {
<<<<<<< Updated upstream
    void deleteData(UserProfile user);
=======
    void deleteData(UserProfile user) throws SystemBusyException, BadRequestException, NotFoundException;
>>>>>>> Stashed changes
    
}
