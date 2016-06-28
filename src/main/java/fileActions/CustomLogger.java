package fileActions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import java.util.Date;

/**
 * Created by r730819 on 6/16/2016.
 *
 * Logger class used to write to an
 * external log, an internal log, and
 * the console.
 */
public class CustomLogger {
    private static Logger logger = (Logger) LogManager.getLogger();
    private static String allLogs = "";
    private static StringBuilder logStringBuilder = new StringBuilder(allLogs);

    /**
     * Logs into information
     * @param msg msg to be logged
     */
    public static void createLogMsgAndSave(String msg){
        Date date = new Date();

        String logMsg = date.toString() + ": " + msg;

        logger.info(logMsg);
        logStringBuilder.append("<div class=\"logInfo\">").append(logMsg).append("</div>");
    }

    /**
     * Logs into error
     * @param msg msg to be logged
     */
    public static void createLogErrorAndSave(String msg){
        Date date = new Date();

        String logMsg = date.toString() + ": " + msg;

        logger.error(logMsg);
        logStringBuilder.append("<div class=\"logError\">").append(logMsg).append("</div>");
    }

    /**
     * returns the contents of the string builder
     * which is all the logs.
     *
     * @return String builders contents - All logs
     */
    public static String getLogStringBuilderContentsAsHtml() {
        CustomLogger.createLogMsgAndSave("Getting logs");
        return logStringBuilder.toString();
    }


    /**
     * sets the length of the string builder
     * to 0 to clear all logs
     */
    public static void clearLogs(){
        CustomLogger.createLogMsgAndSave("Clearing logs");
        logStringBuilder.setLength(0);
    }
}
