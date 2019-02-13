/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producte;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 *
 * @author dios
 */
public class Receptor implements PropertyChangeListener {

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("stockActual".equals(evt.getPropertyName())) {
            if ((int) evt.getOldValue() > (int) evt.getNewValue()) {
                System.out.println("El stock actual es mes petit que el stock minim!");
            }
        }

    }
}
