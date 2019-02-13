/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author profe
 */
public class Bicycle implements Serializable{
    
    public enum Category { ROAD, MTB, EBIKE, CITY, GRAVEL};
    public enum TireSize { S26, S27_5, S29, S700};

    
    private Category _2_category;
    private TireSize _3_tireSize;
    private String _1_modelName;
    
    public Bicycle(String _1_modelName, Category _2_category, TireSize _3_tireSize) {
        this._1_modelName = _1_modelName;
        this._2_category = _2_category;
        this._3_tireSize = _3_tireSize;
    }
    
    
    public String get_1_ModelName() {
        return _1_modelName;
    }

    public void set_1_ModelName(String modelName) {
        this._1_modelName = modelName;
    }

    public Category get_2_Category() {
        return _2_category;
    }

    public void set_2_Category(Category category) {
        this._2_category = category;
    }

    public TireSize get_3_TireSize() {
        return _3_tireSize;
    }

    public void set_3_TireSize(TireSize tireSize) {
        this._3_tireSize = tireSize;
    }
    
    
    
}
