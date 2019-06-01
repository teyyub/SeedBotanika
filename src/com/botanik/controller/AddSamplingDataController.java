package com.botanik.controller;

import com.botanik.dao.impl.SamplingDAOJDBC;
import com.botanik.dao.intf.SamplingDataDAO;
import com.botanik.model.SamplingDataBase;
import java.math.BigDecimal;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author teyyub
 */
public class AddSamplingDataController {

    private final SamplingDataDAO dao = new SamplingDAOJDBC();
    private SamplingDataBase model;
    private Stage dialogStage;
    private boolean isNew;

    @FXML
    private TextField numberSampleTextField, numberFoodTextField, areaSampleTextField, percentageTextField;
    @FXML
    private TextArea noteTextArea;

    @FXML
    private void save() {
        System.out.println("save");
        if (isValid()) {
//            if (isNew) {
                saveModel();
//            } else {
//                updateModel();
//            }

            if (model.getDaoStatus().equals("1")) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
//                    alert.initOwner(dialogStage);
                alert.setContentText("Data is saved");
                alert.showAndWait();
//                    setIsNew(false);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
//                    alert.initOwner(dialogStage);
                alert.setContentText("Data is not saved");
                alert.showAndWait();
            }

        }
//        dialogStage.close();
    }

    private void saveModel() {
        model = new SamplingDataBase(
                numberSampleTextField.getText(),
                numberFoodTextField.getText(),
                areaSampleTextField.getText(),
                percentageTextField.getText(),
                noteTextArea.getText());
        dao.save(model);
    }

    private void updateModel() {
        BigDecimal id = model.getId();
        model = new SamplingDataBase(id,
                    numberSampleTextField.getText(), 
                    numberFoodTextField.getText(), 
                    areaSampleTextField.getText(), 
                    percentageTextField.getText(), 
                    noteTextArea.getText());
            dao.update(model);
    }

    private boolean isValid() {
        String errorMessage = "";
        if (numberSampleTextField.getText().trim() == null || numberSampleTextField.getText().trim().length() == 0) {
            errorMessage += "Enter  number !\n";
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.initOwner(dialogStage);
            alert.setTitle("Invalid");
            alert.setHeaderText("Please enter parametr");
            alert.setContentText("");
            alert.showAndWait();
            return false;
        }
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setIsNew(boolean isNew) {
        this.isNew = isNew;
    }

    public void setModel(SamplingDataBase model) {
        this.model = model;
        numberSampleTextField.setText(model.getNumberSample());
        numberFoodTextField.setText(model.getNumberFood());
        noteTextArea.setText(model.getNote());
        areaSampleTextField.setText(model.getArea());
        percentageTextField.setText(model.getPercentage());
        
    }

}
