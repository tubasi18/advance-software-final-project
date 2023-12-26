package edu.najah.cap.data.deletedatafeature.strategy.subclasses.harddelete;

import edu.najah.cap.data.deletedatafeature.strategy.interfaces.DeleteStrategy;
import edu.najah.cap.iam.UserProfile;

public class RegularUserHardDelete implements DeleteStrategy {
    @Override
    public void deleteData(UserProfile user) {
        //implementation for regular user hard delete logic
    }
}