/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


/**
 *
 * @author profe
 */
public class Model {

    private Collection<Bicycle> data;
    private File f;

    public Model() throws IOException, FileNotFoundException, ClassNotFoundException {
        this(null);
    }

    public Model(String fileName) throws IOException, FileNotFoundException, ClassNotFoundException {
        setFile(fileName);
        loadData();
    }

    public void loadData() throws FileNotFoundException, IOException, ClassNotFoundException {

        data = new ArrayList<Bicycle>();
        if (f.exists()) {
            try ( ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(f)))) {

                while (true) {
                    Bicycle b = (Bicycle) in.readObject();
                    if (b != null) {
                        data.add(b);
                    }
                }

            } catch (EOFException e) {
            };
        }
    }

    public void setFile(String nom) {
        //Si passen un nom incorrecte o buit li poso data.dat
        nom = nom == null || nom.isBlank() ? "data.dat" : nom;
        f = new File(nom);
    }

    public void saveData() throws FileNotFoundException, IOException {

        try ( ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f))) {
            Iterator<Bicycle> it = data.iterator();
            while (it.hasNext()) {
                out.writeObject(it.next());
            }
        }

    }

    public void addData(String model, Object cat, Object ts) {
        Bicycle b = new Bicycle(model, (Bicycle.Category) cat, (Bicycle.TireSize) ts);
        data.add(b);

    }

    public void modifyData(Object obj, String modelName, Object cat, Object ts) {
        //Per modificar la bicicleta la passem des del controlador junt en els 
        //nous valors a prendre. Com és un objecte s'actualitzarà automàticament
        //dins l'ArrayList
        Bicycle b = (Bicycle) obj;
        b.set_1_ModelName(modelName);
        b.set_2_Category((Bicycle.Category) cat);
        b.set_3_TireSize((Bicycle.TireSize) ts);
    }

    public void removeData(Object obj) {
        //Per borrar la bicicleta la passem des del controlador 
        Bicycle b = (Bicycle) obj;
        data.remove(b);
    }

    public Collection<Bicycle> getData() {
        return data;
    }

}
