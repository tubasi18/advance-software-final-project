package edu.najah.cap.data.deletedatafeature.intf;

import edu.najah.cap.exceptions.BadRequestException;
import edu.najah.cap.exceptions.NotFoundException;
import edu.najah.cap.exceptions.SystemBusyException;
import edu.najah.cap.iam.UserProfile;

import java.io.FileNotFoundException;

public interface IDeletionBehavior {
    void delete(UserProfile user) throws SystemBusyException, BadRequestException, NotFoundException, InterruptedException, FileNotFoundException;
}
