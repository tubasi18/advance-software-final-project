package edu.najah.cap.data.exportdatafeature.collector;

import edu.najah.cap.data.exportdatafeature.userservices.factory.FactoryUserType;
import edu.najah.cap.data.exportdatafeature.userservices.intf.ICreateDataObjectUser;
import edu.najah.cap.exceptions.*;
import edu.najah.cap.iam.UserProfile;


public class DataCollector implements IDataCollector {


   public String collectData(UserProfile user) throws SystemBusyException, BadRequestException, NotFoundException, NullValueException, InvalidUserTypeException {

           ICreateDataObjectUser userData = FactoryUserType.creationUserDataObject(user);
       if(userData == null){
           throw new NullValueException(" Null value for User");
       }
       return userData.getDataUser();
   }
}
