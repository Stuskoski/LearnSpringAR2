package databaseActions;

import fileActions.CustomLogger;
import models.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by r730819 on 6/23/2016.
 */
public class UploadCustomerIntoDatabase {
    public static void uploadSingleCustomer(Customer customer){
        Connection connection;
        PreparedStatement statement;
        String sqlStr;

        CustomLogger.createLogMsgAndSave("Attempting to upload data from file to database");

        connection = DatabaseConnections.getDB();

        if(connection!=null){
            try {
                CustomLogger.createLogMsgAndSave("Connection achieved");

                //Vulnerable to sql injection if you type extra junk into file with last field
                sqlStr = "INSERT INTO customers(lastName, firstName, emailAddress, homeAddress, city, state, zipCode) " +
                        "VALUES (?,?,?,?,?,?,?);";

                statement = connection.prepareStatement(sqlStr);

                statement.setString(1, customer.getLastName());
                statement.setString(2, customer.getFirstName());
                statement.setString(3, customer.getEmailAddress());
                statement.setString(4, customer.getHomeAddress());
                statement.setString(5, customer.getCity());
                statement.setString(6, customer.getState());
                statement.setString(7, customer.getZipCode());

                statement.executeUpdate();

                connection.close();

            }catch (SQLException e){
                e.printStackTrace();
                CustomLogger.createLogMsgAndSave("Error inserting data");
            }
        }
    }


    public static void uploadMultipleCustomersIntoDatabase(ArrayList<Customer> customerArrayList){
        CustomLogger.createLogMsgAndSave("Uploading Customer List Into Database");
        Connection connection;
        PreparedStatement statement;
        String sqlStr;

        if(!customerArrayList.isEmpty()){

            connection = DatabaseConnections.getDB();

            if(connection!=null) {
                CustomLogger.createLogMsgAndSave("Connection achieved");

                for (Customer customer : customerArrayList) {
                    try {
                        //Vulnerable to sql injection if you type extra junk into file with last field
                        sqlStr = "INSERT INTO customers(lastName, firstName, emailAddress, homeAddress, city, state, zipCode) " +
                                 "VALUES (?,?,?,?,?,?,?);";

                        statement = connection.prepareStatement(sqlStr);

                        statement.setString(1, customer.getLastName());
                        statement.setString(2, customer.getFirstName());
                        statement.setString(3, customer.getEmailAddress());
                        statement.setString(4, customer.getHomeAddress());
                        statement.setString(5, customer.getCity());
                        statement.setString(6, customer.getState());
                        statement.setString(7, customer.getZipCode());

                        statement.executeUpdate();

                    } catch (SQLException e) {
                        e.printStackTrace();
                        CustomLogger.createLogMsgAndSave("Error inserting data");
                    }
                }

                try {
                    connection.close();
                } catch (SQLException e) {
                    CustomLogger.createLogMsgAndSave("Unable to close SQL Connection");
                }
            }
        }
    }
}
