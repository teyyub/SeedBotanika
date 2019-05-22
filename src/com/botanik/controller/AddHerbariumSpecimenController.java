package com.botanik.controller;

import com.botanik.dao.impl.HerbariumSpecimenDAOJDBC;
import com.botanik.dao.intf.HerbariumSpecimenDAO;
import com.botanik.model.Base;
import com.botanik.model.HerbariumSpecimenBase;
import com.botanik.model.HerbariumSpecimenSearch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author USER
 */
public class AddHerbariumSpecimenController {

    private HerbariumSpecimenBase baseModel;
    private HerbariumSpecimenSearch searchModel;
    private Stage dialogStage;
    HerbariumSpecimenDAO dao = new HerbariumSpecimenDAOJDBC();
    private boolean okClicked = false;
    private boolean isNew;

    @FXML
    private TextField numberTextField;

    @FXML
    private ComboBox<Base> locationCb;
    private ObservableList<Base> combos;
    @FXML
    private CheckBox isHerbarium, isKew;

    @FXML
    public void initialize() {
        System.out.println("init Herbarium Controller");
        loadCombo();
    }

    public void setSearchModel(HerbariumSpecimenSearch searchModel) {
        this.searchModel = searchModel;
         numberTextField.setText(searchModel.getNumber());
//         locationCb.getSelectionModel().select(searchModel.getLocation());
         isHerbarium.setSelected(searchModel.getHerbarium());
         isKew.setSelected(searchModel.getToKew());

    }

    private void loadCombo() {
//        combos = FXCollections.observableArrayList(dao.locationHerbariumSpecimen());
//        locationCb.setItems(combos);
    }

    @FXML
    private void save() {
        System.out.println("save");
        if (isValid()) {
//            if (isNew) {
                saveModel();
//            } else {
//                updateModel();
//            }

            if (baseModel.getDaoStatus().equals("1")) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
//                    alert.initOwner(dialogStage);
                alert.setContentText("Herbarium is saved");
                alert.showAndWait();
//                    setIsNew(false);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
//                    alert.initOwner(dialogStage);
                alert.setContentText("Herbarium is not saved");
                alert.showAndWait();
            }
//            okClicked = true;
//            dialogStage.close();
        }
    }

    private void saveModel() {
//        baseModel = new HerbariumSpecimenBase(numberTextField.getText(),
//                locationId(), isHerbarium(), isKew());
//        dao.save(baseModel);
    }

    private void updateModel() {
//        Number id = searchModel.getId();
//        baseModel = new HerbariumSpecimenBase(id,numberTextField.getText(),
//                locationId(), isHerbarium(), isKew());
//         
////        baseModel.setId(id);
//        dao.update(baseModel);
    }

    private Number locationId() {
        if (locationCb.getSelectionModel().getSelectedIndex() > -1) {
            return locationCb.getSelectionModel().getSelectedItem().getId();
        }
        return -1;
    }

    private boolean isHerbarium() {
        return isHerbarium.isSelected();
    }

    private boolean isKew() {
        return isKew.isSelected();
    }

    private boolean isValid() {
        String errorMessage = "";
        if (numberTextField.getText().trim() == null || numberTextField.getText().trim().length() == 0) {
            errorMessage += "Enter collection number !\n";
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

}
