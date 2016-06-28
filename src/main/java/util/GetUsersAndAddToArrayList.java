package util;

import databaseActions.DatabaseConnections;
import fileActions.CustomLogger;
import persistance.DbCustomerEntity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by r730819 on 6/27/2016.
 */
public class GetUsersAndAddToArrayList {
    /**
     * todo
     *
     */
    public static ArrayList<DbCustomerEntity> getUsers(){
        Statement statement;
        String sqlStr;
        Connection connection;
        ArrayList<DbCustomerEntity> unsortedList = new ArrayList<DbCustomerEntity>();

        CustomLogger.createLogMsgAndSave("Attempting to pull customers from database");

        connection = DatabaseConnections.getDB(); //false for prompt screen

        if(connection!=null) {

            try {
                CustomLogger.createLogMsgAndSave("Pulling customers from database");
                statement = connection.createStatement();

                //Note - Never use * even if all fields are being pulled
                sqlStr = "SELECT idcustomers, lastName, firstName, emailAddress, homeAddress, city, state, zipCode," +
                        " timeStamp " +
                        "FROM customers;";

                ResultSet rs = statement.executeQuery(sqlStr);

                while (rs.next()) {
                    /*//Retrieve by data by column names
                    Integer idcustomers = rs.getInt("idcustomers");
                    String lastName = rs.getString("lastName");
                    String firstName = rs.getString("firstName");
                    String emailAddress = rs.getString("emailAddress");
                    String homeAddress = rs.getString("homeAddress");
                    String city = rs.getString("city");
                    String state = rs.getString("state");
                    String zipCode = rs.getString("zipCode");
                    String timeStamp = rs.getString("timeStamp");*/

                    //Create a new person and add to array list for later use
                    DbCustomerEntity customer = new DbCustomerEntity();
                    customer.setId(rs.getInt("idcustomers"));
                    customer.setFirstName(rs.getString("lastName"));
                    customer.setLastName(rs.getString("firstName"));
                    customer.setEmailAddress(rs.getString("emailAddress"));
                    customer.setHomeAddress(rs.getString("homeAddress"));
                    customer.setCity(rs.getString("city"));
                    customer.setState(rs.getString("state"));
                    customer.setZipCode(rs.getString("zipCode"));
                    customer.setTimeStamp(rs.getString("timeStamp"));

                    unsortedList.add(customer);

                }

                rs.close();
                connection.close();

            } catch (SQLException e) {
                System.out.println(e.getMessage());
                CustomLogger.createLogMsgAndSave("Unable to retrieve customers from database");
            }
        }
        return unsortedList;
    }
}
