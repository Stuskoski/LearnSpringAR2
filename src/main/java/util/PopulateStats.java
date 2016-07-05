package util;

import databaseActions.DatabaseConnections;
import fileActions.CustomLogger;
import models.StatsModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by r730819 on 6/30/2016.
 *
 * Stats class that only has one method to get stats
 */
public class PopulateStats {

    /**
     * Method that will make a SQL call to get
     * various stats from the database.
     *
     * Also calls a few other methods such
     * as number of logging to get those
     * stats
     *
     * @return A stats model with all the updated information.
     *         Used in stats.jsp
     */
    public static StatsModel getStats(){
        StatsModel model = new StatsModel();

        Connection connection;
        Statement statement;

        CustomLogger.createLogMsgAndSave("Attempting to get database stats");

        connection = DatabaseConnections.getDB();

        if(connection!=null){
            try {
                CustomLogger.createLogMsgAndSave("Connection achieved");

                statement = connection.createStatement();


                ResultSet rs = statement.executeQuery("SELECT " +
                        "(SELECT COUNT(*) FROM customers) as customerCount, " +
                        "(SELECT COUNT(*) FROM customers WHERE state='tx') as texanCount, " +
                        "(SELECT COUNT(*) FROM customers WHERE state!='tx') as nonTexanCount," +
                        "(SELECT COUNT(*) FROM users) as registeredUsers," +
                        "(SELECT timeStamp FROM customers LIMIT 1) as lastEmail," +
                        "(SELECT UPDATE_TIME\n" +
                         "FROM   information_schema.tables\n" +
                         "WHERE  TABLE_SCHEMA = 'assign2_db_augustus'\n" +
                         "AND TABLE_NAME = 'customers') as lastCustomerUpdate," +
                        "(SELECT sum( data_length + index_length ) / 1024 / 1024 size \n" +
                         "FROM information_schema.TABLES \n" +
                         "WHERE table_schema = 'assign2_db_augustus') as dbSize;");


                rs.next();

                CustomLogger.createLogMsgAndSave(rs.toString());

                model.setDbEntries(rs.getInt("customerCount"));
                model.setNumberOfTexans(rs.getInt("texanCount"));
                model.setNumberOfNonTexans(rs.getInt("nonTexanCount"));
                model.setNumberOfUsers(rs.getInt("registeredUsers"));
                model.setLastEmail(rs.getString("lastEmail"));
                model.setLastCustomerUpdate(rs.getString("lastCustomerUpdate"));
                model.setDbSizeInMB(rs.getString("dbSize"));

                connection.close();

            }catch (SQLException e){
                e.printStackTrace();

                CustomLogger.createLogMsgAndSave("Error reading stats: " +e.getMessage());
            }
        }

        model.setNumberOfLogs(CustomLogger.getNumOfLogs());

        return model;
    }

}
