package edu.najah.cap.data.CollectorComponent;

import edu.najah.cap.activity.IUserActivityService;
import edu.najah.cap.data.exportdatafeature.factory.FactoryUserType;
import edu.najah.cap.data.exportdatafeature.factory.Interfaces.ICreateDataObjectUser;
import edu.najah.cap.iam.IUserService;
import edu.najah.cap.iam.UserProfile;
import edu.najah.cap.payment.IPayment;
import edu.najah.cap.posts.IPostService;

public class DataCollector {
    private final UserProfile user;

    public DataCollector(UserProfile user) {
        this.user = user;
    }

   public String collectData(){
       ICreateDataObjectUser userData = FactoryUserType.creationUserDataObject(user);

       return userData.getDataUser();
   }
   public  void dataProcess(){
        // strategy
   }

}
