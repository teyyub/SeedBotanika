package com.botanik.model;

import javafx.scene.control.Alert;

/**
 *
 * @author USER
 */
public class DefaultAlert {

    private String context;

    public DefaultAlert() {
    }

    public DefaultAlert(String context) {
        this.context = context;
    }

    public void show() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(context);
        alert.showAndWait();
    }

    public void warning() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.initOwner(dialogStage);
        alert.setTitle("Invalid Fields");
        alert.setHeaderText("Please correct invalid fields");
        alert.setContentText(context);
        alert.showAndWait();
    }

}
