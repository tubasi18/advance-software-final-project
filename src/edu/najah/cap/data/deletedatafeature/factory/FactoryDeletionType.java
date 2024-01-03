package edu.najah.cap.data.deletedatafeature.factory;

import edu.najah.cap.data.deletedatafeature.intf.IDeleteType;
import edu.najah.cap.data.deletedatafeature.typedelete.HardDelete;
import edu.najah.cap.data.deletedatafeature.typedelete.SoftDelete;
import edu.najah.cap.data.enums.DeleteType;
import edu.najah.cap.exceptions.InvalidDeleteTypeException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FactoryDeletionType {

    private FactoryDeletionType(){}
    private static final Logger logger = LogManager.getLogger(FactoryDeletionType.class);

    public static IDeleteType factoryProcess(DeleteType type) throws InvalidDeleteTypeException {
        if (type.equals(DeleteType.HARD)) {
            logger.info( "User Selected Hard Delete");
            return new HardDelete();
        } else if (type.equals(DeleteType.SOFT)){
            logger.info( "User Selected Soft Delete");
            return new SoftDelete();
        }
        else{
            logger.error(String.format("Unsupported delete type %s", type));
            throw new InvalidDeleteTypeException("Unsupported this delete type " + type);
        }
    }
}