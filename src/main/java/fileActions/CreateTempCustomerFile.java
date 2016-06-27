package fileActions;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class CreateTempCustomerFile {

    /**
     * Receives a multipartFile from a controller
     * in which the user has uploaded from the web
     * portal.  The method then creates a temp file
     * on the server's filesystem to be parsed and
     * to create DbCustomerEntities.
     *
     * @param uploadedFile file the user submitted
     * @return Temporary file created on the servers file system
     * @throws IOException Exception throw if no file or unable to
     * create file
     */
    public static File createFile(MultipartFile uploadedFile) throws IOException {

        byte[] bytes = uploadedFile.getBytes();

        // Creating the directory to store file
        String rootPath = System.getProperty("catalina.home");

        File dir = new File(rootPath + File.separator + "tmpFiles");
        if (!dir.exists())
            dir.mkdirs();

        // Create the file on server
        File serverFile = new File(dir.getAbsolutePath()
                + File.separator + "tmpCustomerFile"+ RandomStringUtils.randomNumeric(5)+".txt");
        BufferedOutputStream stream = new BufferedOutputStream(
                new FileOutputStream(serverFile));
        stream.write(bytes);
        stream.close();

        CustomLogger.createLogMsgAndSave("Server File Location="
                + serverFile.getAbsolutePath());

        return  serverFile;
    }
}
