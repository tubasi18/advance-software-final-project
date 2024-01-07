package edu.najah.cap.data.exportdatafeature.exportdata;

import com.dropbox.core.DbxException;
import edu.najah.cap.data.enums.ConverterType;
import edu.najah.cap.data.exportdatafeature.converter.factory.FactoryConverter;
import edu.najah.cap.data.exportdatafeature.converter.intf.IConverter;
import edu.najah.cap.data.exportdatafeature.processdata.strategy.StrategyAction;
import edu.najah.cap.data.enums.EnumAction;
import edu.najah.cap.data.helpers.ExportUtils;
import edu.najah.cap.exceptions.*;
import edu.najah.cap.iam.UserProfile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import java.util.List;

public class ExportData implements  IExport {
    private static final Logger logger = LogManager.getLogger(ExportData.class);
    @Override
    public void exportData(UserProfile user, EnumAction action) throws SystemBusyException, InvalidUserTypeException, BadRequestException, NotFoundException, InvalidUserDataException, InvalidUploadTypeException, FileFiledException, IOException, DbxException, InvalidActionTypeException, InvalidConvertTypeException {
        List<String> data = ExportUtils.getData(user);
        byte[] zipData;

        IConverter converter = FactoryConverter.createConverter(ConverterType.TOZIP);
        zipData = converter.convert(data);
        System.out.println("PDF files and Zip file created successfully.");

        logger.info(String.format("PDF files and Zip file created successfully  for user %s", user.getUserName()));
        StrategyAction.typeAction(action, zipData);
    }
}
