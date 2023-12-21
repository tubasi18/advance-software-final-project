package edu.najah.cap.data.CollectorComponent;

import edu.najah.cap.activity.IUserActivityService;
import edu.najah.cap.data.exportdatafeature.factory.FactoryUserType;
import edu.najah.cap.data.exportdatafeature.factory.Interfaces.ICreateDataObjectUser;
import edu.najah.cap.iam.IUserService;
import edu.najah.cap.iam.UserProfile;
import edu.najah.cap.payment.IPayment;
import edu.najah.cap.posts.IPostService;

public class DataCollector {
    private final IUserActivityService userActivityService;
    private final IPayment paymentService;
    private final IUserService userService;
    private final IPostService postService;
    private final UserProfile user;

    public DataCollector(IUserActivityService userActivityService,
                         IPayment paymentService, IUserService userService,
                         IPostService postService,
                         UserProfile user) {

        this.userActivityService = userActivityService;
        this.paymentService = paymentService;
        this.userService = userService;
        this.postService = postService;
        this.user = user;
    }

   public String collectData(){
       ICreateDataObjectUser userData = FactoryUserType.creationUserDataObject(user,
               userActivityService,
               paymentService,
               userService,
               postService);

       //  System.out.println(userData.getDataUser());

       return userData.getDataUser();
   }
   public  void dataProcess(){
        // strategy
   }


}
