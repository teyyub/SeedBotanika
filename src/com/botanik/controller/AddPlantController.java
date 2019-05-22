 
package com.botanik.controller;

 
import com.botanik.dao.impl.PlanetDAOJDBC;
import com.botanik.dao.intf.PlanetDAO;
import com.botanik.model.Base;
import com.botanik.model.Family;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

/**
 *
 * @author USER
 */
public class AddPlantController {
    private Stage dialogStage;
    PlanetDAO dao = new PlanetDAOJDBC();
    @FXML
    private ComboBox 
          familyCb, genusCb,speciesAuthorCb;
    
    private ObservableList<Base> familyCombos;
    private ObservableList<Base> genusCombos;
    private ObservableList<Base> speciesAuthorsCombos;
    
     @FXML
    public void initialize() {
        System.out.println("init Herbarium Controller");
 
        loadCombo();

    }
     private void loadCombo() {
        familyCombos = FXCollections.observableArrayList(dao.families());
        familyCb.setItems(familyCombos);
    }
    
    @FXML
    private void save(){
        if(isInputValid()){
            System.out.println("save");
        }
    }
    
    
    private Number familyId(){
        if(familyCb.getSelectionModel().getSelectedIndex()==-1)
            return -1;
        Family f = (Family)(familyCb.getSelectionModel().getSelectedItem());
        return f.getId();
    }
    
     private boolean isInputValid() {
        String errorMessage = "";
        if (familyId().equals(-1)) {
            errorMessage += "Enter Family !\n";
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
            alert.show();
            return false;
        }
    }
}
