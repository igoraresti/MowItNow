/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mowitnow;

import java.util.List;


/**
 *
 * @author igor
 */
public class Mowitnow {
    
    private Cesped cesped;
    private List<CortaCesped> cortacesped;

    public Mowitnow(Cesped cesped, List<CortaCesped> cortacesped) {
        this.cesped = cesped;
        this.cortacesped =  cortacesped;
    }

    public Cesped getCesped() {
        return cesped;
    }

    public void setCesped(Cesped cesped) {
        this.cesped = cesped;
    }

    public List<CortaCesped> getCortacesped() {
        return cortacesped;
    }

    public void setCortacesped(List<CortaCesped> cortacesped) {
        this.cortacesped = cortacesped;
    }

    
    
}
