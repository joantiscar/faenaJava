/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt1;

import controller.Controller;
import java.sql.SQLException;
import model.Model;
import view.View;

/**
 *
 * @author dios
 */
public class Pt1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        View v=new View();
        try {
            // TODO code application logic here
            Model m=new Model("cançons");
            Controller c=new Controller(m,v);
            v.setVisible(true);
        } catch (ClassNotFoundException | SQLException ex) {
            v.showMessage("Error al llegir les dades.");
            System.exit(0);
        } 
    }
    
}
