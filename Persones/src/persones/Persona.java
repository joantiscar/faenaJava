/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persones;

/**
 *
 * @author dios
 */
public class Persona {

   private int astio = 1;
   
   public void metodePublic(){
       
       System.out.println("Estas accedint a un metode public");
      
   }
   protected void metodeProtected(){
       
       System.out.println("Estas accedint a un metode protegit");
       
   }
   void metodeSenseres(){
       
       System.out.println("Estas accedint a un metode sense res");
      
   }
   private void metodePrivat(){
       
       System.out.println("Estas accedint a un metode privat");
       
   }
   
   void prova(){   
       metodePublic();
       metodeProtected();
       metodeSenseres();
       metodePrivat();  
       
       
   }

    public int getAstio() {
        return astio;
    }

    public void setAstio(int astio) {
        this.astio = astio;
    }
}
