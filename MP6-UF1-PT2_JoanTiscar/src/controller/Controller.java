/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import vista.Vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import model.Album;
import model.Model;

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
        this.v.setVisible(true);
        control();
        refrescarDades();
    }

    private void refrescarDades() {

        JTable taula = v.getAlbumsTable();
        DefaultTableModel model = (DefaultTableModel) taula.getModel();
        int rowCount = model.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
        for (Object album : m.getDades()) {

            Album loAlbum = (Album) album;
            model.addRow(new Object[]{
                loAlbum.getNom(),
                 loAlbum.getArtista(),
                 loAlbum.getData()
            }
            );

        }
        taula.setModel(model);
        v.setAlbumsTable(taula);

    }

    public boolean comprovarData(String data) {
//        return data.matches("(\\d{1,2}\\/){2}(\\d{4})");
        return true;
    }

    public void control() throws SQLException {

        // Action Listener: farà la majoria d'accions del programa
        ActionListener actionListener = (ActionEvent e) -> {
            if (e.getSource().equals(v.getAfegirButton())) {
                m.afegirAlbum(v.getNomTextField().getText(), v.getArtistaTextField().getText(), v.getDataTextField().getText());
                refrescarDades();
            }
            if (e.getSource().equals(v.getModificarButton())) {
                
                int i = v.getAlbumsTable().getSelectedRow();
                Album album = (Album) m.getDades().toArray()[i];
                
                
                m.editarAlbum(album, v.getNomTextField().getText(), v.getArtistaTextField().getText(), v.getDataTextField().getText());
                refrescarDades();
            }
            if (e.getSource().equals(v.getEliminarButton())) {
                int i = v.getAlbumsTable().getSelectedRow();
                Album album = (Album) m.getDades().toArray()[i];
                m.removeAlbum(album);
                refrescarDades();
            }
            try {
                m.guardarDades();
            } catch (IOException ex) {
                System.out.println("Error al guardar dades");
            }
        };

        //Creació de Adapters
        // Window Adapter
        WindowAdapter windowAdapter = new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                try {
                    m.guardarDades();
                } catch (IOException ex) {
                }
            }

        };
        //Associem el window adapter a la vista
        v.getAfegirButton().addActionListener(actionListener);
        v.getEliminarButton().addActionListener(actionListener);
        v.getModificarButton().addActionListener(actionListener);

        v.getAlbumsTable().getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
            v.getNomTextField().setText(v.getAlbumsTable().getValueAt(v.getAlbumsTable().getSelectedRow(), 0).toString());
            v.getArtistaTextField().setText(v.getAlbumsTable().getValueAt(v.getAlbumsTable().getSelectedRow(), 1).toString());
            v.getDataTextField().setText(v.getAlbumsTable().getValueAt(v.getAlbumsTable().getSelectedRow(), 2).toString());
        });
        
    }

}
