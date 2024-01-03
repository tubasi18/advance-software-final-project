package edu.najah.cap.data.exportdatafeature;

import com.dropbox.core.DbxException;
import edu.najah.cap.data.exportdatafeature.collector.DataCollector;
import edu.najah.cap.data.exportdatafeature.collector.IDataCollector;
import edu.najah.cap.data.enums.ConverterType;
import edu.najah.cap.data.exportdatafeature.converter.factory.FactoryConverter;
import edu.najah.cap.data.exportdatafeature.converter.intf.IConverter;
import edu.najah.cap.data.exportdatafeature.processdata.strategy.StrategyAction;
import edu.najah.cap.data.enums.EnumAction;
import edu.najah.cap.data.helpers.ValidationUserType;
import edu.najah.cap.exceptions.*;
import edu.najah.cap.iam.UserProfile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.List;

public class ExportData {
    private static final Logger logger = LogManager.getLogger(ExportData.class);

    public void exportData(UserProfile user, EnumAction action) throws SystemBusyException, InvalidUserTypeException, BadRequestException, NotFoundException, NullValueException, InvalidUploadTypeException, FileFiledException, IOException, DbxException, InvalidActionTypeException, InvalidConvertTypeException {
        List<String> data = getData(user);
        byte[] zipData;

        IConverter converter = FactoryConverter.createConverter(ConverterType.TOZIP);

        zipData = converter.convert(data);
        System.out.println("PDF files and Zip file created successfully.");

        logger.info(String.format("PDF files and Zip file created successfully  for user %s", user.getUserName()));
        StrategyAction.typeAction(action, zipData);
    }

    public List<String> getData(UserProfile user) throws SystemBusyException, InvalidUserTypeException, BadRequestException, NotFoundException, NullValueException {
        IDataCollector dataCollector = new DataCollector();
        String data = dataCollector.collectData(user);
        String[] parts = data.split("/");
        logger.info(String.format("User data returned successfully for user : %s", user.getUserName()));
        return List.of(parts);
    }
}
