package newphotoboothui;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamResolution;
import com.pi4j.component.servo.ServoDriver;
import com.pi4j.component.servo.ServoProvider;
import com.pi4j.component.servo.impl.RPIServoBlasterProvider;
import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.concurrent.Task;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.transform.Rotate;
import javax.imageio.ImageIO;
import database_Mail.PotoboothSession;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import static newphotoboothui.FXMLDocumentController.stage;


/**
 *
 * @author Joshua Offermans
 */
public class FXMLFotoController implements Initializable{
    @FXML
    AnchorPane rootPane;
    
    @FXML
    Button fotoButton;
    
            
    @FXML
    ImageView imgWebCamCapturedImage;
    private Webcam selWebCam = null;
    private ObjectProperty<Image> imageProperty = new SimpleObjectProperty<Image>();
    private boolean cameraAan = true;
    private BufferedImage grabbedImage;
    
    int fotonummer = Settings.getFotnummer();
    String session = Settings.getSessionId();
    
    int cameraposition = 50;
    
    
    
    public void FotoButton(){
        closeCamera();
        viewFades.FadeOut(rootPane, "FXMLShowcase.fxml");
        
        
    }
    
     protected void initializeWebCam() {

		Task<Void> webCamIntilizer = new Task<Void>() {

			@Override
			protected Void call() throws Exception {

				if (selWebCam == null) {
					selWebCam = Webcam.getDefault();
                                        selWebCam.setViewSize(WebcamResolution.QVGA.getSize());
					selWebCam.open();
				} else {
					closeCamera();
					selWebCam = Webcam.getDefault();
                                        selWebCam.setViewSize(WebcamResolution.QVGA.getSize());
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

	protected void startWebCamStream() {
		Task<Void> task = new Task<Void>() {
			@Override
			protected Void call() throws Exception {
                                fotoButton.setVisible(true);
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
        
        public void makePicutre(){
            try{
                ImageIO.write(grabbedImage, "PNG", new File(session+'_'+fotonummer+".png"));
            }  
            catch(Exception ex){
                System.err.println("Fout bij het maken van de foto: " + ex);
            }
            fotonummer++;
            Settings.setFotonummer(fotonummer);
            closeCamera();
            viewFades.FadeOut(rootPane, "FXMLShowcase.fxml");
        }    
        

	private void closeCamera() {
		if (selWebCam != null) {
			selWebCam.close();
		}
	}
        
        
        public ServoDriver initServo() throws IOException{
            
            final GpioController gpio = GpioFactory.getInstance();
            ServoProvider servoProvider = new RPIServoBlasterProvider();
            ServoDriver servo= servoProvider.getServoDriver(servoProvider.getDefinedServoPins().get(2));
            return servo;
        }
    
        
        public void cameraTurnRight(){ 
            try{
                ServoDriver servo = initServo();
                  for (int i = 20; i > 0; i--) {
                    cameraposition--;
                    servo.setServoPulseWidth(cameraposition); // Set raw value for this servo driver - 50 to 195
                    Thread.sleep(10);
                } 
            }
            catch(Exception ex){
                System.err.println("Fout bij sleep: " + ex);
            }
        }
        
  
        
        public void cameraTurnLeft(){
            try{
                ServoDriver servo = initServo();
                  for (int i = 20; i > 0; i--) {
                    cameraposition++;
                    servo.setServoPulseWidth(cameraposition); // Set raw value for this servo driver - 50 to 195
                    Thread.sleep(10);
                } 
            }
            catch(Exception ex){
                System.err.println("Fout bij sleep: " + ex);
            }
        }
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) { 
        fotoButton.setVisible(false);
        viewFades.FadeIn(rootPane);
        Image loading = new Image(FXMLFotoController.class.getResourceAsStream("a.jpg"));
        imgWebCamCapturedImage.setImage(loading);
        initializeWebCam();
    }


    
    
}
