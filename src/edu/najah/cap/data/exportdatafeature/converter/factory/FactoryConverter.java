package edu.najah.cap.data.exportdatafeature.converter.factory;

import edu.najah.cap.data.enums.ConverterType;
import edu.najah.cap.data.exportdatafeature.converter.impl.ConvertToZIP;
import edu.najah.cap.data.exportdatafeature.converter.intf.IConverter;

public class FactoryConverter {

    private FactoryConverter(){}

    public static IConverter createConverter(ConverterType type ) {
        if (ConverterType.TOZIP.equals(type)) {
            return new ConvertToZIP();
        }
        return null;
    }

}
