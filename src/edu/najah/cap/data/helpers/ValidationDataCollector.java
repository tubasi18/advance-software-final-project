package edu.najah.cap.data.helpers;

import edu.najah.cap.data.exportdatafeature.userservices.abst.ICreateDataObjectUser;

public class ValidationDataCollector {

    private  ValidationDataCollector(){}

    public static  boolean isUserDataNull(ICreateDataObjectUser userData){
        return  userData == null;
    }
}
