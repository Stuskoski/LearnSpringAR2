package databaseActions;

import enums.DatabaseCommands;
import fileActions.CustomLogger;
import org.springframework.beans.factory.annotation.Value;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
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

        connection = GetDatabaseConnection.getDBTest();

        if(connection != null){
            try {
                statement = connection.createStatement();

                switch (cmd) {
                    case CREATE:
                        //create the table with an initial root connection
                        sqlStr = "CREATE DATABASE IF NOT EXISTS `assign2_db_augustus`;";
                        statement.executeUpdate(sqlStr);

                        //create new connection with the new database specified
                        connection = GetDatabaseConnection.getDB();
                        statement = connection.createStatement();

                        //drop the table if it exists
                        sqlStr = "DROP TABLE IF EXISTS customers;";
                        statement.executeUpdate(sqlStr);

                        //Finally create the table
                        sqlStr ="CREATE TABLE customers " +
                                "(idcustomers INTEGER(11) NOT NULL AUTO_INCREMENT, " +
                                " lastName VARCHAR(30) DEFAULT NULL, " +
                                " firstName VARCHAR(30) DEFAULT NULL, " +
                                " emailAddress VARCHAR(50) DEFAULT NULL, " +
                                " homeAddress VARCHAR(60) DEFAULT NULL, " +
                                " city VARCHAR(40) DEFAULT NULL, " +
                                " state VARCHAR(50) DEFAULT NULL, " +
                                " zipCode VARCHAR(15) DEFAULT NULL, " +
                                " timeStamp DATETIME DEFAULT NULL, " +
                                " PRIMARY KEY (idcustomers))";

                        /*sqlStr = "DROP TABLE IF EXISTS customers; " +
                                "CREATE TABLE customers " +
                                "(id INTEGER not NULL, " +
                                " first VARCHAR(255), " +
                                " last VARCHAR(255), " +
                                " age INTEGER, " +
                                " PRIMARY KEY ( id ))";*/

                       /* StringBuilder stringBuilder = new StringBuilder(sqlStr);

                        //stringBuilder.append("CREATE DATABASE IF NOT EXISTS `assign2_db_augustus`;\n");
                        //stringBuilder.append("USE `assign2_db_augustus`;\n");
                        stringBuilder.append("DROP TABLE IF EXISTS `customers`;\n");
                        //stringBuilder.append("SET @saved_cs_client = @@character_set_client;\n");
                        //stringBuilder.append("SET character_set_client = utf8;\n");
                        stringBuilder.append("CREATE TABLE `customers` (\n");
                        stringBuilder.append("`idcustomers` int(11) NOT NULL AUTO_INCREMENT,\n");
                        stringBuilder.append("`lastName` varchar(30) DEFAULT NULL,\n");
                        stringBuilder.append("`firstName` varchar(30) DEFAULT NULL,\n");
                        stringBuilder.append("`emailAddress` varchar(50) DEFAULT NULL,\n");
                        stringBuilder.append("`homeAddress` varchar(60) DEFAULT NULL,\n");
                        stringBuilder.append("`city` varchar(40) DEFAULT NULL,\n");
                        stringBuilder.append("`state` varchar(50) DEFAULT NULL,\n");
                        stringBuilder.append("`zipCode` varchar(15) DEFAULT NULL,\n");
                        stringBuilder.append("`timeStamp` datetime DEFAULT NULL,\n\n");
                        stringBuilder.append("PRIMARY KEY (`idcustomers`)\n");
                        stringBuilder.append(");");
                        //stringBuilder.append("SET character_set_client = @saved_cs_client;\n");
                        //stringBuilder.append("\n");
                       // stringBuilder.append("\n");*/

                        CustomLogger.createLogMsgAndSave(sqlStr);

                        statement.executeUpdate(sqlStr);

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