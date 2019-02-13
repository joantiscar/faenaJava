/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producte;

import java.beans.PropertyVetoException;

/**
 *
 * @author dios
 */
public class Proves {

    public static void main(String[] args) throws PropertyVetoException {
        Producte producte = new Producte();
        Receptor receptor = new Receptor();
        ReceptorBetador receptorVetoable = new ReceptorBetador();
        producte.addPropertyChangeListener(receptor);
        producte.setStockActual(17);
        producte.setStockActual(-2);
        producte.addVetoableChangeListener(receptorVetoable);
        try {
            producte.setPvp(29F);
            producte.setPvp(-1F);
        } catch (PropertyVetoException e) {
        }
    }

}
