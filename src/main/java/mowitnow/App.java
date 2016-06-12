/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mowitnow;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author igor
 */
public class App {
    
    private static final String absolutePath = new File("").getAbsolutePath();
    private static final String path_ficheros_config= "/src/main/resources/ficheros_dato/";
    
    public static void main(String[] args) throws IOException{
        
        AppConfig fichero = new AppConfig(absolutePath+path_ficheros_config+"cesped");
        Mowitnow Cesped_Y_Lista_CortaCesped = fichero.leeFichero();
        AccionesMowitnow actions = new AccionesMowitnow();
        
        for(CortaCesped temp : Cesped_Y_Lista_CortaCesped.getCortacesped()){
            actions.ejecutaOrdenes(temp, Cesped_Y_Lista_CortaCesped.getCesped());
            actions.muestraDatos(temp);
            System.out.println("");
        }
                
    }
    
    
}
