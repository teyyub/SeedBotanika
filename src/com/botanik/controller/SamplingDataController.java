package com.botanik.controller;

import com.botanik.Seed;
import com.botanik.dao.impl.SamplingDAOJDBC;
import com.botanik.dao.intf.SamplingDataDAO;
import com.botanik.model.HerbariumSpecimenSearch;
import com.botanik.model.SamplingDataBase;
import java.io.IOException;
import java.util.Optional;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author teyyub
 */
public class SamplingDataController {

    private SamplingDataDAO dao = new SamplingDAOJDBC();
    @FXML
    TableView mainTable;

    @FXML
    private TableColumn<SamplingDataBase, String> colNumberSample;
    @FXML
    private TableColumn<SamplingDataBase, String> colNumberFood;
    @FXML
    private TableColumn<SamplingDataBase, String> colArea;
    @FXML
    private TableColumn<SamplingDataBase, String> colPercentage;
    @FXML
    private TableColumn<SamplingDataBase, String> colNote;

    ObservableList<SamplingDataBase> samplingDataList;

    private boolean isNew = false;
    private Stage dialogStage;
    @FXML
    private TextField numberSampleTextField, numberFoodTextField, areaSampleTextField, percentageTextField;
    @FXML
    private TextArea note;

    private SamplingDataBase searchModel;

    @FXML
    public void initialize() {
        System.out.println("init Herbarium Controller");

        constructTable();
        loadTable();

    }

    public void constructTable() {
        System.out.println("construct Table");
        PropertyValueFactory<SamplingDataBase, String> numberSample = new PropertyValueFactory<>("numberSample");
        colNumberSample.setText("Number of Plants Sampled");
        colNumberSample.setCellValueFactory(numberSample);

        PropertyValueFactory<SamplingDataBase, String> numberFood = new PropertyValueFactory<>("numberFood");
        colNumberFood.setText("Number of Plants Food");
        colNumberFood.setCellValueFactory(numberFood);

        PropertyValueFactory<SamplingDataBase, String> area = new PropertyValueFactory<>("area");
        colArea.setText("Area Sampled");
        colArea.setCellValueFactory(area);

        PropertyValueFactory<SamplingDataBase, String> percentage = new PropertyValueFactory<>("percentage");
        colPercentage.setText("Percentage of Plants Producing Seed");
        colPercentage.setCellValueFactory(percentage);

        PropertyValueFactory<SamplingDataBase, String> nt = new PropertyValueFactory<>("note");
        colNote.setText("Sampling Notes");
        colNote.setCellValueFactory(nt);
    }

    private void loadTable() {

        samplingDataList = FXCollections.observableArrayList(dao.AllSamplingDatas());
        mainTable.setItems(samplingDataList);
    }

    public boolean isIsNew() {
        return isNew;
    }

    public void setIsNew(boolean isNew) {
        this.isNew = isNew;
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    @FXML
    private void add() {
        try {
            System.out.println("addNewTaxonClicked clicked");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Seed.class.getResource("view/addSamplingData.fxml"));

            AnchorPane page = (AnchorPane) loader.load();

//        // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Add Sampling Data");
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            dialogStage.initStyle(StageStyle.UTILITY);
            dialogStage.initModality(Modality.APPLICATION_MODAL);
            dialogStage.setResizable(false);
            AddSamplingDataController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setIsNew(true);
            dialogStage.showAndWait();
            loadTable();
        } catch (IOException e) {
            System.out.println("exception in addNewTaxonClicked " + e);

        }
    }

    @FXML
    private void edit() throws IOException {
       SamplingDataBase model = (SamplingDataBase) mainTable.getSelectionModel().getSelectedItem();
        if (model != null) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Seed.class.getResource("view/addSamplingData.fxml"));
            AnchorPane formPane = (AnchorPane) loader.load();
            dialogStage = new Stage();
            dialogStage.initStyle(StageStyle.UTILITY);
            dialogStage.setTitle("Edit Herbarium Specimen");
            dialogStage.setResizable(false);
            Scene scene = new Scene(formPane);
            dialogStage.setScene(scene);
            dialogStage.initModality(Modality.WINDOW_MODAL);
            AddSamplingDataController controller = loader.getController();
            controller.setModel(model);
            controller.setIsNew(false);
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
    private void search() {
        searchModel = new SamplingDataBase(
                numberSampleTextField.getText().trim(),
                numberFoodTextField.getText().trim(),
                areaSampleTextField.getText().trim(),
                percentageTextField.getText().trim(),
                note.getText().trim());

        samplingDataList = FXCollections.observableArrayList(dao.samplingDataBySearchModel(searchModel));
        System.out.println("samplingDataList.size " + samplingDataList.size());
        mainTable.setItems(samplingDataList);
//        loadStatusBar();

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
                SamplingDataBase model = (SamplingDataBase) mainTable.getSelectionModel().getSelectedItem();
                mainTable.getItems().remove(index);
                dao.delete(model.getId());
            }
        }
    }

    @FXML
    private void clear() {
        numberSampleTextField.clear();
        numberFoodTextField.clear();
        areaSampleTextField.clear();
        percentageTextField.clear();
        note.clear();
    }
}
