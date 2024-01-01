package edu.najah.cap.data.exportdatafeature.userservices.impl;

import edu.najah.cap.activity.IUserActivityService;
import edu.najah.cap.activity.UserActivity;
import edu.najah.cap.data.exportdatafeature.userservices.abst.ICreateDataObjectUser;
import edu.najah.cap.exceptions.BadRequestException;
import edu.najah.cap.exceptions.NotFoundException;
import edu.najah.cap.exceptions.SystemBusyException;
import edu.najah.cap.iam.IUserService;
import edu.najah.cap.payment.IPayment;
import edu.najah.cap.payment.Transaction;
import edu.najah.cap.posts.IPostService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class PremiumUserServices extends ICreateDataObjectUser {
    private IUserActivityService userActivityService;
    private IPayment paymentService;
    private static final Logger logger = LogManager.getLogger(PremiumUserServices.class);


    public PremiumUserServices(String userName,
                               IUserActivityService userActivityService,
                               IPayment paymentService,
                               IUserService userService,
                               IPostService postService) {
        super(userName, userService, postService);
        this.userActivityService = userActivityService;
        this.paymentService = paymentService;

    }

    @Override
    public String getDataUser() throws SystemBusyException, BadRequestException, NotFoundException {
        logger.info(String.format("Data generated Successfully for the premium user: %s", getUserName()));
        return super.getDataProfile()
                + super.getPostsDetails()
                + "Activity Data: " + getActivityData() +
                "/"
                + "Payment Data: " + getPaymentData();

    }

    public String getActivityData() throws SystemBusyException, BadRequestException, NotFoundException {
        List<UserActivity> userActivities =
                userActivityService.getUserActivity(super.getUserName());

        StringBuilder result = new StringBuilder();
        for (UserActivity userActivity : userActivities) {
            result.append("Activity ID: ").append(userActivity.getId()).append("\n")
                    .append("Activity Date: ").append(userActivity.getActivityDate()).append("\n")
                    .append("Activity Type: ").append(userActivity.getActivityType()).append("\n\n");
        }
        logger.info(String.format("Activity data generated Successfully for the premium user: %s", getUserName()));
        return result.toString();
    }

    public String getPaymentData() throws SystemBusyException, NotFoundException, BadRequestException {
        logger.info(String.format("Payment data generated Successfully for the premium user: %s", getUserName()));
        return "\n" + "Balance: " + getBalance().toString() + "\n" + "Transactions: " + "\n" + getTransactionData();
    }

    public String getTransactionData() throws SystemBusyException, NotFoundException, BadRequestException {
        List<Transaction> transactions = paymentService.getTransactions(super.getUserName());
        StringBuilder result = new StringBuilder();
        for (Transaction transaction : transactions) {
            result.append("Transaction ID: ").append(transaction.getId()).append("\n")
                    .append("Transaction Amount: ").append(transaction.getAmount()).append("\n")
                    .append("Transaction Description: ").append(transaction.getDescription()).append("\n\n");

        }
        logger.info(String.format("Transaction data generated Successfully for the premium user: %s", getUserName()));
        return result.toString();
    }

    public Double getBalance() throws SystemBusyException, NotFoundException, BadRequestException {
        logger.info(String.format("Balance data generated Successfully for the premium user: %s", getUserName()));
        return paymentService.getBalance(super.getUserName());
    }
}
