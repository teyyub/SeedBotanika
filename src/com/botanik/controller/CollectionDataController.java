package com.botanik.controller;

import com.botanik.Seed;

import com.botanik.dao.impl.CollectionDataDAOJDBC;

import com.botanik.dao.intf.CollectionDataDAO;
import com.botanik.model.Base;
import com.botanik.model.CollectionDataBase;

import com.botanik.model.CollectionTableModel;
import com.botanik.model.SamplingDataBase;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author USER
 */
public class CollectionDataController {

    private AnchorPane layout;
    ObservableList<Base> organizeIntituteList;
    ObservableList<Base> wildCultivitedList;
    ObservableList<Base> collectorIntituteList;
    List<CollectionDataBase> collectionTable = new ArrayList();
    Stage dialogStage;
//    private Seed botanika;

    public ButtonController buttonController;
    CollectionDataDAO dao = new CollectionDataDAOJDBC();
    @FXML
    private ComboBox organizeInstituteCb, wildCultivitedCb, collectorInstituteCb;

    @FXML
    private TextField collectionNumberField, projectNameField, accessionNumberField;

    @FXML
    private DatePicker dateField;

    @FXML
    TableView mainTable;
    ObservableList<CollectionDataBase> collectionDataList;
    @FXML
    private TableColumn<CollectionTableModel, String> colNumberColumn;
    @FXML
    private TableColumn<CollectionTableModel, String> colProjectName;
    @FXML
    private TableColumn<CollectionTableModel, String> colOrganization;
    @FXML
    private TableColumn<CollectionTableModel, String> colWild;
    @FXML
    private TableColumn<CollectionTableModel, String> colCollector;
    @FXML
    private TableColumn<CollectionTableModel, String> colAccesion;
    @FXML
    private TableColumn<CollectionTableModel, String> colDate;

    public void setButtonController(ButtonController buttonController) {
        this.buttonController = buttonController;
    }

    @FXML
    private void initialize() {
//        System.out.println(buttonController.toString());
        loadCombos();
        constructTable();
        loadTable();
    }

    private void loadCombos() {
        organizeIntituteList = FXCollections.observableArrayList(dao.organizeInstitute());
        wildCultivitedList = FXCollections.observableArrayList(dao.wildCultivited());
        collectorIntituteList = FXCollections.observableArrayList(dao.collectorInstitute());
        organizeInstituteCb.setItems(organizeIntituteList);
        wildCultivitedCb.setItems(wildCultivitedList);
        collectorInstituteCb.setItems(collectorIntituteList);
    }

    public void constructTable() {
        PropertyValueFactory<CollectionTableModel, String> collectionNumber = new PropertyValueFactory<>("collectionNumber");
        colNumberColumn.setCellValueFactory(collectionNumber);

        PropertyValueFactory<CollectionTableModel, String> projectName = new PropertyValueFactory<>("projectName");
        colProjectName.setCellValueFactory(projectName);

        PropertyValueFactory<CollectionTableModel, String> organ = new PropertyValueFactory<>("organisation");
        colOrganization.setCellValueFactory(organ);

        PropertyValueFactory<CollectionTableModel, String> wild = new PropertyValueFactory<>("wild");
        colWild.setCellValueFactory(wild);

        PropertyValueFactory<CollectionTableModel, String> collect = new PropertyValueFactory<>("colector");
        colCollector.setCellValueFactory(collect);

        PropertyValueFactory<CollectionTableModel, String> acces = new PropertyValueFactory<>("accessionNumber");
        colAccesion.setCellValueFactory(acces);

//        collectionTbl.setOnMouseClicked((MouseEvent event) -> {
//            if (event.getClickCount() == 2) {
//                System.out.println("secilmis table " + collectionTbl.getSelectionModel().getSelectedItems());
//                Specimen s = (Specimen) collectionTbl.getSelectionModel().getSelectedItem();
////                collectionTbl = s;
////                editSpecimen();
//            }
//        }
//        );
        mainTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

    }

    private void loadTable() {

        collectionDataList = FXCollections.observableArrayList(dao.collections());
        mainTable.setItems(collectionDataList);
    }

    @FXML
    public void clear() {
        collectionNumberField.clear();
        projectNameField.clear();
        accessionNumberField.clear();
        organizeInstituteCb.getSelectionModel().clearSelection();
        wildCultivitedCb.getSelectionModel().clearSelection();
        collectorInstituteCb.getSelectionModel().clearSelection();

    }

    @FXML
    private void add() {
        try {
            System.out.println("addCollectionData clicked");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Seed.class.getResource("view/addCollectionData.fxml"));

            AnchorPane page = (AnchorPane) loader.load();

//        // Create the dialog Stage.
            dialogStage = new Stage();
            dialogStage.setTitle("Add Collection Data");
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            dialogStage.initStyle(StageStyle.UTILITY);
            dialogStage.initModality(Modality.APPLICATION_MODAL);
            dialogStage.setResizable(false);
            AddCollectionDataController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setIsNew(true);
            dialogStage.showAndWait();
            loadTable();
        } catch (IOException e) {
            System.out.println("exception in addCollectionData " + e);

        }
    }

    @FXML
    private void edit() throws IOException {
        CollectionDataBase model = (CollectionDataBase) mainTable.getSelectionModel().getSelectedItem();
        if (model != null) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Seed.class.getResource("view/addCollectionData.fxml"));
            AnchorPane formPane = (AnchorPane) loader.load();
            dialogStage = new Stage();
            dialogStage.initStyle(StageStyle.UTILITY);
            dialogStage.setTitle("Edit Collection Data");
            dialogStage.setResizable(false);
            Scene scene = new Scene(formPane);
            dialogStage.setScene(scene);
            dialogStage.initModality(Modality.WINDOW_MODAL);
            AddCollectionDataController controller = loader.getController();
            controller.setModel(model);
            controller.setDialogStage(dialogStage);
            dialogStage.showAndWait();
            loadTable();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
