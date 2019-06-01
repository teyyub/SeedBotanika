package com.botanik.controller;

import com.botanik.Seed;

import com.botanik.dao.impl.LocationDataDAOJDBC;

import com.botanik.dao.intf.LocationDataDAO;
import com.botanik.model.Country;
import com.botanik.model.LocationDataBase;
import com.botanik.model.Region;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Optional;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
public class LocationDataController {

    private LocationDataDAO dao = new LocationDataDAOJDBC();

    @FXML
    TableView mainTable;

    @FXML
    private TableColumn<LocationDataBase, String> colDistrict;
    @FXML
    private TableColumn<LocationDataBase, String> colLatitude;
    @FXML
    private TableColumn<LocationDataBase, String> colLatMethod;
    @FXML
    private TableColumn<LocationDataBase, String> colGrid;
    @FXML
    private TableColumn<LocationDataBase, String> colAltitude;
    @FXML
    private TableColumn<LocationDataBase, String> colDescription;
    @FXML
    private TableColumn<LocationDataBase, String> colLongtitude;
    @FXML
    private TableColumn<LocationDataBase, String> colLatUnits;
    @FXML
    private TableColumn<LocationDataBase, String> colGps;
    @FXML
    private TableColumn<LocationDataBase, String> colAltitudeMethod;

    ObservableList<LocationDataBase> locationDataList;

    private boolean isNew = false;
    private Stage dialogStage;
    @FXML
    private ComboBox countryCb;
    ObservableList<Country> countryList;
    @FXML
    private ComboBox stateCb;
    ObservableList<Region> regionList;
    @FXML
    private TextField districtTextField, latitudeTextField, latMethodTextField, gridTextField, altitudeTextField,
            descriptionTextField, longtitudeTextField, latUnitsTextField, gpsTextField, altitudeMethodTextField;

    private LocationDataBase searchModel;

    @FXML
    public void initialize() {
        System.out.println("init Herbarium Controller");

        constructTable();
        loadTable();
        loadCombos();

    }

    private void loadCombos() {
//        countryList = FXCollections.observableArrayList(continentDAO.getCountries());
//        countryCb.setItems(countryList);
//
//        regionList = FXCollections.observableArrayList(continentDAO.getRegions());
//        stateCb.setItems(regionList);
    }

    public void constructTable() {
        System.out.println("construct Table");
        PropertyValueFactory<LocationDataBase, String> dist = new PropertyValueFactory<>("district");
        colDistrict.setText("District/Municipality");
        colDistrict.setCellValueFactory(dist);

        PropertyValueFactory<LocationDataBase, String> lat = new PropertyValueFactory<>("latitude");
        colLatitude.setText("Latitude*");
        colLatitude.setCellValueFactory(lat);

        PropertyValueFactory<LocationDataBase, String> latMeth = new PropertyValueFactory<>("latMethod");
        colLatMethod.setText("Lat/Long Method");
        colLatMethod.setCellValueFactory(latMeth);

        PropertyValueFactory<LocationDataBase, String> grid = new PropertyValueFactory<>("grid");
        colGrid.setText("Grid Reference");
        colGrid.setCellValueFactory(grid);

        PropertyValueFactory<LocationDataBase, String> alt = new PropertyValueFactory<>("altitude");
        colAltitude.setText("Altitude (m)");
        colAltitude.setCellValueFactory(alt);

        PropertyValueFactory<LocationDataBase, String> desc = new PropertyValueFactory<>("description");
        colDescription.setText("Description of Location");
        colDescription.setCellValueFactory(desc);

        PropertyValueFactory<LocationDataBase, String> longt = new PropertyValueFactory<>("longtitute");
        colLongtitude.setText("Longtitude*");
        colLongtitude.setCellValueFactory(longt);

        PropertyValueFactory<LocationDataBase, String> lat_unit = new PropertyValueFactory<>("latUnits");
        colLatUnits.setText("Lat/Long Units");
        colLatUnits.setCellValueFactory(lat_unit);

        PropertyValueFactory<LocationDataBase, String> gps = new PropertyValueFactory<>("gps");
        colGps.setText("GPS Datum");
        colGps.setCellValueFactory(gps);

        PropertyValueFactory<LocationDataBase, String> alt_method = new PropertyValueFactory<>("altitudeMethod");
        colAltitudeMethod.setText("Altitude Method");
        colAltitudeMethod.setCellValueFactory(alt_method);
    }

