/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apartat1;

/**
 *
 * @author dios
 */
public class RecorrerArray {

    /**
     * @param args the command line arguments
     */
    
    
    static int sumaArray(int[][] array){
        if (array == null) return 0;
        int suma = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                suma = suma + array[i][j];
                
            }
            
        }
        
        return suma;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        int[][] array1 = {{12, 3}, {134, 24}, {12, 24, 67}};
        int[][] array2 = {{-12, 3}, {-134, 24}, {12, 24, -67}};
        int[][] array3 = {{134532354, 334534534}, {13345344, 23453534}, {1345342, 24345, 345367}};
        int[] array4 = {12312, 1234, 123124};
        int[][] array5 = null;
        int[][] array6 = new int [2][3];
        array6[0][1] = 6;
        array6[0][2] = 1;
        array6[1][0] = 5;
        array6[1][1] = 2;
        
        System.out.println(sumaArray(array1));
        System.out.println(sumaArray(array2));
        System.out.println(sumaArray(array3));
//        System.out.println(sumaArray(array4)); //Ja que es un array unidimensional, aquest peta
        System.out.println(sumaArray(array5));
        System.out.println(sumaArray(array6));
        
        
    }
    
}
