package hibernate.entity;
// Generated 11 mar. 2019 12:57:36 by Hibernate Tools 4.3.1



/**
 * Canciones generated by hbm2java
 */
public class Canciones  implements java.io.Serializable {


     private String nom;
     private String genere;
     private String data;

    public Canciones() {
    }

	
    public Canciones(String nom) {
        this.nom = nom;
    }
    public Canciones(String nom, String genere, String data) {
       this.nom = nom;
       this.genere = genere;
       this.data = data;
    }
   
    public String getNom() {
        return this.nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getGenere() {
        return this.genere;
    }
    
    public void setGenere(String genere) {
        this.genere = genere;
    }
    public String getData() {
        return this.data;
    }
    
    public void setData(String data) {
        this.data = data;
    }




}

