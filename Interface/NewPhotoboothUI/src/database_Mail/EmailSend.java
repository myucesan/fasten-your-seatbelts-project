package database_Mail;

/**
 *
 * @author Alfred Espinosa
 */
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage;

public class EmailSend {

    private static final String HOST = "smtp.gmail.com";
    private static final String USER = "alfredez008@gmail.com";
    private static final String PASS = "";
    private static final String FROM = "john@doe.com";
    private static final String SUBJECT = "Corendon Resort - Dreambox";
    private static final boolean SESSION_DEBUG = false;
    
    public static void Mail(String email, String code) {
        try {
            String to = email;
            String messageText = "Thank you for using the Dreambox!\n Visit our website to "
                    + "see the pictures at www.mustafayucesan.nl?code="+code + "\n\n With"
                    + "Kind of Regards,\n Corendon";
            

            Properties props = System.getProperties();

            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", HOST);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.required", "true");

            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            Session mailSession = Session.getDefaultInstance(props, null);
            mailSession.setDebug(SESSION_DEBUG);
            Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(FROM));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(SUBJECT);
            msg.setSentDate(new Date());
            msg.setText(messageText);

            Transport transport = mailSession.getTransport("smtp");
            transport.connect(HOST, USER, PASS);
            transport.sendMessage(msg, msg.getAllRecipients());
            transport.close();
            System.out.println("message send successfully");
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }
}
