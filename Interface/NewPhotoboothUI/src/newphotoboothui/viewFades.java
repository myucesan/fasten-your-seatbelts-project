/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newphotoboothui;

import java.io.IOException;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Joshua Offermans
 */
public class viewFades {

    
    
    
    public static void FadeIn(AnchorPane rootPane){
       rootPane.setOpacity(0);
       FadeTransition fadeTransition = new FadeTransition();
       fadeTransition.setDuration(Duration.millis(1000));
       fadeTransition.setNode(rootPane);
       fadeTransition.setFromValue(0);
       fadeTransition.setToValue(1);
       fadeTransition.play();
    }
    
    
    public static void FadeOut(AnchorPane rootPane,String FXMLFile) {
       FadeTransition fadeTransition = new FadeTransition();
       fadeTransition.setDuration(Duration.millis(500));
       fadeTransition.setNode(rootPane);
       fadeTransition.setFromValue(1);
       fadeTransition.setToValue(0);
       
       fadeTransition.setOnFinished(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
               loadMode load = new loadMode();
              load.loadMode(event,rootPane, FXMLFile);
           }
       });
       fadeTransition.play();
   }
    
    
   
    
    

    private static class loadMode {
        
        
        
        
        
        public void loadMode(ActionEvent event, AnchorPane rootPane, String FXMLFile) {
           try {
           Parent modeView = FXMLLoader.load(getClass().getResource(FXMLFile));
           Scene modeScene = new Scene(modeView);
           Stage appStage = (Stage) rootPane.getScene().getWindow();
           appStage.setScene(modeScene);
           } 
           catch (IOException ex) {
               System.err.println("Fout in laden scene:" + ex);
           }
        }
       
        
        

    }
    
    
}
