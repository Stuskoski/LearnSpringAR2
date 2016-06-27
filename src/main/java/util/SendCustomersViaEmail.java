package util;

import databaseActions.GetDatabaseConnection;
import fileActions.CustomLogger;
import models.CustomerArrayListDownloadedFromDB;
import persistance.DbCustomerEntity;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

/**
 * Created by r730819 on 6/27/2016.
 */
public class SendCustomersViaEmail {

    /**
     * Gets the unsorted array list from the function
     * below and sends to a helper function to sort
     * the list by texas customers.
     *
     * An email will then be generated.
     *
     * @param toEmail Email address to send list to
     * @param fromEmail Email address to send email from
     * @param subject The subject of the email
     */
    public static void sendEmail(String toEmail, String fromEmail, String subject, String message){
        CustomLogger.createLogMsgAndSave("Sending email...");

        String host = ConfigFileController.getMailHost();

        Properties properties = System.getProperties();

        properties.setProperty("mail.smtp.host", host);

        Session session = Session.getInstance(properties);

        try{
            // Create a default MimeMessage object.
            MimeMessage mimeMessage = new MimeMessage(session);

            // Set From: header field of the header.
            mimeMessage.setFrom(new InternetAddress(fromEmail));

            // Set To: header field of the header.
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));

            // Set Subject: header field
            mimeMessage.setSubject(subject);

            // Now set the actual message
            mimeMessage.setText(message);

            // Send message
            Transport.send(mimeMessage);
            CustomLogger.createLogMsgAndSave("Email sent");

            //send good log
        }catch (MessagingException mex) {
            //todo add error page redirection?
            CustomLogger.createLogMsgAndSave("Unable to send email.  Check the following credentials: \n" +
                    "From: "+toEmail+"\n" +
                    "To: " + fromEmail + "\n" +
                    "Host: " + host + "\n" +
                    "Port: Default(25)");

        }
    }

    /**
     * Helper function that will take an array list and
     * loop through it twice and add all the texans first
     * and then all the non texans to a new array.
     *
     * Returns a sorted array when done.
     *
     * @param unsortedList Unsorted list received to be sorted
     * @return A sorted list
     */
    private static ArrayList<DbCustomerEntity> sortArrayList(ArrayList<DbCustomerEntity> unsortedList){
        CustomLogger.createLogMsgAndSave("Sorting customer list");

        ArrayList<DbCustomerEntity> tempList = new ArrayList<DbCustomerEntity>();

        //add all texans to the list
        for(DbCustomerEntity customer : unsortedList){
            if(customer.getState().toLowerCase().equals("tx")){
                tempList.add(customer);
            }
        }

        //add all non texans to the list
        for(DbCustomerEntity customer : unsortedList){
            if(!customer.getState().toLowerCase().equals("tx")){
                tempList.add(customer);
            }
        }

        return tempList;
    }


    /**
     * Gets the unsorted list and creates an unsorted email out of it
     *
     * @param toEmail Email address to send list to
     * @param fromEmail Email address to send email from
     * @param subject The subject of the email
     */
    public static void sendUnsortedEmail(String toEmail, String fromEmail, String subject, String message){
        CustomLogger.createLogMsgAndSave("Sending unsorted customer list");
        ArrayList<DbCustomerEntity> unsortedCustomerList = getUsersFromDBAndAddToList();

        sendJavaxEmail(toEmail, fromEmail, subject, message);

    }

    /**
     * todo
     */
    private static void sendJavaxEmail(String toEmail, String fromEmail, String subject, String message){

        CustomLogger.createLogMsgAndSave("Sending email...");

        String host = ConfigFileController.getMailHost();

        Properties properties = System.getProperties();

        properties.setProperty("mail.smtp.host", host);

        Session session = Session.getInstance(properties);

        try{
            // Create a default MimeMessage object.
            MimeMessage mimeMessage = new MimeMessage(session);

            // Set From: header field of the header.
            mimeMessage.setFrom(new InternetAddress(fromEmail));

            // Set To: header field of the header.
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));

            // Set Subject: header field
            mimeMessage.setSubject(subject);

            // Now set the actual message
            mimeMessage.setText(message);

            // Send message
            Transport.send(mimeMessage);
            CustomLogger.createLogMsgAndSave("Email sent");


            //send good log
        }catch (MessagingException mex) {
            //todo add error page redirection?
            CustomLogger.createLogMsgAndSave("Unable to send email.  Check the following credentials: \n" +
                    "From: "+toEmail+"\n" +
                    "To: " + fromEmail + "\n" +
                    "Host: " + host + "\n" +
                    "Port: Default(25)");

        }
    }


    /**
     * todo
     *
     */
    public static ArrayList<DbCustomerEntity> getUsersFromDBAndAddToList(){
        Statement statement;
        String sqlStr;
        Connection connection;
        ArrayList<DbCustomerEntity> unsortedList = new ArrayList<DbCustomerEntity>();

        CustomLogger.createLogMsgAndSave("Attempting to pull customers from database");

        connection = GetDatabaseConnection.getDB(); //false for prompt screen

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
