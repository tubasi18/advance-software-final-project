package edu.najah.cap.data.deletedatafeature.strategy.paymentdeletion;

import edu.najah.cap.data.Services;
import edu.najah.cap.iam.UserProfile;
import edu.najah.cap.payment.Transaction;

import java.util.List;

public class PaymentDeletion implements PaymentDeletionBehavior{
    public void deletePayment(UserProfile user){
        List<Transaction> userTransactionList= Services.getUserPaymentServiceInstance().getTransactions(user.getUserName());
        for(Transaction transaction:userTransactionList){
            Services.getUserPaymentServiceInstance().removeTransaction(transaction.getUserName(), transaction.getId());
        }
    }
}
