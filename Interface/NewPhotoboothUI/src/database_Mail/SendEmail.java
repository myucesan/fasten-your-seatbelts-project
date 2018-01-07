package database_Mail;

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

    public static String mail(String email, String code) throws IOException {

        String urlLink = "http://mustafayucesan.nl/testJava.php?email=" + email + "&code="+code+"";
        URL url = new URL(urlLink);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        StringBuffer sb;
        try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
            sb = new StringBuffer();
            String line;
            while ((line = in.readLine()) != null) {
                sb.append(line);
            }
        }
        System.out.println(sb.toString());
        return "Mail has been send";
    }

    static void mail(String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
