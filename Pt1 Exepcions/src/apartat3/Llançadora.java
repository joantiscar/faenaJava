/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apartat3;

import java.io.FileNotFoundException;

/**
 *
 * @author dios
 */
public class Llançadora {
    
    public void tiraExcepcioFileNotFound() throws FileNotFoundException{
        
        throw new FileNotFoundException();
    }
    public void tiraExcepcioArrayIndexOutOfBoundsException() throws ArrayIndexOutOfBoundsException{
        
        throw new ArrayIndexOutOfBoundsException();
    }
}
