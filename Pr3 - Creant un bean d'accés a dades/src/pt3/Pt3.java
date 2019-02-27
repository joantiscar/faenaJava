/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt3;

import controller.Controller;
import java.beans.PropertyVetoException;
import java.sql.SQLException;
import model.Model;
import model.Receptor;
import model.ReceptorBetador;
import view.View;

/**
 *
 * @author dios
 */
public class Pt3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws PropertyVetoException {

        View v = new View();
        try {
            // TODO code application logic here
            Model m = new Model();
            Receptor receptor = new Receptor();
            ReceptorBetador receptorVetoable = new ReceptorBetador();
            m.addPropertyChangeListener(receptor);
            m.addVetoableChangeListener(receptorVetoable);
            m.prepareDatabase("cançons");
            m.loadData();
            Controller c = new Controller(m, v);
            v.setVisible(true);
        } catch (ClassNotFoundException | SQLException | PropertyVetoException ex) {
            v.showMessage("Error al llegir les dades.");
            System.exit(0);
        }
    }

}
