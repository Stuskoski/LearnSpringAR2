package com.heb.assortment.util.databaseActions;

import com.heb.assortment.util.enums.DatabaseCommands;
import com.heb.assortment.util.fileActions.CustomLogger;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class ModifyDatabaseMethods {
    /**
     * Combined 3 methods into one that takes a string
     * as an action to either make, clear(truncate), or
     * delete(drop) the database.
     *
     * @param cmd Enum received from the controller to
     *            either create, clear or delete the
     *            customer table
     */
    public static void makeClearDeleteDB(DatabaseCommands cmd) {
        CustomLogger.createLogMsgAndSave("Attempting to modify database");
        Connection connection;
        Statement statement;
        String sqlStr;

        connection = DatabaseConnections.getDBConnectionWithDefaultDB();

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
                        connection = DatabaseConnections.getDB();
                        statement = connection.createStatement();

                        //drop the table if it exists
                        sqlStr = "DROP TABLE IF EXISTS customers;";
                        CustomLogger.createLogMsgAndSave("Executing: " + sqlStr);
                        statement.executeUpdate(sqlStr);

                        //Create the customers table
                        sqlStr ="";
                        StringBuilder stringBuilder = new StringBuilder(sqlStr);
                        stringBuilder.append("CREATE TABLE customers ");
                        stringBuilder.append("(idcustomers INTEGER(11) NOT NULL AUTO_INCREMENT, ");
                        stringBuilder.append(" lastName varchar(30) DEFAULT NULL, ");
                        stringBuilder.append(" firstName varchar(30) DEFAULT NULL, ");
                        stringBuilder.append(" emailAddress varchar(50) DEFAULT NULL, ");
                        stringBuilder.append(" homeAddress varchar(60) DEFAULT NULL, ");
                        stringBuilder.append(" city varchar(40) DEFAULT NULL, ");
                        stringBuilder.append(" state varchar(2) DEFAULT NULL, ");
                        stringBuilder.append(" zipCode varchar(15) DEFAULT NULL, ");
                        stringBuilder.append(" timeStamp datetime DEFAULT NULL, ");
                        stringBuilder.append(" PRIMARY KEY (idcustomers))");

                        CustomLogger.createLogMsgAndSave("Executing: " + stringBuilder.toString());

                        statement.executeUpdate(stringBuilder.toString());

                        /*//Create Users Table
                        sqlStr ="";
                        stringBuilder = new StringBuilder(sqlStr);
                        stringBuilder.append("CREATE TABLE users ");
                        stringBuilder.append("(userName varchar(45) NOT NULL, ");
                        stringBuilder.append(" password varchar(45) NOT NULL, ");
                        stringBuilder.append(" PRIMARY KEY (userName))");

                        CustomLogger.createLogMsgAndSave("Executing: " + stringBuilder.toString());

                        statement.executeUpdate(stringBuilder.toString());*/

                        break;

                    case CLEAR:
                        sqlStr = "TRUNCATE `assign2_db_augustus`.`customers`;";

                        statement.executeUpdate(sqlStr);

                        break;


                    case DELETE:
                        sqlStr = "DROP TABLE `assign2_db_augustus`.`customers`;";

                        statement.executeUpdate(sqlStr);

                        break;
                }
            } catch (SQLException e) {
                CustomLogger.createLogErrorAndSave("Unable to " + cmd.toString() + " database");
                CustomLogger.createLogErrorAndSave(e.getMessage());
                e.printStackTrace();
                DatabaseConnections.clearRootDBConnection();
            }
        }else{
            CustomLogger.createLogErrorAndSave("Unable to " + cmd.toString() + " database");
        }

        CustomLogger.createLogMsgAndSave("Done altering table");
        DatabaseConnections.clearRootDBConnection();

    }
}
