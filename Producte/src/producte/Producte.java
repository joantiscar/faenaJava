/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producte;

import java.beans.*;
import java.io.Serializable;

/**
 *
 * @author dios
 */
public class Producte implements Serializable {
    
        private float pvp;

    public static final String PROP_PVP = "pvp";

    /**
     * Get the value of pvp
     *
     * @return the value of pvp
     */
    public float getPvp() {
        return pvp;
    }

    /**
     * Set the value of pvp
     *
     * @param pvp new value of pvp
     * @throws java.beans.PropertyVetoException
     */
    public void setPvp(float pvp) throws PropertyVetoException {
        float oldPvp = this.pvp;
        vetoableChangeSupport.fireVetoableChange(PROP_PVP, oldPvp, pvp);
        this.pvp = pvp;
        propertySupport.firePropertyChange(PROP_PVP, oldPvp, pvp);
    }

    
    private String denominacio = "";

    private String fabricant = "";

    private int stockMinim = 0;

        private int stockActual = 0;

    public static final String PROP_STOCKACTUAL = "stockActual";

    /**
     * Get the value of stockActual
     *
     * @return the value of stockActual
     */
    public int getStockActual() {
        return stockActual;
    }

    /**
     * Set the value of stockActual
     *
     * @param stockActual new value of stockActual
     */
    public void setStockActual(int stockActual) {
        this.stockActual = stockActual;
        propertySupport.firePropertyChange(PROP_STOCKACTUAL, this.stockMinim, stockActual);
    }

    
    
    /**
     * Get the value of stockMinim
     *
     * @return the value of stockMinim
     */
    public int getStockMinim() {
        return stockMinim;
    }

    /**
     * Set the value of stockMinim
     *
     * @param stockMinim new value of stockMinim
     */
    public void setStockMinim(int stockMinim) {
        this.stockMinim = stockMinim;
    }

    /**
     * Get the value of stockMinim
     *
     * @return the value of stockMinim
     */
    private transient final VetoableChangeSupport vetoableChangeSupport = new VetoableChangeSupport(this);

    /**
     * Add VetoableChangeListener.
     *
     * @param listener
     */
    public void addVetoableChangeListener(VetoableChangeListener listener) {
        vetoableChangeSupport.addVetoableChangeListener(listener);
    }

    /**
     * Remove VetoableChangeListener.
     *
     * @param listener
     */
    public void removeVetoableChangeListener(VetoableChangeListener listener) {
        vetoableChangeSupport.removeVetoableChangeListener(listener);
    }

        


 
    
    /**
     * Get the value of fabricant
     *
     * @return the value of fabricant
     */
    public String getFabricant() {
        return fabricant;
    }

    /**
     * Set the value of fabricant
     *
     * @param fabricant new value of fabricant
     */
    public void setFabricant(String fabricant) {
        this.fabricant = fabricant;
    }

    private int anyFabricacio = 0;

    /**
     * Get the value of anyFabricacio
     *
     * @return the value of anyFabricacio
     */
    public int getAnyFabricacio() {
        return anyFabricacio;
    }

    /**
     * Set the value of anyFabricacio
     *
     * @param anyFabricacio new value of anyFabricacio
     */
    public void setAnyFabricacio(int anyFabricacio) {
        this.anyFabricacio = anyFabricacio;
    }

    private String[] caracteristiquesTecniques;

    /**
     * Get the value of caracteristiquesTecniques
     *
     * @return the value of caracteristiquesTecniques
     */
    public String[] getCaracteristiquesTecniques() {
        return caracteristiquesTecniques;
    }

    /**
     * Set the value of caracteristiquesTecniques
     *
     * @param caracteristiquesTecniques new value of caracteristiquesTecniques
     */
    public void setCaracteristiquesTecniques(String[] caracteristiquesTecniques) {
        this.caracteristiquesTecniques = caracteristiquesTecniques;
    }

    /**
     * Get the value of caracteristiquesTecniques at specified index
     *
     * @param index the index of caracteristiquesTecniques
     * @return the value of caracteristiquesTecniques at specified index
     */
    public String getCaracteristiquesTecniques(int index) {
        return this.caracteristiquesTecniques[index];
    }

    /**
     * Set the value of caracteristiquesTecniques at specified index.
     *
     * @param index the index of caracteristiquesTecniques
     * @param caracteristiquesTecniques new value of caracteristiquesTecniques
     * at specified index
     */
    public void setCaracteristiquesTecniques(int index, String caracteristiquesTecniques) {
        this.caracteristiquesTecniques[index] = caracteristiquesTecniques;
    }

    /**
     * Get the value of Denominacio
     *
     * @return the value of Denominacio
     */
    public String getDenominacio() {
        return denominacio;
    }

    /**
     * Set the value of Denominacio
     *
     * @param denominacio new value of Denominacio
     */
    public void setDenominacio(String denominacio) {
        this.denominacio = denominacio;
    }
    
    private String noSerie = "";

    /**
     * Get the value of NoSerie
     *
     * @return the value of NoSerie
     */
    public String getNoSerie() {
        return noSerie;
    }

    /**
     * Set the value of NoSerie
     *
     * @param noSerie new value of NoSerie
     */
    public void setNoSerie(String noSerie) {
        this.noSerie = noSerie;
    }

    private PropertyChangeSupport propertySupport;
    
    public Producte() {
        propertySupport = new PropertyChangeSupport(this);
    }
    
    
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(listener);
    }
    
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener(listener);
    }
    
}
