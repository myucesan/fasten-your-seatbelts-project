/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newphotoboothui;

import com.github.sarxos.webcam.Webcam;
import database_Mail.SqlConnection;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Joshua Offermans
 */
public class FXMLBeginController  implements Initializable{
    
    @FXML
    AnchorPane rootPane;
    
    @FXML
    ImageView imgWebCamCapturedImage;
    private Webcam selWebCam = null;
    private ObjectProperty<Image> imageProperty = new SimpleObjectProperty<Image>();
    private boolean cameraAan = true;
    private BufferedImage grabbedImage;
    SqlConnection connection = new SqlConnection();
        
    
    public void beginButton() throws SQLException {
        
        viewFades.FadeOut(rootPane, "FXMLMode.fxml");
        try {
            connection.Open();
            connection.Remove();
        } catch (ClassNotFoundException | SQLException c) {
            System.out.println(c);
        }
    }
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
    
}
