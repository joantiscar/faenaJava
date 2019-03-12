/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProvaHibernate;

import controller.Controller;
import hivernate.view.CancionesStore;
import java.sql.SQLException;
import model.Model;

/**
 *
 * @author becari
 */
public class ProvaHibernate {
    public static void main(String[] args) {
         CancionesStore v = new CancionesStore();
        try {
            Model m = new Model();
            Controller c = new Controller(m, v);
            v.setVisible(true);
        } catch (SQLException ex) {
            System.out.println("Error al llegir les dades.");
            System.exit(0);
        }
    }
}
