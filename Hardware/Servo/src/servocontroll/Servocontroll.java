/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servocontroll;
import com.pi4j.component.servo.ServoDriver;
import com.pi4j.component.servo.ServoProvider;
import com.pi4j.component.servo.impl.RPIServoBlasterProvider;
import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.GpioPinPwmOutput;
import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import com.pi4j.wiringpi.Gpio;

 
/**
 *
 * @author Joshua
 */
public class Servocontroll {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        servoturn();
        
        
    }
    

    
    
    public static int getbuttoninput(){
              // aanmaken gpio controller
        int turn = 0;
        final GpioController gpio = GpioFactory.getInstance();
        gpio.shutdown();
        
        //aanmaken buttons
        final GpioPinDigitalInput Button1 = gpio.provisionDigitalInputPin(RaspiPin.GPIO_04,"pin1", PinPullResistance.PULL_DOWN);
        final GpioPinDigitalInput Button2 = gpio.provisionDigitalInputPin(RaspiPin.GPIO_05,"pin2" ,PinPullResistance.PULL_DOWN);
         gpio.unprovisionPin(Button1);
         gpio.unprovisionPin(Button2);
        //check state
        boolean button1state = Button1.isHigh();
        boolean button2state = Button2.isHigh();
        
        if (button1state){
            turn = 1;
        }
        else if (button2state){
            turn = 2;
        }
        else {
            turn = 0;
        }
        
        return turn;
    }
    
    public static void servoturn() throws Exception{
        int pos = 50;
        int turn = getbuttoninput();
        final GpioController gpio = GpioFactory.getInstance();
        
        ServoProvider servoProvider = new RPIServoBlasterProvider();
        ServoDriver servo7 = servoProvider.getServoDriver(servoProvider.getDefinedServoPins().get(2));
        while (true){
            turn = getbuttoninput();
            if (turn == 1){
               for (int i = 20; i > 0; i--) {
                   System.out.println("Button1");
                pos++;
                servo7.setServoPulseWidth(pos); // Set raw value for this servo driver - 50 to 195
                Thread.sleep(10);
            }
            }
            else if (turn == 2){
                System.out.println("Button2");
                for (int k = 20; k > 0; k-- ) {
                    pos--;
                    servo7.setServoPulseWidth(pos); // Set raw value for this servo driver - 50 to 195
                    Thread.sleep(10);
                }
            }
            else{
            System.out.println("iets");
            }
            Gpio.delay(500);
        } 
              }
    }
    
