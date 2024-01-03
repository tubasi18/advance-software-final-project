package edu.najah.cap.data;

import edu.najah.cap.activity.IUserActivityService;
import edu.najah.cap.activity.UserActivity;
import edu.najah.cap.activity.UserActivityService;
import edu.najah.cap.data.deletedatafeature.managerdeletion.ManagerDeletion;
import edu.najah.cap.data.enums.DeleteType;
import edu.najah.cap.data.exportdatafeature.exportdata.ExportData;
import edu.najah.cap.data.enums.EnumAction;
import edu.najah.cap.data.helpers.Services;
import edu.najah.cap.exceptions.BadRequestException;
import edu.najah.cap.exceptions.NotFoundException;
import edu.najah.cap.exceptions.SystemBusyException;
import edu.najah.cap.exceptions.Util;
import edu.najah.cap.iam.IUserService;
import edu.najah.cap.iam.UserProfile;
import edu.najah.cap.iam.UserService;
import edu.najah.cap.iam.UserType;
import edu.najah.cap.payment.IPayment;
import edu.najah.cap.payment.PaymentService;
import edu.najah.cap.payment.Transaction;
import edu.najah.cap.posts.IPostService;
import edu.najah.cap.posts.Post;
import edu.najah.cap.posts.PostService;

import java.time.Instant;
import java.util.Scanner;

public class Application {

    private static final IUserActivityService userActivityService = new UserActivityService();
    private static final IPayment paymentService = new PaymentService();
    private static final IUserService userService = new UserService();
    private static final IPostService postService = new PostService();

    private static String loginUserName;

    public static void main(String[] args) throws SystemBusyException, BadRequestException, NotFoundException {
        generateRandomData();
        Instant start = Instant.now();
        System.out.println("Application Started: " + start);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your username: ");
        System.out.println("Note: You can use any of the following usernames: user0, user1, user2, user3, .... user99");
        String userName = scanner.next();
        setLoginUserName(userName);
        //TODO Your application starts here. Do not Change the existing code
        Services.setServices(userService, userActivityService, postService, paymentService);
        try {
            UserProfile user = userService.getUser(loginUserName);
            boolean continueActions = true;
            while (continueActions) {
                System.out.println("Choose an action: 1 - Export Data, 2 - Delete Data, 3 - Exit");
                int userChoice = scanner.nextInt();
                switch (userChoice) {
                    case 1:
                        System.out.println("Choose an action: - Download Data , - Upload Data ");
                        ExportData exportData = new ExportData();
                        String choiceUserExport = scanner.next();
                        EnumAction typeExport = EnumAction.valueOf(choiceUserExport.toUpperCase());
                        exportData.exportData(user, typeExport);
                        break;
                    case 2:
                        System.out.println("Choose an action:  Soft Delete Data ,  Hard Delete Data ");
                        ManagerDeletion mangerDeletion = new ManagerDeletion();
                        String choiceUserDelete = scanner.next();
                        DeleteType typeDelete = DeleteType.valueOf(choiceUserDelete.toUpperCase());
                        mangerDeletion.delete(user, typeDelete);
                        break;
                    case 3:
                        continueActions = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter 1, 2, or 3.");
                }
                if (continueActions) {
                    System.out.println("Do you want to perform another action? (yes/no)");
                    String userResponse = scanner.next().toLowerCase();
                    continueActions = userResponse.equals("yes");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //TODO Your application ends here. Do not Change the existing code
        Instant end = Instant.now();

        System.out.println("Application Ended: " + end);
    }


    private static void generateRandomData() {
        Util.setSkipValidation(true);
        for (int i = 0; i < 100; i++) {
            generateUser(i);
            generatePost(i);
            generatePayment(i);
            generateActivity(i);
        }
        System.out.println("Data Generation Completed");
        Util.setSkipValidation(false);
    }


    private static void generateActivity(int i) {
        for (int j = 0; j < 100; j++) {
            try {
                if (UserType.NEW_USER.equals(userService.getUser("user" + i).getUserType())) {
                    continue;
                }
            } catch (Exception e) {
                System.err.println("Error while generating activity for user" + i);
            }
            userActivityService.addUserActivity(new UserActivity("user" + i, "activity" + i + "." + j, Instant.now().toString()));
        }
    }

    private static void generatePayment(int i) {
        for (int j = 0; j < 100; j++) {
            try {
                if (userService.getUser("user" + i).getUserType() == UserType.PREMIUM_USER) {
                    paymentService.pay(new Transaction("user" + i, i * j, "description" + i + "." + j));
                }
            } catch (Exception e) {
                System.err.println("Error while generating post for user" + i);
            }
        }
    }

    private static void generatePost(int i) {
        for (int j = 0; j < 100; j++) {
            postService.addPost(new Post("title" + i + "." + j, "body" + i + "." + j, "user" + i, Instant.now().toString()));
        }
    }

    private static void generateUser(int i) {
        UserProfile user = new UserProfile();
        user.setUserName("user" + i);
        user.setFirstName("first" + i);
        user.setLastName("last" + i);
        user.setPhoneNumber("phone" + i);
        user.setEmail("email" + i);
        user.setPassword("pass" + i);
        user.setRole("role" + i);
        user.setDepartment("department" + i);
        user.setOrganization("organization" + i);
        user.setCountry("country" + i);
        user.setCity("city" + i);
        user.setStreet("street" + i);
        user.setPostalCode("postal" + i);
        user.setBuilding("building" + i);
        user.setUserType(getRandomUserType(i));
        userService.addUser(user);
    }

    private static UserType getRandomUserType(int i) {
        if (i > 0 && i < 3) {
            return UserType.NEW_USER;
        } else if (i > 3 && i < 7) {
            return UserType.REGULAR_USER;
        } else {
            return UserType.PREMIUM_USER;
        }
    }

    public static String getLoginUserName() {
        return loginUserName;
    }

    private static void setLoginUserName(String loginUserName) {
        Application.loginUserName = loginUserName;
    }
}