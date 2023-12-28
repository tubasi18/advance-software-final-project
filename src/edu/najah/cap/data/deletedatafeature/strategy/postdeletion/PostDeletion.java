package edu.najah.cap.data.deletedatafeature.strategy.postdeletion;

import edu.najah.cap.data.Services;
import edu.najah.cap.exceptions.BadRequestException;
import edu.najah.cap.exceptions.NotFoundException;
import edu.najah.cap.exceptions.SystemBusyException;
import edu.najah.cap.iam.UserProfile;
import edu.najah.cap.posts.Post;

import java.util.List;

public class PostDeletion implements PostDeletionBehavior {

    @Override

    public void deletePost(UserProfile user) throws SystemBusyException, BadRequestException, NotFoundException {
        List <Post> userPosts= Services.getUserPostServiceInstance().getPosts(user.getUserName());
        for(int i=userPosts.size()-1; i>=0; i--){
            Services.getUserPostServiceInstance().deletePost(user.getUserName(),userPosts.get(i).getId());
        }

    }
}

