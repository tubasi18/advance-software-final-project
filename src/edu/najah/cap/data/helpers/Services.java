package edu.najah.cap.data.helpers;

import edu.najah.cap.activity.IUserActivityService;
import edu.najah.cap.activity.UserActivityService;
import edu.najah.cap.iam.IUserService;
import edu.najah.cap.iam.UserService;
import edu.najah.cap.payment.IPayment;
import edu.najah.cap.payment.PaymentService;
import edu.najah.cap.posts.IPostService;
import edu.najah.cap.posts.PostService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Services {
    private static IUserService userService;
    private static IUserActivityService userActivityService;
    private static IPostService postService;
    private static IPayment paymentService;
    private static final Logger logger = LogManager.getLogger(Services.class);
    public static void setServices(IUserService userService,
                                   IUserActivityService userActivityService,
                                   IPostService postService,
                                   IPayment paymentService) {
        Services.userService = userService;
        Services.userActivityService = userActivityService;
        Services.paymentService = paymentService;
        Services.postService = postService;
        logger.info("Services set successfully.");
    }

    public static synchronized IUserService getUserServiceInstance() {
        if (userService == null) {
            userService = new UserService();
            logger.info("Creating a new instance of UserService.");
        }
        return userService;
    }

    public static synchronized IUserActivityService getUserActivityServiceInstance() {
        if (userActivityService == null) {
            userActivityService = new UserActivityService();
            logger.info("Creating a new instance of UserActivityService.");
        }
        return userActivityService;
    }

    public static synchronized IPostService getUserPostServiceInstance() {
        if (postService == null) {
            postService = new PostService();
            logger.info("Creating a new instance of PostService.");
        }
        return postService;
    }

    public static synchronized IPayment getUserPaymentServiceInstance() {
        if (paymentService == null) {
            paymentService = new PaymentService();
            logger.info("Creating a new instance of PaymentService.");
        }
        return paymentService;
    }
}
