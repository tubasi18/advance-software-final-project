package edu.najah.cap.data.deletedatafeature.intf;

import edu.najah.cap.exceptions.*;
import edu.najah.cap.iam.UserProfile;

public interface IDeleteType {
    void delete(UserProfile user) throws InvalidUserTypeException, SystemBusyException, BadRequestException, NotFoundException, InterruptedException, InvalidUserNameException;
}
