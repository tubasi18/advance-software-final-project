package edu.najah.cap.data.deletedatafeature.deletionbehavior;

import edu.najah.cap.data.deletedatafeature.intf.IDeletionBehavior;
import edu.najah.cap.data.helpers.Services;
import edu.najah.cap.exceptions.BadRequestException;
import edu.najah.cap.exceptions.NotFoundException;
import edu.najah.cap.exceptions.SystemBusyException;
import edu.najah.cap.iam.UserProfile;
import edu.najah.cap.payment.Transaction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PaymentDeletion implements IDeletionBehavior {
    private static final Logger logger = LogManager.getLogger(PaymentDeletion.class);

    public void delete(UserProfile user) throws SystemBusyException, BadRequestException, NotFoundException {
        List<Transaction> userTransactionList = Services.getUserPaymentServiceInstance().getTransactions(user.getUserName());
        logger.info("Starting Payment deletion process for user: {}", user.getUserName());

        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (Transaction transaction : userTransactionList) {
            executor.submit(() -> {
                try {
                   Services.getUserPaymentServiceInstance().removeTransaction(user.getUserName(), transaction.getId());
                } catch (NotFoundException | SystemBusyException | BadRequestException e) {
//                    logger.error("Error deleting payment " , e);
                    e.printStackTrace();

                }
            });
        }
        executor.shutdown();
    }
}