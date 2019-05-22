package com.botanik.controller;

import com.botanik.Seed;
import com.botanik.dao.impl.HerbariumSpecimenDAOJDBC;
import com.botanik.dao.intf.HerbariumSpecimenDAO;
import com.botanik.model.Base;
import com.botanik.model.HerbariumSpecimenBase;
import com.botanik.model.HerbariumSpecimenSearch;
import java.io.IOException;
import java.util.Optional;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.controlsfx.control.StatusBar;

/**
 *
 * @author USER
 */
public class HerbariumSpecimenController {

    private HerbariumSpecimenBase baseModel;
    private AnchorPane formPane;
    private Stage primaryStage;
    HerbariumSpecimenDAO dao = new HerbariumSpecimenDAOJDBC();
    @FXML
    private TextField numberTextField;

    
    
    @FXML
    private ComboBox<Base> dublicatedCb;
    private ObservableList<Base> dublicates;
    
    @FXML
    private ComboBox<Base> locationCb;
    private ObservableList<Base> combos;

    @FXML
    private CheckBox isHerbarium ;

    @FXML
    private StatusBar statusBar;

    @FXML
    TableView herbariumTbl;

    @FXML
    private TableColumn<HerbariumSpecimenSearch, String> colNumber;
    @FXML
    private TableColumn<HerbariumSpecimenSearch, String> colLocation;
    @FXML
    private TableColumn<HerbariumSpecimenSearch, String> colSpecimen;
    @FXML
    private TableColumn<HerbariumSpecimenSearch, String> colKew;

    ObservableList<HerbariumSpecimenSearch> herbariumList;

    @FXML
    public void initialize() {
        System.out.println("init Herbarium Controller");

        constructTable();
        loadTable();
        loadCombo();

    }

    private void loadTable() {
//        herbariumList = FXCollections.observableArrayList(dao.herbariumSpecimen());
//        herbariumTbl.setItems(herbariumList);
    }

    private void loadCombo() {
//        combos = FXCollections.observableArrayList(dao.locationHerbariumSpecimen());
//        locationCb.setItems(combos);
    }

    public void constructTable() {
        System.out.println("construct Table");
        PropertyValueFactory<HerbariumSpecimenSearch, String> number = new PropertyValueFactory<>("number");
        colNumber.setText("Number");
        colNumber.setCellValueFactory(number);

        PropertyValueFactory<HerbariumSpecimenSearch, String> location = new PropertyValueFactory<>("location");
        colLocation.setText("Location");
        colLocation.setCellValueFactory(location);

        PropertyValueFactory<HerbariumSpecimenSearch, String> specimen = new PropertyValueFactory<>("yesHerbarium");
        colSpecimen.setText("HerBarium Specimen");
        colSpecimen.setCellValueFactory(specimen);

        PropertyValueFactory<HerbariumSpecimenSearch, String> kew = new PropertyValueFactory<>("yesToKew");
        colKew.setText("Sent to Kew");
        colKew.setCellValueFactory(kew);

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
    private void create() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Seed.class.getResource("view/addHerbariumSpecimen.fxml"));
        formPane = (AnchorPane) loader.load();
        primaryStage = new Stage();
        primaryStage.initStyle(StageStyle.UTILITY);
        primaryStage.setTitle("Add Herbarium Specimen");
//        primaryStage.setResizable(false);
        Scene scene = new Scene(formPane);
        primaryStage.setScene(scene);
        primaryStage.initModality(Modality.WINDOW_MODAL);
        AddHerbariumSpecimenController controller = loader.getController();
        controller.setDialogStage(primaryStage);
        controller.setIsNew(true);
        primaryStage.showAndWait();
        
        loadTable();
        
        
    }

    @FXML
    private void edit() throws IOException {
        HerbariumSpecimenSearch model = (HerbariumSpecimenSearch) herbariumTbl.getSelectionModel().getSelectedItem();
        if (model != null) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Seed.class.getResource("view/addHerbariumSpecimen.fxml"));
            formPane = (AnchorPane) loader.load();
            primaryStage = new Stage();
            primaryStage.initStyle(StageStyle.UTILITY);
            primaryStage.setTitle("Edit Herbarium Specimen");
            primaryStage.setResizable(false);
            Scene scene = new Scene(formPane);
            primaryStage.setScene(scene);
            primaryStage.initModality(Modality.WINDOW_MODAL);
            AddHerbariumSpecimenController controller = loader.getController();
            controller.setSearchModel(model);
            controller.setIsNew(false);
            controller.setDialogStage(primaryStage);
            primaryStage.showAndWait();
            loadTable();
        } else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(primaryStage);
//            alert.setTitle("No Selection");
            alert.setHeaderText("No Selection");
            alert.setContentText("Please select a item in the table.");

            alert.showAndWait();
        }
    }

    @FXML
    private void delete() {
        int index = herbariumTbl.getSelectionModel().getSelectedIndex();
        if (index == -1) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(primaryStage);
            alert.setTitle("Warning");
//            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText("Select at least one element");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.initOwner(primaryStage);
            alert.setTitle("Delete");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText("Doy you want to delte this item?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                HerbariumSpecimenSearch model = (HerbariumSpecimenSearch) herbariumTbl.getSelectionModel().getSelectedItem();
                herbariumTbl.getItems().remove(index);
                dao.delete(model.getId());
            }
        }
    }

    @FXML
    private void search() {
//        baseModel = new HerbariumSpecimenBase(numberTextField.getText(),
//                locationId(), herbariumSelected(), kewSelected());
//
//        herbariumList = FXCollections.observableArrayList(dao.herbariumSpecimenByModel(baseModel));
//        herbariumTbl.setItems(herbariumList);
//        loadStatusBar();

    }

    private void loadStatusBar() {
        statusBar.setPrefWidth(2000);
        System.out.println("with " + statusBar.getPrefWidth() + " height " + statusBar.getPrefHeight() + " "
                + statusBar.getText() + " " + statusBar.getLeftItems()
        );
        statusBar.setText("Hello");
        statusBar.getLeftItems().add(new Button("Info"));
    }

    @FXML
    private void clear() {
        numberTextField.clear();
        locationCb.getSelectionModel().clearSelection();
        isHerbarium.setSelected(false);
       
    }

    private boolean herbariumSelected() {
        return isHerbarium.isSelected();
    }

  

    private Number locationId() {
        if (locationCb.getSelectionModel().getSelectedIndex() != -1) {
            return locationCb.getSelectionModel().getSelectedItem().getId();
        }
        return -1;
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

}
