package com.botanik.controller;

import com.botanik.dao.impl.CollectionDataDAOJDBC;
import com.botanik.dao.impl.CombosDAOJDBC;
import com.botanik.dao.intf.CollectionDataDAO;
import com.botanik.dao.intf.CombosDAO;
import com.botanik.model.Base;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author USER
 */
public class AddFormController {

    Stage dialogStage;
    private Base model;
    private int combos_id;
    private boolean isNew;
    CollectionDataDAO dao = new CollectionDataDAOJDBC();

    CombosDAO combosDAO = new CombosDAOJDBC();

    @FXML
    private TextField nameTextField;

    @FXML
    public void initialize() {

    }

    public void init() {
        if (!isNew) {
            nameTextField.setText(this.model.getName());
        }
    }

    @FXML
    private void onEnter() {
        save();
    }

    @FXML
    private void save() {
        System.out.println("save");
        if (isNew) {
            saveModel();
        } else {
            updateModel();
        }
    }

    private void saveModel() {
        if (isInputValid()) {
            model = new Base(nameTextField.getText().trim());
            dao.save(model, combos_id);
            if (model.getDaoStatus().equals("1")) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Data is saved");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Data is not saved");
                alert.showAndWait();
            }
            dialogStage.close();
        }

    }

    private void updateModel() {
        if (isInputValid()) {
            model.setName(nameTextField.getText().trim());
            combosDAO.updateCombosById(model, combos_id);
            if (model.getDaoStatus().equals("1")) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Data is saved");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Data is not saved");
                alert.showAndWait();
            }
            dialogStage.close();
        }

    }

    private boolean isInputValid() {
        String errorMessage = "";
        if (nameTextField.getText().trim() == null || nameTextField.getText().trim().length() == 0) {
            errorMessage += "Enter name !\n";
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);
            alert.show();
            return false;
        }
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setCombos_id(int combos_id) {
        this.combos_id = combos_id;
    }

    public void setIsNew(boolean isNew) {
        this.isNew = isNew;
    }

    public void setModel(Base model) {
        this.model = model;
    }

    public Base getModel() {
        return model;
    }

}
