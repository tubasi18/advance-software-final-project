package edu.najah.cap.data.collectorcomponent;

import edu.najah.cap.exceptions.BadRequestException;
import edu.najah.cap.exceptions.NotFoundException;
import edu.najah.cap.exceptions.NullValueException;
import edu.najah.cap.exceptions.SystemBusyException;

public interface IDataCollector {
    String collectData() throws SystemBusyException, BadRequestException, NotFoundException, NullValueException;
}
