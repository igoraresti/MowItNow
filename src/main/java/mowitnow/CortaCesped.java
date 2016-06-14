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
public class CortaCesped {
    private int pos_x;
    private int pos_y;
    private char orientation;
    private String ordenes;
    
    public CortaCesped(int x, int y, char orientation, String ordenes){
        this.pos_x = x;
        this.pos_y = y;
        this.orientation = orientation;
        this.ordenes = ordenes;
    }
    
    public void move()
    {
        switch (this.getOrientation()) {
            case 'N':
                this.setPos_y(this.getPos_y() + 1);
                break;
            case 'S':
                this.setPos_y(this.getPos_y() - 1);
                break;
            case 'W':
                this.setPos_x(this.getPos_x() - 1);
                break;
            case 'E':
                this.setPos_x(this.getPos_x() + 1);
                break;
            default:
                break;
        }
    }
    
    public void rotateLeft(){
        
       if(this.getOrientation()=='N')
           this.setOrientation('W');
       else if(this.getOrientation()=='W')
           this.setOrientation('S');
       else if(this.getOrientation()=='S')
           this.setOrientation('E');
       else if(this.getOrientation()=='E')
           this.setOrientation('N');
        
    }
    
    public void rotateRight(){
        
       if(this.getOrientation()=='N')
           this.setOrientation('E');
       else if(this.getOrientation()=='E')
           this.setOrientation('S');
       else if(this.getOrientation()=='S')
           this.setOrientation('W');
       else if(this.getOrientation()=='W')
           this.setOrientation('N');
        
    }

    public int getPos_x() {
        return pos_x;
    }

    public void setPos_x(int pos_x) {
        this.pos_x = pos_x;
    }

    public int getPos_y() {
        return pos_y;
    }

    public void setPos_y(int pos_y) {
        this.pos_y = pos_y;
    }

    public char getOrientation() {
        return orientation;
    }

    public void setOrientation(char orientation) {
        this.orientation = orientation;
    }

    public String getOrdenes() {
        return ordenes;
    }

    public void setOrdenes(String ordenes) {
        this.ordenes = ordenes;
    }

    @Override
    public String toString() {
        return "CortaCesped " + "pos_x=" + pos_x + ", pos_y=" + pos_y + ", orientation=" + orientation;
    }
    
    
    
    
    
}
