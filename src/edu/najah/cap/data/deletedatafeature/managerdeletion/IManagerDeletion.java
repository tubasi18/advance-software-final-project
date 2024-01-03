package edu.najah.cap.data.deletedatafeature.managerdeletion;

import edu.najah.cap.data.enums.DeleteType;
import edu.najah.cap.exceptions.*;
import edu.najah.cap.iam.UserProfile;

public interface IManagerDeletion  {

    void delete(UserProfile user , DeleteType type) throws SystemBusyException, BadRequestException, NotFoundException, InterruptedException, InvalidDeleteTypeException, InvalidUserTypeException, InvalidUserNameException ;
}
