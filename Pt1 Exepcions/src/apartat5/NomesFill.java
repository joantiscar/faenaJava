/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apartat5;

import java.io.FileNotFoundException;

/**
 *
 * @author dios
 */
class Pare {

    public void method1(){
    }
}

class Fill extends Pare {

    @Override
    public void method1() throws FileNotFoundException{
        throw new java.io.FileNotFoundException();
    }
}
