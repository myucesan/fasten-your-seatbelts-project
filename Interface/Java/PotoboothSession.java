/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package potoboothsession;

import java.util.*;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
 *
 * @author Alfred Espinosa
 */
public class PotoboothSession {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // TODO code application logic here

        final String CODE = randomAlphaNumeric();
        final String CURRENTDATETIME = currentDateTime();
        
        JDBC.Open();
        //JDBC.Insert(CODE, CURRENTDATETIME);
        JDBC.Remove();
        JDBC.Close();

        System.out.println(CODE);
        System.out.println(CURRENTDATETIME);

    }

    /*
        Deze methode roept de huidige tijd en datum op.
     */
    private static String currentDateTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        return dtf.format(now);
    }

    /*
        Deze methode genereert een alfanumeriek code. De klant kan de gegenereerde code
        invoeren op de website om zijn foto's te benaderen.
     */
    private static String randomAlphaNumeric() {
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
