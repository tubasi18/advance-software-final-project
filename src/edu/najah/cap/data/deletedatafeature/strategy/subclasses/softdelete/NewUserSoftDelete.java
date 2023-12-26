package edu.najah.cap.data.deletedatafeature.strategy.subclasses.softdelete;

import edu.najah.cap.data.deletedatafeature.strategy.interfaces.DeleteStrategy;
import edu.najah.cap.iam.UserProfile;

public class NewUserSoftDelete implements DeleteStrategy {
    @Override
    public void deleteData(UserProfile user) {
        //implementation for new user soft delete logic

    }
}