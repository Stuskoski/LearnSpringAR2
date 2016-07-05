package com.heb.assortment.util.login;

import com.heb.assortment.util.fileActions.CustomLogger;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by r730819 on 7/5/2016.
 *
 * Hashing methods for a little more
 * security of the server side
 */
public class HashPasswords {

    /**
     * Creates a hash from a string based password.
     *
     * Uses sha256 that corresponds to sha2("password",0) or sha2("password",256)
     * in MySQL
     *
     * @param password String based password to be hashed
     * @return A hex string of the hash bytes.  Null on exception.
     */
    public static String hash(String password){

        try {
            CustomLogger.createLogMsgAndSave("Hashing password");

            MessageDigest sha256;

            sha256 = MessageDigest.getInstance("SHA-256");

            byte[] passBytes = password.getBytes();
            byte[] passHash = sha256.digest(passBytes);

            return toHex(passHash);

        } catch (NoSuchAlgorithmException e) {
            CustomLogger.createLogMsgAndSave("Hash error: " + e.getMessage());
            return null;
        }
    }

    /**
     * Converts a byte array into a hexadecimal string.
     *
     * @param   array       the byte array to convert
     * @return              a length*2 character string encoding the byte array
     */
    private static String toHex(byte[] array)
    {
        BigInteger bi = new BigInteger(1, array);
        String hex = bi.toString(16);
        int paddingLength = (array.length * 2) - hex.length();
        if(paddingLength > 0)
            return String.format("%0" + paddingLength + "d", 0) + hex;
        else
            return hex;
    }
}
