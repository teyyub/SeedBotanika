package com.botanik.controller;

import com.botanik.Seed;
import com.botanik.dao.impl.CollectionDataDAOJDBC;
import com.botanik.dao.impl.CombosDAOJDBC;
import com.botanik.dao.impl.FileOperationDAOJDBC;
import com.botanik.dao.impl.HabitatDataDAOJDBC;
import com.botanik.dao.impl.HerbariumSpecimenDAOJDBC;
import com.botanik.dao.impl.LocationDataDAOJDBC;
import com.botanik.dao.impl.PlantDAOJDBC;
import com.botanik.dao.impl.SamplingDAOJDBC;
import com.botanik.dao.impl.SeedDAOJDBC;
import com.botanik.dao.impl.SeedMorphologyDAOJDBC;
import com.botanik.dao.intf.CollectionDataDAO;
import com.botanik.dao.intf.CombosDAO;
import com.botanik.dao.intf.HabitatDataDAO;
import com.botanik.dao.intf.HerbariumSpecimenDAO;
import com.botanik.dao.intf.LocationDataDAO;
import com.botanik.dao.intf.PlantDAO;
import com.botanik.dao.intf.SamplingDataDAO;
import com.botanik.dao.intf.SeedDAO;
import com.botanik.dao.intf.SeedMorphologyDAO;
import com.botanik.model.Base;
import com.botanik.model.CollectionDataBase;
import com.botanik.model.DefaultAlert;
import com.botanik.model.DefaultCombo;
import com.botanik.model.DefaultDate;
import com.botanik.model.DefaultImage;
import com.botanik.model.DefaultSeed;
import com.botanik.model.HabitatDataBase;
import com.botanik.model.HerbariumSpecimenBase;
import com.botanik.model.ImageFile;
import com.botanik.model.LocalIcon;
import com.botanik.model.LocationDataBase;
import com.botanik.model.Plant;
import com.botanik.model.SamplingDataBase;
import com.botanik.model.SeedMorphology;
import com.botanik.model.SeedWeight;
import com.project.file.intf.FileOperation;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.controlsfx.control.textfield.TextFields;

/**
 *
 * @author teyyub , Mar 25, 2018 , 1:38:14 PM
 */
public class MainController implements Initializable {

    private Stage dialogStage;//, primaryStage;
    private AddFormController controller;
    private CombosDAO baseDao = new CombosDAOJDBC();
    private CollectionDataBase collectionModel;
    private LocationDataBase locationModel;
    private Plant plantModel;
    private SamplingDataBase samplingModel;
    private HerbariumSpecimenBase herbariumModel;
    private HabitatDataBase habitatModel;
    private SeedMorphology morphologyModel;
    private SeedWeight seedWeightModel;
//    private SeedModel seedModel = new SeedModel();
    private DefaultSeed defaultSeed = new DefaultSeed();
    //daos
    private final CollectionDataDAO daoCollection = new CollectionDataDAOJDBC();
    private final LocationDataDAO daoLocation = new LocationDataDAOJDBC();
    private final PlantDAO daoPlant = new PlantDAOJDBC();
    private final SeedDAO daoSeed = new SeedDAOJDBC();
    private final SamplingDataDAO daoSampling = new SamplingDAOJDBC();
    private final HerbariumSpecimenDAO daoHerbarium = new HerbariumSpecimenDAOJDBC();
    private final HabitatDataDAO daoHabitat = new HabitatDataDAOJDBC();
    private final SeedMorphologyDAO daoSeedMorphology = new SeedMorphologyDAOJDBC();
    private FileOperation fileOper = new FileOperationDAOJDBC();
    DefaultImage defaultImage;
    @FXML
    private ImageView seedImage;
    @FXML
    private TextField nameField, collectionNumberTextField, accessionTextField, heightTextField;

    /////location data view element
    @FXML
    private TextField latitudeTextField, latMethodTextField, gridTextField,
            altitudeTextField, longtitudeTextField, latUnitsTextField,
            gpsTextField, altitudeMethodTextField;
    @FXML
    private TextArea descTextField;
    @FXML
    private ComboBox countryCb, stateCb;

    ///end of declaration ////
    @FXML
    private TextField habitatTextField, landTextField, geologyTextField, aspectTextField, factorTextField, soilTextField,
            associatedSpeciesTextField, slopeTextField, landUseTextField;

    //herbarium view
    @FXML
    private TextField herbariumNumberTextField, voucherTextField;

    @FXML
    private TextField numberSampleTextField, numberFoodTextField, areaSampleTextField, percentageTextField;
    @FXML
    private TextArea noteTextArea, plantDescTextArea, siteNotesTextArea;

    //morphology view
    @FXML
    private TextField sizeTextField, slengthTextField, swidthTextField, sheightTextField, configureTextfield;

    @FXML
    private ComboBox dispersalAidsCb, embrioCb, fruitTypeCb, typeWeightCb;

    @FXML
    private ComboBox habitatCb, landFormCb, aspectCb, factorsCb, soilTypeCb, slopeCb, landUseCb;

    //seed weight view
    @FXML
    private TextField weight_1000, weight_100, fruit_weight;

    @FXML
    private TextArea perfruitTextField;

    @FXML
    private CheckBox isHerbarium, isKew;

    //plant view 
    @FXML
    private ComboBox familyCb, genusCb, speciesCb, rankCb, rankCb2, organisationCb, wildCb, collectorCb,
            locationCb, dublicatedCb,
            speciesAuthorCb, infraSpeciesCb, infraAuthorCb, identificationStatusCb, identifierInstituteCb,
            usesCb, vernacularNameCb, assessmentInformationCb, otherKeyCb, plantFromCb, infraSpecies2Cb, infraAuthor2Cb, identifiedFromCb;

    @FXML
    private TextField seedIdTextField, familyText;

    //end of view
    @FXML
    private DatePicker identDate, dateCollected;

    ObservableList<Base> combosList;
    public boolean isCollection;
    public boolean isSeedWeightNew = true;
    public boolean isSeedMorphologyNew = true;
    public boolean isHabitatNew = true;
    public boolean isHerbariumNew = true;
    public boolean isSamplingNew = true;
    public boolean isLocationNew = true;
    public boolean isCollectionNew = true;
    public boolean isPlantNew = true;
    public boolean isSeedNew = true;
    public Number seedId;

    private DefaultCombo defaultCombo;

    @FXML
    private TabPane tab;

