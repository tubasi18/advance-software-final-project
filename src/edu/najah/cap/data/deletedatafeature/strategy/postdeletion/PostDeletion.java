package edu.najah.cap.data.deletedatafeature.strategy.postdeletion;

import edu.najah.cap.data.helpers.Services;
import edu.najah.cap.exceptions.BadRequestException;
import edu.najah.cap.exceptions.NotFoundException;
import edu.najah.cap.exceptions.SystemBusyException;
import edu.najah.cap.iam.UserProfile;
import edu.najah.cap.posts.Post;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PostDeletion implements PostDeletionBehavior {

    @Override

    public void deletePost(UserProfile user) throws SystemBusyException, BadRequestException, NotFoundException {
        List <Post> userPosts= Services.getUserPostServiceInstance().getPosts(user.getUserName());

        ExecutorService executor = Executors.newFixedThreadPool(5);

        try {
            for (Post post : userPosts) {
                executor.submit(() -> {
                    try {
                        Services.getUserPostServiceInstance().deletePost(user.getUserName(),post.getId());
                    } catch (NotFoundException | SystemBusyException | BadRequestException e) {
                        e.printStackTrace();
                    }
                });
            }
        } finally {
            executor.shutdown();
        }
    }
}

