 
package com.botanik.model;

import javafx.scene.control.TextField;

/**
 *
 * @author USER
 */
public class DefaultInput {
    private String origin; 
    private TextField originTextField;
    public DefaultInput() {
    }

    public DefaultInput(String origin) {
        this.origin = origin;
    }

    public DefaultInput(String origin, TextField originTextField) {
        this.origin = origin;
        this.originTextField = originTextField;
    }

    public DefaultInput(TextField originTextField) {
        this.originTextField = originTextField;
    }
    
    
    
    public void check(){
        String errorMessage = "";
        if (originTextField.getText().trim() == null || originTextField.getText().trim().length() == 0) {
            errorMessage += origin;
        }
    }
    
}
