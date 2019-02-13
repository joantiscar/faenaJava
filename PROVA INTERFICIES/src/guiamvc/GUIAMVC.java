/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiamvc;

import controlador.Controlador;
import model.Model;
import vista.Vista;

/**
 *
 * @author dios
 */
public class GUIAMVC {
    public static void main(String[] args) {
        Vista v = new Vista();
        Model m = new Model();
        Controlador c = new Controlador(v, m);
        v.setVisible(true);
    }
}
