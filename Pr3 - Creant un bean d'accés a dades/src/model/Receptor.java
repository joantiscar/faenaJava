/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 *
 * @author dios
 */
public class Receptor implements PropertyChangeListener {

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (Model.PROP_DATABASE.equals(evt.getPropertyName())) {
                System.out.println("La base de dades es diu " + evt.getNewValue().toString());
            
        }
        if (Model.PROP_DBUSER.equals(evt.getPropertyName())) {
                System.out.println("L'usuari de la connexió és: " + evt.getNewValue().toString());
            
        }
        if (Model.PROP_DBPASSWORD.equals(evt.getPropertyName())) {
                System.out.println("La contrassenya es correcta");
            
        }

    }
}
