/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesabstractes;

/**
 *
 * @author dios
 */

// Crearem la classe abstracta treballador.
// Les seves subclasses seran Tecnic i Enginyer, i la idea es que, ja que no hauriem de tindre cap treballador
// Que no estigue classificat entre Tecnic i Enginyer, la classe treballador no cal ser utilitzada per a crear objectes
// Pero al ser utilitzada com a classe abstracta, la podem fer servir per a agrupar les altres classes
// I donarlis les propietats i els metodes que tenen que heredar les dos.
public abstract class Treballador {
    
     int codi;
    
    String nom;
    
    String cognom;
    
    String dataNaixement;
    
    
    //Els metodes es declaren d'una forma diferent als metodes normals, ja que nomes tenen el nom del metode amb l'abstract
    // i no tenen claus. Aquests metodes es creen per a obligar a les subclasses a crear metodes amb aquest nom i sobreescriurels
    // En aquest cas, obligarem a les subclasses a crear els metodes definirDades() i obtindreDades();
    // La principal utilitat d'aixo es estructurar millor les classes i les subclasses, ja que si, per exemple, 
    // Cada una de les subclasses te dades que nomes pertany a una de elles, vols forçar a que es creen el seu propi metode,
    // Ja que un metode "Generic", que estigue pensat per a treballar nomes amb les propietats de la classe pare, 
    // no seria util per a les classes filles.
    public abstract void definirDades();
    
    public abstract void obtindreDades();
    
    
}
