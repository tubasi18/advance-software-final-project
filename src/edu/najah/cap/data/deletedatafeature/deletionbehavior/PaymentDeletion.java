package edu.najah.cap.data.deletedatafeature.deletionbehavior;

import edu.najah.cap.data.deletedatafeature.intf.IDeletionBehavior;
import edu.najah.cap.data.helpers.Services;
import edu.najah.cap.data.helpers.YmlHandler;
import edu.najah.cap.exceptions.BadRequestException;
import edu.najah.cap.exceptions.NotFoundException;
import edu.najah.cap.exceptions.SystemBusyException;
import edu.najah.cap.iam.UserProfile;
import edu.najah.cap.payment.Transaction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PaymentDeletion implements IDeletionBehavior {
    private static final Logger logger = LogManager.getLogger(PaymentDeletion.class);

    @Override
    public void delete(UserProfile user) throws SystemBusyException, BadRequestException, NotFoundException, FileNotFoundException {
        List<Transaction> transaction = new ArrayList<>(Services.getUserPaymentServiceInstance().getTransactions(user.getUserName()));
        ExecutorService executor = Executors.newFixedThreadPool(Integer.parseInt(YmlHandler.getValue("threads")));
        executor.submit(() -> {
            try {
                logger.info("Starting Payment deletion process for user: {}", user.getUserName());
                for (Iterator<Transaction> iterator = transaction.iterator(); iterator.hasNext(); ) {
                    Transaction transactionGet = iterator.next();
                    Services.getUserPaymentServiceInstance().removeTransaction(user.getUserName(), transactionGet.getId());
                    iterator.remove();
                }
            } catch (NotFoundException | BadRequestException | SystemBusyException e) {
                logger.error(String.format("Payment are not found for user: %s", user.getUserName()));
            }
        });
        executor.shutdown();
    }
}