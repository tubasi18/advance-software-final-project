package edu.najah.cap.data.deletedatafeature.factory.impl;

import edu.najah.cap.data.deletedatafeature.factory.intf.IDeletionBehavior;
import edu.najah.cap.data.helpers.Services;
import edu.najah.cap.exceptions.BadRequestException;
import edu.najah.cap.exceptions.NotFoundException;
import edu.najah.cap.exceptions.SystemBusyException;
import edu.najah.cap.iam.UserProfile;
import edu.najah.cap.payment.Transaction;
import edu.najah.cap.posts.Post;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PaymentDeletion implements IDeletionBehavior {

    public void delete(UserProfile user) throws SystemBusyException, BadRequestException, NotFoundException {
        List<Transaction> userTransactionList = Services.getUserPaymentServiceInstance().getTransactions(user.getUserName());

        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (Transaction transaction : userTransactionList) {
            executor.submit(() -> {
                try {
                   Services.getUserPostServiceInstance().deletePost(user.getUserName(), transaction.getId());
                } catch (NotFoundException | SystemBusyException | BadRequestException e) {
                    e.printStackTrace();
                }
            });
        }
        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}


