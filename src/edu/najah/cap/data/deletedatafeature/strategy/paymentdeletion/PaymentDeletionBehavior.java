package edu.najah.cap.data.deletedatafeature.strategy.paymentdeletion;


import edu.najah.cap.exceptions.BadRequestException;
import edu.najah.cap.exceptions.NotFoundException;
import edu.najah.cap.exceptions.SystemBusyException;
import edu.najah.cap.iam.UserProfile;


public interface PaymentDeletionBehavior {
    void deletePayment(UserProfile user) throws SystemBusyException, BadRequestException, NotFoundException;

}
