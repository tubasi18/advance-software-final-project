package edu.najah.cap.data.deletedatafeature.factory.intf;

import edu.najah.cap.exceptions.BadRequestException;
import edu.najah.cap.exceptions.InvalidUserTypeException;
import edu.najah.cap.exceptions.NotFoundException;
import edu.najah.cap.exceptions.SystemBusyException;
import edu.najah.cap.iam.UserProfile;

public interface IDeleteType {
    void delete(UserProfile user) throws InvalidUserTypeException, SystemBusyException, BadRequestException, NotFoundException, InterruptedException;
}
