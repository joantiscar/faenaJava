/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.beans.*;
import java.io.Serializable;

/**
 *
 * @author dios
 */
public class NewBean implements Serializable {
    
    public static final String PROP_SAMPLE_PROPERTY = "sampleProperty";
    
    private String sampleProperty;
    
    private PropertyChangeSupport propertySupport;
    
    public NewBean() {
        propertySupport = new PropertyChangeSupport(this);
    }
    
    public String getSampleProperty() {
        return sampleProperty;
    }
    
        private int propietat = 0;

    public static final String PROP_PROPIETAT = "propietat";

    /**
     * Get the value of propietat
     *
     * @return the value of propietat
     */
    public int getPropietat() {
        return propietat;
    }

    /**
     * Set the value of propietat
     *
     * @param propietat new value of propietat
     * @throws java.beans.PropertyVetoException
     */
    public void setPropietat(int propietat) throws PropertyVetoException {
        int oldPropietat = this.propietat;
        vetoableChangeSupport.fireVetoableChange(PROP_PROPIETAT, oldPropietat, propietat);
        this.propietat = propietat;
        propertySupport.firePropertyChange(PROP_PROPIETAT, oldPropietat, propietat);
    }

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

    
    public void setSampleProperty(String value) {
        String oldValue = sampleProperty;
        sampleProperty = value;
        propertySupport.firePropertyChange(PROP_SAMPLE_PROPERTY, oldValue, sampleProperty);
    }
    
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(listener);
    }
    
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener(listener);
    }
    
}
