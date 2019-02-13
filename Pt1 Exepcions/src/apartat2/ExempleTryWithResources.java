/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apartat2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author dios
 */
public class ExempleTryWithResources {
    private double cps;
    private int cursors;
    private int abueles;
    private int granjes;
    private int mines;
    private int fabriques;
    private int bancs;
    private double cookies_actuals = 0;
    
    informacioPartida partida = new informacioPartida();
    private void guardarPartida() {
        
        
            //Al guardar partida, l'objecte partida es guarda dins de partida.sav.
            //Cal dirli quines variables guardar a l'objecte
        try(BufferedReader br =
                   new BufferedReader(new FileReader("partida.sav"))) {
            FileOutputStream saveFile = new FileOutputStream("partida.sav");
            ObjectOutputStream save = new ObjectOutputStream(saveFile);
            partida.setCursors(cursors);
            partida.setAbueles(25);
            partida.setGranjes(granjes);
            partida.setMines(mines);
            partida.setFabriques(fabriques);
            partida.setBancs(bancs);
            partida.setCookies_actuals(cookies_actuals);
            save.writeObject(partida);
            save.close(); // This also closes saveFile.
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
    
    
        private void cargarPartida() {
            
        //Per a carregar partida, carreguem l'objecte que hi ha guardat a partida.sav a l'objecte partida.
        //Un cop carregat, li fem adaptarse a les noves dades amb els metodes:
        // carregarVariables(), calcularCps() i calcularCostos().
        try(BufferedReader br =
                   new BufferedReader(new FileReader("partida.sav"))) {
            FileInputStream saveFile = new FileInputStream("partida.sav");
            ObjectInputStream save = new ObjectInputStream(saveFile);
            partida = (informacioPartida) save.readObject();
            this.abueles = partida.getAbueles();
            save.close();

        } catch (Exception exc) {
            exc.printStackTrace();
        }

    }
        public static void main(String[] args) {
        
            ExempleTryWithResources p = new ExempleTryWithResources();
            //L'objectiu es que em retorne que a la partida hi han 25 abueles
            
            p.guardarPartida();
            p.cargarPartida();
            System.out.println(p.abueles);
            
            
    }
}
