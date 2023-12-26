package edu.najah.cap.data.deletedatafeature.strategy.subclasses;

import edu.najah.cap.activity.UserActivity;
import edu.najah.cap.data.Helpers.DeletedUsernamesTracker;
import edu.najah.cap.data.Services;
import edu.najah.cap.data.deletedatafeature.strategy.interfaces.DeleteStrategy;
<<<<<<< Updated upstream
=======
import edu.najah.cap.exceptions.BadRequestException;
import edu.najah.cap.exceptions.NotFoundException;
import edu.najah.cap.exceptions.SystemBusyException;
>>>>>>> Stashed changes
import edu.najah.cap.iam.UserProfile;
import edu.najah.cap.iam.UserService;
import edu.najah.cap.payment.Transaction;

import java.util.List;

public class HardDelete implements DeleteStrategy {
    @Override
<<<<<<< Updated upstream
    public void deleteData(UserProfile user) {
=======
    public void deleteData(UserProfile user) throws SystemBusyException, BadRequestException, NotFoundException {
>>>>>>> Stashed changes
        List<Transaction> userTransactionList= Services.getUserPaymentServiceInstance().getTransactions(user.getUserName());
        for(Transaction transaction:userTransactionList){
            Services.getUserPaymentServiceInstance().removeTransaction(transaction.getUserName(), transaction.getId());
        }
        Services.getUserPostServiceInstance().deletePost(user.getUserName(),user.getUserName());
        List <UserActivity> userActivities= Services.getUserActivityServiceInstance().getUserActivity(user.getUserName());
        for( UserActivity activity:userActivities){
            Services.getUserActivityServiceInstance().removeUserActivity(user.getUserName(),activity.getId());
        }
        DeletedUsernamesTracker.archiveUsername(user.getUserName());
        Services.getUserServiceInstance().deleteUser(user.getUserName());
        //needs refactoring according to user type
    }
}
