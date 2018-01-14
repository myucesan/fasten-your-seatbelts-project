/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newphotoboothui;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javax.imageio.ImageIO;
import javax.print.attribute.standard.PrinterInfo;
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
    
    private String[] fotos = Settings.getArray();
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
        fotonummer--;
        if (fotonummer == 0){
            scrollBack.setVisible(false);
        }
        if (fotonummer < (aantalFotos - 1)){
            scrollForward.setVisible(true);
        }
        setPicture(fotonummer);
    }
    
    public void scrollForward(){
        fotonummer++;
        if (fotonummer == (aantalFotos - 1)){
            scrollForward.setVisible(false);
        }
        else {
            scrollForward.setVisible(true);
        }
        if(fotonummer> 0 ){
            scrollBack.setVisible(true);
        }
        setPicture(fotonummer);
    }
    
    public void deleteFoto(){
        
        /*
        int j = 0;
        fotos[fotonummer] = "deleted";
        String[] temp = new String[15];
        for(int k = 0; k < aantalFotos; k++){
            temp[k] = fotos[k];
        }
        for(int i = 0; fotos[i] != null; i++){
            if(temp[i] == "deleted"){
                j--;
            }
            else {
                fotos[j] = temp[i];
            }
            j++;
        }*/
        fotos = ArrayUtils.remove(fotos,fotonummer);
        aantalFotos--;
        setPicture(fotonummer);
        
    }
    
    
    
    public void addArray(boolean burst){
        int i = aantalFotos-1;
        String fotonaam;
        if(!burst){
                 fotonaam= sessionid+"_"+i+".png";
        }
        else{
                fotonaam = sessionid+"_"+"B"+"_"+i+".gif";
            }
        Settings.setArray(fotonaam, i);
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
