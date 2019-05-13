/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import model.Model;
import org.bson.Document;
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
    public void fillKeysComboBox() {
        String[] keys = m.getKeys();

        JComboBox combo = v.getDocumentKeysComboBox();
        combo.removeAllItems();
        for(String key : keys){
            combo.addItem(key);
        }
        v.setDocumentKeysComboBox(combo);
       
            
    }
    

    public void control() {

        ActionListener actionListener = (ActionEvent e) -> {
            if (e.getSource().equals(v.getAddCollectionButton())) {
                m.insertDocument(v.getDocumentTextArea().getText());
                fillDocumentsTable();
                
            }

            if (e.getSource().equals(v.getDeleteCollectionButton())) {
                m.removeDocument();
                fillDocumentsTable();
                
            }
            if (e.getSource().equals(v.getEditCollectionButton())) {
                m.updateDocument(v.getDocumentTextArea().getText());
                fillDocumentsTable();
                
            }
            if (e.getSource().equals(v.getSaveClauButton())) {
                if("".equals(v.getNovaClauTextField().getText())){
                  m.updateKey(v.getDocumentKeysComboBox().getSelectedItem() , v.getDocumentValueTextField().getText());
                }else{
                    m.updateKey(v.getNovaClauTextField().getText() , v.getDocumentValueTextField().getText());  
                }
                fillDocumentsTable();  

            }
            if (e.getSource().equals(v.getDeleteClauButton())) {
                if(!"".equals(v.getDocumentKeysComboBox().getSelectedItem().toString())){
                  m.removeKey(v.getDocumentKeysComboBox().getSelectedItem().toString());
                }
                fillDocumentsTable();  

            }  
        };

        v.getDocumentsList().addListSelectionListener((ListSelectionEvent e) -> {
            JTextArea textarea = v.getDocumentTextArea();
            textarea.setText(v.getDocumentsList().getSelectedValue());
            v.setDocumentTextArea(textarea);

            Document document = Document.parse(v.getDocumentsList().getSelectedValue());

            m.setDocument(document.get("_id"));
            fillKeysComboBox();
            
        });

        v.getDatabasesTree().addTreeSelectionListener((TreeSelectionEvent e) -> {
            if (v.getDatabasesTree().getSelectionPath().getPath().length > 2) {

                m.setDatabase(v.getDatabasesTree().getSelectionPath().getPath()[1].toString());
                m.setCollection(v.getDatabasesTree().getSelectionPath().getPath()[2].toString());
                fillDocumentsTable();
               
            }
        });
        v.getDocumentKeysComboBox().addItemListener((ItemEvent event) -> {
            if (event.getStateChange() == ItemEvent.SELECTED) {
                JTextArea textArea = v.getDocumentValueTextField();
                textArea.setText(m.getValueFromKey(v.getDocumentKeysComboBox().getSelectedItem()).toString());
            }
        } // Listening if a new items of the combo box has been selected.
        );
        v.getAddCollectionButton().addActionListener(actionListener);
        v.getEditCollectionButton().addActionListener(actionListener);
        v.getDeleteCollectionButton().addActionListener(actionListener);
        v.getSaveClauButton().addActionListener(actionListener);
        v.getDeleteClauButton().addActionListener(actionListener);
        
    }
    private void fillDocumentsTable() {
             DefaultListModel list = new DefaultListModel();
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                JsonParser jp = new JsonParser();

                for (Document s : m.indexDocuments()) {
                    JsonElement je = jp.parse(s.toJson());
                    list.addElement(gson.toJson(je));
                }
                JList llista = v.getDocumentsList();
                llista.setModel(list);
                v.setDocumentsList(llista);
        }

}
