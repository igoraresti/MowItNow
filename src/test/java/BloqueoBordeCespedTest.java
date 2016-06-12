/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.IOException;
import mowitnow.*;



import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import org.hamcrest.Matcher;
import static org.junit.Assert.assertEquals;


/**
 *
 * @author igor
 */
public class BloqueoBordeCespedTest {
    
    private static String absolutePath = new File("").getAbsolutePath();
    private static String path_ficheros_config= "/src/main/resources/ficheros_dato/";
    
    
    @Test
    public void paredNorte() throws IOException{
        
        AppConfig fichero = new AppConfig(absolutePath+path_ficheros_config+"cesped_top_border");
        Mowitnow Cesped_Y_Lista_CortaCesped = fichero.leeFichero();
        AccionesMowitnow actions = new AccionesMowitnow();
        
        boolean test=false;
        
        for(CortaCesped temp : Cesped_Y_Lista_CortaCesped.getCortacesped()){
            actions.ejecutaOrdenes(temp, Cesped_Y_Lista_CortaCesped.getCesped());
            test = temp.getOrientation() == 'N' && temp.getPos_x()==1 && temp.getPos_y()==5;
        }
        assertEquals(true, test);
    }
    
    @Test
    public void paredSur() throws IOException{
        
        AppConfig fichero = new AppConfig(absolutePath+path_ficheros_config+"cesped_botton_border");
        Mowitnow Cesped_Y_Lista_CortaCesped = fichero.leeFichero();
        AccionesMowitnow actions = new AccionesMowitnow();
        boolean test=false;
        
        for(CortaCesped temp : Cesped_Y_Lista_CortaCesped.getCortacesped()){
            actions.ejecutaOrdenes(temp, Cesped_Y_Lista_CortaCesped.getCesped());
            test = temp.getOrientation() == 'S' && temp.getPos_x()==1 && temp.getPos_y()==0;
        }
        assertEquals(true, test);
    }
    
    @Test
    public void paredEste() throws IOException{
        
        AppConfig fichero = new AppConfig(absolutePath+path_ficheros_config+"cesped_left_border");
        Mowitnow Cesped_Y_Lista_CortaCesped = fichero.leeFichero();
        AccionesMowitnow actions = new AccionesMowitnow();
        boolean test=false;
        
        for(CortaCesped temp : Cesped_Y_Lista_CortaCesped.getCortacesped()){
            actions.ejecutaOrdenes(temp, Cesped_Y_Lista_CortaCesped.getCesped());
            test = temp.getOrientation() == 'W' && temp.getPos_x()==0 && temp.getPos_y()==2;
        }
        assertEquals(true, test);
    }
    
    @Test
    public void paredOeste() throws IOException{
        
        AppConfig fichero = new AppConfig(absolutePath+path_ficheros_config+"cesped_right_border");
        Mowitnow Cesped_Y_Lista_CortaCesped = fichero.leeFichero();
        AccionesMowitnow actions = new AccionesMowitnow();
        boolean test=false;
        
        for(CortaCesped temp : Cesped_Y_Lista_CortaCesped.getCortacesped()){
            actions.ejecutaOrdenes(temp, Cesped_Y_Lista_CortaCesped.getCesped());
            test = temp.getOrientation() == 'E' && temp.getPos_x()==5 && temp.getPos_y()==2;
        }
        assertEquals(true, test);
    }

    

    
}
