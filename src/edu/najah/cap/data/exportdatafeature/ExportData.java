package edu.najah.cap.data.exportdatafeature;

import edu.najah.cap.data.exportdatafeature.collector.DataCollector;
import edu.najah.cap.data.exportdatafeature.collector.IDataCollector;
import edu.najah.cap.data.enums.ConverterType;
import edu.najah.cap.data.exportdatafeature.converter.factory.FactoryConverter;
import edu.najah.cap.data.exportdatafeature.converter.intf.IConverter;
import edu.najah.cap.data.exportdatafeature.processdata.strategy.StrategyAction;
import edu.najah.cap.data.enums.EnumAction;
import edu.najah.cap.exceptions.*;
import edu.najah.cap.iam.UserProfile;
import edu.najah.cap.iam.UserType;

import java.util.List;

public class ExportData {
    IDataCollector dataCollector;

    public void exportData(UserProfile user, EnumAction action) throws FileFiledException, SystemBusyException, BadRequestException, NotFoundException, NullValueException, InvalidUserTypeException {
        List<String> data = getData(user);
        byte[] zipData;

        if (user.getUserType() == UserType.PREMIUM_USER) {
            IConverter converter = FactoryConverter.createConverter(ConverterType.TOZIP);
            zipData = converter.convert(data);
            System.out.println("PDF files and Zip file created successfully.");
        } else {
            IConverter converter = FactoryConverter.createConverter(ConverterType.TOZIP);
            zipData = converter.convert(List.of(data.get(0)));
        }

        System.out.println("PDF file and Zip file created successfully.");
        StrategyAction.typeAction(action, zipData);
    }

    public List<String> getData(UserProfile user) throws SystemBusyException, InvalidUserTypeException, BadRequestException, NotFoundException, NullValueException {
        this.dataCollector = new DataCollector();
        String data = dataCollector.collectData(user);
        String[] parts = data.split("/");
        return List.of(parts);
    }
}
