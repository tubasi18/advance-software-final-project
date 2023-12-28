package edu.najah.cap.data.deletedatafeature;

import edu.najah.cap.data.deletedatafeature.strategy.FactoryContext;
import edu.najah.cap.iam.UserProfile;

public class MangerDeletion {
    public  UserProfile user;
    public  boolean bool;
    public MangerDeletion(UserProfile user , boolean bool) throws Exception {
        this.user= user;
        this.bool=bool;
    }

    public  void delete() throws Exception {
        FactoryContext.factoryProcess(user,bool);
    }
}
