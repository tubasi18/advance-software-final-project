package edu.najah.cap.data.helpers;

import edu.najah.cap.data.exportdatafeature.collector.DataCollector;
import edu.najah.cap.data.exportdatafeature.collector.IDataCollector;
import edu.najah.cap.exceptions.*;
import edu.najah.cap.iam.UserProfile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ExportUtils {

    private ExportUtils(){}
    private static final Logger logger = LogManager.getLogger(ExportUtils.class);

    public static List<String> getData(UserProfile user) throws SystemBusyException, InvalidUserTypeException, BadRequestException, NotFoundException, NullValueException {
        IDataCollector dataCollector = new DataCollector();
        String data = dataCollector.collectData(user);
        String[] parts = data.split("/");
        logger.info(String.format("User data returned successfully for user : %s", user.getUserName()));
        return List.of(parts);
    }
}
