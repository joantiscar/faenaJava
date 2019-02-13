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
 * @author dios
 */
public class Controlador {
    
    private Vista v;
    private Model m;

    public Controlador(Vista v, Model m) {
        this.v = v;
        this.m = m;
        controller();
    }
    
    public void controller(){
    
        
        ActionListener al= (ActionEvent e) -> {
            if(e.getSource().equals(v.getBotoCalcular())){
               m.calcularPosicio(v.getFraseTextField().getText().trim(), v.getParaulaTextFied().getText().trim());
               v.getPosicioLabel().setText("Posicio: " +m.getPosicio());
        }
        };
    // Associo l'ActionListener en els components que m'interesse
    v.getBotoCalcular().addActionListener(al);
    }
    
    
    
}
