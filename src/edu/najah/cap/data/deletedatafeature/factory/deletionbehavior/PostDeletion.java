package edu.najah.cap.data.deletedatafeature.factory.deletionbehavior;

import edu.najah.cap.data.deletedatafeature.factory.intf.IDeletionBehavior;
import edu.najah.cap.data.helpers.Services;
import edu.najah.cap.exceptions.BadRequestException;
import edu.najah.cap.exceptions.NotFoundException;
import edu.najah.cap.exceptions.SystemBusyException;
import edu.najah.cap.iam.UserProfile;
import edu.najah.cap.posts.Post;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.concurrent.*;

public class PostDeletion implements IDeletionBehavior {
    private static final Logger logger = LogManager.getLogger(PostDeletion.class);

    public void delete(UserProfile user) throws SystemBusyException, BadRequestException, NotFoundException {
        List<Post> userPosts = Services.getUserPostServiceInstance().getPosts(user.getUserName());
        logger.info("Starting Post deletion process for user: {}", user.getUserName());

        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (Post post : userPosts) {
            executor.submit(() -> {
                try {
                    Services.getUserPostServiceInstance().deletePost(user.getUserName(), post.getId());
                } catch (NotFoundException | SystemBusyException | BadRequestException e) {
                    //logger.error("Error deleting post " , e);
                    e.printStackTrace();

                }
            });
        }
        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}