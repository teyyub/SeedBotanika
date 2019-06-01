package com.botanik.controller;

import com.botanik.dao.impl.CollectionDataDAOJDBC;
import com.botanik.dao.intf.CollectionDataDAO;
import com.botanik.model.Base;
import com.botanik.model.CollectionDataBase;
import java.math.BigDecimal;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author USER
 */
public class AddCollectionDataController {

    @FXML
    private TextField nameField, numberTextField, accessionTextField;
    @FXML
    private ComboBox organisationCb, wildCb, collectorCb;
    private Stage dialogStage;
    private boolean isNew;
    private CollectionDataBase model;
    AnchorPane layout;

    CollectionDataDAO dao = new CollectionDataDAOJDBC();
    ObservableList<Base> organizeIntituteList;
    ObservableList<Base> wildCultivitedList;
    ObservableList<Base> collectorIntituteList;

    @FXML
    private void initialize() {
//        System.out.println(buttonController.toString());
        loadCombos();

    }

    @FXML
    public void save() {
        System.out.println("save");
        if (isInputValid()) {
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
        System.out.println("save " + nameField.getText());
        model = new CollectionDataBase(
                numberTextField.getText().trim(),
                nameField.getText().trim(),
                accessionTextField.getText().trim(),
                null,
                organizeInstituteId(), 
                wildCultivitedId(),  
                collectorInstituteId() 
        );

        dao.save(model);
    }

    private void updateModel() {
        BigDecimal id = model.getId();
        model = new CollectionDataBase(
                id,
                numberTextField.getText().trim(),
                nameField.getText().trim(),
                accessionTextField.getText().trim(),
                null,
                organizeInstituteId(),  
                wildCultivitedId(),  
                collectorInstituteId() 
        );
        dao.update(model);
    }

    private BigDecimal organizeInstituteId() {
        if (organisationCb.getSelectionModel().getSelectedIndex() == -1) {
            return BigDecimal.valueOf(-1);
        }
        return ((Base) organisationCb.getSelectionModel().getSelectedItem()).getId();
    }

    private BigDecimal wildCultivitedId() {
        if (wildCb.getSelectionModel().getSelectedIndex() == -1) {
            return BigDecimal.valueOf(-1);
        }
        return ((Base) wildCb.getSelectionModel().getSelectedItem()).getId();
    }

    private BigDecimal collectorInstituteId() {
        if (collectorCb.getSelectionModel().getSelectedIndex() == -1) {
            return BigDecimal.valueOf(-1);
        }
        return ((Base) collectorCb.getSelectionModel().getSelectedItem()).getId();
    }

    @FXML
    private void clear() {
        nameField.clear();
        numberTextField.clear();
        accessionTextField.clear();
        organisationCb.getSelectionModel().clearSelection();
        wildCb.getSelectionModel().clearSelection();
        collectorCb.getSelectionModel().clearSelection();

    }

    private void loadCombos() {
        organizeIntituteList = FXCollections.observableArrayList(dao.organizeInstitute());
        wildCultivitedList = FXCollections.observableArrayList(dao.wildCultivited());
        collectorIntituteList = FXCollections.observableArrayList(dao.collectorInstitute());
        organisationCb.setItems(organizeIntituteList);
        wildCb.setItems(wildCultivitedList);
        collectorCb.setItems(collectorIntituteList);
    }

    private boolean isInputValid() {
        String errorMessage = "";
        if (nameField.getText().trim() == null || nameField.getText().trim().length() == 0) {
            errorMessage += "Enter name!\n";
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

    public void setModel(CollectionDataBase model) {
        this.model = model;
        numberTextField.setText(model.getCollectionNumber());
        nameField.setText(model.getProjectName());
        accessionTextField.setText(model.getAccessionNumber());

    }

}
