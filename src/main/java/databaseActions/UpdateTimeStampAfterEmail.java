package databaseActions;

import fileActions.CustomLogger;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by r730819 on 6/28/2016.
 */
public class UpdateTimeStampAfterEmail {
    /**
     * Created by r730819 on 6/15/2016.
     * This method will get a SQL connection
     * and simply update all the time stamps
     * of every customer is the
     *
     */

    public static void update(){
        Statement statement;
        String sqlStr;

        Connection connection = DatabaseConnections.getDB();

        if(connection!=null){
            CustomLogger.createLogMsgAndSave("Attempting to update email timestamps");
            try {
                statement = connection.createStatement();

                sqlStr = "UPDATE customers " +
                         "SET timeStamp = NOW()";

                statement.executeUpdate(sqlStr);

            } catch (SQLException e) {
                CustomLogger.createLogErrorAndSave("Unable to update email timestamps");
                CustomLogger.createLogErrorAndSave(e.getMessage());
                DatabaseConnections.clearDBConnection();
            }
        }else{
            CustomLogger.createLogErrorAndSave("Unable to update email timestamps");
        }

        CustomLogger.createLogMsgAndSave("Done altering email timestamps");
        DatabaseConnections.clearDBConnection();
    }
}
