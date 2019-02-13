/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apartat4;

import java.io.Serializable;

/**
 *
 * @author dios
 */
public class Persona implements Serializable {

    private String nom;

    private String cognom;
    private int edat;

    private float pes;
    private float alçada;

    private char sexe;
    private char te_carnet;
    
    
    public String toString() {
        return "Nom: " + this.nom + " \nCognom: " + this.cognom + "\nEdat: " + this.edat + "\nPes: " + this.pes + "\nAlçada: " + this.alçada + "\nSexe: " +this.sexe + "\nTe carnet de conduir: " + this.te_carnet;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognom() {
        return cognom;
    }

    public void setCognom(String cognom) {
        this.cognom = cognom;
    }

    public int getEdat() {
        return edat;
    }

    public void setEdat(int edat) {
        this.edat = edat;
    }

    public float getPes() {
        return pes;
    }

    public void setPes(float pes) {
        this.pes = pes;
    }

    public float getAlçada() {
        return alçada;
    }

    public void setAlçada(float alçada) {
        this.alçada = alçada;
    }

    public char getSexe() {
        return sexe;
    }

    public void setSexe(char sexe) {
        this.sexe = sexe;
    }

    public char getTe_carnet() {
        return te_carnet;
    }

    public void setTe_carnet(char te_carnet) {
        this.te_carnet = te_carnet;
    }
}
