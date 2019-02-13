/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author dios
 */
public class Cancion implements Serializable{
    
    public enum Genere { Rock, Blues, Jazz, Pop, Folk, Altres };
   

    
    private Genere _2_genere;
    private String _3_data;
    private String _1_nom;
    
    public Cancion(String _1_nom, Genere _2_genere, String _3_data) {
        this._1_nom = _1_nom;
        this._2_genere = _2_genere;
        this._3_data = _3_data;
    }
    
    
    public String get_1_Nom() {
        return _1_nom;
    }

    public void set_1_Nom(String nom) {
        this._1_nom = nom;
    }

    public Genere get_2_Genere() {
        return _2_genere;
    }

    public void set_2_Genere(Genere genere) {
        this._2_genere = genere;
    }

    public String get_3_Data() {
        return _3_data;
    }

    public void set_3_Data(String data) {
        this._3_data = data;
    }
    
    
    
}
