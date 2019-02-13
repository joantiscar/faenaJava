/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producte;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;

/**
 *
 * @author dios
 */
public class ReceptorBetador implements VetoableChangeListener {

    @Override
    public void vetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
        if ((float) evt.getNewValue() < 0) {
            System.out.println("No s'ha pogut canviar la propietat " + evt.getPropertyName());
            System.out.println("Motiu: nou valor " + evt.getNewValue() + " es mes petit que 0");
            throw new PropertyVetoException("error", evt);
        }
    }

}
