/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newphotoboothui;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import org.apache.commons.lang3.ArrayUtils;

/**
 *
 * @author Joshua Offermans
 */
public class FXMLShowcaseController implements Initializable{
    @FXML
    AnchorPane rootPane;
    
    @FXML
    ImageView showCase;
    
    @FXML
    ImageView scrollForward;
    
    
    @FXML
    ImageView scrollBack;
    
    public String[] fotos = Settings.getArray();
    Boolean burst;
    int aantalFotos = Settings.getFotnummer();
    int fotonummer = aantalFotos - 1;
    String sessionid = Settings.getSessionId();

    
    public void setPicture(int pictureNumber){  
        File file = new File(fotos[pictureNumber]);
        try {
            String localUrl = file.toURI().toURL().toString();
            Image localImage = new Image(localUrl, true);
            showCase.setImage(localImage);
        } catch (MalformedURLException ex) {
            Logger.getLogger(FXMLShowcaseController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public void verder(){
        viewFades.FadeOut(rootPane, "FXMLCode.fxml");
        
    }
    
    public void nogEenFoto(){
        viewFades.FadeOut(rootPane, "FXMLMode.fxml");
         
}
    
    public void scrollBack(){
        if(fotonummer > 0){
            fotonummer--;
        hidescroll();
        setPicture(fotonummer);
        }
    }
    
    public void scrollForward(){
        if(fotonummer < aantalFotos-1){
            fotonummer++;
            hidescroll();
            setPicture(fotonummer);
        }
    }
    
   public void hidescroll(){
        if ((fotonummer == (aantalFotos - 1)) && (aantalFotos != 1)){
            scrollForward.setVisible(false);
            scrollBack.setVisible(true);
        }
        else if((fotonummer > 0) && (fotonummer < aantalFotos) ) {
            scrollForward.setVisible(true);
            scrollBack.setVisible(true);
        }
        else if ((fotonummer == 0) && (aantalFotos == 1) ){
            scrollBack.setVisible(false);
            scrollForward.setVisible(false);
        }
        else if ((fotonummer == 0)){
            scrollBack.setVisible(false);
            scrollForward.setVisible(true);
        }
        
   }
    
    public void deleteFoto(){
        if(aantalFotos > 0){
            File file = new File(fotos[fotonummer]);
            file.delete();
            fotos = ArrayUtils.remove(fotos,fotonummer);
            aantalFotos--;
            if (fotonummer > 0 ){
                fotonummer--;
            }
            Settings.setFotonummer(aantalFotos);
            Settings.replaceArray(fotos);
            hidescroll();
            setPicture(fotonummer);
        }
    }
    
    
    
    public void addArray(boolean burst){
        String fotonaam;
        int fotoid = (Settings.getFotoid() - 1);
        if(!burst){
                 fotonaam= sessionid+"_"+fotoid+".png";
        }
        else{
                fotonaam = sessionid+"_"+"B"+"_"+fotoid+".gif";
            }
        Settings.setArray(fotonaam, aantalFotos-1);
    }
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) { 
        viewFades.FadeIn(rootPane);
        burst = Settings.getBurst();
        addArray(burst);
        scrollForward.setVisible(false);
        if (fotonummer == 0 ){
            scrollBack.setVisible(false);
        }
        setPicture(fotonummer);
    }
    
}
