package databaseActions;

import util.ConfigFileController;
import fileActions.CustomLogger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetDatabaseConnection {

    /**
     * Created by r730819 on 6/14/2016.
     * This class creates a database connection
     *
     * Boolean uploadData determines if user wants to upload
     * data or just grab a connection for looking at the DB
     */
    public static Connection getDB(){
        Connection conn1 = null;

        CustomLogger.createLogMsgAndSave(ConfigFileController.getDatabaseURL());
        CustomLogger.createLogMsgAndSave(ConfigFileController.getDatabaseUser());
        CustomLogger.createLogMsgAndSave(ConfigFileController.getDatabasePass());

        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver()); //would not work without this guy
            conn1 = DriverManager.getConnection(ConfigFileController.getDatabaseURL(), ConfigFileController.getDatabaseUser(),
                    ConfigFileController.getDatabasePass());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        if (conn1 != null) {
            CustomLogger.createLogMsgAndSave("Connection established");
        }else{
            CustomLogger.createLogMsgAndSave("Unable to retrieve database connection");
        }

        return conn1;

    }

    public static Connection getDBConnectionWithDefaultDB(){
        Connection conn1 = null;

        CustomLogger.createLogMsgAndSave(ConfigFileController.getDatabaseURL());
        CustomLogger.createLogMsgAndSave(ConfigFileController.getDatabaseUser());
        CustomLogger.createLogMsgAndSave(ConfigFileController.getDatabasePass());

        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver()); //would not work without this guy
            conn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306", ConfigFileController.getDatabaseUser(),
                    ConfigFileController.getDatabasePass());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        if (conn1 != null) {
            CustomLogger.createLogMsgAndSave("Connection established");
        }else{
            CustomLogger.createLogMsgAndSave("Unable to retrieve database connection");
        }

        return conn1;

    }
}
