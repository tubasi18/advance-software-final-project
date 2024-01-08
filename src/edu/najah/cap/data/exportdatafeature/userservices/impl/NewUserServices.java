package edu.najah.cap.data.exportdatafeature.userservices.impl;

import edu.najah.cap.data.exportdatafeature.userservices.abst.ICreateDataObjectUser;
import edu.najah.cap.exceptions.BadRequestException;
import edu.najah.cap.exceptions.NotFoundException;
import edu.najah.cap.exceptions.SystemBusyException;
import edu.najah.cap.iam.IUserService;
import edu.najah.cap.posts.IPostService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NewUserServices extends ICreateDataObjectUser {
    private static final Logger logger = LogManager.getLogger(NewUserServices.class);

    public NewUserServices(String username,
                           IPostService postService,
                           IUserService userService) {
        super(username, userService, postService);
    }

    @Override
    public String getDataUser() throws SystemBusyException, BadRequestException, NotFoundException {
        logger.info(String.format("Data  generated Successfully for the new user: %s",getUserName()));
        return super.getDataProfile() + super.getPostsDetails();
    }
}
