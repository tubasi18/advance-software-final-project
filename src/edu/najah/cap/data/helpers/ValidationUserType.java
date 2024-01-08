package edu.najah.cap.data.helpers;

import edu.najah.cap.iam.UserProfile;
import edu.najah.cap.iam.UserType;

public class ValidationUserType {
    private ValidationUserType(){}
    public static boolean isPremium(UserProfile user) {
        return user.getUserType().equals(UserType.PREMIUM_USER);
    }
    public static boolean isNew(UserProfile user) {
        return user.getUserType().equals(UserType.NEW_USER);
    }
    public static boolean isRegular(UserProfile user) {
        return user.getUserType().equals(UserType.REGULAR_USER);
    }
}
