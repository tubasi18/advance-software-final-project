package edu.najah.cap.data.deletedatafeature.strategy.paymentdeletion;

import edu.najah.cap.iam.UserProfile;

public interface PaymentDeletionBehavior {
    void deletePayment(UserProfile user);

}
