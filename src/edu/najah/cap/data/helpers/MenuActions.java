package edu.najah.cap.data.helpers;

import com.dropbox.core.DbxException;
import edu.najah.cap.data.deletedatafeature.managerdeletion.ManagerDeletion;
import edu.najah.cap.data.enums.DeleteType;
import edu.najah.cap.data.enums.EnumAction;
import edu.najah.cap.data.exportdatafeature.exportdata.ExportData;
import edu.najah.cap.exceptions.*;
import edu.najah.cap.iam.UserProfile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class MenuActions {

    private  static final Scanner scanner = new Scanner(System.in);
    private MenuActions(){}
    public static void deleteAction(UserProfile user) throws SystemBusyException, InvalidUserTypeException, BadRequestException, NotFoundException, InvalidUserNameException, InterruptedException, InvalidDeleteTypeException, FileNotFoundException {
        System.out.println("Choose an action:  Soft Delete Data ,  Hard Delete Data ");
        ManagerDeletion mangerDeletion = new ManagerDeletion();
        String choiceUserDelete = scanner.next();
        DeleteType typeDelete = DeleteType.valueOf(choiceUserDelete.toUpperCase());
        mangerDeletion.delete(user, typeDelete);
    }
    public static void exportAction(UserProfile user) throws SystemBusyException, InvalidUploadTypeException, InvalidUserTypeException, InvalidUserDataException, FileFiledException, BadRequestException, NotFoundException, IOException, InvalidActionTypeException, DbxException, InvalidConvertTypeException {
        System.out.println("Choose an action: - Download Data , - Upload Data ");
        ExportData exportData = new ExportData();
        String choiceUserExport = scanner.next();
        EnumAction typeExport = EnumAction.valueOf(choiceUserExport.toUpperCase());
        exportData.exportData(user, typeExport);
    }
}
