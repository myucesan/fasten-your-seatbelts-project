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

/**
 *
 * @author Joshua Offermans
 */
public class FXMLModeController implements Initializable{
    @FXML
    AnchorPane rootPane;
    
    public void enkeleButton(){
        viewFades.FadeOut(rootPane, "FXMLFoto.fxml");
        
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) { 
         viewFades.FadeIn(rootPane);
    }
    
}
