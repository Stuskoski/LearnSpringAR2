package util;

import persistance.hibernateObjects.customer.DbCustomerEntity;

import java.util.ArrayList;

/**
 * Created by r730819 on 6/27/2016.
 */
public class CreateEmailMessage {

    /**
     * Calls a function to pull all the customers
     * from the database unsorted.
     *
     * Loops through the arraylist and sorts by
     * pulling all the texas customers first and
     * then the 2nd loop pulls the rest.
     *
     * Generates an email message with toString
     * loop on every DbCustomerEntity.
     *
     * @return The sorted email message
     */
    public static String getSortedEmail(){
        ArrayList<DbCustomerEntity> customerList = GetUsersAndAddToArrayList.getUsers();
        ArrayList<DbCustomerEntity> sortedCustomerList = new ArrayList<DbCustomerEntity>();
        String message = "";
        StringBuilder stringBuilder = new StringBuilder(message);


        //Add all texans to sorted list
        for(DbCustomerEntity customer : customerList){
            if(customer.getState().toLowerCase().equals("tx")){
                sortedCustomerList.add(customer);
            }
        }

        //Add all non texans to sorted list
        for(DbCustomerEntity customer : customerList){
            if(!customer.getState().toLowerCase().equals("tx")){
                sortedCustomerList.add(customer);
            }
        }

        stringBuilder.append("======= Texas Customers =======\n");

        //Create email msg
        for(DbCustomerEntity customer : sortedCustomerList){

            if(!customer.getState().toLowerCase().equals("tx")){
                stringBuilder.append("======= Non Texas Customers =======\n");
            }

            stringBuilder.append(customer.toString()).append("\n");
        }


        return stringBuilder.toString();
    }

    /**
     * Calls function to pull all customers from
     * the database and put them in an arraylist.
     *
     * Loops through the arraylist and calls the
     * to string function on every DbCustomerEntity
     * object to generate an unsorted email.
     *
     * @return The unsorted email message
     */
    public static String getUnsortedEmail(){
        ArrayList<DbCustomerEntity> customerList = GetUsersAndAddToArrayList.getUsers();
        String message = "";
        StringBuilder stringBuilder = new StringBuilder(message);

        stringBuilder.append("======= Unsorted Customers =======\n");

        for(DbCustomerEntity customer : customerList){
            stringBuilder.append(customer.toString()).append("\n");
        }

        return stringBuilder.toString();
    }
}
