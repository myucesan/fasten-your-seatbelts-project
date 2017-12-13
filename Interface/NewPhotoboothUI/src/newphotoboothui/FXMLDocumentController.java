/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newphotoboothui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Koen
 */
public class FXMLDocumentController implements Initializable {
    
    FXMLLoader loader = new FXMLLoader();
    
    @FXML
    Button beginButton;
    
    @FXML
    Button enkeleButton;
    
    @FXML
    Button burstButton;
    
    @FXML
    Button fotoButton;
    
    @FXML
    Button deleteButton;
    
    @FXML
    Button opnieuwButton;
    
    @FXML
    Button verderButton;
    
    @FXML
    Button submitButton;
    
    @FXML
    Button klaarButton;
    
    @FXML
    AnchorPane rootPane;
    
    static Stage stage;
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        if (event.getSource()==beginButton) {
            System.out.println("You clicked me!");
            beginButton(event);
        }
        else if(event.getSource()==enkeleButton) {
            System.out.println("You clicked me!");
            enkeleButton(event);
        }
        
        else if(event.getSource()==burstButton) {
            enkeleButton(event);
        }
        
        else if(event.getSource()==fotoButton) {
            fotoButton(event);
        }
        
        else if(event.getSource()==verderButton)
            verderButton(event);
    }
    
   public void beginButton(ActionEvent event) throws IOException{
        Parent modeParent = FXMLLoader.load(getClass().getResource("FXMLMode.fxml"));
        Scene modeScene = new Scene(modeParent);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(modeScene);
        appStage.show();
    }
   
   public void enkeleButton(ActionEvent event) throws IOException{
        Parent fotoParent = FXMLLoader.load(getClass().getResource("FXMLFoto.fxml"));
        Scene fotoScene = new Scene(fotoParent);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(fotoScene);
        appStage.show();
   }
    
   public void burstButton(ActionEvent event) throws IOException{
        Parent fotoParent = FXMLLoader.load(getClass().getResource("FXMLFoto.fxml"));
        Scene fotoScene = new Scene(fotoParent);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(fotoScene);
        appStage.show();
   }
   
   public void fotoButton(ActionEvent event) throws IOException{
        Parent showParent = FXMLLoader.load(getClass().getResource("FXMLShowcase.fxml"));
        Scene showScene = new Scene(showParent);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(showScene);
        appStage.show();
   }
   
   public void verderButton(ActionEvent event) throws IOException{
       Parent codeParent = FXMLLoader.load(getClass().getResource("FXMLCode.fxml"));
       Scene codeScene = new Scene(codeParent);
       Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
       appStage.setScene(codeScene);
       appStage.show();
   }
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
