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

    /**
     * Logs but with no color so default is black
     * @param msg msg to be logged
     */
    public static void createLogMsgAndSave(String msg){

        Date date = new Date();

        logger.info(date.toString() + ": " + msg);
    }
}
