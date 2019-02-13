/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generics;

/**
 *
 * @author dios
 */
public class Generics {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Capsa de cadenes
        CapsaCadenes cs = new CapsaCadenes();
        cs.set("Astio");
        System.out.println("El contingut de la capsa es " +cs.get());

        // Capsa d'objectes
        
        CapsaObjectes co = new CapsaObjectes();
        co.set("Una cadena");
        String contingut = (String) co.get();
        System.out.println("El contingut de la capsa es " +contingut);
//        co.set(new Double(0.1));
        contingut = (String) co.get();
        System.out.println("El contingut de la capsa es " +contingut);
        
        CapsaGenerica<Double> cg = new CapsaGenerica<>();
        cg.set(new Double(0.1));
            double contingutt;
            contingutt = cg.get();
        System.out.println("El contingut de la capsa es " +contingutt);
        
      }  
}

class CapsaObjectes{
    
    private Object contingut=null;
    
    public void set(Object s){
        contingut=s;
    }
    
    public Object get(){
        return contingut;
    }
}
class CapsaCadenes{
    
    private String contingut=null;
    
    public void set(String s){
        contingut=s;
    }
    
    public String get(){
        return contingut;
    }
}
class CapsaGenerica <T>{
    
    private T contingut=null;
    
    public void set(T s){
        contingut=s;
    }
    
    public T get(){
        return contingut;
    }
}