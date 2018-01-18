/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newphotoboothui;

import com.github.sarxos.webcam.Webcam;
import database_Mail.PotoboothSession;

/**
 *
 * @author Joshua Offermans
 */
public class Settings {
    
    private static int fotonummer = 0;   
    private static int fotoid = 0;
    private static String session = PotoboothSession.randomAlphaNumeric();
    private static Boolean burst = false;
    private static String[] fotoarray = new String[15];
    private static Thread th;
    private static Webcam sellWebcam = null;
    private static final String CURRENTDATE = PotoboothSession.currentDateTime();
    private static int temp;
    
    
    public static void genNewSession(){
       session = PotoboothSession.randomAlphaNumeric();
    }
    
    public static void setTemp(int temp){
        Settings.temp = temp;
    }
    
    
    public static void setFotonummer(int fotonummer){     
        Settings.fotonummer = fotonummer;
    }
    
    public static void setBurst(Boolean burst){
        Settings.burst = burst;
    }
    
    public static void setArray(String fotonaam,int i){
        Settings.fotoarray[i] = fotonaam;        
    }
    
    public static void setFotoid(int fotoid){
        Settings.fotoid = fotoid;
    }
    
    public static void replaceArray(String[] array) {
        fotoarray = array;
    }
    
    public static int getFotoid(){
        return fotoid;
    }
    
    public static String[] getArray(){
        return fotoarray;
    }
    
    public static Boolean getBurst(){
        return burst;
    }
    
    public static int getFotnummer(){     
        return fotonummer;
    }
    
    public static String getSessionId(){     
        return session;
    }
    
    public static String getCurrentDate(){     
        return CURRENTDATE;
    }

    public static int getTemp(){
        return temp;
    }
    
    
}
