/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mowitnow;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.File;

/**
 *
 * @author igor
 */
public class AppConfig {
    
    private String _path;

    public AppConfig(String path) {
        this._path = path;
    }
    
    
    public Mowitnow leeFichero() throws IOException
    {
        Mowitnow Cesped_Y_Lista_CortaCesped = null;
        Cesped cesped;
        List<CortaCesped> lista_cortacesped = new ArrayList<>();
        CortaCesped cortacesped;
        String line;
        String[] datos;
        
        try (BufferedReader fichero = new BufferedReader(new FileReader(_path))) {
            // Primera linea es el cesped, común para todos los cortacesped
            line = fichero.readLine();
            datos = line.split(" ");
            cesped = new Cesped(Integer.parseInt(datos[0]), Integer.parseInt(datos[1]));
            while ((line = fichero.readLine()) != null) {
                // Se lee posicion y orentacion cortacesped
                datos = line.split(" ");
                // Se lee las ordenes
                line = fichero.readLine();
                // Se crea el objeto cesped
                cortacesped = new CortaCesped(Integer.parseInt(datos[0]), Integer.parseInt(datos[1]), datos[2].charAt(0),line);
                // Secrea añade el cesped a la lista
                lista_cortacesped.add(cortacesped);
                
            }
            Cesped_Y_Lista_CortaCesped= new Mowitnow(cesped,lista_cortacesped);
            
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        
        return Cesped_Y_Lista_CortaCesped;
    }
  
    
    
    
    
}
