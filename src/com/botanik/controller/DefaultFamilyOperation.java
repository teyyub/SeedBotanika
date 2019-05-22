package com.botanik.controller;

import com.botanik.Seed;
import com.botanik.dao.impl.CombosDAOJDBC;
import com.botanik.dao.intf.CombosDAO;
import com.botanik.model.Base;
import com.botanik.model.CollectionDataBase;
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
public class DefaultFamilyOperation {

    CombosDAO baseDao = new CombosDAOJDBC();
    @FXML
    private TableView familyTable;

    @FXML
    private Label lblCount;

    @FXML
    private TableColumn<Base, Integer> idColumn;
    @FXML
    private TableColumn<Base, String> nameColumn;

    ObservableList<Base> familyList;
    List<Base> families;
    
    Base selectedItem;
    
    private Number gen_id = null;
            
    @FXML
    private TextField familyNameText;

    @FXML
    private void initialize() {
        System.out.println("init DefaultFamilyOperation");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        loadFamilyTable();
        familyNameText.setOnKeyPressed((KeyEvent event) -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                searchFamily();
            }
        });

    }

    private void loadFamilies() {
     
          families = baseDao.combosByIds(1);
    }

    private void loadFamilyTable() {
        loadFamilies();
        familyList = FXCollections.observableArrayList(families);
        familyTable.setItems(familyList);
        familyTable.refresh();
        lblCount.setText("Record in Family " + String.valueOf(families.size()));
    }

    @FXML
    private void searchFamily() {

        if ((familyNameText.getText().equals("")) || (familyNameText.getText().length() == 0)) {
            loadFamilyTable();
        } else {
            families = baseDao.familyByName(familyNameText.getText());
            familyList = FXCollections.observableArrayList(families);
            familyTable.setItems(familyList);
            familyTable.refresh();
        }
    }

    @FXML
    private void onEnter(ActionEvent ae) {

    }

    @FXML
    private void delete() {
        selectedItem = (Base) familyTable.getSelectionModel().getSelectedItem();
        if (selectedItem == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
//            alert.initOwner(dialogStage);
            alert.setContentText("Family is not selected");
            alert.showAndWait();
        } else {
            if (isDeleteOk()) {
                try {
                    baseDao.deleteFamilyById(selectedItem.getId());
                    loadFamilyTable();
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
        createForm("view/addFrm.fxml", "Add Family", true);
        loadFamilyTable();
        System.out.println("gen_id " +gen_id);
    }

    @FXML
    private void edit() {

        selectedItem = (Base) familyTable.getSelectionModel().getSelectedItem();
        if (selectedItem == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
//            alert.initOwner(dialogStage);
            alert.setContentText("Family is not selected");
            alert.showAndWait();
        } else {            
            editForm("view/addFrm.fxml", "Edit Family");
        }
        loadFamilyTable();
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
            controller.setCombos_id(1);
            controller.setIsNew(isNew); 
            controller.setDialogStage(stage);            
            stage.showAndWait();
            gen_id = controller.getModel().getId();
            if(gen_id!=null){
                System.out.println("salam");
                familyTable.getSelectionModel().selectAll();
                
            }

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
            controller.setCombos_id(1);
            controller.init();
            controller.setDialogStage(stage);
            stage.showAndWait();

        } catch (IOException ex) {
            Logger.getLogger(CollectionDataBase.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
