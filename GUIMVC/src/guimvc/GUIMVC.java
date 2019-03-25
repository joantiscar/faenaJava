/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guimvc;

import controlador.Controlador;
import model.Model;
import vista.Vista;

/**
 *
 * @author profe
 */
public class GUIMVC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Vista v=new Vista();
        Model m=new Model();
        Controlador c=new Controlador(v, m);
        v.setVisible(true);
        
        
//        KeyListener k=new KeyListener(){
//            @Override
//            public void keyTyped(KeyEvent e) {
//                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//            }
//
//            @Override
//            public void keyPressed(KeyEvent e) {
//                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//            }
//
//            @Override
//            public void keyReleased(KeyEvent e) {
//                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//            }
//        
//        };
//        
//        KeyAdapter ka=new KeyAdapter(){
//            
//            @Override
//            public void keyTyped(KeyEvent e) {
//                e.getKeyChar();
//            }
//        
//        
//        };
        
        
        
    }
    
}
