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
import java.util.Arrays;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import model.Model;
import vista.Vista;

/**
 *
 * @author dios
 */
public class Controller {

    private Model m;
    private Vista v;

    public Controller(Model m, Vista v) {
        this.m = m;
        this.v = v;
        fillTree();
        control();
    }

    public void fillTree() {
        String[] databases = m.getDatabases();

        DefaultMutableTreeNode categories = new DefaultMutableTreeNode("Bases de dades");

        for (String database : databases) {
            DefaultMutableTreeNode categoria = new DefaultMutableTreeNode(database);
            String[] collections = m.getCollections(database);
            for (String collection : collections) {
                DefaultMutableTreeNode col = new DefaultMutableTreeNode(collection);
                categoria.add(col);
            }
            categories.add(categoria);
        }
        DefaultTreeModel treeModel = new DefaultTreeModel(categories);
        JTree tree = v.getDatabasesTree();
        tree.setModel(treeModel);
        v.setDatabasesTree(tree);

    }

    public void control() {

        ActionListener actionListener = (ActionEvent e) -> {
//            if (e.getSource().equals(v.getDatabasesTree().)) {
//             
//            }

        };

        v.getDatabasesTree().addTreeSelectionListener((TreeSelectionEvent e) -> {
            m.setDatabase(v.getDatabasesTree().getSelectionPath().getPath()[1].toString());
            m.setCollection(v.getDatabasesTree().getSelectionPath().getPath()[2].toString());

            DefaultListModel list = new DefaultListModel();
            for(Object s : m.indexDocuments()){
                list.addElement(s);
            }
//            int size = list.getModel().getSize();
//            System.out.println(size);
//
//            for (int i = 0; i < size; i++) {
//                System.out.println(list.getModel().getElementAt(i));
//            }

            v.setDocumentsList(new JList(list));
        });
    }

}
