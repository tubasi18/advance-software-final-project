package edu.najah.cap.data.exportdatafeature;

import edu.najah.cap.activity.IUserActivityService;
import edu.najah.cap.data.CollectorComponent.DataCollector;
import edu.najah.cap.data.exportdatafeature.factory.FactoryUserType;
import edu.najah.cap.data.exportdatafeature.factory.Interfaces.ICreateDataObjectUser;
import edu.najah.cap.iam.IUserService;
import edu.najah.cap.iam.UserProfile;
import edu.najah.cap.payment.IPayment;
import edu.najah.cap.posts.IPostService;

public class ExportData {
    DataCollector dataCollector;
    public ExportData(UserProfile user,
                      IUserActivityService userActivityService,
                      IPayment paymentService, IUserService userService,
                      IPostService postService) {

        this.dataCollector = new DataCollector(userActivityService,
                paymentService,
                userService,
                postService,
                user);
    }

    public void exportData() {
        dataCollector.collectData();

    }
}
