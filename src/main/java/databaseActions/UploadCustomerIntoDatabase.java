package databaseActions;

import fileActions.CustomLogger;
import models.Customer;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by r730819 on 6/23/2016.
 */
public class UploadCustomerIntoDatabase {
    public static void uploadSingleCustomer(Customer customer){
        Connection connection;
        Statement statement;
        String sqlStr;

        CustomLogger.createLogMsgAndSave("Attempting to upload data from file to database");

        connection = GetDatabaseConnection.getDB();

        if(connection!=null){
            try {
                CustomLogger.createLogMsgAndSave("Connection achieved");
                statement = connection.createStatement();

                //Vulnerable to sql injection if you type extra junk into file with last field
                sqlStr = "INSERT INTO customers(last_name, first_name, email_addr, home_addr, city, state, zip_code)" +
                        "VALUES ('"+ customer.getLastName() + "','" + customer.getFirstName() + "','" +
                        customer.getEmailAddress() + "','" + customer.getHomeAddress() + "','" + customer.getCity() +
                        "','" + customer.getState() + "','" + customer.getZipCode() +
                        "');";

                statement.executeUpdate(sqlStr);

            }catch (SQLException e){
                CustomLogger.createLogMsgAndSave("Error inserting data");
            }
        }
    }
}
