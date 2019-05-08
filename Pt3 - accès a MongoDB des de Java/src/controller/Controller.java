/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import model.Model;
import vista.Vista;

/**
 *
 * @author dios
 */
public class Controller {

    private Model m;
    private Vista v;

    public Controller(Model m, Vista v){
        this.m = m;
        this.v = v;
        fillTree();
        control();
    }

    public void fillTree(){
        List databases = m.getDatabases();
    }
    
    public void control() {

        ActionListener actionListener = (ActionEvent e) -> {
//            if (e.getSource().equals(v.getDatabasesTree().)) {
//             
//            }

            
        };

//        v.getAlbumShowCancionesButton().addActionListener(actionListener);

    }

}
