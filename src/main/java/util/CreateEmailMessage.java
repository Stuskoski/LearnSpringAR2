package util;

import persistance.DbCustomerEntity;

import java.util.ArrayList;

/**
 * Created by r730819 on 6/27/2016.
 */
public class CreateEmailMessage {

    public static String getSortedEmail(){
        ArrayList<DbCustomerEntity> customerList = GetUsersAndAddToArrayList.getUsers();

        return null;
    }

    public static String getUnsortedEmail(){
        String message = "";
        ArrayList<DbCustomerEntity> customerList = GetUsersAndAddToArrayList.getUsers();

        for(DbCustomerEntity customer : customerList){
            message += customer.toString();
            message += "\n";
        }

        return message;
    }
}
