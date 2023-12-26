package edu.najah.cap.data.deletedatafeature.strategy.interfaces;

import edu.najah.cap.iam.IUserService;
import edu.najah.cap.iam.UserProfile;

public interface DeleteStrategy {
    void deleteData(UserProfile user);
}
