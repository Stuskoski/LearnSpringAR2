package util;

import databaseActions.DatabaseConnections;
import databaseActions.UpdateTimeStampAfterEmail;
import fileActions.CustomLogger;
import persistance.hibernateObjects.customer.DbCustomerEntity;

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
    public static boolean sendEmail(String toEmail, String fromEmail, String subject, String message){
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

            UpdateTimeStampAfterEmail.update();

            return true;
            //send good log
        }catch (MessagingException mex) {
            //todo add error page redirection?
            CustomLogger.createLogMsgAndSave("Unable to send email.  Check the following credentials: \n" +
                    "From: "+toEmail+"\n" +
                    "To: " + fromEmail + "\n" +
                    "Host: " + host + "\n" +
                    "Port: Default(25)");
            return false;

        }
    }
}
