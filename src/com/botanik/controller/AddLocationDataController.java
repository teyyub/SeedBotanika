package com.botanik.controller;

 
import com.botanik.dao.impl.LocationDataDAOJDBC;
 
import com.botanik.dao.intf.LocationDataDAO;
import com.botanik.model.Country;
import com.botanik.model.LocationDataBase;
import com.botanik.model.Region;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author teyyub
 */
public class AddLocationDataController {

    private final LocationDataDAO dao = new LocationDataDAOJDBC();
    private LocationDataBase model;
    private Stage dialogStage;
    private boolean isNew;
//    ContinentDAO continentDAO = new ContinentDAOJDBC();
    @FXML
    private ComboBox countryCb;
    ObservableList<Country> countryList;
    @FXML
    private ComboBox stateCb;
    ObservableList<Region> regionList;
    @FXML
    private TextField districtTextField, latitudeTextField, latMethodTextField, gridTextField, altitudeTextField,
            descriptionTextField, longtitudeTextField, latUnitsTextField, gpsTextField, altitudeMethodTextField;

    @FXML
    public void initialize() {

        loadCombos();

    }

    private void loadCombos() {
//        countryList = FXCollections.observableArrayList(continentDAO.getCountries());
//        countryCb.setItems(countryList);
//
//        regionList = FXCollections.observableArrayList(continentDAO.getRegions());
//        stateCb.setItems(regionList);
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
        }
//        dialogStage.close();
    }

    private void saveModel() {
        model = new LocationDataBase(
                countryId(),
                stateId(),
                latitudeTextField.getText().trim(),
                latMethodTextField.getText().trim(),
                gridTextField.getText().trim(),
                altitudeTextField.getText().trim(),
                descriptionTextField.getText().trim(),
                longtitudeTextField.getText().trim(),
                latUnitsTextField.getText().trim(),
                gpsTextField.getText().trim(),
                altitudeMethodTextField.getText().trim());
        dao.save(model);
    }

    private void updateModel() {
        Number id = model.getId();
        model = new LocationDataBase(
                id,
                countryId(),
                stateId(),                
                latitudeTextField.getText().trim(),
                latMethodTextField.getText().trim(),
                gridTextField.getText().trim(),
                altitudeTextField.getText().trim(),
                descriptionTextField.getText().trim(),
                longtitudeTextField.getText().trim(),
                latUnitsTextField.getText().trim(),
                gpsTextField.getText().trim(),
                altitudeMethodTextField.getText().trim());

        dao.update(model);
    }

    private Number countryId() {
        if (countryCb.getSelectionModel().getSelectedIndex() == -1) {
            return -1;
        }
        return ((Country) countryCb.getSelectionModel().getSelectedItem()).getId();
    }

    private Number stateId() {
        if (stateCb.getSelectionModel().getSelectedIndex() == -1) {
            return -1;
        }
        return ((Region) stateCb.getSelectionModel().getSelectedItem()).getId();
    }

    private boolean isValid() {
        String errorMessage = "";
        if (districtTextField.getText().trim() == null || districtTextField.getText().trim().length() == 0) {
            errorMessage += "Enter  District !\n";
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

    public void setModel(LocationDataBase model) {
        this.model = model;       
        latitudeTextField.setText(model.getLatitude());
        latMethodTextField.setText(model.getLatMethod());
        gridTextField.setText(model.getGrid());
        altitudeTextField.setText(model.getAltitude());
        descriptionTextField.setText(model.getDescription());
        longtitudeTextField.setText(model.getLongtitude());
        latUnitsTextField.setText(model.getLatUnits());
        gpsTextField.setText(model.getGps());
        altitudeMethodTextField.setText(model.getAltitudeMethod());
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setIsNew(boolean isNew) {
        this.isNew = isNew;
    }

}
