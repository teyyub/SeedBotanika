package com.botanik.controller;

import com.botanik.dao.impl.CombosDAOJDBC;
import com.botanik.dao.impl.SeedDAOJDBC;
import com.botanik.dao.intf.CombosDAO;
import com.botanik.dao.intf.SeedDAO;
import com.botanik.model.CollectionDataBase;
import com.botanik.model.DefaultDate;
import com.botanik.model.DefaultImage;
import com.botanik.model.ImageFile;
import com.botanik.model.PlantView;
import com.botanik.model.SamplingDataView;
import com.botanik.model.SeedMorphologyView;
import com.botanik.model.SeedView;
import com.botanik.model.SeedWeightView;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListCell;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.util.StringConverter;

/**
 *
 * @author teyyub , 9:32:58 AM
 */
public class EditRegularUserController {

    private SeedView seedView = new SeedView();
    private final SeedDAO daoSeed = new SeedDAOJDBC();
    private CombosDAO baseDao = new CombosDAOJDBC();
    private CollectionDataBase collectionModel;
    private PlantView plantView;
    DefaultImage defaultImage;
    @FXML
    private TabPane viewTab;
    @FXML
    private ImageView seedImage;
     
    @FXML
    private TextField seedIdTextField, habitatTextField, orgInsTextField, familyTextField,
            famAzeTextField, taxonTextField, taxonAzeTextField, wildOrCultTextField, collectorsTextField,
            countryTextField, districtTextField, locationTextField,
            soilTypeTextField, assSpeciesTextField, herbariumLocationTextField,
            longtitudeTextField, altitudeTextField, plantFromTextField,
            heightTextField, landTextField, geologyTextField, aspectTextField, factorTextField, soilTextField,
            associatedSpeciesTextField, slopeTextField, landUseTextField,
            numberSampleTextField, numberFoodTextField, areaSampleTextField, weight_1000, typeOfWeight, fruit_weight,
            sizeTextField, fruitType, slengthTextField, swidthTextField, aidsTextField, configureTextfield, embrioTextField;

    @FXML
    private TextArea plantDescTextArea, perfruitTextField;
    @FXML
    private DatePicker dateCollected;

    @FXML
    private void handleTab() {
        loadSelectedTab(tabIndex());
    }

    public EditRegularUserController() {
//        loadView(new Locale("en", "EN"));

    }

    @FXML
    public void initialize() {
    }

    private int tabIndex() {
        return viewTab.getSelectionModel().getSelectedIndex();
    }

    public void loadBySeedId(Number id) {
        seedView = new SeedView();
        seedView = daoSeed.SeedById(id);
        handleTab();
    }

    private void loadSelectedTab(int index) {
        switch (index) {
            case 0:
                handlePlantData();
                break;
            case 1:
                handleCollection();
                break;

            default:
                break;
        }
    }

