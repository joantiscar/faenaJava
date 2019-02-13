/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.table.TableColumn;
import model.Cancion;
import model.Cancion.Genere;
import model.Model;
import utilscontroller.Utils;
import view.View;

/**
 *
 * @author dios
 */
public class Controller {

    private Model m;
    private View v;

    public Controller(Model m, View v) {
        this.m = m;
        this.v = v;
        control();
        v.getListButton().doClick();
    }

    public boolean comprovarData(String data) {
        return data.matches("(\\d{1,2}\\/){2}(\\d{4})");
    }

    public void control() {
        // Creacio de metode para comprovar la exprsio regular

        // Definició de la Taula
        TableColumn tc = Utils.loadTable((ArrayList<Cancion>) m.getData(), v.getCancionTable(), Cancion.class, false);

        // Creació de Listeners
        // Focus Listener (s'utilitzarà para avisar a l'usuari de que la data no esta en el format correcte)
        FocusListener focusListener = new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                // No ens interesa fer res cuan es faigue focus, aixi que aquest metode pot estar buit                
                
            }

            public void focusLost(FocusEvent e) {

                if (!comprovarData(v.getAnyCancion().getText().trim())) {
                    v.showMessage("Error! La data ha de estar en format dd/mm/yy");
                    v.getAnyCancion().setText("");

                }

            }
        };

        // Action Listener: farà la majoria d'accions del programa
        ActionListener actionListener = (ActionEvent e) -> {

            if (e.getSource().equals(v.getCrudButton())) {
                v.getNomCancion().setText("");
                Utils.loadCombo(Genere.values(), v.getGenereCombo());
                v.getAnyCancion().setText("");
                Utils.loadTable((ArrayList<Cancion>) m.getData(), v.getCancionTable(), Cancion.class, false);
                v.getjPanel3().removeAll();
                v.getjPanel3().repaint();
                v.getjPanel3().revalidate();
                v.getjPanel3().add(v.getjPanel5());
                v.getjPanel3().revalidate();

            }
            if (e.getSource().equals(v.getListButton())) {
                Utils.loadTable((ArrayList<Cancion>) m.getData(), v.getCancionTableLlistat(), Cancion.class, false);
                v.getjPanel3().removeAll();
                v.getjPanel3().repaint();
                v.getjPanel3().revalidate();
                v.getjPanel3().add(v.getjPanel4());
                v.getjPanel3().revalidate();

            }
            if (e.getSource().equals(v.getExitButton())) {
                try {

                    m.saveData();
                } catch (IOException ex) {
                    v.showMessage("Error al guardar les dades.");
                }
                System.exit(0);

            }
            if (e.getSource().equals(v.getAddButton())) {
                if (comprovarData(v.getAnyCancion().getText().trim())) {
                    m.addData(v.getNomCancion().getText().trim(), v.getGenereCombo().getSelectedItem(), v.getAnyCancion().getText().trim());
                    Utils.loadTable((ArrayList<Cancion>) m.getData(), v.getCancionTable(), Cancion.class, false);
                    v.cleanFields();
                } else {
                    v.showMessage("Error! La data ha de estar en format dd/mm/yy");
                    v.getAnyCancion().setText("");
                }

            }
            if (e.getSource().equals(v.getModifyButton())) {
                if (comprovarData(v.getAnyCancion().getText().trim())) {
                    int filasel = v.getCancionTable().getSelectedRow();
                    if (filasel != -1) {
                        v.getCancionTable().getColumnModel().addColumn(tc);
                        m.modifyData(v.getCancionTable().getValueAt(filasel, 3),
                                v.getNomCancion().getText(),
                                v.getGenereCombo().getSelectedItem(),
                                v.getAnyCancion().getText());
                        v.getCancionTable().getColumnModel().removeColumn(tc);
                        Utils.loadTable((ArrayList<Cancion>) m.getData(), v.getCancionTable(), Cancion.class, false);
                        v.cleanFields();
                    } else {
                        v.showMessage("Error: Has de seleccionar una cançó");
                        v.showMessage("Error! La data ha de estar en format dd/mm/yy");
                    }

                } else {

                    v.getAnyCancion().setText("");
                }
            }
            if (e.getSource().equals(v.getRemoveButton())) {

                int filasel = v.getCancionTable().getSelectedRow();

                if (filasel != -1) {
                    v.getCancionTable().getColumnModel().addColumn(tc);
                    m.removeData(v.getCancionTable().getValueAt(filasel, 3));
                    v.getCancionTable().getColumnModel().removeColumn(tc);

                    Utils.loadTable((ArrayList<Cancion>) m.getData(), v.getCancionTable(), Cancion.class, false);
                    v.cleanFields();
                } else {
                    v.showMessage("Error: Has de seleccionar una cançó");
                }
            }

        };

        //Creació de Adapters
        // Window Adapter
        WindowAdapter windowAdapter = new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                try {
                    m.saveData();
                } catch (IOException ex) {
                    v.showMessage("Error al guardar les dades.");
                }
                System.exit(0);
            }

        };
        //Associem el window adapter a la vista
        v.addWindowListener(windowAdapter);

        // Mouse Adapter
        MouseAdapter mouseAdapter = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                int filasel = v.getCancionTable().getSelectedRow();

                if (filasel != -1) {
                    v.getNomCancion().setText(v.getCancionTable().getValueAt(filasel, 0).toString());
                    v.getGenereCombo().setSelectedItem(v.getCancionTable().getValueAt(filasel, 1));
                    v.getAnyCancion().setText(v.getCancionTable().getValueAt(filasel, 2).toString());
                } else {
                    v.cleanFields();
                }
            }

        };

        // Assignació de ActionListeners:
        v.getCrudButton().addActionListener(actionListener);
        v.getListButton().addActionListener(actionListener);
        v.getExitButton().addActionListener(actionListener);
        v.getAddButton().addActionListener(actionListener);
        v.getModifyButton().addActionListener(actionListener);
        v.getRemoveButton().addActionListener(actionListener);

        // Assignació de Focus Listener
        v.getAnyCancion().addFocusListener(focusListener);

        // Assignació de MouseListener
        v.getCancionTable().addMouseListener(mouseAdapter);
    }

}
