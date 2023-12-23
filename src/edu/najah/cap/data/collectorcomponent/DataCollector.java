package edu.najah.cap.data.collectorcomponent;

import edu.najah.cap.data.exportdatafeature.factory.FactoryUserType;
import edu.najah.cap.data.exportdatafeature.factory.interfaces.ICreateDataObjectUser;
import edu.najah.cap.iam.UserProfile;

public class DataCollector {
    private final UserProfile user;

    public DataCollector(UserProfile user) {
        this.user = user;
    }

   public String collectData(){
       ICreateDataObjectUser userData = FactoryUserType.creationUserDataObject(user);

       return userData.getDataUser();
   }
}
