/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mowitnow;

/**
 *
 * @author igor
 */
public class AccionesMowitnow {
    
    
    public void muestraDatos(CortaCesped cortaCesped)
    {
        System.out.println("Pos y orientacion: "+cortaCesped.getPos_x()+" "+ cortaCesped.getPos_y() +" "+ cortaCesped.getOrientation());
    }
    
    public void ejecutaOrdenes(CortaCesped cortacesped, Cesped cesped){
        
        char[] ordenes = cortacesped.getOrdenes().toUpperCase().toCharArray();
        
        for(char temp: ordenes){
            switch (temp){
                case('A'):
                    if(cortacesped.getOrientation() == 'E'
                            && cortacesped.getPos_x()+1 <= cesped.getWidth())
                        cortacesped.move();
                    else if(cortacesped.getOrientation() == 'W'
                            && cortacesped.getPos_x()-1 >= 0)
                        cortacesped.move();
                    else if(cortacesped.getOrientation() == 'N'
                            && cortacesped.getPos_y()+1 <= cesped.getHigh())
                        cortacesped.move();
                    else if(cortacesped.getOrientation() == 'S'
                            && cortacesped.getPos_y()-1 >= 0)
                        cortacesped.move();
                    break;
                                      
                case('R'):
                    cortacesped.rotateRight();
                    break;
                    
                case('L'):
                    cortacesped.rotateLeft();
                    break;

                default:
                    break;
            }
           
        }
        
    }
    
}
