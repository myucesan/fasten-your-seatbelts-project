/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newphotoboothui;

import database_Mail.PotoboothSession;

/**
 *
 * @author Joshua Offermans
 */
public class Settings {
    
    private static int fotonummer = 0;   
    private static String session = PotoboothSession.randomAlphaNumeric();
    
    
    public static void setFotonummer(int fotonummer){     
        Settings.fotonummer = fotonummer;
    }

    
    
    public static int getFotnummer(){     
        return fotonummer;
    }
    
    public static String getSessionId(){     
        return session;
    }
    
}
