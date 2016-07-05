package databaseActions;

import util.ConfigFileController;
import fileActions.CustomLogger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnections {
    private static Connection dbConnection;
    private static Connection rootDbConnection;

    /**
     * This method will attempt to grab
     * a database connection using the
     * ConfigFileController with the user
     * settings.
     *
     * @return A database connection
     */
    public static Connection getDB() {
        CustomLogger.createLogMsgAndSave("Attempt database connection...");
        CustomLogger.createLogMsgAndSave("URL: " + ConfigFileController.getDatabaseURL());
        CustomLogger.createLogMsgAndSave("User: " + ConfigFileController.getDatabaseUser());
        CustomLogger.createLogMsgAndSave("Pass: ********");

        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver()); //would not work without this guy
            dbConnection = DriverManager.getConnection(ConfigFileController.getDatabaseURL(), ConfigFileController.getDatabaseUser(),
                    ConfigFileController.getDatabasePass());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        if (dbConnection != null) {
            CustomLogger.createLogMsgAndSave("Connection established");
        } else {
            CustomLogger.createLogErrorAndSave("Unable to retrieve database connection");
        }

        return dbConnection;

    }

    /**
     * Very similar to the method above but with
     * a different string url to connect to the root
     * of the database.
     *
     * This connection is needed when creating the database
     * since an attempt to connect to a non-existing db will
     * throw an error
     *
     * @return connection to db root
     */
    public static Connection getDBConnectionWithDefaultDB() {
        CustomLogger.createLogMsgAndSave("Attempt root database connection...");
        CustomLogger.createLogMsgAndSave("URL: " + ConfigFileController.getRootDatabaseURL());
        CustomLogger.createLogMsgAndSave("User: " + ConfigFileController.getDatabaseUser());
        CustomLogger.createLogMsgAndSave("Pass: ********");

        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver()); //would not work without this guy
            rootDbConnection = DriverManager.getConnection(ConfigFileController.getRootDatabaseURL(), ConfigFileController.getDatabaseUser(),
                    ConfigFileController.getDatabasePass());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        if (rootDbConnection != null) {
            CustomLogger.createLogMsgAndSave("Connection established");
        } else {
            CustomLogger.createLogErrorAndSave("Unable to retrieve database connection");
        }

        return rootDbConnection;

    }

    /**
     * Attempts to close the database connection
     * and then set it to null to be ready for
     * next use.
     *
     * For the regular database connection
     */
    public static void clearDBConnection() {
        try {
            dbConnection.close();
            CustomLogger.createLogMsgAndSave("Database connection closed.");
            dbConnection = null;
        } catch (SQLException e) {
            CustomLogger.createLogErrorAndSave("Unable to close DB connection. Details: " + e.getMessage());
        }
    }

    /**
     * Attempts to close the database connection
     * and then set it to null to be ready for
     * next use.
     *
     * For the root database connection
     */
    public static void clearRootDBConnection() {
        try {
            rootDbConnection.close();
            CustomLogger.createLogMsgAndSave("Root database connection closed.");
            rootDbConnection = null;
        } catch (SQLException e) {
            CustomLogger.createLogErrorAndSave("Unable to close root DB connection. Details: " + e.getMessage());
        }
    }


}
