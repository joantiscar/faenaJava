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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.table.TableColumn;
import model.Bicycle;
import model.Bicycle.Category;
import model.Bicycle.TireSize;
import model.Model;
import utilscontroller.Utils;
import view.View;

/**
 *
 * @author profe
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

    public void control() {

        //El mètode loadTable(...) retorna una columna que conté a cada fila 
        //l'objecte bicycle corresponent als camps de la fila 
        TableColumn tc=Utils.loadTable((ArrayList<Bicycle>) m.getData(), v.getBicycleTable(), Bicycle.class,false);
        
        //Codi que s'executarà quan apretem algun botó de la vista 
        ActionListener actionListener = (ActionEvent e) -> {
            //Accions a fer quan apretem el botó CRUD
            if (e.getSource().equals(v.getCrudButton())) {
                //Carreguem els objectes en les dades
                v.getModelName().setText("");
                Utils.loadCombo(Category.values(), v.getCategoryCombo());
                Utils.loadCombo(TireSize.values(), v.getTireSizeCombo());
                Utils.loadTable((ArrayList<Bicycle>) m.getData(), v.getBicycleTable(), Bicycle.class, false);
                //Mostrem els panels adequats
                v.getjPanel3().removeAll();
                v.getjPanel3().repaint();
                v.getjPanel3().revalidate();
                v.getjPanel3().add(v.getjPanel5());
                v.getjPanel3().revalidate();

            }
            //Accions a fer quan apretem el botó List
            if (e.getSource().equals(v.getListButton())) {
                //Carreguem els objectes en les dades
                Utils.loadTable((ArrayList<Bicycle>) m.getData(), v.getBicycleTableLlistat(), Bicycle.class, false);
                //Mostrem els panels adequats
                v.getjPanel3().removeAll();
                v.getjPanel3().repaint();
                v.getjPanel3().revalidate();
                v.getjPanel3().add(v.getjPanel4());
                v.getjPanel3().revalidate();

            }
            //Accions a fer quan apretem el botó Exit            
            if (e.getSource().equals(v.getExitButton())) {
                try {
                    //Guardem les dades de la taula al fitxer
                    m.saveData();
                } catch (IOException ex) {
                    v.showMessage("Error al guardar les dades.");
                }
                System.exit(0);

            }
            //Accions a fer quan apretem el botó Add            
            if (e.getSource().equals(v.getAddButton())) {
                //Passem les dades introduïdes i les afegim 
                m.addData(v.getModelName().getText().trim(), v.getCategoryCombo().getSelectedItem(), v.getTireSizeCombo().getSelectedItem());
                //Refresquem la taula
                Utils.loadTable((ArrayList<Bicycle>) m.getData(), v.getBicycleTable(), Bicycle.class, false);
                //Posem los camps en blanc
                v.cleanFields();
            }
            //Accions a fer quan apretem el botó Modify
            if(e.getSource().equals(v.getModifyButton())){
            
                //Guardem la fila seleccionada. Si no hi ha cap obtindrem un -1 
                int filasel=v.getBicycleTable().getSelectedRow();
                
                //Si hem seleccionat una fila actualitzem l'objecte bicicleta 
                //associat en els valors posats als components de la vista
                if(filasel!=-1){
                    //Afegim momentàniament la columna en los objectes a la taula
                    //i en això recuperem l'objecte Bicycle que passem al mètode
                    //modifyData() del model (el seu 1r paràmetre)
                    v.getBicycleTable().getColumnModel().addColumn(tc);
                    m.modifyData(v.getBicycleTable().getValueAt(filasel, 3), 
                            v.getModelName().getText(), 
                            v.getCategoryCombo().getSelectedItem(), 
                            v.getTireSizeCombo().getSelectedItem());
                    //Tornem a eliminar la columna de la taula
                    v.getBicycleTable().getColumnModel().removeColumn(tc);

                    //Refresquem la taula
                    Utils.loadTable((ArrayList<Bicycle>) m.getData(), v.getBicycleTable(), Bicycle.class, false);
                    //Posem los camps en blanc
                    v.cleanFields();
                } 
                //I si no hem seleccionat mostrem missatge d'advertiment
                else v.showMessage("Has de seleccionar una bicicleta!!");
            }

            //Accions a fer quan apretem el botó Remove
            if(e.getSource().equals(v.getRemoveButton())){
            
                //Guardem la fila seleccionada. Si no hi ha cap obtindrem un -1 
                int filasel=v.getBicycleTable().getSelectedRow();
                
                //Si hem seleccionat una fila eliminem l'objecte bicicleta 
                //associat de l'ArrayList que conté les dades de l'aplicació
                if(filasel!=-1){
                    //Afegim momentàniament la columna en los objectes a la taula
                    //i en això recuperem l'objecte Bicycle que passem al mètode
                    //removeData() del model
                    v.getBicycleTable().getColumnModel().addColumn(tc);
                    m.removeData(v.getBicycleTable().getValueAt(filasel, 3));
                    //Tornem a eliminar la columna de la taula
                    v.getBicycleTable().getColumnModel().removeColumn(tc);

                    //Refresquem la taula
                    Utils.loadTable((ArrayList<Bicycle>) m.getData(), v.getBicycleTable(), Bicycle.class, false);
                    //Posem los camps en blanc
                    v.cleanFields();
                } 
                //I si no hem seleccionat mostrem missatge d'advertiment
                else v.showMessage("Has de seleccionar una bicicleta!!");
            }





        };

        //Afegim els action listeners als botons
        v.getCrudButton().addActionListener(actionListener);
        v.getListButton().addActionListener(actionListener);
        v.getExitButton().addActionListener(actionListener);
        v.getAddButton().addActionListener(actionListener);
        v.getModifyButton().addActionListener(actionListener);
        v.getRemoveButton().addActionListener(actionListener);

        
        //Codi que s'executarà quan apretem sobre la taula. Les taules no accepten
        //ActionListeners, només mouseListeners o Adapters
        MouseAdapter mouseAdapter = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
                //Guardem la fila seleccionada. Si no hi ha cap obtindrem un -1 
                int filasel=v.getBicycleTable().getSelectedRow();
                
                //Si hem seleccionat una fila actualitzem els components en els
                //valors de la bicicleta seleccionada
                if(filasel!=-1){
                    v.getModelName().setText(v.getBicycleTable().getValueAt(filasel, 0).toString());
                    v.getCategoryCombo().setSelectedItem(v.getBicycleTable().getValueAt(filasel, 1));
                    v.getTireSizeCombo().setSelectedItem(v.getBicycleTable().getValueAt(filasel, 2));
                } 
                //I si no hem seleccionat els posem en blanc
                else v.cleanFields();
            }

        };

        //Associem el window adapter a la vista
        v.getBicycleTable().addMouseListener(mouseAdapter);
        
        
        
        
        
        
        /**
         * *******************************************************************
         * Per a que funcione el de baix, hem de posar la propietat 
         * defaultCloseOperation del JFrame en el valor DISPOSE
         * setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
         */
        //Per a que si tanquem la finestra apretant la x fessem el mateix que si
        //sortim apretant el botó Exit
        WindowAdapter windowAdapter = new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                //Mateix codi que quan apretem el botó de sortir del programa
                try {
                    //Guardem les dades de la taula al fitxer
                    m.saveData();
                } catch (IOException ex) {
                    v.showMessage("Error al guardar les dades.");
                }
                System.exit(0);
            }

        };

        //Associem el window adapter a la vista
        v.addWindowListener(windowAdapter);

    }

    
}
