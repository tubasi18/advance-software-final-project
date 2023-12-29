package edu.najah.cap.data.exportdatafeature.userservices.impl;

import edu.najah.cap.data.exportdatafeature.userservices.intf.ICreateDataObjectUser;
import edu.najah.cap.exceptions.BadRequestException;
import edu.najah.cap.exceptions.NotFoundException;
import edu.najah.cap.exceptions.SystemBusyException;
import edu.najah.cap.iam.IUserService;
import edu.najah.cap.iam.UserProfile;
import edu.najah.cap.posts.IPostService;

public class NewUserServices extends ICreateDataObjectUser {
    public NewUserServices(String username,
                           IPostService postService,
                           IUserService userService) {
        super(username, userService, postService);
    }

    @Override
    public String getDataUser() throws SystemBusyException, BadRequestException, NotFoundException {
        return super.getDataProfile() + super.getPostsDetails();
    }
}
