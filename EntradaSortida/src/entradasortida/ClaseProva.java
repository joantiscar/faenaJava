/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entradasortida;

import java.io.Serializable;

/**
 *
 * @author profe
 */
public class ClaseProva implements Serializable{
    
    private int campEnter=0;
    private float campReal=0.0F;

    public int getCampEnter() {
        return campEnter;
    }

    public void setCampEnter(int campEnter) {
        this.campEnter = campEnter;
    }

    public float getCampReal() {
        return campReal;
    }

    public void setCampReal(float campReal) {
        this.campReal = campReal;
    }

    @Override
    public String toString() {
        return "ClaseProva{" + "campEnter=" + campEnter + ", campReal=" + campReal + '}';
    }
    
    
}
