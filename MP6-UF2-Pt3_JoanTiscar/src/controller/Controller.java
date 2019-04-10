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
import javax.swing.table.TableColumn;
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
        };

        //Creació de Adapters
        // Window Adapter
        WindowAdapter windowAdapter = new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                m.closeDatabase();

                System.exit(0);
            }

        };
        
        MouseAdapter mouseAdapter = new MouseAdapter(){
         public void mouseClicked(MouseEvent e) {
             
             int row = v.getResultTable().getSelectedRow();
             System.out.println(row);
             
             String nom = v.getAlbumResultTable().getModel().getValueAt(row, 0).toString();
             String artista = v.getAlbumResultTable().getModel().getValueAt(row, 1).toString();
             String data = v.getAlbumResultTable().getModel().getValueAt(row, 2).toString();
             v.cancionesDisplayResult(m.indexCancionesPerAlbum(nom, artista, data));
         }                
      };
        //Associem el window adapter a la vista
        v.addWindowListener(windowAdapter);
        v.getCancionDeleteButton().addActionListener(actionListener);
        v.getCancionInsertButton().addActionListener(actionListener);
        v.getCancionModifyButton().addActionListener(actionListener);
        v.getAlbumDeleteButton().addActionListener(actionListener);
        v.getAlbumInsertButton().addActionListener(actionListener);
        v.getAlbumModifyButton().addActionListener(actionListener);
        v.getAlbumResultTable().addMouseListener(mouseAdapter);



    }

}
