package newphotoboothui;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamResolution;
import com.github.sarxos.webcam.ds.v4l4j.V4l4jDriver;
import com.pi4j.component.servo.ServoDriver;
import com.pi4j.component.servo.ServoProvider;
import com.pi4j.component.servo.impl.RPIServoBlasterProvider;
import com.pi4j.component.temperature.TemperatureSensor;
import com.pi4j.component.temperature.impl.TmpDS18B20DeviceType;
import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.w1.W1Device;
import com.pi4j.io.w1.W1Master;
import com.pi4j.temperature.TemperatureScale;
import com.sun.javafx.tk.Toolkit;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Button;
import gifwriter.GifSequenceWriter;
import java.awt.Graphics2D;
import java.nio.IntBuffer;
import java.util.List;
import javafx.scene.image.PixelFormat;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.text.Text;
import sun.awt.image.IntegerComponentRaster;

/**
 *
 * @author Joshua Offermans
 */
public class FXMLFotoController implements Initializable {
    
    static {
          Webcam.setDriver(new V4l4jDriver());
    }  
    
    @FXML
    AnchorPane rootPane;

    @FXML
    Button fotoButton;
    @FXML
    Text tempText;

    @FXML
    ImageView imgWebCamCapturedImage;
    private Webcam selWebCam = null;
    private ObjectProperty<Image> imageProperty = new SimpleObjectProperty<Image>();
    private boolean cameraAan = true;
    private BufferedImage grabbedImage;
    Thread th;
    int fotonummer = Settings.getFotnummer();
    String session = Settings.getSessionId();

    int cameraposition = 50;
    
  
    public double getTemperature() {
        W1Master master = new W1Master();
        double temperature = 0;
        // Temperatuur checken voor elke temperatuur sensor; in dit geval één
        for (TemperatureSensor device : master.getDevices(TemperatureSensor.class)) {
            //in de temperatuur variabele wordt de waarde opgeslagen afgerond op 1 decimaal
            temperature = device.getTemperature(TemperatureScale.CELSIUS);
        }
        // temperatuur wordt teruggegeven aan de method call
        return temperature;
    }
    
    
    

    
    public void setTemp() {
        double temp = getTemperature();
        Settings.setTemp((int) temp);
        String text = "De tempratuur is: " + temp +"C";
        tempText.setText(text);
        
    }
    
    // code uit javafx.embed.swing.SwingFXUtils;
      public WritableImage toFXImage(BufferedImage bimg, WritableImage wimg) {
        int bw = bimg.getWidth();
        int bh = bimg.getHeight();
        switch (bimg.getType()) {
            case BufferedImage.TYPE_INT_ARGB:
            case BufferedImage.TYPE_INT_ARGB_PRE:
                break;
            default:
                BufferedImage converted =
                    new BufferedImage(bw, bh, BufferedImage.TYPE_INT_ARGB_PRE);
                Graphics2D g2d = converted.createGraphics();
                g2d.drawImage(bimg, 0, 0, null);
                g2d.dispose();
                bimg = converted;
                break;
        }
        // assert(bimg.getType == TYPE_INT_ARGB[_PRE]);
        if (wimg != null) {
            int iw = (int) wimg.getWidth();
            int ih = (int) wimg.getHeight();
            if (iw < bw || ih < bh) {
                wimg = null;
            } else if (bw < iw || bh < ih) {
                int empty[] = new int[iw];
                PixelWriter pw = wimg.getPixelWriter();
                PixelFormat<IntBuffer> pf = PixelFormat.getIntArgbPreInstance();
                if (bw < iw) {
                    pw.setPixels(bw, 0, iw-bw, bh, pf, empty, 0, 0);
                }
                if (bh < ih) {
                    pw.setPixels(0, bh, iw, ih-bh, pf, empty, 0, 0);
                }
            }
        }
        if (wimg == null) {
            wimg = new WritableImage(bw, bh);
        }
        PixelWriter pw = wimg.getPixelWriter();
        IntegerComponentRaster icr = (IntegerComponentRaster) bimg.getRaster();
        int data[] = icr.getDataStorage();
        int offset = icr.getDataOffset(0);
        int scan = icr.getScanlineStride();
        PixelFormat<IntBuffer> pf = (bimg.isAlphaPremultiplied() ?
                                     PixelFormat.getIntArgbPreInstance() :
                                     PixelFormat.getIntArgbInstance());
        pw.setPixels(0, 0, bw, bh, pf, data, offset, scan);
        return wimg;
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
                                   final Image mainiamge = toFXImage(grabbedImage, null);
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
        th = new Thread(task);
        th.setDaemon(true);
        th.start();
        imgWebCamCapturedImage.imageProperty().bind(imageProperty);

    }
    
   

