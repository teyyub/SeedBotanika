package com.botanik.controller;

import com.botanik.Seed;
import com.botanik.dao.intf.HerbariumSpecimenDAO;
import com.botanik.model.CollectionDataBase;
import com.botanik.model.HerbariumSpecimenBase;
import java.io.IOException;
import java.util.Optional;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author USER
 */
public class PlantNamesController {

    private ButtonController buttonContriller;
    private HerbariumSpecimenBase baseModel;
    HerbariumSpecimenDAO dao;
    @FXML
    private TextField numberTextField;

    @FXML
    TableView mainTable;

    @FXML
    private ComboBox locationCb;

    private Seed mainApp;

    public void setMainApp(Seed mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private CheckBox isHerbarium, isKew;

    public void setButtonContriller(ButtonController buttonContriller) {
        this.buttonContriller = buttonContriller;
    }

    @FXML
    private void save() {
        System.out.println("save");
//        if (isValid()) {
//            baseModel = new HerbariumSpecimenBase(numberTextField.getText(),
//                    Long.valueOf(1),  Boolean.TRUE);
//            dao.save(baseModel);
//        }
    }

    @FXML
    private void add() {
        try {
            System.out.println("addPlandAndIdentificationData clicked");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Seed.class.getResource("view/addPlandAndIdentificationData.fxml"));

            AnchorPane page = (AnchorPane) loader.load();

//        // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Add Plants Name and Identification");
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            dialogStage.initStyle(StageStyle.UTILITY);
            dialogStage.initModality(Modality.APPLICATION_MODAL);
            dialogStage.setResizable(false);

            dialogStage.showAndWait();
        } catch (IOException e) {
            System.out.println("exception in addCollectionData " + e);

        }
    }

    @FXML
    private void edit() {
    }

    @FXML
    private void delete() {

        int index = mainTable.getSelectionModel().getSelectedIndex();
        if (index == -1) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.initOwner();
            alert.setTitle("Warning");
//            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText("Select at least one element");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//            alert.initOwner(primaryStage);
            alert.setTitle("Delete");
//            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText("Doy you want to delte this item?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                CollectionDataBase model = (CollectionDataBase) mainTable.getSelectionModel().getSelectedItem();
                mainTable.getItems().remove(index);
                dao.delete(model.getId());
            }
        }
    }

    @FXML
    private void search() {
    }

    @FXML
    private void clear() {
    }

    private boolean isValid() {

        return false;
    }

}
