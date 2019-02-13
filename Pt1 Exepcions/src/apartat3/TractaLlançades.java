/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apartat3;

/**
 *
 * @author dios
 */
public class TractaLlançades {
    public static void main(String[] args) {
        Llançadora c = new Llançadora();
        try{
            c.tiraExcepcioFileNotFound();
        }catch(java.io.FileNotFoundException e){
            System.out.println("Fitxer no trobat!");
        }
        try{
            c.tiraExcepcioArrayIndexOutOfBoundsException();
        }catch(java.lang.ArrayIndexOutOfBoundsException e){
            System.out.println("Has intentat accedir a una posició del vector que no existeix!");
        }
    }
}
