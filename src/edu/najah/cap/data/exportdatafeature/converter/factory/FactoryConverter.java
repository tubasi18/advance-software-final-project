package edu.najah.cap.data.exportdatafeature.converter.factory;

import edu.najah.cap.data.enums.ConverterType;
import edu.najah.cap.data.exportdatafeature.converter.impl.ConvertToZIP;
import edu.najah.cap.data.exportdatafeature.converter.intf.IConverter;
import edu.najah.cap.exceptions.InvalidConvertTypeException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FactoryConverter {
    private static final Logger logger = LogManager.getLogger(FactoryConverter.class);
    private FactoryConverter(){}

    public static IConverter createConverter(ConverterType type ) throws InvalidConvertTypeException {
        if (ConverterType.TOZIP.equals(type)) {
            logger.info("User want the data as a ZIP file");
            return new ConvertToZIP();
        }
        logger.error(String.format("Unsupported this convert type : %s", type));
        throw new InvalidConvertTypeException("Unsupported this upload type .");
    }
}
