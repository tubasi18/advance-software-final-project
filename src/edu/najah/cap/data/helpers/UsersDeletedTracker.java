package edu.najah.cap.data.helpers;

import java.util.ArrayList;
import java.util.List;

public class UsersDeletedTracker {
    private  UsersDeletedTracker(){}
    private static final  List<String> archivedUsernames = new ArrayList<>();

    public static boolean isUserDeleted(String userName) {
        return archivedUsernames.contains(userName);
    }
    public static void archiveUsername(String userName) {
        archivedUsernames.add(userName);
    }


    public static List<String> getArchivedUsernames() {
        return archivedUsernames;
    }

}
