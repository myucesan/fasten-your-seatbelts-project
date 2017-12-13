/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package potoboothsession;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author Alfred Espinosa
 */
public class SendEmail {

    public static String mail(String email) throws IOException {

        String urlLink = "http://mustafayucesan.nl/testJava.php?email=" + email + "";
        URL url = new URL(urlLink);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuffer sb = new StringBuffer();
        String line;

        while ((line = in.readLine()) != null) {
            sb.append(line);
        }
        in.close();
        System.out.println(sb.toString());
        return "Mail has been send";
    }
}
