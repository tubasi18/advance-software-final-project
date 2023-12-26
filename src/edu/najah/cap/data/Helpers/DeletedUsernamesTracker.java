package edu.najah.cap.data.Helpers;

import java.util.ArrayList;
import java.util.List;

public class DeletedUsernamesTracker {
    public static List<String> archivedUsernames = new ArrayList<>();

    public static boolean isUserDeleted(String userName) {
        return archivedUsernames.contains(userName);
    }
    public static void archiveUsername(String userName) {
        archivedUsernames.add(userName);
    }
}
