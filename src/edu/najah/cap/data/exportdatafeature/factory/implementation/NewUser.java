package edu.najah.cap.data.exportdatafeature.factory.implementation;

import edu.najah.cap.data.exportdatafeature.factory.interfaces.ICreateDataObjectUser;
import edu.najah.cap.exceptions.BadRequestException;
import edu.najah.cap.exceptions.NotFoundException;
import edu.najah.cap.exceptions.SystemBusyException;
import edu.najah.cap.iam.IUserService;
import edu.najah.cap.iam.UserProfile;
import edu.najah.cap.posts.IPostService;

public class NewUser extends ICreateDataObjectUser {
    public NewUser(UserProfile userProfile,
                   IPostService postService,
                   IUserService userService) {
        super(userService, userProfile, postService);
    }

    @Override
    public String getDataUser() throws SystemBusyException, BadRequestException, NotFoundException {
        return super.getDataProfile() + super.getPostsDetails();
    }
}