    private void loadTable() {
        locationDataList = FXCollections.observableArrayList(dao.AllLocationDatas());
        mainTable.setItems(locationDataList);
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
            System.out.println("addLocationData clicked");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Seed.class.getResource("view/addLocationData.fxml"));

            AnchorPane page = (AnchorPane) loader.load();

//        // Create the dialog Stage.
            dialogStage = new Stage();
            dialogStage.setTitle("Add Location Data");
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            dialogStage.initStyle(StageStyle.UTILITY);
            dialogStage.initModality(Modality.APPLICATION_MODAL);
            dialogStage.setResizable(false);
            AddLocationDataController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setIsNew(true);

            dialogStage.showAndWait();
            loadTable();

        } catch (IOException e) {
            System.out.println("exception in addLocationData " + e);

        }
    }

    @FXML
    private void edit() throws IOException {
        LocationDataBase model = (LocationDataBase) mainTable.getSelectionModel().getSelectedItem();
        if (model != null) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Seed.class.getResource("view/addLocationData.fxml"));
            AnchorPane formPane = (AnchorPane) loader.load();
            dialogStage = new Stage();
            dialogStage.initStyle(StageStyle.UTILITY);
            dialogStage.setTitle("Edit Herbarium Specimen");
            dialogStage.setResizable(false);
            Scene scene = new Scene(formPane);
            dialogStage.setScene(scene);
            dialogStage.initModality(Modality.WINDOW_MODAL);
            AddLocationDataController controller = loader.getController();
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

        searchModel = new LocationDataBase(
                countryId(),
                stateId(),
                latitudeTextField.getText(),
                latMethodTextField.getText(),
                gridTextField.getText(),
                altitudeTextField.getText(),
                descriptionTextField.getText(),
                longtitudeTextField.getText(),
                latUnitsTextField.getText(),
                gpsTextField.getText(),
                altitudeMethodTextField.getText());

        locationDataList = FXCollections.observableArrayList(dao.locationDataBySearchModel(searchModel));
        System.out.println("samplingDataList.size " + locationDataList.size());
        mainTable.setItems(locationDataList);
//        loadStatusBar();

    }

    private BigDecimal countryId() {
        if (countryCb.getSelectionModel().getSelectedIndex() == -1) {
            return BigDecimal.valueOf(-1);
        }
        return ((Country) countryCb.getSelectionModel().getSelectedItem()).getId();
    }

    private BigDecimal stateId() {
        if (stateCb.getSelectionModel().getSelectedIndex() == -1) {
            return BigDecimal.valueOf(-1);
        }
        return ((Region) stateCb.getSelectionModel().getSelectedItem()).getId();
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
                LocationDataBase model = (LocationDataBase) mainTable.getSelectionModel().getSelectedItem();
                mainTable.getItems().remove(index);
                dao.delete(model.getId());
            }
        }
    }

    @FXML
    private void clear() {
        countryCb.getSelectionModel().clearSelection();
        stateCb.getSelectionModel().clearSelection();
        districtTextField.clear();
        latitudeTextField.clear();
        latMethodTextField.clear();
        gridTextField.clear();
        altitudeTextField.clear();
        descriptionTextField.clear();
        longtitudeTextField.clear();
        latUnitsTextField.clear();
        gpsTextField.clear();
        altitudeTextField.clear();
        altitudeMethodTextField.clear();

    }
}
