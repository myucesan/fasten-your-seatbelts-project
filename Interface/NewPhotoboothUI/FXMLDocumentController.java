/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newphotoboothui;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamResolution;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.concurrent.Task;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.github.sarxos.webcam.Webcam;
import javafx.scene.transform.Rotate;



/**
 *
 * @author Koen
 */
public class FXMLDocumentController implements Initializable {
    
    FXMLLoader loader = new FXMLLoader();
    
     @FXML
    ImageView imgWebCamCapturedImage;
    private Webcam selWebCam = null;
    private ObjectProperty<Image> imageProperty = new SimpleObjectProperty<Image>();
    private boolean cameraAan = true;
    private BufferedImage grabbedImage;
    
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
    Button startButton;
    
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

    public FXMLDocumentController() {
        
    }
    
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
    
     protected void initializeWebCam() {

		Task<Void> webCamIntilizer = new Task<Void>() {

			@Override
			protected Void call() throws Exception {

				if (selWebCam == null) {
					selWebCam = Webcam.getDefault();
					selWebCam.open();
				} else {
					closeCamera();
					selWebCam = Webcam.getDefault();
					selWebCam.open();
				}
				startWebCamStream();
				return null;
			}

		};
                imgWebCamCapturedImage.setTranslateZ(imgWebCamCapturedImage.getBoundsInLocal().getWidth() / 2.0);
                imgWebCamCapturedImage.setRotationAxis(Rotate.Y_AXIS);
                imgWebCamCapturedImage.setRotate(180);
		new Thread(webCamIntilizer).start();
	}
     
     
     protected void setImageViewSize() {

		double height = 640;
		double width = 480;
		imgWebCamCapturedImage.setFitHeight(height);
		imgWebCamCapturedImage.setFitWidth(width);
		imgWebCamCapturedImage.prefHeight(height);
		imgWebCamCapturedImage.prefWidth(width);
		imgWebCamCapturedImage.setPreserveRatio(true);

}

	protected void startWebCamStream() {


		Task<Void> task = new Task<Void>() {

			@Override
			protected Void call() throws Exception {

				while (cameraAan) {
					try {
						if ((grabbedImage = selWebCam.getImage()) != null) {

							Platform.runLater(new Runnable() {

								@Override
								public void run() {
									final Image mainiamge = SwingFXUtils
                                                                                .toFXImage(grabbedImage, null);
									imageProperty.set(mainiamge);
								}
							});

							grabbedImage.flush();

						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

				return null;
			}

		};
		Thread th = new Thread(task);
		th.setDaemon(true);
		th.start();
		imgWebCamCapturedImage.imageProperty().bind(imageProperty);

	}

	private void closeCamera() {
		if (selWebCam != null) {
			selWebCam.close();
		}
	}
   public void startButton() throws IOException{
       initializeWebCam();
       startButton.setVisible(false);
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
       // initializeWebCam();
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
