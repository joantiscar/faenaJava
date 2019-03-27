/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import view.Vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.TableColumn;
import model.Canciones;
import model.Model;
import utilscontroller.Utils;

/**
 *
 * @author dios
 */
public class Controller {

    private Model m;
    private Vista v;

    public Controller(Model m, Vista v) throws SQLException {
        this.m = m;
        this.v = v;
        control();
    }

    public boolean comprovarData(String data) {
//        return data.matches("(\\d{1,2}\\/){2}(\\d{4})");
        return true;
    }

    public void control() throws SQLException {

        TableColumn tc = Utils.loadTable((ArrayList<Canciones>) m.getData(), v.getResultTable(), Canciones.class, false);

        // Action Listener: farà la majoria d'accions del programa
        ActionListener actionListener = (ActionEvent e) -> {
            if (e.getSource().equals(v.getQueryButton())) {

                if (!v.getNameTextField().getText().trim().equals("")) {
                    v.displayResult(m.runQueryBasedOnNom(v.getNameTextField().getText().trim()));
                } else if (!v.getGenereTextField().getText().trim().equals("")) {
                    v.displayResult(m.runQueryBasedOnGenere(v.getGenereTextField().getText().trim()));
                } else if (!v.getDataTextField().getText().trim().equals("")) {
                    v.displayResult(m.runQueryBasedOnData(v.getDataTextField().getText().trim()));
                } else try {
                    v.displayResult(m.getData());
                } catch (SQLException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (e.getSource().equals(v.getDeleteButton())) {

                    try {
                       
                                
                    m.runDeleteQuery(v.getResultTable().getModel().getValueAt(v.getResultTable().getSelectedRow(), 0).toString());
                
                    v.displayResult(m.getData());
                } catch (SQLException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (e.getSource().equals(v.getInsertButton())) {

                                        System.out.println("astio");
                if (!v.getNameTextField().getText().trim().equals("")) {
                    try {
                        
                    m.runInsertQuery(v.getNameTextField().getText().trim(), v.getGenereTextField().getText().trim(), v.getDataTextField().getText().trim());
                
                    v.displayResult(m.getData());
                } catch (SQLException ex) {
                        System.out.println("astioooo");
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            }
            if (e.getSource().equals(v.getModifyButton())) {

                if (!v.getNameTextField().getText().trim().equals("")) {
                    try {
                        
                    m.runModifyQuery(v.getResultTable().getModel().getValueAt(v.getResultTable().getSelectedRow(), 0).toString(), 
                            v.getNameTextField().getText().trim(), v.getGenereTextField().getText().trim(), v.getDataTextField().getText().trim());
                
                    v.displayResult(m.getData());
                } catch (SQLException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            }
        };

        //Creació de Adapters
        // Window Adapter
        WindowAdapter windowAdapter = new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                System.exit(0);
            }

        };
        //Associem el window adapter a la vista
        v.addWindowListener(windowAdapter);
        v.getQueryButton().addActionListener(actionListener);
        v.getInsertButton().addActionListener(actionListener);
        v.getDeleteButton().addActionListener(actionListener);
        v.getModifyButton().addActionListener(actionListener);

    }

}
