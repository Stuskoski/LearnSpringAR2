package com.heb.assortment.util.fileActions;

import com.heb.assortment.domain.DbCustomerEntity;
import java.util.ArrayList;

/**
 * Created by r730819 on 6/14/2016.
 *
 */
public class HandleLinesFromFile {

    /**
     *
     * @param line A string representing one line from the read customer file
     */
    public static void parseLines(String line, ArrayList<DbCustomerEntity> customerArray){

        //Variables
        String strippedLines;
        String personDetails[];

        //Replace all occurrences of " inside the received line and put it into new variable
        strippedLines = line.replaceAll("\"", "");

        //Split the string into an array based off of commas
        personDetails = strippedLines.split(",");

        createUserAndAddToArray(personDetails, customerArray);

    }

    /**
     * Create a new person and add the details.
     * After the user is create go ahead and
     * add the user to the ArrayList that will
     * be used later.
     *
     * @param personDetails An array contains the 7 details of
     *                      the person to be uploaded
     *
     * @param customerArray An ArrayList reference that contains
     *                    multiple users.
     */
    public static void createUserAndAddToArray(String personDetails[], ArrayList<DbCustomerEntity> customerArray){

        if(personDetails.length != 7){
            CustomLogger.createLogMsgAndSave("Error: Incorrect number of details for person in file");
            return;
        }

        DbCustomerEntity customer = new DbCustomerEntity();

        //The order matters here according to the text file specs
        customer.setLastName(personDetails[0]);
        customer.setFirstName(personDetails[1]);
        customer.setEmailAddress(personDetails[2]);
        customer.setHomeAddress(personDetails[3]);
        customer.setCity(personDetails[4]);
        customer.setState(personDetails[5]);
        customer.setZipCode(personDetails[6]);

        customerArray.add(customer);
    }
}
