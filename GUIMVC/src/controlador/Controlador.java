/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Model;
import vista.Vista;

/**
 *
 * @author profe
 */
public class Controlador {
    
    private Vista v;
    private Model m;

    public Controlador(Vista v, Model m) {
        this.v = v;
        this.m = m;
        control();
    }
    
    public void control(){
    
        ActionListener al = (ActionEvent e) -> {
        
            //Miro si l'objecte que provoca l'esdeveniment és el botó Calcular
            if(e.getSource().equals(v.getCalcularButton())){
                //Calculo la posició de la paraula dins la frase
                m.calcularPosicio(v.getFraseTextField().getText().trim(), v.getParaulaTextField().getText().trim());
                
                //Modifico la posició mostrada a la vista
                v.getPosicioLabel().setText("Posició: "+m.getPosicio());
            
            }
        };
        
        //Associo l'ActionListener en els components que m'interesse
        v.getCalcularButton().addActionListener(al);
    
    }
    
    
    
}
