package edu.najah.cap.data.helpers;

import edu.najah.cap.activity.IUserActivityService;
import edu.najah.cap.activity.UserActivityService;
import edu.najah.cap.iam.IUserService;
import edu.najah.cap.iam.UserService;
import edu.najah.cap.payment.IPayment;
import edu.najah.cap.payment.PaymentService;
import edu.najah.cap.posts.IPostService;
import edu.najah.cap.posts.PostService;

public class Services {
    private Services(){}
    private static IUserService userService;
    private static IUserActivityService userActivityService;
    private static IPostService postService;
    private static IPayment paymentService;

    public static synchronized IUserService getUserServiceInstance() {
        if (userService == null) {
            userService = new UserService();

        }
        return userService;
    }

    public static synchronized IUserActivityService getUserActivityServiceInstance() {
        if (userActivityService == null) {
            userActivityService = new UserActivityService();
        }
        return userActivityService;
    }

    public static synchronized IPostService getUserPostServiceInstance() {
        if (postService == null) {
            postService = new PostService();
        }
        return postService;
    }

    public static synchronized IPayment getUserPaymentServiceInstance() {
        if (paymentService == null) {
            paymentService = new PaymentService();
        }
        return paymentService;
    }
}
