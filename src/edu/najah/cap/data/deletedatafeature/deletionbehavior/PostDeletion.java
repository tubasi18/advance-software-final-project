package edu.najah.cap.data.deletedatafeature.deletionbehavior;

import edu.najah.cap.data.deletedatafeature.intf.IDeletionBehavior;
import edu.najah.cap.data.helpers.Services;
import edu.najah.cap.data.helpers.YmlHandler;
import edu.najah.cap.exceptions.BadRequestException;
import edu.najah.cap.exceptions.NotFoundException;
import edu.najah.cap.exceptions.SystemBusyException;
import edu.najah.cap.iam.UserProfile;
import edu.najah.cap.posts.Post;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.*;

public class PostDeletion implements IDeletionBehavior {
    private static final Logger logger = LogManager.getLogger(PostDeletion.class);

    @Override
    public void delete(UserProfile user) throws SystemBusyException, BadRequestException, NotFoundException, FileNotFoundException {
        List<Post> posts = new ArrayList<>(Services.getUserPostServiceInstance().getPosts(user.getUserName()));
        ExecutorService executor = Executors.newFixedThreadPool(Integer.parseInt(YmlHandler.getValue("threads")));
        executor.submit(() -> {
            try {
                logger.info("Starting Post deletion process for user: {}", user.getUserName());
                for (Iterator<Post> iterator = posts.iterator(); iterator.hasNext(); ) {
                    Post post = iterator.next();
                    Services.getUserPostServiceInstance().deletePost(user.getUserName(), post.getId());
                    iterator.remove();
                }
            } catch (NotFoundException | BadRequestException | SystemBusyException e) {
                logger.error(String.format("Posts are not found for user: %s", user.getUserName()));
            }
        });
        executor.shutdown();
    }
}