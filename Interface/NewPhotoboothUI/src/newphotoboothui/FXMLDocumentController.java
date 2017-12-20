/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newphotoboothui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

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
            //beginFadeOut();
            //.setStyle
            beginButton(event);
        }
        else if(event.getSource()==enkeleButton) {
            //enkeleFadeOut();
            enkeleButton(event);
        }
        
        else if(event.getSource()==burstButton) {
            //burstFadeOut();
            burstButton(event);
        }
        
        else if(event.getSource()==fotoButton) {
            //fotoFadeOut();
            fotoButton(event);
        }
        
        else if(event.getSource()==opnieuwButton) {
            //opnieuwFadeOut();
            opnieuwButton(event);
        }
        
        else if(event.getSource()==verderButton) {
            //verderFadeOut();
            verderButton(event);
        }
        
        else if(event.getSource()==klaarButton) {
            //klaarFadeOut();
            klaarButton(event);
        }
            
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
   
   public void opnieuwButton(ActionEvent event) throws IOException {
       Parent modeParent = FXMLLoader.load(getClass().getResource("FXMLMode.fxml"));
       Scene modeScene = new Scene(modeParent);
       Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
       appStage.setScene(modeScene);
       appStage.show();
   }
   
   public void verderButton(ActionEvent event) throws IOException{
       Parent codeParent = FXMLLoader.load(getClass().getResource("FXMLCode.fxml"));
       Scene codeScene = new Scene(codeParent);
       Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
       appStage.setScene(codeScene);
       appStage.show();
   }
   
   public void klaarButton(ActionEvent event) throws IOException{
       Parent beginParent = FXMLLoader.load(getClass().getResource("FXMLBegin.fxml"));
       Scene beginScene = new Scene(beginParent);
       Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
       appStage.setScene(beginScene);
       appStage.show();
   }
   
   /*public void beginFadeOut() {
       FadeTransition fadeTransition = new FadeTransition();
       fadeTransition.setDuration(Duration.millis(500));
       fadeTransition.setNode(rootPane);
       fadeTransition.setFromValue(1);
       fadeTransition.setToValue(0);
       
       fadeTransition.setOnFinished(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
               try {
                   beginButton(event);
               } catch (IOException ex) {
                   Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
       });
       fadeTransition.play();
   }
   
   public void enkeleFadeOut() {
       FadeTransition fadeTransition = new FadeTransition();
       fadeTransition.setDuration(Duration.millis(500));
       fadeTransition.setNode(rootPane);
       fadeTransition.setFromValue(1);
       fadeTransition.setToValue(0);
       
       fadeTransition.setOnFinished(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
               try {
                   enkeleButton(event);
               } catch (IOException ex) {
                   Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
       });
       fadeTransition.play();
   }
   
   public void burstFadeOut() {
       FadeTransition fadeTransition = new FadeTransition();
       fadeTransition.setDuration(Duration.millis(500));
       fadeTransition.setNode(rootPane);
       fadeTransition.setFromValue(1);
       fadeTransition.setToValue(0);
       
       fadeTransition.setOnFinished(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
               try {
                   burstButton(event);
               } catch (IOException ex) {
                   Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
       });
       fadeTransition.play();
   }
   
   public void fotoFadeOut() {
       FadeTransition fadeTransition = new FadeTransition();
       fadeTransition.setDuration(Duration.millis(500));
       fadeTransition.setNode(rootPane);
       fadeTransition.setFromValue(1);
       fadeTransition.setToValue(0);
       
       fadeTransition.setOnFinished(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
               try {
                   fotoButton(event);
               } catch (IOException ex) {
                   Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
       });
       fadeTransition.play();
   }
   
   public void opnieuwFadeOut() {
       FadeTransition fadeTransition = new FadeTransition();
       fadeTransition.setDuration(Duration.millis(500));
       fadeTransition.setNode(rootPane);
       fadeTransition.setFromValue(1);
       fadeTransition.setToValue(0);
       
       fadeTransition.setOnFinished(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
               try {
                   opnieuwButton(event);
               } catch (IOException ex) {
                   Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
       });
       fadeTransition.play();
   }
   
   public void verderFadeOut() {
       FadeTransition fadeTransition = new FadeTransition();
       fadeTransition.setDuration(Duration.millis(500));
       fadeTransition.setNode(rootPane);
       fadeTransition.setFromValue(1);
       fadeTransition.setToValue(0);
       
       fadeTransition.setOnFinished(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
               try {
                   verderButton(event);
               } catch (IOException ex) {
                   Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
       });
       fadeTransition.play();
   }
   
   public void klaarFadeOut() {
       FadeTransition fadeTransition = new FadeTransition();
       fadeTransition.setDuration(Duration.millis(500));
       fadeTransition.setNode(rootPane);
       fadeTransition.setFromValue(1);
       fadeTransition.setToValue(0);
       
       fadeTransition.setOnFinished(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
               try {
                   klaarButton(event);
               } catch (IOException ex) {
                   Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
       });
       fadeTransition.play();
   }
   
   public void buttonPress() {
       -fx-background-color:
   }*/
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