//            alert.initOwner(primaryStage);
//            alert.setTitle("No Selection");
            alert.setHeaderText("No Selection");
            alert.setContentText("Please select a item in the table.");

            alert.showAndWait();
        }
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
    public void search() {
        try {
            if (enableSearch()) {
                CollectionDataBase searchModel = new CollectionDataBase(
                        collectionNumberField.getText().trim(),
                        projectNameField.getText().trim(),
                        accessionNumberField.getText().trim(),
                        toDate(dateField.getValue()),
                        organizeInstituteId(),                        
                        wildCultivitedId(),                        
                        collectorInstituteId() );
                collectionTable = dao.collections();
            }
        } catch (Exception ex) {
            Logger.getLogger(CollectionDataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private boolean enableSearch() {
        String errorMessage = "";
        if (collectionNumberField.getText().trim() == null || collectionNumberField.getText().trim().length() == 0) {
            errorMessage += "Enter collection number !\n";
        }

        if (projectNameField.getText().trim() == null || projectNameField.getText().trim().length() == 0) {
            errorMessage += "Enter name!\n";
        }

        if (accessionNumberField.getText().trim() == null || accessionNumberField.getText().trim().length() == 0) {
            errorMessage += "Enter name!\n";
        }

        if (accessionNumberField.getText().trim() == null || accessionNumberField.getText().trim().length() == 0) {
            errorMessage += "Enter name!\n";
        }
        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid");
            alert.setHeaderText("Please enter parametr for searching");
            alert.setContentText("");
            alert.showAndWait();
            return false;
        }
    }

    @FXML
    public void addOrganisation() {

        try {
            System.out.println("create user dialog");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Seed.class.getResource("view/addFrm.fxml"));

            layout = (AnchorPane) loader.load();

            Stage stage = new Stage();
            stage.setTitle("Add Organisation/Institute");
            Scene scene = new Scene(layout);
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            AddFormController controller = loader.getController();
//            controller.choose(true, false, false);
            controller.setDialogStage(stage);

            stage.showAndWait();
            loadCombos();

            System.out.println("salam");
        } catch (IOException ex) {
            Logger.getLogger(CollectionDataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void addWildCultivited() {

        try {
            System.out.println("create user dialog");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Seed.class.getResource("view/addFrm.fxml"));

            layout = (AnchorPane) loader.load();

            Stage stage = new Stage();
            stage.setTitle("Add Wild or Cultivited");
            Scene scene = new Scene(layout);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.initModality(Modality.APPLICATION_MODAL);
            AddFormController controller = loader.getController();
            controller.setDialogStage(stage);
//            controller.choose(false, true, false);
            stage.show();

            System.out.println("salam");
        } catch (IOException ex) {
            Logger.getLogger(CollectionDataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void add_CollectorInstitute() {

        try {
            System.out.println("create user dialog");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Seed.class.getResource("view/addFrm.fxml"));

            layout = (AnchorPane) loader.load();

            Stage stage = new Stage();
            stage.setTitle("Collector Name&Institute");
            Scene scene = new Scene(layout);
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            AddFormController controller = loader.getController();
//            controller.choose(false, false, true);
            controller.setDialogStage(stage);
            stage.showAndWait();

            System.out.println("salam");
        } catch (IOException ex) {
            Logger.getLogger(CollectionDataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private boolean isInputValid() {
        String errorMessage = "";
        if (collectionNumberField.getText().trim() == null || collectionNumberField.getText().trim().length() == 0) {
            errorMessage += "Enter collection number !\n";
        }

//        if (projectNameField.getText().trim() == null || projectNameField.getText().trim().length() == 0) {
//            errorMessage += "Enter name!\n";
//        }
//
//        if (accessionNumberField.getText().trim() == null || accessionNumberField.getText().trim().length() == 0) {
//            errorMessage += "Enter name!\n";
//        }
//
//         if (accessionNumberField.getText().trim() == null || accessionNumberField.getText().trim().length() == 0) {
//            errorMessage += "Enter name!\n";
//        }
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

    private Number organizeInstituteId() {
        if (organizeInstituteCb.getSelectionModel().getSelectedIndex() != -1) {
            Base base = (Base) organizeInstituteCb.getSelectionModel().getSelectedItem();
            return base.getId();
        }
        return -1;
    }

    private Number wildCultivitedId() {
        if (wildCultivitedCb.getSelectionModel().getSelectedIndex() != -1) {
            Base base = (Base) wildCultivitedCb.getSelectionModel().getSelectedItem();
            return base.getId();
        }
        return -1;
    }

    private Number collectorInstituteId() {
        if (collectorInstituteCb.getSelectionModel().getSelectedIndex() != -1) {
            Base base = (Base) collectorInstituteCb.getSelectionModel().getSelectedItem();
            return base.getId();
        }
        return -1;
    }

    @FXML
    public void saveCollectionData() throws Exception {
        try {

            if (isInputValid()) {
                CollectionDataBase saveModel = new CollectionDataBase(
                        collectionNumberField.getText().trim(),
                        projectNameField.getText().trim(),
                        accessionNumberField.getText().trim(),
                        toDate(dateField.getValue()),
                        organizeInstituteId(), 
                        wildCultivitedId(),  
                        collectorInstituteId() 
                );

                dao.save(saveModel);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    private Date toDate(LocalDate value) throws Exception {
        try {
            Instant instant = Instant.from(value.atStartOfDay(ZoneId.systemDefault()));
            Date date = Date.from(instant);
            return date;
        } catch (Exception e) {
        }
        return null;

    }

}
