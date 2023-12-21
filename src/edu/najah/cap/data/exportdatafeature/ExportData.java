package edu.najah.cap.data.exportdatafeature;

import edu.najah.cap.activity.IUserActivityService;
import edu.najah.cap.data.exportdatafeature.factory.FactoryUserType;
import edu.najah.cap.iam.IUserService;
import edu.najah.cap.iam.UserProfile;
import edu.najah.cap.payment.IPayment;
import edu.najah.cap.posts.IPostService;

public class ExportData {
    private final IUserActivityService userActivityService ;
    private final IPayment paymentService ;
    private final IUserService userService ;
    private final IPostService postService;
    private final UserProfile user;
    public ExportData(UserProfile user, IUserActivityService userActivityService, IPayment paymentService, IUserService userService, IPostService postService){
        this.userActivityService = userActivityService;
        this.paymentService = paymentService;
        this.userService = userService;
        this.postService = postService;
        this.user = user;
    }


    public void getUserData(){
        FactoryUserType.creationUserDataObject(user,userActivityService,paymentService,userService,postService);

    }
}
