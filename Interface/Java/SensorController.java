import com.pi4j.component.temperature.TemperatureSensor;
import com.pi4j.component.temperature.impl.TmpDS18B20DeviceType;
import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.w1.W1Device;
import com.pi4j.io.w1.W1Master;
import java.io.IOException;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author my96
 */
public class SensorController {
    // In lijst w1Devices alle temperatuur sensoren ophalen

    W1Master master = new W1Master();
    List<W1Device> w1Devices = master.getDevices(TmpDS18B20DeviceType.FAMILY_CODE);

    public double getTemperature() {
        double temperature = 0;
        // Temperatuur checken voor elke temperatuur sensor; in dit geval één
        for (W1Device device : w1Devices) {
            //in de temperatuur variabele wordt de waarde opgeslagen afgerond op 1 decimaal
            temperature = ((TemperatureSensor) device).getTemperature();
        }
        // temperatuur wordt teruggegeven aan de method call
        return temperature;
    }
/*

Irrelevant voor product

    public String getTempSensorID() {
        String message = "";
        for (W1Device device : w1Devices) {
            try {
                message = ("1-Wire ID: " + device.getId() + " value: " + device.getValue());
                //returns the ID of the Sensor and the  full text of the virtual file
            } catch (IOException e) {
                e.printStackTrace();

            }
        }
        return message;
    }
*/
    public boolean isObstacle() {
        // Pins worden geregistreerd
        final GpioController gpio = GpioFactory.getInstance();
        // Waarde van een specifieke pin wordt gelezen
        final GpioPinDigitalOutput pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_05, "ObstacleDetector", PinState.HIGH);
        pin.setShutdownOptions(true, PinState.LOW);
        boolean result = false;
        
        // wanneer er een obstakel voor de sensor staat wordt result true anders false en die waarde wordt dan teruggegeven aan de method call
        for (int i = 0; i < 100; i++) {
            if (pin.isHigh()) {
                result = true;
            } else {
                result = false;
            }
        }
        return result;
    }
}
