package edu.najah.cap.data.deletedatafeature;

import edu.najah.cap.data.deletedatafeature.strategy.FactoryContext;
import edu.najah.cap.exceptions.BadRequestException;
import edu.najah.cap.exceptions.NotFoundException;
import edu.najah.cap.exceptions.SystemBusyException;
import edu.najah.cap.iam.UserProfile;

public class MangerDeletion {
    public  UserProfile user;
    public  boolean bool;
    public MangerDeletion(UserProfile user , boolean bool)  {
        this.user= user;
        this.bool=bool;
    }

    public  void delete() throws SystemBusyException, BadRequestException, NotFoundException {
        FactoryContext.factoryProcess(user,bool);
    }
}
