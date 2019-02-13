package apartat1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dios
 */
public class NumDecimals {
    public static void main(String[] args) {
        if(args.length !=0){
            int decimals;
            int posicioPunt;
            for (int i = 0; i < args.length; i++) {
                try{
                    double argument = Double.parseDouble(args[i]);
                    posicioPunt = args[i].indexOf('.');
                    decimals = args[i].length() - posicioPunt - 1;
                    if (posicioPunt == -1) decimals = 0;
                    System.out.println("El numero " +args[i] + " té " +decimals + " numeros decimals");
                }catch(Exception e){
                    System.out.println("Error! El parametre \"" +args[i] +"\" no es un nombre real!");
                }
                
                
            }
        }else{
            System.out.println("No has passat cap parametre!");
        }
    }
}
