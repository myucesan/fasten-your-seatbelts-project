/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package photoboothui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 *
 * @author Koen
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    public static void beginButton(ActionEvent event) {
        
        
        
        
    }
    
    public static void enkelefotoButton(ActionEvent event) {
        System.out.println("Maak enkele foto");
    }
    
    public void burstfotoButton(ActionEvent event) {
        System.out.println("Maak een burst foto");
    }
    
    public void fotoButton(ActionEvent event) {
        System.out.println("Foto gemaakt!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
