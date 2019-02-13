/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author dios
 */
public class Model {
    
    private int posicio;
    
    
    public void calcularPosicio(String frase, String paraula){
        
        if (frase == null || paraula == null){
            posicio = -1;
        }else{
           posicio = frase.indexOf(paraula);  
        }
       
        
    }

    public int getPosicio() {
        return posicio;
    }
    
}
