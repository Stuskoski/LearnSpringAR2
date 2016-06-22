package databaseActions;

import models.Customer;
import models.CustomerArrayListDownloadedFromDB;
import org.springframework.beans.factory.annotation.Value;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by r730819 on 6/22/2016.
 */
public class GetCustomersFromDatabase {

    @Value("${db.user:augustus}")
    private static String databaseUser;

    @Value("${db.pass:mypass123}")
    private static String databasePass;

    @Value("${db.url:jdbc:mysql://localhost:3306/assign1_db_augustus}")
    private static String databaseURL;

    public static void getCustomers() {
        Statement statement;
        String sqlStr;
        Connection connection;

        connection = GetDatabaseConnection.getDB(databaseURL, databaseUser,
                databasePass); //false for prompt screen

        if (connection != null) {

            //Clear persons array before reloading it just in case
            CustomerArrayListDownloadedFromDB.downloadedArrayList.clear();

            try {
                //CustomLogger.createLogMsgAndSave("Pulling customers from database");
                statement = connection.createStatement();

                //Note - Never use * even if all fields are being pulled
                sqlStr = "SELECT last_name, first_name, email_addr, home_addr, city, state, zip_code, time_stamp " +
                        "FROM customers;";

                ResultSet rs = statement.executeQuery(sqlStr);

                int counter = 1;

                while (rs.next()) {
                    //last_name, first_name, email_addr, home_addr, city, state, zip_code, time_stamp
                    //Retrieve by data by column names
                    String last_name = rs.getString("last_name");
                    String first_name = rs.getString("first_name");
                    String email_addr = rs.getString("email_addr");
                    String home_addr = rs.getString("home_addr");
                    String city = rs.getString("city");
                    String state = rs.getString("state");
                    String zip_code = rs.getString("zip_code");
                    String time_stamp = rs.getString("time_stamp");

                    //Create a new person and add to array list for later use
                    Customer customer = new Customer();
                    customer.setLastName(last_name);
                    customer.setFirstName(first_name);
                    customer.setEmailAddr(email_addr);
                    customer.setHomeAddr(home_addr);
                    customer.setCity(city);
                    customer.setState(state);
                    customer.setZipCode(zip_code);
                    customer.setTimeStamp(time_stamp);
                    customer.setCustomerNum(counter);

                    CustomerArrayListDownloadedFromDB.downloadedArrayList.add(customer);

                    counter++;//increment customer number
                }

                rs.close();


            } catch (SQLException e) {
                System.out.println(e.getMessage());
               // CustomLogger.createLogMsgAndSave("SQL error in GetDataFromDBWithEmail", "red");
            }
        }
    }

}
