/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp6.uf2.pt2_joantiscar;

import java.sql.SQLException;

/**
 *
 * @author dios
 */
public class MP6UF2Pt2_JoanTiscar {

    /**
     * @param args the command line arguments
     */
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
