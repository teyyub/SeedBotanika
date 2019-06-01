package com.botanik.model;

/**
 *
 * @author teyyub , 9:39:07 PM
 */
public class Combo {

    private Number comboId;
    private String name;

    public Combo() {
    }

    public Combo(Number comboId, String name) {
        this.comboId = comboId;
        this.name = name;
    }

    public Number getComboId() {
        return comboId;
    }

    public void setComboId(Number comboId) {
        this.comboId = comboId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
}
