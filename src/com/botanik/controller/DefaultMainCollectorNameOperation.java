package com.botanik.controller;

import com.botanik.Seed;
import com.botanik.dao.impl.CombosDAOJDBC;
import com.botanik.dao.intf.CombosDAO;
import com.botanik.model.Base;
import com.botanik.model.CollectionDataBase;
import com.botanik.model.Combo;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author teyyub , 11:08:01 AM
 */
public class DefaultMainCollectorNameOperation {

    CombosDAO baseDao = new CombosDAOJDBC();
    @FXML
    private TableView table;

    @FXML
    private Label lblCount;

    @FXML
    private TableColumn<Base, Integer> idColumn;
    @FXML
    private TableColumn<Base, String> nameColumn;

    ObservableList<Base> mainCollList;
    List<Base> mainCollectors;
    
    Base selectedItem;
            
    @FXML
    private TextField nameText;

    @FXML
    private void initialize() {
        System.out.println("init DefaultFamilyOperation");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        loadTable();
        nameText.setOnKeyPressed((KeyEvent event) -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                search();
            }
        });

    }

    private void loadMainCollector() {     
          mainCollectors = baseDao.combosByIds(18);
    }

    private void loadTable() {
        loadMainCollector();
        mainCollList = FXCollections.observableArrayList(mainCollectors);
        table.setItems(mainCollList);
        table.refresh();
        lblCount.setText("Record in Data " + String.valueOf(mainCollectors.size()));
    }

    @FXML
    private void search() {

        if ((nameText.getText().equals("")) || (nameText.getText().length() == 0)) {
            loadTable();
        } else {
            Combo c = new Combo(18,nameText.getText());
            mainCollectors = baseDao.loadByCombo(c);
            mainCollList = FXCollections.observableArrayList(mainCollectors);
            table.setItems(mainCollList);
            table.refresh();
        }
    }

    @FXML
    private void onEnter(ActionEvent ae) {

    }

    @FXML
    private void delete() {
        selectedItem = (Base) table.getSelectionModel().getSelectedItem();
        if (selectedItem == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
//            alert.initOwner(dialogStage);
            alert.setContentText("Item is not selected");
            alert.showAndWait();
        } else {
            if (isDeleteOk()) {
                try {
                    baseDao.deleteCombosById(selectedItem.getId(),18);
                    loadTable();
                } catch (Exception e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
//                    alert.initOwner(dialogStage);
                    alert.setContentText("Error is accurred " + e.getMessage());
                    alert.showAndWait();
                }
            }
        }
    }

    private boolean isDeleteOk() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//        alert.initOwner(dialogStage);
        alert.setContentText("Do you want to delete this item? ");
        Optional<ButtonType> result = alert.showAndWait();
        return result.get() == ButtonType.OK;
    }

    @FXML
    private void add() {
        createForm("view/addFrm.fxml", "Add", true);
        loadTable();
    }

    @FXML
    private void edit() {

        selectedItem = (Base) table.getSelectionModel().getSelectedItem();
        if (selectedItem == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
//            alert.initOwner(dialogStage);
            alert.setContentText("Item is not selected");
            alert.showAndWait();
        } else {            
            editForm("view/addFrm.fxml", "Edit");
        }
        loadTable();
    }

    

    private void createForm(String view, String title, boolean isNew) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Seed.class.getResource(view));

            AnchorPane layout = (AnchorPane) loader.load();

            Stage stage = new Stage();
            stage.setTitle(title);
            Scene scene = new Scene(layout);
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            AddFormController controller = loader.getController();
            controller.setCombos_id(18);
            controller.setIsNew(isNew); 
            controller.setDialogStage(stage);
            stage.showAndWait();

        } catch (IOException ex) {
            Logger.getLogger(CollectionDataBase.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }
    
     private void editForm(String view, String title ) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Seed.class.getResource(view));

            AnchorPane layout = (AnchorPane) loader.load();

            Stage stage = new Stage();
            stage.setTitle(title);
            Scene scene = new Scene(layout);
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            AddFormController controller = loader.getController();
            controller.setModel(this.selectedItem);            
            controller.setIsNew(false); 
            controller.setCombos_id(18);
            controller.init();
            controller.setDialogStage(stage);
            stage.showAndWait();

        } catch (IOException ex) {
            Logger.getLogger(CollectionDataBase.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
