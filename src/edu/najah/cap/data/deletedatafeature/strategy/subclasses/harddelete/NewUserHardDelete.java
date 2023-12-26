package edu.najah.cap.data.deletedatafeature.strategy.subclasses.harddelete;

import edu.najah.cap.data.deletedatafeature.strategy.interfaces.DeleteStrategy;
import edu.najah.cap.iam.UserProfile;

public class NewUserHardDelete implements DeleteStrategy {
    @Override
    public void deleteData(UserProfile user) {
    //implementation for new user hard delete logic
    }
}
