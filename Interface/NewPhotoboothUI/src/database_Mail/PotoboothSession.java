/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database_Mail;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
 *
 * @author Alfred Espinosa
 */
public class PotoboothSession {


    /*
        Deze methode roept de huidige tijd en datum op.
     */
    public static String currentDateTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        return dtf.format(now);
    }

    /*
        Deze methode genereert een alfanumeriek code. De klant kan de gegenereerde code
        invoeren op de website om zijn foto's te benaderen.
     */
    public static String randomAlphaNumeric() {
        final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghij"
                + "klmnopqrstuvwxyz0123456789";
        int LENGTH = 6;
        StringBuilder builder = new StringBuilder();

        while (LENGTH-- != 0) {
            int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }

        return builder.toString();
    }

}
