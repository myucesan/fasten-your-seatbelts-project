/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newphotoboothui;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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

/**
 *
 * @author Joshua Offermans
 */
public class FXMLShowcaseController implements Initializable{
    @FXML
    AnchorPane rootPane;
    
    @FXML
    ImageView showCase;
    
    private String[] fotos = new String[20];
    int aantalFotos = Settings.getFotnummer();
    int fotonummer = aantalFotos - 1;
    String sessionid = Settings.getSessionId();

    
    public void setPicture(int pictureNumber){  
        BufferedImage bufferedImage;
        try {
            bufferedImage =  ImageIO.read(new File(fotos[pictureNumber]));
            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
            this.showCase.setImage(image);
        } catch (IOException ex) {
            Logger.getLogger(FXMLShowcaseController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void verder(){
        viewFades.FadeOut(rootPane, "FXMLCode.fxml");
        
    }
    
    
    
    
    public void nogEenFoto(){
        viewFades.FadeOut(rootPane, "FXMLFoto.fxml");
         
}
    
    public void scrollBack(){
        if(fotos[fotonummer] == null){
            while(fotos[fotonummer] == null){
                fotonummer--;
            }
        }
        else{
            fotonummer--;
        }
                System.out.println("Foto: " + fotonummer);
                System.out.println(fotos[fotonummer]);
        setPicture(fotonummer);
        
    }
    
    public void scrollForward(){
        if(fotos[fotonummer] == null){
            while(fotos[fotonummer] == null){
                fotonummer++;
            }
        }
        else{
            fotonummer++;
        }
        System.out.println("Foto: " + fotonummer);
        System.out.println(fotos[fotonummer]);
        setPicture(fotonummer);
        
    }
    
    public void deleteFoto(){
        fotos[fotonummer] = null;
        scrollBack();
        
    }
    
    
    
    public void setArray(){
        for(int i = 0;i < aantalFotos ; i++ ){
            fotos[i] = sessionid+"_"+i+".png";
        }
    }
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) { 
        System.out.println(aantalFotos);
        viewFades.FadeIn(rootPane);
         setArray();
         setPicture(fotonummer);
    }
    
}
