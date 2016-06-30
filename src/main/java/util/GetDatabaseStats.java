package util;

import databaseActions.DatabaseConnections;
import fileActions.CustomLogger;
import models.StatsModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by r730819 on 6/30/2016.
 */
public class GetDatabaseStats {

    public static StatsModel getStatsFromDB(){
        StatsModel model = new StatsModel();

        Connection connection;
        Statement statement;
        String sqlStr;

        CustomLogger.createLogMsgAndSave("Attempting to get database stats");

        connection = DatabaseConnections.getDB();

        if(connection!=null){
            try {
                CustomLogger.createLogMsgAndSave("Connection achieved");

                statement = connection.createStatement();

                ResultSet rs = statement.executeQuery("SELECT count(*) FROM customers; SELECT count(*) FROM users;");

                rs.next();

                model.setDbEntries(rs.getInt(1));

                rs.next();

                model.setDbEntries(rs.getInt(1));



                connection.close();

            }catch (SQLException e){
                e.printStackTrace();

                CustomLogger.createLogMsgAndSave("Error reading stats: " +e.getMessage());
            }
        }
        return model;
    }



}