    public void makePicture() {
        int fotoid = Settings.getFotoid();
        try {
            ImageIO.write(grabbedImage, "PNG", new File(session + '_' + fotoid + ".png"));
        } catch (Exception ex) {
            System.err.println("Fout bij het maken van de foto: " + ex);
        }
        fotoid++;
        fotonummer++;
        Settings.setFotoid(fotoid);
        Settings.setFotonummer(fotonummer);
        Settings.setBurst(false);
        cameraAan = false;
        try {
            th.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(FXMLFotoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        closeCamera();
        viewFades.FadeOut(rootPane, "FXMLShowcase.fxml");
    }
    
    
    @FXML
    public void makeBurst() {
        String[] args = new String[20];
        String fotonaam;
        int fotoid = Settings.getFotoid();
        fotonummer = Settings.getFotnummer();
        for(int i = 0 ; i < 20; i++){
            try {
                fotonaam = session + '_' +i+ '_' + fotoid + ".png";
                ImageIO.write(grabbedImage, "PNG", new File(fotonaam));
                args[i] = fotonaam;
            } catch (Exception ex) {
                System.err.println("Fout bij het maken van de foto: " + ex);
            }
        }
        try {
            GifSequenceWriter.main(args,fotoid);
        } catch (Exception ex) {
            Logger.getLogger(FXMLFotoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        fotoid++;
        fotonummer++;
        Settings.setFotoid(fotoid);
        Settings.setFotonummer(fotonummer);
        Settings.setBurst(true);
                cameraAan = false;
        try {
            th.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(FXMLFotoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        closeCamera();
        viewFades.FadeOut(rootPane, "FXMLShowcase.fxml");
    }
    
    
    
    

    private void closeCamera() {
        if (selWebCam != null) {
            selWebCam.close();
        }
    }

    public ServoDriver initServo() throws IOException {

        final GpioController gpio = GpioFactory.getInstance();
        ServoProvider servoProvider = new RPIServoBlasterProvider();
        ServoDriver servo = servoProvider.getServoDriver(servoProvider.getDefinedServoPins().get(6));
        return servo;
    }

    @FXML
    public void cameraTurnRight() {
        try {
            ServoDriver servo = initServo();
            if (cameraposition > 50) {
                for (int i = 20; i > 0; i--) {
                    cameraposition--;
                    servo.setServoPulseWidth(cameraposition); // Set raw value for this servo driver - 50 to 195
                    Thread.sleep(10);
                }
            }
        } catch (Exception ex) {
            System.err.println("Fout bij sleep: " + ex);
        }
    }

    @FXML
    public void cameraTurnLeft() {
        try {
            ServoDriver servo = initServo();
            if (cameraposition< 250){
                for (int i = 20; i > 0; i--) {
                    cameraposition++;
                    servo.setServoPulseWidth(cameraposition); // Set raw value for this servo driver - 50 to 195
                    Thread.sleep(10);
                }
            }
        } catch (Exception ex) {
            System.err.println("Fout bij sleep: " + ex);
        }
    }

  
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fotonummer = Settings.getFotnummer();
        session = Settings.getSessionId();
        fotoButton.setVisible(false);
        setTemp();
        viewFades.FadeIn(rootPane);
        initializeWebCam();
        Image loading = new Image(FXMLFotoController.class.getResourceAsStream("load.gif"));
        imgWebCamCapturedImage.setImage(loading);
    }
}