    private void handlePlantData() {

        plantView = seedView.getPlantView();
        if (plantView.getId() != null) {
            seedIdTextField.setText(String.format("%07d", seedView.getId()));
            orgInsTextField.setText(plantView.getOrgInst());
            familyTextField.setText(plantView.getFamily());
            famAzeTextField.setText(plantView.getFamAze());
            taxonTextField.setText(plantView.getTaxon());
            taxonAzeTextField.setText(plantView.getTaxAze());
            wildOrCultTextField.setText(plantView.getWild());
            collectorsTextField.setText(plantView.getCollectors());
            countryTextField.setText(plantView.getCountry());
            districtTextField.setText(plantView.getDistrict());
            longtitudeTextField.setText(plantView.getLongtitude());
            altitudeTextField.setText(plantView.getAltitude());
            plantDescTextArea.setText(plantView.getPlantDesc());
            habitatTextField.setText(plantView.getHabitat());
            factorTextField.setText(plantView.getFactor());
            soilTypeTextField.setText(plantView.getSoilType());
            assSpeciesTextField.setText(plantView.getAssSpecies());
            herbariumLocationTextField.setText(plantView.getHerbariumNumber() + " " + plantView.getHerbariumLocation());
            plantFromTextField.setText(plantView.getPlantfrom());
            locationTextField.setText(plantView.getLocation());
            dateCollected.setValue(new DefaultDate(plantView.getCollectedDate()).toLocalDate());

            defaultImage = plantView.getDefaultImage();
            if (defaultImage != null) {
                File file1 = defaultImage.readFile();
                if (file1 != null) {
                    try {
                        seedImage.setImage(new ImageFile().image(file1));

                    } catch (MalformedURLException ex) {
                        Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    seedImage.setImage(null);
                }

            }

        } else {
            seedIdTextField.setText(String.format("%07d", baseDao.getId()));
        }

    }

    private void handleCollection() {

        SamplingDataView sdv = seedView.getSampling();
        if (sdv != null) {
            numberSampleTextField.setText(sdv.getNumberSample());
            numberFoodTextField.setText(sdv.getNumberFood());
            areaSampleTextField.setText(sdv.getArea());
        }
        SeedWeightView swv = seedView.getSeedWeight();
        if (swv != null) {
            weight_1000.setText(swv.getWeight_1000());
            typeOfWeight.setText(swv.getTypeWeight());
            fruit_weight.setText(swv.getFruit_weight());
            perfruitTextField.setText(swv.getPerfruit());
        }

        SeedMorphologyView smv = seedView.getMorphology();
        if (smv != null) {
            sizeTextField.setText(smv.getSize());
            fruitType.setText(smv.getType());
            slengthTextField.setText(smv.getLength());
            swidthTextField.setText(smv.getWidth());
            heightTextField.setText(smv.getHeight());
            aidsTextField.setText(smv.getAid());
            configureTextfield.setText(smv.getConfiguration());
            embrioTextField.setText(smv.getEmbrio());
        }
//        collectionModel = defaultSeed.getCollection();
//        if ((collectionModel != null) && (collectionModel.getId() != null)) {
////            collectionNumberTextField.setText(collectionModel.getCollectionNumber());
////            nameField.setText(collectionModel.getProjectName());
////            accessionTextField.setText(collectionModel.getAccessionNumber());
//            dateCollected.setValue(new DefaultDate(collectionModel.getDateCollection()).toLocalDate());
//
//        }
//        loadCollectionOrganizationCombo();
//        loadCollectionMainCollectorCombo();
//        loadWildOrCultivetedCombo();
    }

    private ComboBox<Locale> createComboBox() {
        ComboBox<Locale> comboBox = new ComboBox<>();
        ObservableList<Locale> options = FXCollections.observableArrayList(Locale.ENGLISH, Locale.GERMAN);
        comboBox.setItems(options);
        comboBox.setConverter(new StringConverter<Locale>() {
            @Override
            public String toString(Locale object) {
                return object.getDisplayLanguage();
            }

            @Override
            public Locale fromString(String string) {
                return null;
            }
        });
        comboBox.setCellFactory(p -> new LanguageListCell());
        comboBox.getSelectionModel().selectFirst();

        comboBox.setOnAction(event -> loadView(comboBox.getSelectionModel().getSelectedItem()));
        return comboBox;
    }

    private void loadView(Locale locale) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();

            // Here, just the resource bundles name is mentioned. You can add support for more languages
            // by adding more properties-files with language-specific endings like
            // "E_13_Internationalization_fr.properties".
            fxmlLoader.setResources(ResourceBundle.getBundle("com/botanik/resources/english", locale));
            fxmlLoader.load(this.getClass().getResource("/com/botanik/recources/E_13_Internationalization.fxml").openStream());    
//            Pane pane = (BorderPane) fxmlLoader.load(this.getClass().getResource("/com/e_13_internationalization/E_13_Internationalization.fxml").openStream());
//            borderPane.setCenter(pane);
        } catch (IOException ex) {
        }
    }

    class LanguageListCell extends ListCell<Locale> {

        @Override
        protected void updateItem(Locale item, boolean empty) {
            super.updateItem(item, empty);
            if (item != null) {
                setText(item.getDisplayLanguage());
            }
        }
    }

}
