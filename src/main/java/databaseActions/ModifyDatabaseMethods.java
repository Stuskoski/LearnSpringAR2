package databaseActions;

import enums.DatabaseCommands;
import fileActions.CustomLogger;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class ModifyDatabaseMethods {
    /**
     * Created by r730819 on 6/15/2016.
     * This method will get a SQL connection
     * and simply update all the time stamps
     * of every customer is the
     *
     */

    public static void updateTimeStampAfterEmail(){
        Statement statement;
        String sqlStr;

        Connection connection = GetDatabaseConnection.getDB();

        if(connection!=null){
            CustomLogger.createLogMsgAndSave("Attempting to update email timestamps");
            try {
                statement = connection.createStatement();

                sqlStr = "UPDATE customers " +
                         "SET timeStamp = NOW()";

                statement.executeUpdate(sqlStr);

            } catch (SQLException e) {
                CustomLogger.createLogMsgAndSave("Unable to update email timestamps");
            }
        }else{
            CustomLogger.createLogMsgAndSave("Unable to update email timestamps");
        }
    }

    /**
     * Combined 3 methods into one that takes a string
     * as an action to either make, clear(truncate), or
     * delete(drop) the database.
     *
     * @param cmd Enum received from the controller to
     *            either create, clear or delete the
     *            customer table
     */
    public static void makeClearDeleteDB(DatabaseCommands cmd) { //todo use enum for readability
        CustomLogger.createLogMsgAndSave("Attempting to modify database");
        Connection connection;
        Statement statement;
        String sqlStr;

        connection = GetDatabaseConnection.getDBConnectionWithDefaultDB();

        if(connection != null){
            try {
                statement = connection.createStatement();

                switch (cmd) {
                    case CREATE:
                        //create the table with an initial root connection
                        sqlStr = "CREATE DATABASE IF NOT EXISTS `assign2_db_augustus`;";
                        CustomLogger.createLogMsgAndSave("Executing: " + sqlStr);
                        statement.executeUpdate(sqlStr);

                        //create new connection with the new database specified
                        connection = GetDatabaseConnection.getDB();
                        statement = connection.createStatement();

                        //drop the table if it exists
                        sqlStr = "DROP TABLE IF EXISTS customers;";
                        CustomLogger.createLogMsgAndSave("Executing: " + sqlStr);
                        statement.executeUpdate(sqlStr);

                        //Finally create the table
                        sqlStr ="";
                        StringBuilder stringBuilder = new StringBuilder(sqlStr);
                        stringBuilder.append("CREATE TABLE customers ");
                        stringBuilder.append("(idcustomers INTEGER(11) NOT NULL AUTO_INCREMENT, ");
                        stringBuilder.append(" lastName varchar(30) DEFAULT NULL, ");
                        stringBuilder.append(" firstName varchar(30) DEFAULT NULL, ");
                        stringBuilder.append(" emailAddress varchar(50) DEFAULT NULL, ");
                        stringBuilder.append(" homeAddress varchar(60) DEFAULT NULL, ");
                        stringBuilder.append(" city varchar(40) DEFAULT NULL, ");
                        stringBuilder.append(" state varchar(50) DEFAULT NULL, ");
                        stringBuilder.append(" zipCode varchar(15) DEFAULT NULL, ");
                        stringBuilder.append(" timeStamp datetime DEFAULT NULL, ");
                        stringBuilder.append(" PRIMARY KEY (idcustomers))");

                        CustomLogger.createLogMsgAndSave("Executing: " + stringBuilder.toString());

                        statement.executeUpdate(stringBuilder.toString());

                        break;

                    case CLEAR:
                        sqlStr = "TRUNCATE `assign2_db_augustus`.`customers`;";

                        statement.executeUpdate(sqlStr);

                        break;


                    case DELETE:
                        sqlStr = "DROP DATABASE `assign2_db_augustus`;";

                        statement.executeUpdate(sqlStr);

                        break;
                }
            } catch (SQLException e) {
                CustomLogger.createLogMsgAndSave("Unable to " + cmd.toString() + " database");
                e.printStackTrace();
            }
        }else{
            CustomLogger.createLogMsgAndSave("Unable to " + cmd.toString() + " database");
        }

        CustomLogger.createLogMsgAndSave("Done altering table");

    }
}
