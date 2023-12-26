package edu.najah.cap.data.collectorcomponent;

import edu.najah.cap.data.exportdatafeature.factory.FactoryUserType;
import edu.najah.cap.data.exportdatafeature.factory.interfaces.ICreateDataObjectUser;
import edu.najah.cap.exceptions.BadRequestException;
import edu.najah.cap.exceptions.NotFoundException;
import edu.najah.cap.exceptions.NullValueException;
import edu.najah.cap.exceptions.SystemBusyException;
import edu.najah.cap.iam.UserProfile;


public class DataCollector implements IDataCollector {
    private final UserProfile user;

    public DataCollector(UserProfile user) {
        this.user = user;
    }

   public String collectData() throws SystemBusyException, BadRequestException, NotFoundException, NullValueException {

       ICreateDataObjectUser userData = FactoryUserType.creationUserDataObject(user);
       if(userData == null){
           throw new NullValueException(" Null value for User");
       }
       return userData.getDataUser();
   }
}
