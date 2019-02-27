/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author dios
 */
public class ReceptorBetador implements VetoableChangeListener {

    @Override
    public void vetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
        if (Model.PROP_DATABASE.equals(evt.getPropertyName())) {
            String pattern = "jdbc:mysql:\\/\\/[\\S]+[:][\\d]+[/]";
            Pattern r = Pattern.compile(pattern);
            System.out.println(evt.getNewValue().toString());
            Matcher m = r.matcher(evt.getNewValue().toString());
            if (!m.find()) {
                System.out.println("No s'ha pogut canviar la propietat 'DATABASE'. Potser el valor es invalid");
                throw new PropertyVetoException("error", evt);
            }

        }
        if (Model.PROP_DBUSER.equals(evt.getPropertyName())) {
            String pattern =  "\\s";
            Pattern r = Pattern.compile(pattern);
            Matcher m = r.matcher(evt.getNewValue().toString());
            if (m.find()) {
                System.out.println("No s'ha pogut canviar la propietat 'DBUSER'. Potser el valor es invalid");
                throw new PropertyVetoException("error", evt);
            }


        }
        if (Model.PROP_DBPASSWORD.equals(evt.getPropertyName())) {
            String pattern = "\\s";
            Pattern r = Pattern.compile(pattern);
            Matcher m = r.matcher(evt.getNewValue().toString());
            if (m.find()) {
                System.out.println("No s'ha pogut canviar la propietat 'DBPASSWORD'. No cumpleix amb els standards de seguretat");
            throw new PropertyVetoException("error", evt);
            
            }

        }
    }

}
