/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apartat4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/**
 *
 * @author dios
 */
public class MultiCapsa<E>{

    private Collection<E> contingut;
    
    public <E extends Comparable>Collection<E> ordenat(){
        Object[] array = contingut.toArray();
        List l = Arrays.asList(array);
        Collections.sort(l);
        return l;

    }
//       public Collection<E> ordenat(){
//        Collection<E> ordenadet = new TreeSet<>();
//        Iterator iterador = contingut.iterator();
//        
//        while(iterador.hasNext()){
//            ordenadet.add((E) iterador.next());
//        }
//        
//        
//        return ordenadet;
//    }
    
    public MultiCapsa(Collection<E> implementacio) {
        contingut = implementacio;
    }

    public boolean esBuida() {
        return contingut.isEmpty();
    }

    public void afegir(E elem) {
        contingut.add(elem);

    }

    public Object obtenir() {
        Iterator iterador = contingut.iterator();
        return iterador.next();
    }

    public boolean eliminar() {

        Iterator iterador = contingut.iterator();
        return contingut.remove(iterador.next());

    }

    public boolean buidar() {
        contingut.clear();
        return esBuida();
    }

//    
//    
    
}
class Bicycle implements Comparable{
    @Override
    public int compareTo(Object o) {
        if (this.cadence == ((Bicycle)o).cadence) return 0;
        if (this.cadence > ((Bicycle)o).cadence) return -1;
        if (this.cadence < ((Bicycle)o).cadence) return 1;
        return 0;
    }
    int cadence = 0;
    int speed = 0;
    int gear = 1;

    public Bicycle(int cadence, int speed, int gear) {
        this.cadence = cadence;
        this.speed = speed;
        this.gear = gear;
    }

    @Override
    public String toString() {
        return "Bicycle{" + "cadence=" + cadence + ", speed=" + speed + ", gear=" + gear + '}';
    }

    
    
    void changeCadence(int newValue) {
         cadence = newValue;
    }

    void changeGear(int newValue) {
         gear = newValue;
    }

    void speedUp(int increment) {
         speed = speed + increment;   
    }

    void applyBrakes(int decrement) {
         speed = speed - decrement;
    }

    void printStates() {
         System.out.println("cadence:" +
             cadence + " speed:" + 
             speed + " gear:" + gear);
    }

    
    
}