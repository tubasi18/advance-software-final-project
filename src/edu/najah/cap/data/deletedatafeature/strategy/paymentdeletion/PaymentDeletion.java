package edu.najah.cap.data.deletedatafeature.strategy.paymentdeletion;

import edu.najah.cap.data.Services;
import edu.najah.cap.exceptions.BadRequestException;
import edu.najah.cap.exceptions.NotFoundException;
import edu.najah.cap.exceptions.SystemBusyException;
import edu.najah.cap.iam.UserProfile;
import edu.najah.cap.payment.Transaction;

import java.util.List;

public class PaymentDeletion implements PaymentDeletionBehavior {

    public void deletePayment(UserProfile user) throws SystemBusyException, BadRequestException, NotFoundException {

        List<Transaction> userTransactionList = Services.getUserPaymentServiceInstance().getTransactions(user.getUserName());
        for (int i = userTransactionList.size() - 1 ; i >= 0 ; i--) {
            Services.getUserPaymentServiceInstance().removeTransaction(user.getUserName(), userTransactionList.get(i).getId());
        }
    }
}

