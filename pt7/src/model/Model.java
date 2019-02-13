/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author dios
 */
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

public class Model {
private Collection<Cancion> data;
    private File f;

    public Model() throws IOException, FileNotFoundException, ClassNotFoundException {
        this(null);
    }

    public Model(String fileName) throws IOException, FileNotFoundException, ClassNotFoundException {
        setFile(fileName);
        loadData();
    }

    public void loadData() throws FileNotFoundException, IOException, ClassNotFoundException {

        data = new ArrayList<>();
        if (f.exists()) {
            try ( ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(f)))) {

                while (true) {
                    Cancion b = (Cancion) in.readObject();
                    if (b != null) {
                        data.add(b);
                    }
                }

            } catch (EOFException e) {
            }
        }
    }

    public void setFile(String No) {
        No = No == null || No.isBlank() ? "data.dat" : No;
        f = new File(No);
    }

    public void saveData() throws FileNotFoundException, IOException {

        try ( ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f))) {
            Iterator<Cancion> it = data.iterator();
            while (it.hasNext()) {
                out.writeObject(it.next());
            }
        }

    }

    public void addData(String nom, Object cat, String dat) {
        Cancion b = new Cancion(nom, (Cancion.Genere) cat, dat);
        data.add(b);

    }

    public void modifyData(Object obj, String nom, Object genere, String dat) {
        Cancion b = (Cancion) obj;
        b.set_1_Nom(nom);
        b.set_2_Genere((Cancion.Genere) genere);
        b.set_3_Data(dat);
    }

    public void removeData(Object obj) {
        Cancion b = (Cancion) obj;
        data.remove(b);
    }

    public Collection<Cancion> getData() {
        return data;
    }    
}
