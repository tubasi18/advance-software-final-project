package edu.najah.cap.data.exportdatafeature;

import edu.najah.cap.data.collectorcomponent.DataCollector;
import edu.najah.cap.data.exportdatafeature.converter.ConvertString;
import edu.najah.cap.data.exportdatafeature.strategy.StrategyAction;
import edu.najah.cap.data.exportdatafeature.strategy.enumaction.EnumAction;
import edu.najah.cap.exceptions.*;
import edu.najah.cap.iam.UserProfile;


public class ExportData {
    DataCollector dataCollector;
    EnumAction action;

    public ExportData(UserProfile user , EnumAction action) {

        this.dataCollector = new DataCollector(user);
        this.action = action;
    }

    public void exportData() throws FileFiledException, SystemBusyException, BadRequestException, NotFoundException, NullValueException {
        String data = dataCollector.collectData();

        ConvertString convertString = new ConvertString();

        String[] parts = data.split("/");

        byte[] zipData;

        if (parts.length == 2) {
            byte[] pdfData1 = convertString.convertTextToPDF(parts[0]);
            byte[] pdfData2 = convertString.convertTextToPDF(parts[1]);
            zipData = convertString.convertPDFsToZip(pdfData1, pdfData2);
            System.out.println("PDF files and Zip file created successfully.");
        } else {
            byte[] pdfData = convertString.convertTextToPDF(data);
            zipData = convertString.convertPDFToZip(pdfData);
            System.out.println("PDF file and Zip file created successfully.");
        }



         StrategyAction.typeAction(action,zipData);


    }
}
