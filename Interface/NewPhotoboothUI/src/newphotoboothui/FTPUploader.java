package newphotoboothui;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

/**
 *
 * @author Alfred Espinosa
 */
public class FTPUploader {

    FTPClient ftp = null;
    private static final String PATH = "";
    private static final String IMAGE_DIR = "/var/www/html/images/";
    private static final String HOST = "185.177.59.153";
    private static final String USER = "fys";
    private static final String PASSWORD = "fys-resort5";

    private FTPUploader(String host, String user, String pwd) throws Exception {
        ftp = new FTPClient();
        ftp.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
        int reply;
        ftp.connect(host);
        reply = ftp.getReplyCode();
        if (!FTPReply.isPositiveCompletion(reply)) {
            ftp.disconnect();
            throw new Exception("Exception in connecting to FTP Server");
        }
        ftp.login(user, pwd);
        ftp.setFileType(FTP.BINARY_FILE_TYPE);
        ftp.enterLocalPassiveMode();
    }

    private void uploadFile(String localFileFullName, String fileName, String hostDir)
            throws Exception {
        try (InputStream input = new FileInputStream(new File(localFileFullName))) {
            this.ftp.storeFile(hostDir + fileName, input);

            this.ftp.sendCommand("SITE chmod 755 " + IMAGE_DIR + fileName + "");

            //delete = true;
        }
    }

    private void disconnect() {
        if (this.ftp.isConnected()) {
            try {
                this.ftp.logout();
                this.ftp.disconnect();
            } catch (IOException f) {
                // do nothing as file is already saved to server
            }
        }
    }

    public static void Upload(String fileName) throws Exception {
        System.out.println("Start");

        FTPUploader ftpUploader = new FTPUploader(HOST, USER, PASSWORD);
        //FTP server path is relative. So if FTP account HOME directory is "/home/pankaj/public_html/" and you need to upload 
        // files to "/home/pankaj/public_html/wp-content/uploads/image2/", you should pass directory parameter as "/wp-content/uploads/image2/"
        System.out.println(fileName);
        ftpUploader.uploadFile(PATH + fileName, fileName, IMAGE_DIR);
        //deleteFile();
        ftpUploader.disconnect();

        System.out.println("Done");
    }

    public static void deleteFile(String fileName) {

        try {

            File file = new File(PATH + fileName);

            if (file.delete()) {
                System.out.println(file.getName() + " is deleted from the pi dir!");
            } else {
                System.out.println("Delete operation is failed.");
            }

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}
