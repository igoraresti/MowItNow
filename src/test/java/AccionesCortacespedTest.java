/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.IOException;
import mowitnow.AccionesMowitnow;
import mowitnow.AppConfig;
import mowitnow.CortaCesped;
import mowitnow.Mowitnow;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author igor
 */
public class AccionesCortacespedTest {
    
    private static final String absolutePath = new File("").getAbsolutePath();
    private static final String path_ficheros_config= "/src/main/resources/ficheros_dato/";
    
    @Test
    public void accionesCortacesped() throws IOException {
        
        AppConfig fichero = new AppConfig(absolutePath+path_ficheros_config+"cesped");
        Mowitnow Cesped_Y_Lista_CortaCesped = fichero.leeFichero();
        AccionesMowitnow actions = new AccionesMowitnow();
        
        //Bloque acciones
        for(CortaCesped temp : Cesped_Y_Lista_CortaCesped.getCortacesped()){
            actions.ejecutaOrdenes(temp, Cesped_Y_Lista_CortaCesped.getCesped());
        }
        //Bloque examinar acciones
        boolean test = (Cesped_Y_Lista_CortaCesped.getCortacesped().get(0).getPos_x() == 1 &&
                Cesped_Y_Lista_CortaCesped.getCortacesped().get(0).getPos_y() == 2 &&
                Cesped_Y_Lista_CortaCesped.getCortacesped().get(0).getOrientation() == 'N');
        assertThat(test);

    }
}