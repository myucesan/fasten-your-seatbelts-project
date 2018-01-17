/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newphotoboothui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;


/*
    Hieronder import packages voor de qr-code generator.
 */
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import database_Mail.EmailSend;
import database_Mail.SendEmail;
import database_Mail.SqlConnection;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Joshua Offermans & Mustafa (QR-Code)
 */
public class FXMLCodeController implements Initializable {
    
    SqlConnection connection = new SqlConnection();

    @FXML
    AnchorPane rootPane;
    
    @FXML
    ImageView qrCode;
    
    @FXML // fx:id="textBox"
    private TextField textBox;
    
    @FXML
    Button submitButton;
    
    public void submit() throws IOException {
        
        
        System.out.println("Submit button clicked " + textBox.getText());

        String email = textBox.getText();

        if (email.contains("@")) {
            EmailSend.Mail(email, Settings.getSessionId());
        } else {
            textBox.setText("Please fill an email address");
        }
        
    }
    
    public void klaarButton() throws IOException {

        try {

            connection.Close();

        } catch (SQLException c) {
            System.out.println(c);
        }

       viewFades.FadeOut(rootPane, "FXMLBegin.fxml");
    }

   
    public void generateQrCode() {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        String myWeb = "http://mustafayucesan.nl/?code=" + Settings.getSessionId();
        int width = 300;
        int height = 300;
        String fileType = "png";

        BufferedImage bufferedImage = null;
        try {
            BitMatrix byteMatrix = qrCodeWriter.encode(myWeb, BarcodeFormat.QR_CODE, width, height);
            bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            bufferedImage.createGraphics();

            Graphics2D graphics = (Graphics2D) bufferedImage.getGraphics();
            graphics.setColor(Color.WHITE);
            graphics.fillRect(0, 0, width, height);
            graphics.setColor(Color.BLACK);

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (byteMatrix.get(i, j)) {
                        graphics.fillRect(i, j, 1, 1);
                    }
                }
            }

            System.out.println("Success...");

        } catch (WriterException ex) {
            Logger.getLogger(FXMLCodeController.class.getName()).log(Level.SEVERE, null, ex);
        }

//        ImageView qrView = new ImageView();
        qrCode.setImage(SwingFXUtils.toFXImage(bufferedImage, null));
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        viewFades.FadeIn(rootPane);
        generateQrCode();
        
    }

}
