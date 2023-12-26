package edu.najah.cap.data.deletedatafeature.strategy.paymentdeletion;

import edu.najah.cap.data.Services;
<<<<<<< Updated upstream
=======
import edu.najah.cap.exceptions.BadRequestException;
import edu.najah.cap.exceptions.NotFoundException;
import edu.najah.cap.exceptions.SystemBusyException;
>>>>>>> Stashed changes
import edu.najah.cap.iam.UserProfile;
import edu.najah.cap.payment.Transaction;

import java.util.List;

public class PaymentDeletion implements PaymentDeletionBehavior{
<<<<<<< Updated upstream
    public void deletePayment(UserProfile user){
=======
    public void deletePayment(UserProfile user) throws SystemBusyException, BadRequestException, NotFoundException {
>>>>>>> Stashed changes
        List<Transaction> userTransactionList= Services.getUserPaymentServiceInstance().getTransactions(user.getUserName());
        for(Transaction transaction:userTransactionList){
            Services.getUserPaymentServiceInstance().removeTransaction(transaction.getUserName(), transaction.getId());
        }
    }
}