    private AutoCompletionBinding<Base> bindAutoCompletion;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        escape(familyCb);
        escape(genusCb);
        escape(speciesCb);
        escape(speciesAuthorCb);
        escape(rankCb);
        escape(rankCb2);
        escape(infraSpeciesCb);
        escape(infraSpecies2Cb);
        escape(infraAuthorCb);
        escape(infraAuthor2Cb);
        escape(identificationStatusCb);
        escape(identifierInstituteCb);
        escape(usesCb);
        escape(vernacularNameCb);
        escape(assessmentInformationCb);
        escape(otherKeyCb);
        escape(plantFromCb);
        escape(identifiedFromCb);
        escape(organisationCb);
        escape(wildCb);
        escape(collectorCb);
        escape(countryCb);
        escape(stateCb);
        escape(locationCb);
        escape(fruitTypeCb);
        escape(embrioCb);
        escape(dispersalAidsCb);

    }

    private void loadFamilyAutoCompletion() {
        bindAutoCompletion = TextFields.bindAutoCompletion(familyCb.getEditor(), familyCb.getItems());
    }

    private void loadGenusAutoCompletion() {
        bindAutoCompletion = TextFields.bindAutoCompletion(genusCb.getEditor(), genusCb.getItems());
    }

    private void loadSpeciesAutoCompletion() {
        bindAutoCompletion = TextFields.bindAutoCompletion(speciesCb.getEditor(), speciesCb.getItems());
    }

    private void loadSpeciesAuthorAutoCompletion() {
        bindAutoCompletion = TextFields.bindAutoCompletion(speciesAuthorCb.getEditor(), speciesAuthorCb.getItems());
    }

    private void loadRankAutoCompletion() {
        bindAutoCompletion = TextFields.bindAutoCompletion(rankCb.getEditor(), rankCb.getItems());
    }

    private void loadInfSpeciesAutoCompletion() {
        bindAutoCompletion = TextFields.bindAutoCompletion(infraSpeciesCb.getEditor(), infraSpeciesCb.getItems());
    }

    private void loadInfSpeciesAuthorAutoCompletion() {
        bindAutoCompletion = TextFields.bindAutoCompletion(infraAuthorCb.getEditor(), infraAuthorCb.getItems());
    }

    private void loadRank2AutoCompletion() {
        bindAutoCompletion = TextFields.bindAutoCompletion(rankCb2.getEditor(), rankCb2.getItems());
    }

    private void loadIdenStatusAutoCompletion() {
        bindAutoCompletion = TextFields.bindAutoCompletion(identificationStatusCb.getEditor(), identificationStatusCb.getItems());
    }

    private void loadIdenNameAutoCompletion() {
        bindAutoCompletion = TextFields.bindAutoCompletion(identifierInstituteCb.getEditor(), identifierInstituteCb.getItems());
    }

    private void loadUsesAutoCompletion() {
        bindAutoCompletion = TextFields.bindAutoCompletion(usesCb.getEditor(), usesCb.getItems());
    }

    private void loadVernacularAutoCompletion() {
        bindAutoCompletion = TextFields.bindAutoCompletion(vernacularNameCb.getEditor(), vernacularNameCb.getItems());
    }

    private void loadAssInfAutoCompletion() {
        bindAutoCompletion = TextFields.bindAutoCompletion(assessmentInformationCb.getEditor(), assessmentInformationCb.getItems());
    }

    private void loadOtherKeyAutoCompletion() {
        bindAutoCompletion = TextFields.bindAutoCompletion(otherKeyCb.getEditor(), otherKeyCb.getItems());
    }

    private void loadPlantFormAutoCompletion() {
        bindAutoCompletion = TextFields.bindAutoCompletion(plantFromCb.getEditor(), plantFromCb.getItems());
    }

    private void loadWildOrCultivitedAuthoCompletion() {
        bindAutoCompletion = TextFields.bindAutoCompletion(wildCb.getEditor(), wildCb.getItems());
    }

    private void loadIdentFromAutoCompletion() {
        bindAutoCompletion = TextFields.bindAutoCompletion(identifiedFromCb.getEditor(), identifiedFromCb.getItems());
    }

    private void loadOrganizationAutoCompletion() {
        bindAutoCompletion = TextFields.bindAutoCompletion(organisationCb.getEditor(), organisationCb.getItems());
    }

    private void loadTypeWeightAuthoCompletion() {
        bindAutoCompletion = TextFields.bindAutoCompletion(typeWeightCb.getEditor(), typeWeightCb.getItems());

    }

    private void loadLocationOfHerbariumAuthoCompletion() {
        bindAutoCompletion = TextFields.bindAutoCompletion(locationCb.getEditor(), locationCb.getItems());
    }

    private void loadDublicatedAuthoCompletion() {
        bindAutoCompletion = TextFields.bindAutoCompletion(dublicatedCb.getEditor(), dublicatedCb.getItems());
    }

    private void loadHabitatAuthoCompletion() {
        bindAutoCompletion = TextFields.bindAutoCompletion(habitatCb.getEditor(), habitatCb.getItems());
    }

    private void loadLandFormAuthoCompletion() {
        bindAutoCompletion = TextFields.bindAutoCompletion(landFormCb.getEditor(), landFormCb.getItems());
    }

    private void loadAspectAuthoCompletion() {
        bindAutoCompletion = TextFields.bindAutoCompletion(aspectCb.getEditor(), aspectCb.getItems());
    }

    private void loadFactorAuthoCompletion() {
        bindAutoCompletion = TextFields.bindAutoCompletion(factorsCb.getEditor(), factorsCb.getItems());
    }

    private void loadSoilTypeAuthoCompletion() {
        bindAutoCompletion = TextFields.bindAutoCompletion(soilTypeCb.getEditor(), soilTypeCb.getItems());
    }

    private void loadSlopeAuthoCompletion() {
        bindAutoCompletion = TextFields.bindAutoCompletion(slopeCb.getEditor(), slopeCb.getItems());
    }

    private void loadLandUseAuthoCompletion() {
        bindAutoCompletion = TextFields.bindAutoCompletion(landUseCb.getEditor(), landUseCb.getItems());
    }

    private void loadFruitTypeAuthoCompletion() {
        bindAutoCompletion = TextFields.bindAutoCompletion(fruitTypeCb.getEditor(), fruitTypeCb.getItems());

    }

    private void loadDispersalAidsAuthoCompletion() {
        System.out.println("dispersalAidsCb");
        bindAutoCompletion = TextFields.bindAutoCompletion(dispersalAidsCb.getEditor(), dispersalAidsCb.getItems());
    }

    private void loadTypeOfEmbrioAuthoCompletion() {
        System.out.println("dispersalAidsCb");
        bindAutoCompletion = TextFields.bindAutoCompletion(embrioCb.getEditor(), embrioCb.getItems());
    }

    @FXML
    private void handleTab() {
        loadSelectedTab(tabIndex());
    }

    private int tabIndex() {
        return tab.getSelectionModel().getSelectedIndex();
    }

    private void loadSelectedTab(int index) {
        switch (index) {
            case 0:
                handlePlantData();
                break;
            case 1:
                handleCollection();
                break;
            case 2:
                handleLocationData();
                break;
            case 3:
                handleHabitatData();
                break;
            case 4:
                handleSample();
                break;
            case 5:
                handleHerbariumSpecimen();
                break;
            case 6:
                handleSeedMorphology();
                break;
            case 7:
                handleSeedWeight();
                break;
            default:
                break;
        }

    }

    private void handlePlantData() {

        plantModel = defaultSeed.getPlant();
        if (plantModel.getId() != null) {
            seedIdTextField.setText(String.format("%07d", defaultSeed.getId()));
            plantDescTextArea.setText(plantModel.getPlantDesc());
            heightTextField.setText(plantModel.getHeight());
            identDate.setValue(new DefaultDate(plantModel.getIdentificationDate()).toLocalDate());

            defaultImage = plantModel.getDefaultImage();
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
        loadFamilyCombos();
        loadGenusCombos();
        loadSpeciesCombos();
        loadRankCombos();
        loadRank2Combos();
        loadInfraSpecies();
        loadInfraSpecies2();
        loadInfraAuthor();
        loadInfraAuthor2();
        loadIdentificationStatus();
        loadIdentifierInstitute();
        loadUses();
        loadVernacularName();
        loadAssessmentInformation();
        loadOtherKey();
        loadPlantFrom();
        loadIdentifiedFrom();
        loadSpeciesAuthor();

    }

    private void handleSeedWeight() {
        loadTypeOfMaterialWeightCombo();
    }

    private void handleHabitatData() {
        habitatModel = defaultSeed.getHabitat();
        if ((habitatModel != null) && (habitatModel.getId() != null)) {
            geologyTextField.setText(habitatModel.getGeology());
            associatedSpeciesTextField.setText(habitatModel.getAssociated());
            siteNotesTextArea.setText(habitatModel.getSiteNotes());
        }
        loadHabitatCombos();
        loadLandFormCombos();
        loadAspectCombos();
        loadFactorAffectingCombos();
        loadSoilTypeCombos();
        loadSlopeCombos();
        loadLandUseCombos();
    }

    private void handleSample() {
        samplingModel = defaultSeed.getSampling();
        if ((samplingModel != null) && (samplingModel.getId() != null)) {
            numberSampleTextField.setText(samplingModel.getNumberSample());
            numberFoodTextField.setText(samplingModel.getNumberFood());
            areaSampleTextField.setText(samplingModel.getArea());
            percentageTextField.setText(samplingModel.getPercentage());
            noteTextArea.setText(samplingModel.getNote());
        }
    }

    private void handleHerbariumSpecimen() {
        herbariumModel = defaultSeed.getHerbarium();
        if ((herbariumModel != null) && (herbariumModel.getId() != null)) {
            isHerbarium.setSelected(herbariumModel.getHerbarium());
            herbariumNumberTextField.setText(herbariumModel.getNumber());
            voucherTextField.setText(herbariumModel.getVoucher());
        }
        loadlocationOfHerbariumCombos();
        loadDublicatedCombos();
    }

    private void handleSeedMorphology() {

        morphologyModel = defaultSeed.getMorphology();
        if ((morphologyModel != null) && (morphologyModel.getId() != null)) {
            sizeTextField.setText(morphologyModel.getSize());
            slengthTextField.setText(morphologyModel.getLength());
            swidthTextField.setText(morphologyModel.getWidth());
            sheightTextField.setText(morphologyModel.getHeight());
            configureTextfield.setText(morphologyModel.getConfiguration());
        }
        loadFruitTypeCombo();
        loadDispersalAidsCombo();
        loadTypeOfEmrioCombo();
    }

    private void handleLocationData() {

        locationModel = defaultSeed.getLocation();
        if ((locationModel != null) && (locationModel.getId() != null)) {
            latitudeTextField.setText(locationModel.getLatitude());
            latMethodTextField.setText(locationModel.getLatMethod());
            gridTextField.setText(locationModel.getGrid());
            altitudeTextField.setText(locationModel.getAltitude());
            descTextField.setText(locationModel.getDescription());
            longtitudeTextField.setText(locationModel.getLongtitude());
            latUnitsTextField.setText(locationModel.getLatUnits());
            gpsTextField.setText(locationModel.getGps());
            altitudeMethodTextField.setText(locationModel.getAltitudeMethod());
        }
        loadLocationCountryCombo();
        loadLocationRegionCombo();

    }

    private void handleCollection() {
        collectionModel = defaultSeed.getCollection();
        if ((collectionModel != null) && (collectionModel.getId() != null)) {
            collectionNumberTextField.setText(collectionModel.getCollectionNumber());
            nameField.setText(collectionModel.getProjectName());
            accessionTextField.setText(collectionModel.getAccessionNumber());
            dateCollected.setValue(new DefaultDate(collectionModel.getDateCollection()).toLocalDate());

        }
        loadCollectionOrganizationCombo();
        loadCollectionMainCollectorCombo();
        loadWildOrCultivetedCombo();
    }

    private void loadLocationCountryCombo() {
        if ((locationModel != null) && (locationModel.getId() != null)) {
            new DefaultCombo(countryCb, 19).loadComboById();
            String txt = new DefaultCombo(countryCb, 19).comboTextById(locationModel.getCountryId());
            new DefaultCombo(countryCb, txt).select();
        } else {
            loadCountryCombos();
        }

    }

    private void loadLocationRegionCombo() {
        if ((locationModel != null) && (locationModel.getId() != null)) {
            new DefaultCombo(stateCb, 20).loadComboById();
            String txt = new DefaultCombo(stateCb, 20).comboTextById(locationModel.getStateId());
            new DefaultCombo(stateCb, txt).select();
        } else {
            loadRegionCombos();
        }
    }

    private void loadCollectionOrganizationCombo() {
        if ((collectionModel != null) && (collectionModel.getId() != null)) {
            new DefaultCombo(organisationCb, 16).loadComboById();
            String txt = new DefaultCombo(organisationCb, 16).comboTextById(collectionModel.getOrganizeInstituteId());
            new DefaultCombo(organisationCb, txt).select();
        } else {
            loadOrganisationCombos();
        }

    }

    private void loadWildOrCultivetedCombo() {
        if ((collectionModel != null) && (collectionModel.getId() != null)) {
            new DefaultCombo(wildCb, 17).loadComboById();
            String txt = new DefaultCombo(wildCb, 17).comboTextById(collectionModel.getWildCultivitedId());
            new DefaultCombo(wildCb, txt).select();
        } else {
            new DefaultCombo(wildCb, 17).loadComboById();
        }

        loadWildOrCultivitedAuthoCompletion();
    }

    private void loadCollectionMainCollectorCombo() {
        if ((collectionModel != null) && (collectionModel.getId() != null)) {
            new DefaultCombo(collectorCb, 18).loadComboById();
            String txt = new DefaultCombo(collectorCb, 18).comboTextById(collectionModel.getCollectorInstituteId());
            new DefaultCombo(collectorCb, txt).select();
        } else {
            loadMainCollectorCombos();
        }
    }

    private void loadInfraSpecies() {
        if (plantModel != null) {
            if (plantModel.getId() != null) {
                new DefaultCombo(infraSpeciesCb, 5).loadComboById();
                String txt = new DefaultCombo(infraSpeciesCb, 5).comboTextById(plantModel.getInfraSpeciesId());
                new DefaultCombo(infraSpeciesCb, txt).select();
            }
        } else {
            new DefaultCombo(infraSpeciesCb, 5).loadComboById();
        }
        new DefaultCombo(infraSpeciesCb, 5).loadComboById();

        loadInfSpeciesAutoCompletion();
    }

    private void loadInfraAuthor() {
        if (plantModel != null) {
            if (plantModel.getId() != null) {
                new DefaultCombo(infraAuthorCb, 6).loadComboById();
                String txt = new DefaultCombo(infraAuthorCb, 6).comboTextById(plantModel.getInfrauthorId());
                new DefaultCombo(infraAuthorCb, txt).select();
            }
        } else {
            new DefaultCombo(infraAuthorCb, 6).loadComboById();
        }
    }

    private void loadIdentificationStatus() {
        if (plantModel != null) {
            if (plantModel.getId() != null) {
                new DefaultCombo(identificationStatusCb, 7).loadComboById();
                String txt = new DefaultCombo(identificationStatusCb, 7).comboTextById(plantModel.getIdentStatusId());
                new DefaultCombo(identificationStatusCb, txt).select();
            }
        } else {
            new DefaultCombo(identificationStatusCb, 7).loadComboById();
        }
        new DefaultCombo(identificationStatusCb, 7).loadComboById();

    }

    private void loadIdentifierInstitute() {
        if (plantModel != null) {
            if (plantModel.getId() != null) {
                new DefaultCombo(identifierInstituteCb, 8).loadComboById();
                String txt = new DefaultCombo(identifierInstituteCb, 8).comboTextById(plantModel.getIdentInstituteId());
                new DefaultCombo(identifierInstituteCb, txt).select();
            }
        } else {
            new DefaultCombo(identifierInstituteCb, 8).loadComboById();
        }
        new DefaultCombo(identifierInstituteCb, 8).loadComboById();

    }

    private void loadSpeciesAuthor() {
        if (plantModel != null) {
            if (plantModel.getId() != null) {
                new DefaultCombo(speciesAuthorCb, 3).loadComboById();
                String txt = new DefaultCombo(speciesAuthorCb, 3).comboTextById(plantModel.getSpeciesAuthorId());
                new DefaultCombo(speciesAuthorCb, txt).select();
            }
        } else {
            new DefaultCombo(speciesAuthorCb, 3).loadComboById();
        }
        new DefaultCombo(speciesAuthorCb, 3).loadComboById();
        loadSpeciesAuthorAutoCompletion();
    }

    private void loadFamilyCombos() {
        if (plantModel != null) {
            if (plantModel.getId() != null) {
                new DefaultCombo(familyCb, 1).loadComboById();
                String txt = new DefaultCombo(familyCb, 1).comboTextById(plantModel.getFamilyId());
                new DefaultCombo(familyCb, txt).select();
            }
        } else {
            new DefaultCombo(familyCb, 1).loadComboById();
        }
        new DefaultCombo(familyCb, 1).loadComboById();
        loadFamilyAutoCompletion();
    }

    private void loadGenusCombos() {

        if (plantModel != null) {
            if (plantModel.getId() != null) {
                new DefaultCombo(genusCb, 2).loadComboById();
                String txt = new DefaultCombo(genusCb, 2).comboTextById(plantModel.getGenusId());
                new DefaultCombo(genusCb, txt).select();
            }
        } else {
            new DefaultCombo(genusCb, 2).loadComboById();
        }
        new DefaultCombo(genusCb, 2).loadComboById();
        loadGenusAutoCompletion();
    }

    private void loadSpeciesCombos() {

        if (plantModel != null) {
            if (plantModel.getId() != null) {
                new DefaultCombo(speciesCb, 24).loadComboById();
                String txt = new DefaultCombo(speciesCb, 24).comboTextById(plantModel.getSpeciesId());
                new DefaultCombo(speciesCb, txt).select();
            }
        } else {

            new DefaultCombo(speciesCb, 24).loadComboById();
        }
        new DefaultCombo(speciesCb, 24).loadComboById();
        loadSpeciesAutoCompletion();
    }

    private void loadRankCombos() {
        if (plantModel != null) {
            if (plantModel.getId() != null) {
                new DefaultCombo(rankCb, 4).loadComboById();
                String txt = new DefaultCombo(rankCb, 4).comboTextById(plantModel.getRankId());
                new DefaultCombo(rankCb, txt).select();
            }
        } else {
            new DefaultCombo(rankCb, 4).loadComboById();
        }
        new DefaultCombo(rankCb, 4).loadComboById();
        loadRankAutoCompletion();
    }

    private void loadRank2Combos() {
        if (plantModel != null) {
            if (plantModel.getId() != null) {
                new DefaultCombo(rankCb2, 4).loadComboById();
                String txt = new DefaultCombo(rankCb2, 4).comboTextById(plantModel.getRank2Id());
                new DefaultCombo(rankCb2, txt).select();
            }
        } else {
            new DefaultCombo(rankCb2, 4).loadComboById();
        }
        new DefaultCombo(rankCb2, 4).loadComboById();
        loadRank2AutoCompletion();
    }

    private void loadUses() {
        if (plantModel != null) {
            if (plantModel.getId() != null) {
                new DefaultCombo(usesCb, 10).loadComboById();
                String txt = new DefaultCombo(usesCb, 10).comboTextById(plantModel.getUsesId());
                new DefaultCombo(usesCb, txt).select();
            }
        } else {
            new DefaultCombo(usesCb, 10).loadComboById();
        }
        new DefaultCombo(usesCb, 10).loadComboById();
        loadUsesAutoCompletion();
    }

    private void loadVernacularName() {
        if (plantModel != null) {
            if (plantModel.getId() != null) {
                new DefaultCombo(vernacularNameCb, 11).loadComboById();
                String txt = new DefaultCombo(vernacularNameCb, 11).comboTextById(plantModel.getVerNameId());
                new DefaultCombo(vernacularNameCb, txt).select();
            }
        } else {
            new DefaultCombo(vernacularNameCb, 11).loadComboById();
        }
        new DefaultCombo(vernacularNameCb, 11).loadComboById();
        loadVernacularAutoCompletion();
    }

    private void loadAssessmentInformation() {
        if (plantModel != null) {
            if (plantModel.getId() != null) {
                new DefaultCombo(assessmentInformationCb, 12).loadComboById();
                String txt = new DefaultCombo(assessmentInformationCb, 12).comboTextById(plantModel.getAssesInforId());
                new DefaultCombo(assessmentInformationCb, txt).select();
            }
        } else {
            new DefaultCombo(assessmentInformationCb, 12).loadComboById();
        }
        new DefaultCombo(assessmentInformationCb, 12).loadComboById();
        loadAssInfAutoCompletion();
    }

    private void loadOtherKey() {
        if (plantModel != null) {
            if (plantModel.getId() != null) {
                new DefaultCombo(otherKeyCb, 13).loadComboById();
                String txt = new DefaultCombo(otherKeyCb, 13).comboTextById(plantModel.getOtherKeyId());
                new DefaultCombo(otherKeyCb, txt).select();
            }
        } else {
            new DefaultCombo(otherKeyCb, 13).loadComboById();
        }
        new DefaultCombo(otherKeyCb, 13).loadComboById();
        loadOtherKeyAutoCompletion();
    }

    private void loadPlantFrom() {
        if (plantModel != null) {
            if (plantModel.getId() != null) {
                new DefaultCombo(plantFromCb, 14).loadComboById();
                String txt = new DefaultCombo(plantFromCb, 14).comboTextById(plantModel.getPlantFormId());
                new DefaultCombo(plantFromCb, txt).select();
            }
        } else {
            new DefaultCombo(plantFromCb, 14).loadComboById();
        }
        new DefaultCombo(plantFromCb, 14).loadComboById();
        loadPlantFormAutoCompletion();
    }

    private void loadInfraSpecies2() {
        if (plantModel != null) {
            if (plantModel.getId() != null) {
                new DefaultCombo(infraSpecies2Cb, 5).loadComboById();
                String txt = new DefaultCombo(infraSpecies2Cb, 5).comboTextById(plantModel.getInfraSpecies2Id());
                new DefaultCombo(infraSpecies2Cb, txt).select();
            }
        } else {
            new DefaultCombo(infraSpecies2Cb, 5).loadComboById();
        }
        new DefaultCombo(infraSpecies2Cb, 5).loadComboById();
        loadInfSpeciesAutoCompletion();
    }

    private void loadInfraAuthor2() {
        if (plantModel != null) {
            if (plantModel.getId() != null) {
                new DefaultCombo(infraAuthor2Cb, 6).loadComboById();
                String txt = new DefaultCombo(infraAuthor2Cb, 6).comboTextById(plantModel.getInfraAuthor2Id());
                new DefaultCombo(infraAuthor2Cb, txt).select();
            }
        } else {
            new DefaultCombo(infraAuthor2Cb, 6).loadComboById();
        }
        new DefaultCombo(infraAuthor2Cb, 6).loadComboById();
        loadInfSpeciesAuthorAutoCompletion();
    }

    private void loadIdentifiedFrom() {
        if (plantModel != null) {
            if (plantModel.getId() != null) {
                new DefaultCombo(identifiedFromCb, 15).loadComboById();
                String txt = new DefaultCombo(identifiedFromCb, 15).comboTextById(plantModel.getIdentFromId());
                new DefaultCombo(identifiedFromCb, txt).select();
            }
        } else {
            new DefaultCombo(identifiedFromCb, 15).loadComboById();
        }
        new DefaultCombo(identifiedFromCb, 15).loadComboById();
        loadIdentFromAutoCompletion();
    }

    private void loadOrganisationCombos() {

        if (seedWeightModel != null) {
            if (seedWeightModel.getId() != null) {
                new DefaultCombo(typeWeightCb, 16).loadComboById();
                String txt = new DefaultCombo(organisationCb, 16).comboTextById(seedWeightModel.getTypeWeightId());
                new DefaultCombo(organisationCb, txt).select();
            }
        } else {
            new DefaultCombo(organisationCb, 16).loadComboById();
        }
        new DefaultCombo(organisationCb, 16).loadComboById();
        loadOrganizationAutoCompletion();
    }

    private void loadMainCollectorCombos() {
        if (seedWeightModel != null) {
            if (seedWeightModel.getId() != null) {
                new DefaultCombo(collectorCb, 18).loadComboById();
                String txt = new DefaultCombo(collectorCb, 18).comboTextById(seedWeightModel.getTypeWeightId());
                new DefaultCombo(collectorCb, txt).select();
            }
        } else {
            new DefaultCombo(collectorCb, 18).loadComboById();
        }
        new DefaultCombo(collectorCb, 18).loadComboById();

    }

    private void loadCountryCombos() {
        if (seedWeightModel != null) {
            if (seedWeightModel.getId() != null) {
                new DefaultCombo(countryCb, 19).loadComboById();
                String txt = new DefaultCombo(countryCb, 19).comboTextById(seedWeightModel.getTypeWeightId());
                new DefaultCombo(countryCb, txt).select();
            }
        } else {
            new DefaultCombo(countryCb, 19).loadComboById();
        }
    }

    private void loadRegionCombos() {
        if (seedWeightModel != null) {
            if (seedWeightModel.getId() != null) {
                new DefaultCombo(stateCb, 19).loadComboById();
                String txt = new DefaultCombo(stateCb, 20).comboTextById(seedWeightModel.getTypeWeightId());
                new DefaultCombo(stateCb, txt).select();
            }
        } else {
            new DefaultCombo(stateCb, 20).loadComboById();
        }

    }

    private void loadFruitTypeCombo() {
        if ((morphologyModel != null) && (morphologyModel.getId() != null)) {
            new DefaultCombo(fruitTypeCb, 22).loadComboById();
            String txt = new DefaultCombo(fruitTypeCb, 22).comboTextById(morphologyModel.getTypeId());
            new DefaultCombo(fruitTypeCb, txt).select();
        } else {
            new DefaultCombo(fruitTypeCb, 22).loadComboById();
        }

        loadFruitTypeAuthoCompletion();
    }

    private void loadDispersalAidsCombo() {
        if ((morphologyModel != null) && (morphologyModel.getId() != null)) {
            new DefaultCombo(dispersalAidsCb, 26).loadComboById();
            String txt = new DefaultCombo(dispersalAidsCb, 26).comboTextById(morphologyModel.getAidId());
            new DefaultCombo(dispersalAidsCb, txt).select();
        } else {
            new DefaultCombo(dispersalAidsCb, 26).loadComboById();
        }
        loadDispersalAidsAuthoCompletion();
    }

    private void loadTypeOfEmrioCombo() {
        if ((morphologyModel != null) && (morphologyModel.getId() != null)) {
            new DefaultCombo(embrioCb, 27).loadComboById();
            String txt = new DefaultCombo(embrioCb, 27).comboTextById(morphologyModel.getEmbrioId());
            new DefaultCombo(embrioCb, txt).select();
        } else {
            new DefaultCombo(embrioCb, 27).loadComboById();
        }
        loadTypeOfEmbrioAuthoCompletion();
    }

    private void loadTypeOfMaterialWeightCombo() {

        seedWeightModel = defaultSeed.getSeedWeight();

        if ((seedWeightModel != null) && (seedWeightModel.getId() != null)) {
            new DefaultCombo(typeWeightCb, 23).loadComboById();
            String txt = new DefaultCombo(typeWeightCb, 23).comboTextById(seedWeightModel.getTypeWeightId());
            new DefaultCombo(typeWeightCb, txt).select();
            weight_1000.setText(seedWeightModel.getWeight_1000());
            weight_100.setText(seedWeightModel.getWeight_100());
            fruit_weight.setText(seedWeightModel.getFruit_weight());
            perfruitTextField.setText(seedWeightModel.getPerfruit());
        } else {
            new DefaultCombo(typeWeightCb, 23).loadComboById();
        }

        loadTypeWeightAuthoCompletion();
    }

    private void loadlocationOfHerbariumCombos() {
        if ((herbariumModel != null) && (herbariumModel.getId() != null)) {
            new DefaultCombo(locationCb, 21).loadComboById();
            String txt = new DefaultCombo(locationCb, 21).comboTextById(herbariumModel.getLocationId());
            new DefaultCombo(locationCb, txt).select();
        } else {
            new DefaultCombo(locationCb, 21).loadComboById();
        }

        loadLocationOfHerbariumAuthoCompletion();
    }

    private void loadDublicatedCombos() {
        if ((herbariumModel != null) && (herbariumModel.getId() != null)) {
            new DefaultCombo(dublicatedCb, 25).loadComboById();
            String txt = new DefaultCombo(dublicatedCb, 25).comboTextById(herbariumModel.getDublicatedId());
            new DefaultCombo(dublicatedCb, txt).select();
        } else {
            new DefaultCombo(dublicatedCb, 25).loadComboById();
        }

        loadDublicatedAuthoCompletion();
    }

    private void loadHabitatCombos() {
        if ((habitatModel != null) && (habitatModel.getId() != null)) {
            new DefaultCombo(habitatCb, 28).loadComboById();
            String txt = new DefaultCombo(habitatCb, 28).comboTextById(habitatModel.getHabitat());
            new DefaultCombo(habitatCb, txt).select();
        } else {
            new DefaultCombo(habitatCb, 28).loadComboById();
        }

        loadHabitatAuthoCompletion();
    }

    private void loadLandFormCombos() {
        if ((habitatModel != null) && (habitatModel.getId() != null)) {
            new DefaultCombo(landFormCb, 29).loadComboById();
            String txt = new DefaultCombo(landFormCb, 29).comboTextById(habitatModel.getLandForm());
            new DefaultCombo(landFormCb, txt).select();
        } else {
            new DefaultCombo(landFormCb, 29).loadComboById();
        }
        loadLandFormAuthoCompletion();
    }

    private void loadAspectCombos() {
        if ((habitatModel != null) && (habitatModel.getId() != null)) {
            new DefaultCombo(aspectCb, 30).loadComboById();
            String txt = new DefaultCombo(aspectCb, 30).comboTextById(habitatModel.getAspect());
            new DefaultCombo(aspectCb, txt).select();
        } else {
            new DefaultCombo(aspectCb, 30).loadComboById();
        }

        loadAspectAuthoCompletion();
    }

    private void loadFactorAffectingCombos() {
        if ((habitatModel != null) && (habitatModel.getId() != null)) {
            new DefaultCombo(factorsCb, 31).loadComboById();
            String txt = new DefaultCombo(factorsCb, 31).comboTextById(habitatModel.getFactor());
            new DefaultCombo(factorsCb, txt).select();
        } else {
            new DefaultCombo(factorsCb, 31).loadComboById();
        }

        loadFactorAuthoCompletion();
    }

    private void loadSoilTypeCombos() {
        if ((habitatModel != null) && (habitatModel.getId() != null)) {
            new DefaultCombo(soilTypeCb, 32).loadComboById();
            String txt = new DefaultCombo(soilTypeCb, 32).comboTextById(habitatModel.getSoil());
            new DefaultCombo(soilTypeCb, txt).select();
        } else {
            new DefaultCombo(soilTypeCb, 32).loadComboById();
        }

        loadSoilTypeAuthoCompletion();
    }

    private void loadSlopeCombos() {
        if ((habitatModel != null) && (habitatModel.getId() != null)) {
            new DefaultCombo(slopeCb, 33).loadComboById();
            String txt = new DefaultCombo(slopeCb, 33).comboTextById(habitatModel.getSlope());
            new DefaultCombo(slopeCb, txt).select();
        } else {
            new DefaultCombo(slopeCb, 33).loadComboById();
        }
        loadSlopeAuthoCompletion();
    }

    private void loadLandUseCombos() {
        if ((habitatModel != null) && (habitatModel.getId() != null)) {
            new DefaultCombo(landUseCb, 34).loadComboById();
            String txt = new DefaultCombo(landUseCb, 34).comboTextById(habitatModel.getLandUse());
            new DefaultCombo(landUseCb, txt).select();
        } else {
            new DefaultCombo(landUseCb, 34).loadComboById();
        }
        loadLandUseAuthoCompletion();
    }

    @FXML
    private void clear() {

    }

    @FXML
    public void init() {
        System.out.println(" init");
    }

    @FXML
    private void addFamily() {
        createForm("view/familyOperation.fxml", "Add Family");
        loadFamilyCombos();
    }

//    @FXML
//    private void editFamily() {
//        createForm("view/addFrm.fxml", "Add Family");
//        loadFamilyCombos();
//    }
    @FXML
    private void addGenus() {
        createForm("view/genusOperation.fxml", "Add Genus");
        loadGenusCombos();
    }

    @FXML
    private void addSpecies() {
        createForm("view/speciesOperation.fxml", "Add Species");
        loadSpeciesCombos();
    }

    @FXML
    private void addSpeciesAuthor() {
        createForm("view/speciesAuthorOperation.fxml", "Add Species Author");
        loadSpeciesAuthor();
    }

    @FXML
    private void addRank() {
        createForm("view/rankOperation.fxml", "Add Rank");
        loadRankCombos();
    }

    @FXML
    private void addInfraSpecies() {
        createForm("view/infraSpeciesOperation.fxml", "Add Infra Specific Species");
        loadInfraSpecies();
    }

    @FXML
    private void addInfraAuthor() {
        createForm("view/infraAuthorOperation.fxml", "Add Infra Specific Author");
        loadInfraAuthor();
    }

    @FXML
    private void addRank2() {
        createForm("view/rankOperation.fxml", "Add Rank");
        loadRank2Combos();
    }

    @FXML
    private void addIdentificationStatus() {
        createForm("view/identStatusOperation.fxml", "Add Identification Status");
        loadIdentificationStatus();
    }

    @FXML
    private void addIdentifierNameInstitute() {
        createForm("view/identInstituteOperation.fxml", "Add Identifier's Name and Institute");
        loadIdentifierInstitute();
    }

    @FXML
    private void addUses() {
        createForm("view/usesOperation.fxml", "Add Uses");
        loadUses();
    }

    @FXML
    private void addVernacularName() {
        createForm("view/vernacularOperation.fxml", "Add Vernacular Name");
        loadVernacularName();
    }

    @FXML
    private void addAssesInfor() {
        createForm("view/assessmentOperation.fxml", "Add Assessment Information");
        loadAssessmentInformation();
    }

    @FXML
    private void addOtherKey() {
        createForm("view/otherKeyOperation.fxml", "Add Other Key Information");
        loadOtherKey();
    }

    @FXML
    private void addPlantForm() {
        createForm("view/plantFormOperation.fxml", "Add Plant Form");
        loadPlantFrom();
    }

    @FXML
    private void addInfraSpecies2() {
        createForm("view/addFrm.fxml", "Add Infra Specific Species ");
        loadInfraSpecies2();
    }

    @FXML
    private void addInfAutor2() {
        createForm("view/addFrm.fxml", "Add Infra Specificc Author ");
        loadInfraAuthor2();
    }

    @FXML
    private void addIdentFrom() {
        createForm("view/identifiedFromOperation.fxml", "Add Identified From");
        loadIdentifiedFrom();
    }

    @FXML
    private void addOrganisationCombo() {
        createForm("view/organisationInstituteOperation.fxml", "Add Organisation Institute");
        loadOrganisationCombos();
    }

    @FXML
    private void addWildOrCultivatedCombo() {
        createForm("view/addFrm.fxml", "Add Wild or Cultivited");
        loadWildOrCultivetedCombo();
    }

    @FXML
    private void addMainCollectorNameCombo() {
        createForm("view/mainCollectorOperation.fxml", "Add Main Collector Name");
        loadMainCollectorCombos();
    }

    @FXML
    private void addLocationHerbariumCombo() {
        createForm("view/locationOfHerbariumOperation.fxml", "Add Herbarium of Location");
        loadlocationOfHerbariumCombos();
    }

    @FXML
    private void addDublicated() {
        createForm("view/dublicatedOperation.fxml", "Add Dublicated");
        loadDublicatedCombos();
    }

    @FXML
    private void addFruitTypeCombo() {
        createForm("view/fruitTypeOperation.fxml", "Add Fruit type");
        loadFruitTypeCombo();
    }

    @FXML
    private void addDispersalAidsCombo() {
        createForm("view/dispersalAidsOperation.fxml", "Add Dispersal aids");
        loadDispersalAidsCombo();
    }

    @FXML
    private void addTypeOFEmrioCombo() {
        createForm("view/typeOfEmbrioOperation.fxml", "Add Type of Embrio");
        loadTypeOfEmrioCombo();
    }

    @FXML
    private void addTypeMaterialCombo() {
        createForm("view/typeOfMaterialOperation.fxml", "Add Type Of Material Weight");
        loadTypeOfMaterialWeightCombo();
    }

    @FXML
    private void addHabitatCombo() {
        createForm("view/habitatOperation.fxml", "Add Habitat");
        loadHabitatCombos();
    }

    @FXML
    private void addLandFormCombo() {
        createForm("view/landFormOperation.fxml", "Add Land Form");
        loadLandFormCombos();
    }

    @FXML
    private void addAspectCombo() {
        createForm("view/aspectOperation.fxml", "Add Aspect");
        loadAspectCombos();
    }

    @FXML
    private void addFactorsHabitatCombo() {
        createForm("view/factorOperation.fxml", "Add Factors Affecting Habitat");
        loadFactorAffectingCombos();
    }

    @FXML
    private void addSoilTypeCombo() {
        createForm("view/soilTypeOperation.fxml", "Add Soil Type");
        loadSoilTypeCombos();
    }

    @FXML
    private void addSlopeCombo() {
        createForm("view/slopeOperation.fxml", "Add Slope");
        loadSlopeCombos();
    }

    @FXML
    private void addLandUseCombo() {
        createForm("view/landUseOperation.fxml", "Add Land Use");
        loadLandUseCombos();
    }

    @FXML
    private void addWildorCultivates() {
        createForm("view/wildOrCultivatesOperation.fxml", "Add Wild or Cultivates");
        loadWildOrCultivetedCombo();
    }

    private void createForm(String view, String title) {
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
            stage.getIcons().add(new LocalIcon().getIcon());

            stage.showAndWait();

            System.out.println("after stage close");

        } catch (IOException ex) {
            Logger.getLogger(CollectionDataBase.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void saveHandle() {
        switch (tabIndex()) {
            case 0:
                savePlant();
                break;
            case 1:
                saveCollection();
                break;
            case 2:
                saveLocation();
                break;
            case 3:
                saveHabitat();
                break;
            case 4:
                saveSampling();
                break;
            case 5:
                saveHerbarium();
                break;
            case 6:
                saveSeedMorphology();
                break;
            case 7:
                saveSeedWeight();
                break;
            default:
                break;
        }

    }

    private void savePlant() {
        defaultCombo = new DefaultCombo(familyCb);

//        if (defaultCombo.isInputValid()) {
        if (isPlantNew) {
            savePlantModel();
            defaultSeed.setPlant(plantModel);
        } else {
            updatePlantModel();
            defaultSeed.setPlant(plantModel);
        }
        if (plantModel.getDaoStatus().equals("1")) {
            new DefaultAlert("Data is saved").show();
        } else {
            new DefaultAlert("Data is not saved").show();
        }
//        }
        saveSeed();
    }

    private void saveCollection() {
//        if (isCollectionInputValid()) {
        if (isCollectionNew) {
            saveCollectionModel();
            defaultSeed.setCollection(collectionModel);
//                seedModel.setCollectionId(collectionModel.getId());
        } else {
            updateCollectionModel();
            defaultSeed.setCollection(collectionModel);
        }
        if (collectionModel.getDaoStatus().equals("1")) {
            new DefaultAlert("Data is saved").show();
        } else {
            new DefaultAlert("Data is not saved").show();
        }
//        }
        saveSeed();
    }

    private void saveLocation() {
//        if (isLocationInputValid()) {
        if (isLocationNew) {
            saveLocationModel();
//            seedModel.setLocationId(locationModel.getId());
            defaultSeed.setLocation(locationModel);
        } else {
            updateLocationModel();
            defaultSeed.setLocation(locationModel);
        }

        if (locationModel.getDaoStatus().equals("1")) {
            new DefaultAlert("Data is saved").show();
        } else {
            new DefaultAlert("Data is not saved").show();
        }
//        }
        saveSeed();
    }

    private void saveSampling() {
//        if (isSamplingInputValid()) {
        if (isSamplingNew) {
            saveSamplingModel();
            defaultSeed.setSampling(samplingModel);
        } else {
            updateSamplingModel();
            defaultSeed.setSampling(samplingModel);
        }

        if (samplingModel.getDaoStatus().equals("1")) {
            new DefaultAlert("Data is saved").show();
        } else {
            new DefaultAlert("Data is not saved").show();
        }
//        }
        saveSeed();
    }

    private void saveHerbarium() {
//        if (isHerbariumInputValid()) {
        if (isHerbariumNew) {
            saveHerbariumModel();
            defaultSeed.setHerbarium(herbariumModel);
        } else {
            updateHerbariumModel();
            defaultSeed.setHerbarium(herbariumModel);
        }

        if (herbariumModel.getDaoStatus().equals("1")) {
            new DefaultAlert("Data is saved").show();
        } else {
            new DefaultAlert("Data is not saved").show();
        }
//        }
        saveSeed();
    }

    private void saveHabitat() {
//        if (isHabitatInputValid()) {
        if (isHabitatNew) {
            saveHabitatModel();
            defaultSeed.setHabitat(habitatModel);
        } else {
            updateHabitatModel();
            defaultSeed.setHabitat(habitatModel);
        }
        if (habitatModel.getDaoStatus().equals("1")) {
            new DefaultAlert("Data is saved").show();
        } else {
            new DefaultAlert("Data is not saved").show();
        }
//        }

        saveSeed();
    }

    private void saveSeedMorphology() {
        if (isSeedMorphologyInputValid()) {
            if (isSeedMorphologyNew) {
                saveSeedMorphologyModel();
                defaultSeed.setMorphology(morphologyModel);
            } else {
                updateSeedMorphologyModel();
                defaultSeed.setMorphology(morphologyModel);
            }

            if (morphologyModel.getDaoStatus().equals("1")) {
                new DefaultAlert("Data is saved").show();
            } else {
                new DefaultAlert("Data is not saved").show();
            }
        }
        saveSeed();
    }

    private void saveSeedWeight() {
        if (isSeedWeightInputValid()) {
            if (isSeedWeightNew) {
                saveSeedWeightModel();
                defaultSeed.setSeedWeight(seedWeightModel);
            } else {
                updateSeedWeightModel();
                defaultSeed.setSeedWeight(seedWeightModel);
            }

            if (seedWeightModel.getDaoStatus().equals("1")) {
                new DefaultAlert("Data is saved").show();
            } else {
                new DefaultAlert("Data is not saved").show();
            }
        }
        saveSeed();
    }

    private void savePlantModel() {
        plantModel = new Plant(
                familyId(),
                genusId(),
                speciesId(),
                speciesAuthorId(),
                rankId(),
                infraSpeciesId(),
                infraAuthorId(),
                rank2Id(),
                identifationStatusId(),
                identifierInstituteId(),
                plantDescTextArea.getText(),
                usesId(),
                vernacularNameId(),
                assesInforId(),
                otherKeyId(),
                plantFormId(),
                infraSpecies2Id(),
                infraAuthor2Id(),
                identFromId(),
                new DefaultDate(identDate.getValue()).toDate(),
                heightTextField.getText()
        );

        daoPlant.save(plantModel);
        if (defaultImage != null) {
            defaultImage.file();
            defaultImage.setPlantId(plantModel.getId());
            fileOper.saveFile(defaultImage);
            try {
                defaultImage.saveFile();
            } catch (IOException ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        isPlantNew = false;
    }

    private void saveSeed() {
        if (defaultSeed.getId() == null) {
            daoSeed.save(defaultSeed);
        } else {
            daoSeed.update(defaultSeed);
        }
    }

    private void updatePlantModel() {
        BigDecimal id = plantModel.getId();
        plantModel = new Plant(id,
                familyId(),
                genusId(),
                speciesId(),
                speciesAuthorId(),
                rankId(),
                infraSpeciesId(),
                infraAuthorId(),
                rank2Id(),
                identifationStatusId(),
                identifierInstituteId(),
                plantDescTextArea.getText(),
                usesId(),
                vernacularNameId(),
                assesInforId(),
                otherKeyId(),
                plantFormId(),
                infraSpecies2Id(),
                infraAuthor2Id(),
                identFromId(),
                new DefaultDate(identDate.getValue()).toDate(),
                heightTextField.getText()
        );
        daoPlant.update(plantModel);

        defaultImage.file();
        defaultImage.setPlantId(plantModel.getId());
        fileOper.updateFile(defaultImage);
        try {
            defaultImage.saveFile();
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }

        isPlantNew = false;
    }

    private void saveCollectionModel() {
        System.out.println("save " + nameField.getText());
        collectionModel = new CollectionDataBase(
                collectionNumberTextField.getText(),
                nameField.getText(),
                accessionTextField.getText(),
                new DefaultDate(dateCollected.getValue()).toDate(),
                organizeInstituteId(),
                wildCultivitedId(),
                collectorInstituteId()
        );

        daoCollection.save(collectionModel);
        isCollectionNew = false;
    }

    private void updateCollectionModel() {
        BigDecimal id = collectionModel.getId();

        if (id == null) {
            //save
            saveCollectionModel();
        } else {

            collectionModel = new CollectionDataBase(id,
                    collectionNumberTextField.getText(),
                    nameField.getText(),
                    accessionTextField.getText(),
                    new DefaultDate(dateCollected.getValue()).toDate(),
                    organizeInstituteId(),
                    wildCultivitedId(),
                    collectorInstituteId()
            );
            daoCollection.update(collectionModel);

        }
        isCollectionNew = false;
    }

    private void saveLocationModel() {
        locationModel = new LocationDataBase(
                countryId(),
                stateId(),
                latitudeTextField.getText(),
                latMethodTextField.getText(),
                gridTextField.getText(),
                altitudeTextField.getText(),
                descTextField.getText(),
                longtitudeTextField.getText(),
                latUnitsTextField.getText(),
                gpsTextField.getText(),
                altitudeMethodTextField.getText());
        daoLocation.save(locationModel);
        isLocationNew = false;
    }

    private void updateLocationModel() {
        BigDecimal id = locationModel.getId();
        if (id == null) {
            saveLocationModel();
        } else {
            locationModel = new LocationDataBase(id,
                    countryId(),
                    stateId(),
                    latitudeTextField.getText(),
                    latMethodTextField.getText(),
                    gridTextField.getText(),
                    altitudeTextField.getText(),
                    descTextField.getText(),
                    longtitudeTextField.getText(),
                    latUnitsTextField.getText(),
                    gpsTextField.getText(),
                    altitudeMethodTextField.getText());
            daoLocation.update(locationModel);
            isLocationNew = false;
        }
    }

    private void saveSamplingModel() {
        samplingModel = new SamplingDataBase(
                numberSampleTextField.getText(),
                numberFoodTextField.getText(),
                areaSampleTextField.getText(),
                percentageTextField.getText(),
                noteTextArea.getText());
        daoSampling.save(samplingModel);
        isSamplingNew = false;
    }

    private void updateSamplingModel() {
        BigDecimal id = samplingModel.getId();
        if (id == null) {
            saveSamplingModel();
        } else {
            samplingModel = new SamplingDataBase(id,
                    numberSampleTextField.getText(),
                    numberFoodTextField.getText(),
                    areaSampleTextField.getText(),
                    percentageTextField.getText(),
                    noteTextArea.getText());
            daoSampling.update(samplingModel);
            isSamplingNew = false;
        }
    }

    private void saveHerbariumModel() {
        herbariumModel = new HerbariumSpecimenBase(herbariumNumberTextField.getText(),
                locationId(), dublicatedId(), isHerbarium(), voucherTextField.getText());
        daoHerbarium.save(herbariumModel);
        isHerbariumNew = false;
    }

    private void updateHerbariumModel() {
        BigDecimal id = herbariumModel.getId();
        if (id == null) {
            saveHerbariumModel();
        } else {
            herbariumModel = new HerbariumSpecimenBase(id, herbariumNumberTextField.getText(),
                    locationId(), dublicatedId(), isHerbarium(), voucherTextField.getText());
            daoHerbarium.update(herbariumModel);
            isHerbariumNew = false;
        }
    }

    private void saveHabitatModel() {
        habitatModel = new HabitatDataBase(habitatId(),
                landFormId(),
                geologyTextField.getText(),
                aspectId(),
                factorAffectId(),
                soilTypeId(),
                associatedSpeciesTextField.getText(),
                slopeId(),
                landUseId(),
                siteNotesTextArea.getText()
        );
        daoHabitat.save(habitatModel);
    }

    private void updateHabitatModel() {
        BigDecimal id = habitatModel.getId();
        if (id == null) {
            saveHabitatModel();
        } else {
            habitatModel = new HabitatDataBase(id, habitatId(),
                    landFormId(),
                    geologyTextField.getText(),
                    aspectId(),
                    factorAffectId(),
                    soilTypeId(),
                    associatedSpeciesTextField.getText(),
                    slopeId(),
                    landUseId(),
                    siteNotesTextArea.getText());
            daoHabitat.update(habitatModel);
            isHabitatNew = false;
        }
    }

    private void saveSeedMorphologyModel() {
        morphologyModel = new SeedMorphology(
                sizeTextField.getText(),
                fruitTypeId(),
                slengthTextField.getText(),
                swidthTextField.getText(),
                sheightTextField.getText(),
                dispersalAidsId(),
                configureTextfield.getText(),
                typeOfEmbrioId());
        daoSeedMorphology.save(morphologyModel);
        isSeedMorphologyNew = false;
    }

    private void updateSeedMorphologyModel() {
        BigDecimal id = morphologyModel.getId();
        if (id == null) {
            saveSeedMorphologyModel();
        } else {
            morphologyModel = new SeedMorphology(id,
                    sizeTextField.getText(),
                    fruitTypeId(),
                    slengthTextField.getText(),
                    swidthTextField.getText(),
                    sheightTextField.getText(),
                    dispersalAidsId(),
                    configureTextfield.getText(),
                    typeOfEmbrioId());
            daoSeedMorphology.update(morphologyModel);
            isSeedMorphologyNew = false;
        }
    }

    private void saveSeedWeightModel() {

        seedWeightModel = new SeedWeight(weight_1000.getText(),
                weight_100.getText(), typeWeightId(), fruit_weight.getText(), perfruitTextField.getText());
        daoSeedMorphology.save(seedWeightModel);
        isSeedWeightNew = false;
    }

    private void updateSeedWeightModel() {
        BigDecimal id = seedWeightModel.getId();
        if (id ==null) {
            saveSeedWeightModel();
        } else {
            seedWeightModel = new SeedWeight(id, weight_1000.getText(),
                    weight_100.getText(), typeWeightId(), fruit_weight.getText(), perfruitTextField.getText());
            daoSeedMorphology.update(seedWeightModel);
            isSeedWeightNew = false;
        }
    }

    private BigDecimal familyId() {
        return new DefaultCombo(familyCb).selectedId();
    }

    private BigDecimal genusId() {
        return new DefaultCombo(genusCb).selectedId();
    }

    private BigDecimal speciesId() {
        return new DefaultCombo(speciesCb).selectedId();
    }

    private BigDecimal speciesAuthorId() {
        return new DefaultCombo(speciesAuthorCb).selectedId();
    }

    private BigDecimal rankId() {
        return new DefaultCombo(rankCb).selectedId();
    }

    private BigDecimal rank2Id() {
        return new DefaultCombo(rankCb2).selectedId();
    }

    private BigDecimal infraSpeciesId() {
        return new DefaultCombo(infraSpeciesCb).selectedId();
    }

    private BigDecimal infraSpecies2Id() {
        return new DefaultCombo(infraSpecies2Cb).selectedId();
    }

    private BigDecimal infraAuthorId() {
        return new DefaultCombo(infraAuthorCb).selectedId();
    }

    private BigDecimal infraAuthor2Id() {
        return new DefaultCombo(infraAuthor2Cb).selectedId();
    }

    private BigDecimal identifationStatusId() {
        return new DefaultCombo(identificationStatusCb).selectedId();
    }

    private BigDecimal identifierInstituteId() {
        return new DefaultCombo(identifierInstituteCb).selectedId();
    }

 
    private BigDecimal usesId() {
        return new DefaultCombo(usesCb).selectedId();
    }

    private BigDecimal vernacularNameId() {
        return new DefaultCombo(vernacularNameCb).selectedId();
    }

    private BigDecimal assesInforId() {
        return new DefaultCombo(assessmentInformationCb).selectedId();
    }

    private BigDecimal otherKeyId() {
        return new DefaultCombo(otherKeyCb).selectedId();
    }

    private BigDecimal plantFormId() {
        return new DefaultCombo(plantFromCb).selectedId();
    }

    private BigDecimal identFromId() {
        return new DefaultCombo(identifiedFromCb).selectedId();

    }

    private BigDecimal organizeInstituteId() {
        return new DefaultCombo(organisationCb).selectedId();
    }

    private BigDecimal wildCultivitedId() {
        return new DefaultCombo(wildCb).selectedId();
    }

    private BigDecimal collectorInstituteId() {
        return new DefaultCombo(collectorCb).selectedId();
    }

    private BigDecimal countryId() {
        return new DefaultCombo(countryCb).selectedId();
    }

    private BigDecimal stateId() {
        return new DefaultCombo(stateCb).selectedId();
    }

    private BigDecimal locationId() {
        return new DefaultCombo(locationCb).selectedId();
    }

    private BigDecimal habitatId() {
        return new DefaultCombo(habitatCb).selectedId();
    }

    private BigDecimal landFormId() {
        return new DefaultCombo(landFormCb).selectedId();
    }

    private BigDecimal aspectId() {
        return new DefaultCombo(aspectCb).selectedId();
    }

    private BigDecimal factorAffectId() {
        return new DefaultCombo(factorsCb).selectedId();
    }

    private BigDecimal soilTypeId() {
        return new DefaultCombo(soilTypeCb).selectedId();
    }

    private BigDecimal slopeId() {
        return new DefaultCombo(slopeCb).selectedId();
    }

    private BigDecimal landUseId() {
        return new DefaultCombo(landUseCb).selectedId();
    }

    private BigDecimal dublicatedId() {
        return new DefaultCombo(dublicatedCb).selectedId();
    }

    private BigDecimal fruitTypeId() {
        return new DefaultCombo(fruitTypeCb).selectedId();
    }

    private BigDecimal dispersalAidsId() {
        return new DefaultCombo(dispersalAidsCb).selectedId();
    }

    private BigDecimal typeOfEmbrioId() {
        return new DefaultCombo(embrioCb).selectedId();
    }

    private BigDecimal typeWeightId() {
        return new DefaultCombo(typeWeightCb).selectedId();
    }
 
    private boolean isHerbarium() {
        return isHerbarium.isSelected();
    }

    private boolean isKew() {
        return isKew.isSelected();
    }

    private boolean isInputValid() {
        String errorMessage = "";
        if (familyCb.getSelectionModel().getSelectedIndex() == -1) {
            errorMessage += "Enter Family!\n";
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            new DefaultAlert(errorMessage).warning();
            return false;
        }
    }

    private boolean isCollectionInputValid() {
        String errorMessage = "";
//        new DefaultInput(collectionNumberTextField).check();
        if (collectionNumberTextField.getText().trim() == null || collectionNumberTextField.getText().trim().length() == 0) {
            errorMessage += "Enter Collection Number!\n";
        }
        if (errorMessage.length() == 0) {
            return true;
        } else {
            new DefaultAlert(errorMessage).warning();
            return false;
        }
    }

//    private boolean isLocationInputValid() {
//        String errorMessage = "";
//        if (districtTextField.getText().trim() == null || districtTextField.getText().trim().length() == 0) {
//            errorMessage += "Enter District/Municipality name!\n";
//        }
//
//        if (errorMessage.length() == 0) {
//            return true;
//        } else {
//            new DefaultAlert(errorMessage).warning();
//            return false;
//        }
//    }
    private boolean isSamplingInputValid() {
        String errorMessage = "";
        if (numberSampleTextField.getText().trim() == null || numberSampleTextField.getText().trim().length() == 0) {
            errorMessage += "Number of Plant sample!\n";
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            new DefaultAlert(errorMessage).warning();
            return false;
        }
    }

    private boolean isHerbariumInputValid() {
        String errorMessage = "";
        if (herbariumNumberTextField.getText().trim() == null || herbariumNumberTextField.getText().trim().length() == 0) {
            errorMessage += "Enter Herbarium number!\n";
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            new DefaultAlert(errorMessage).warning();
            return false;
        }
    }

//    private boolean isHabitatInputValid() {
//        String errorMessage = "";
//        if (habitatTextField.getText().trim() == null || habitatTextField.getText().trim().length() == 0) {
//            errorMessage += "Enter Habitat name!\n";
//        }
//
//        if (errorMessage.length() == 0) {
//            return true;
//        } else {
//            new DefaultAlert(errorMessage).warning();
//            return false;
//        }
//    }
    private boolean isSeedMorphologyInputValid() {
        String errorMessage = "";
        if (sizeTextField.getText().trim() == null || sizeTextField.getText().trim().length() == 0) {
            errorMessage += "Enter Fruit size!\n";
        }
        if (errorMessage.length() == 0) {
            return true;
        } else {
            new DefaultAlert(errorMessage).warning();
            return false;
        }
    }

    private boolean isSeedWeightInputValid() {
        String errorMessage = "";
        if (weight_1000.getText().trim() == null || weight_1000.getText().trim().length() == 0) {
            errorMessage += "Enter Seed Weight!\n";
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            new DefaultAlert(errorMessage).warning();
            return false;
        }
    }

    private void escape(ComboBox combo) {
        combo.setOnKeyPressed((KeyEvent event) -> {
            if (event.getCode() == KeyCode.ESCAPE) {
                combo.getSelectionModel().clearSelection();
            }
        });
    }

    @FXML
    private void upload() {
        Number imageId = null;
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
//        fileChooser.showOpenDialog(dialogStage);
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All images", "*.*")
        //                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
        //                new FileChooser.ExtensionFilter("PNG", "*.png")
        );
        File file = fileChooser.showOpenDialog(dialogStage);
        if (file != null) {
            Image image = new Image(file.toURI().toString());
            seedImage.setImage(image);
            if (defaultImage != null) {
                imageId = defaultImage.getImageId();
            }
            defaultImage = new DefaultImage(file);
            defaultImage.setImageId(imageId);
        } else {
            defaultImage = null;
        }

    }

    @FXML
    private void download() {
    }

    public void loadBySeedId(Number id) {
        defaultSeed = new DefaultSeed();
        defaultSeed = daoSeed.defaultSeedById(id);
        handleTab();
    }

}
