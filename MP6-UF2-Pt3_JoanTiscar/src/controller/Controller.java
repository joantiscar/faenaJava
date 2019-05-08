/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import view.Vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableColumn;
import model.Album;
import model.Cancion;
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
        control();
    }

    public void control() throws SQLException {

        v.albumsDisplayResult(m.indexAlbums());
        // Action Listener: farà la majoria d'accions del programa
        ActionListener actionListener = (ActionEvent e) -> {
            if (e.getSource().equals(v.getAlbumInsertButton())) {
                m.createAlbum(v.getAlbumNameTextField().getText().trim(), v.getAlbumArtistaTextField().getText().trim(), v.getAlbumDataTextField().getText().trim());
                v.albumsDisplayResult(m.indexAlbums());

            }

            if (e.getSource().equals(v.getCancionInsertButton())) {
                m.createCancion(v.getCancionNameTextField().getText().trim(), Integer.parseInt(v.getCancionDuracioTextField().getText().trim()));
                v.cancionesDisplayResult(m.getCancionesFromCurrentAlbum());

            }

            if (e.getSource().equals(v.getAlbumDeleteButton())) {
                int row = v.getAlbumResultTable().getSelectedRow();
                Album albumABorrar = new Album();

                albumABorrar.setNom(v.getAlbumResultTable().getModel().getValueAt(row, 0).toString());
                albumABorrar.setArtista(v.getAlbumResultTable().getModel().getValueAt(row, 1).toString());
                albumABorrar.setData(v.getAlbumResultTable().getModel().getValueAt(row, 2).toString());

                m.deleteAlbum(albumABorrar);
                v.albumsDisplayResult(m.indexAlbums());

            }

            if (e.getSource().equals(v.getAlbumModifyButton())) {
                int row = v.getAlbumResultTable().getSelectedRow();
                Album albumAModificar = new Album();

                albumAModificar.setNom(v.getAlbumResultTable().getModel().getValueAt(row, 0).toString());
                albumAModificar.setArtista(v.getAlbumResultTable().getModel().getValueAt(row, 1).toString());
                albumAModificar.setData(v.getAlbumResultTable().getModel().getValueAt(row, 2).toString());

                m.editAlbum(albumAModificar, v.getAlbumNameTextField().getText().trim(), v.getAlbumArtistaTextField().getText().trim(), v.getAlbumDataTextField().getText().trim());
                v.albumsDisplayResult(m.indexAlbums());

            }

            if (e.getSource().equals(v.getAlbumShowCancionesButton())) {

                int row = v.getAlbumResultTable().getSelectedRow();
                String nom = v.getAlbumResultTable().getModel().getValueAt(row, 0).toString();
                String artista = v.getAlbumResultTable().getModel().getValueAt(row, 1).toString();
                String data = v.getAlbumResultTable().getModel().getValueAt(row, 2).toString();
                v.cancionesDisplayResult(m.indexCancionesPerAlbum(nom, artista, data));

            }
            
             if (e.getSource().equals(v.getCancionModifyButton())) {
                int row = v.getResultTable().getSelectedRow();
                Cancion cancionAModificar = new Cancion();

                cancionAModificar.setNom(v.getResultTable().getModel().getValueAt(row, 0).toString());
                cancionAModificar.setDuracio(Integer.parseInt(v.getResultTable().getModel().getValueAt(row, 1).toString()));

                m.editCancion(v.getCancionNameTextField().getText().trim(), Integer.parseInt(v.getCancionDuracioTextField().getText().trim()), cancionAModificar);
                v.cancionesDisplayResult(m.getCancionesFromCurrentAlbum());

            }
             if (e.getSource().equals(v.getCancionDeleteButton())) {
                int row = v.getResultTable().getSelectedRow();
                Cancion cancionABorrar = new Cancion();

                cancionABorrar.setNom(v.getResultTable().getModel().getValueAt(row, 0).toString());
                cancionABorrar.setDuracio(Integer.parseInt(v.getResultTable().getModel().getValueAt(row, 1).toString()));

                m.deleteCancion(cancionABorrar);
                v.cancionesDisplayResult(m.getCancionesFromCurrentAlbum());

            }
        };

        v.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {

                m.closeDatabase();
                System.exit(0);

            }
        });
        v.getCancionDeleteButton().addActionListener(actionListener);
        v.getCancionInsertButton().addActionListener(actionListener);
        v.getCancionModifyButton().addActionListener(actionListener);
        v.getAlbumDeleteButton().addActionListener(actionListener);
        v.getAlbumInsertButton().addActionListener(actionListener);
        v.getAlbumModifyButton().addActionListener(actionListener);
        v.getAlbumShowCancionesButton().addActionListener(actionListener);

    }

}
