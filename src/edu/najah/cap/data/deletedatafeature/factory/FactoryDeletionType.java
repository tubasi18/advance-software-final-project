package edu.najah.cap.data.deletedatafeature.factory;

import edu.najah.cap.data.deletedatafeature.factory.intf.IDeleteType;
import edu.najah.cap.data.deletedatafeature.factory.typedelete.HardDelete;
import edu.najah.cap.data.deletedatafeature.factory.typedelete.SoftDelete;
import edu.najah.cap.data.enums.DeleteType;
import edu.najah.cap.exceptions.InvalidDeleteTypeException;

public class FactoryDeletionType {

    private FactoryDeletionType(){}
    public static IDeleteType factoryProcess(DeleteType type) throws InvalidDeleteTypeException {
        if (type.equals(DeleteType.HARD_DELETE)) {
            return new HardDelete();
        } else if (type.equals(DeleteType.SOFT_DELETE)){
            return new SoftDelete();
        }
        else{
            throw new InvalidDeleteTypeException("Unsupported this delete type .");
        }
    }
}