package edu.najah.cap.data.deletedatafeature.strategy.profiledeltion;


import edu.najah.cap.exceptions.BadRequestException;
import edu.najah.cap.exceptions.NotFoundException;
import edu.najah.cap.exceptions.SystemBusyException;
import edu.najah.cap.iam.UserProfile;

public interface ProfileDeletionBehavior {

    void deleteProfile(UserProfile user) throws SystemBusyException, NotFoundException, BadRequestException;

}
