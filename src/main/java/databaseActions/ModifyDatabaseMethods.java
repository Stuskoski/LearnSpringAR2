package databaseActions;

import enums.DatabaseCommands;
import org.springframework.beans.factory.annotation.Value;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class ModifyDatabaseMethods {

    @Value("${db.user:augustus}")
    private static String databaseUser;

    @Value("${db.pass:mypass123}")
    private static String databasePass;

    @Value("${db.url:jdbc:mysql://localhost:3306/assign1_db_augustus}")
    private static String databaseURL;

    /**
     * Created by r730819 on 6/15/2016.
     * This method will get a SQL connection
     * and simply update all the time stamps
     * of every customer is the
     *

    public static void updateTimeStampAfterEmail(){
        Statement statement;
        String sqlStr;

        Connection connection = GetDatabaseConnection.getDBConnectionForEmail(SettingsTab.urlTextField.getText(),
                SettingsTab.userTextField.getText(), SettingsTab.passTextField.getText(), "email");

        if(connection!=null){
            CustomLogger.createLogMsgAndSave("Attempting to update email timestamps");
            try {
                statement = connection.createStatement();

                sqlStr = "UPDATE customers " +
                         "SET time_stamp = now()";

                statement.executeUpdate(sqlStr);

            } catch (SQLException e) {
                CustomLogger.createLogMsgAndSave("Unable to update email timestamps", "red");
            }
        }else{
            PromptForDatabaseCredentialsScreen.createScreen("email");
        }

    }*/

    /**
     * Send file to a method that will
     * parse the file and create
     * Person objects.  The method returns
     * an ArrayList containing all the objects
     * created from the file.  Ensures all 7 details
     * are present for each user.

    public static void attemptUploadData(Connection connection){
        if(connection!=null){
            CustomLogger.createLogMsgAndSave("Attempting to upload data from file to database");

            Statement statement;
            String sqlStr;

            ReadFile.readAndCreateObjects(new File(UploadDataTab.fileNameTextField.getText()));

            //Alternative, search for mysqlimport.exe then execute the cmd below.  Mysqlimport is probably faster.
            //'mysqlimport.exe --local -u[USER] -p[PASSWORD] --fields-terminated-by=, assign1_db_augustus [PATH TO FILE]'
            for (Person person : PersonsArrayList.personsArray){
                try {
                    statement = connection.createStatement();

                    //Vulnerable to sql injection if you type extra junk into file with last field
                    sqlStr = "INSERT INTO customers(last_name, first_name, email_addr, home_addr, city, state, zip_code)" +
                            "VALUES ('"+ person.getLastName() + "','" + person.getFirstName() + "','" + person.getEmailAddr() + "','" +
                            person.getHomeAddr() + "','" + person.getCity() + "','" + person.getState() + "','" + person.getZipCode() +
                            "');";

                    statement.executeUpdate(sqlStr);

                } catch (SQLException e) {
                    CustomLogger.createLogMsgAndSave("Error inserting data", "red");
                }
            }

            DatabaseAlerts alerts = new DatabaseAlerts();
            alerts.uploadDataSuccess();
        }
    }*/


    /**
     * Combined 3 methods into one that takes a string
     * as an action to either make, clear(truncate), or
     * delete(drop) the database.
     *
     * @param cmd Received from DatabaseActions.DatabaseActionListeners
     *               and is either "create", "clear", "delete" to specify
     *               which action to take.
     */
    public static void makeClearDeleteDB(DatabaseCommands cmd) { //todo use enum for readability
        File mySqlPath;
        Process process = null;

        //CustomLogger.createLogMsgAndSave("Attempting to alter database");

        //Find the MySQL path. Restricted to windows only currently
        mySqlPath = findMySQLExec();
        if (mySqlPath != null && !mySqlPath.toString().equals("") && mySqlPath.canExecute()) {
            try {
                switch (cmd) {
                    case CREATE:
                        File tempFile = new File("assign2_db_augustus_customers.sql");

                        Runtime runtime = Runtime.getRuntime();

                        if(runtime != null){
                           // runtime.exec(new String[]{mySqlPath.toString(), "-u", databaseUser,
                             //       "-p" + databasePass, "-e", "source " + tempFile.toString()});
                        }

                        break;


                    case CLEAR:
                        Runtime.getRuntime().exec(new String[]{mySqlPath.toString(), "-u", databaseUser,
                                "-p" + databasePass, "-e", "TRUNCATE `assign1_db_augustus`.`customers`;"});
                        break;


                    case DELETE:
                        Runtime.getRuntime().exec(new String[]{mySqlPath.toString(), "-u", databaseUser,
                                "-p" + databasePass, "-e", "DROP DATABASE `assign1_db_augustus`;"});
                        break;
                }
            } catch (IOException e) {
                //CustomLogger.createLogMsgAndSave("Unable to execute " + mySqlPath.toString(), "red");
            }
        }
    }

    /**
     * Searches in program files for the correct
     * extension to the mysql executable.
     *
     * @return the executable mysql file
     */
    private static File findMySQLExec(){
        File retFile = null;
        Process process = null;

       // CustomLogger.createLogMsgAndSave("Looking for mysql.exe in Program Files");

        //windows cmd to search for the mysql executable. todo - consider handling other OS
        try {
            process = Runtime.getRuntime().exec("where /R \"C:\\Program Files\" mysql.exe");
        } catch (IOException e) {
            //CustomLogger.createLogMsgAndSave("Unable to locate MySQL executable", "red");
        }

        //Create a new file based off the path returned and return that file
        if(process!=null){
            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
            try {
                retFile = new File(in.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return retFile;
    }
}
