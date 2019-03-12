/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import hibernate.entity.Canciones;
import hivernate.view.CancionesStore;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.TableColumn;
import model.Model;
import utilscontroller.Utils;

/**
 *
 * @author dios
 */
public class Controller {

    private Model m;
    private CancionesStore v;

    public Controller(Model m, CancionesStore v) throws SQLException {
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

    }

}
