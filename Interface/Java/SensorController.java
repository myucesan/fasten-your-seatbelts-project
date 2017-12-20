
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

    W1Master master = new W1Master();
    List<W1Device> w1Devices = master.getDevices(TmpDS18B20DeviceType.FAMILY_CODE);

    public double getTemperature() {
        double temperature = 0;
        for (W1Device device : w1Devices) {
            //returns the temperature as double rounded to one decimal place after the point
            temperature = ((TemperatureSensor) device).getTemperature();
        }

        return temperature;
    }

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

    public boolean isObstacle() {
        final GpioController gpio = GpioFactory.getInstance();
        final GpioPinDigitalOutput pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_05, "ObstacleDetector", PinState.HIGH);
        pin.setShutdownOptions(true, PinState.LOW);
        boolean result = false;
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
