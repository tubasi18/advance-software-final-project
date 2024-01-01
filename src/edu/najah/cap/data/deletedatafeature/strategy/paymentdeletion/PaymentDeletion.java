package edu.najah.cap.data.deletedatafeature.strategy.paymentdeletion;

import edu.najah.cap.data.helpers.Services;
import edu.najah.cap.exceptions.BadRequestException;
import edu.najah.cap.exceptions.NotFoundException;
import edu.najah.cap.exceptions.SystemBusyException;
import edu.najah.cap.iam.UserProfile;
import edu.najah.cap.payment.Transaction;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PaymentDeletion implements PaymentDeletionBehavior {

    public void deletePayment(UserProfile user) throws SystemBusyException, BadRequestException, NotFoundException {

        List<Transaction> userTransactionList = Services.getUserPaymentServiceInstance().getTransactions(user.getUserName());

        ExecutorService executor = Executors.newFixedThreadPool(5);

        try {
            for (Transaction transaction : userTransactionList) {
                executor.submit(() -> {
                    try {
                        Services.getUserPaymentServiceInstance().removeTransaction(user.getUserName(), transaction.getId());
                    } catch (SystemBusyException | BadRequestException | NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
        } finally {
            executor.shutdown();
        }
    }
}

