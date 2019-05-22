package com.botanik.controller;

import com.botanik.Seed;

import com.botanik.dao.impl.SearchDAOJDBC;
import com.botanik.dao.intf.SearchDAO;
import com.botanik.export.controller.ExportController;
import com.botanik.logger.Logger;
import com.botanik.model.DefaultDate;
import com.botanik.model.LocalIcon;
import com.botanik.model.Search;
import com.botanik.model.SearchModel;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author teyyub
 */
public class SearchController {

    private SearchDAO dao = new SearchDAOJDBC();
    private ExportController ec = new ExportController();
    Map<Integer, Object[]> data = new TreeMap<>();
    @FXML
    TableView mainTable;

    @FXML
    private TableColumn<Search, Number> colSeedId;
    @FXML
    private TableColumn<Search, String> colPlant;
    @FXML
    private TableColumn<Search, Date> colDate;
    @FXML
    private TableColumn<Search, String> colCollection;
    @FXML
    private TableColumn<Search, String> colLocation;
    @FXML
    private TableColumn<Search, String> colHerbarium;
    @FXML
    private TableColumn<Search, String> colHabitat;

//    @FXML
//    private TableColumn<SeedModel, String> colHerbarium;
//    @FXML
//    private TableColumn<SeedModel, String> colHabitat;
//    ObservableList<SeedModel> seedDataList;
//    private boolean isNew = false;
    private Stage dialogStage;
//    @FXML
//    private ComboBox countryCb;
//    ObservableList<Country> countryList;
//    @FXML
//    private ComboBox stateCb;
//    ObservableList<Region> regionList;

    ObservableList<Search> searchList;
    @FXML
    private TextField idTextField, collectionNumberText, accessionNumberText, bankedNumberText,
            familyText, genusText, speciesText, regionText, collectorText;
//            plantTextField, 
//            numberTextField, locationTextField, sampleTextField, herbariumTextField, habitatTextField;

    @FXML
    private DatePicker collectedDate, germinationDate;
    private SearchModel searchModel;

    @FXML
    public void initialize() {
        System.out.println("init SeedModel Controller");

        constructTable();
        mainTable.setOnMouseClicked((MouseEvent event) -> {
            if (event.getClickCount() == 2) {
                try {
                    edit();
                } catch (IOException ex) {
                    System.out.println("error");
                }
            }

        });

//        loadTable();
//        loadCombos();
    }

    public void constructTable() {
        System.out.println("construct Table");
        PropertyValueFactory<Search, Number> seedid = new PropertyValueFactory<>("seedId");
        colSeedId.setText("Seed ID");
        colSeedId.setCellValueFactory(seedid);

        PropertyValueFactory<Search, String> cp = new PropertyValueFactory<>("plant");
        colPlant.setText("Plant");
        colPlant.setCellValueFactory(cp);

        PropertyValueFactory<Search, Date> cd = new PropertyValueFactory<>("collectedDate");
        colDate.setText("Collection Date");
        colDate.setCellValueFactory(cd);
//
        PropertyValueFactory<Search, String> cc = new PropertyValueFactory<>("collection");
        colCollection.setText("Collection");
        colCollection.setCellValueFactory(cc);

        PropertyValueFactory<Search, String> cl = new PropertyValueFactory<>("region");
        colLocation.setText("Country");
        colLocation.setCellValueFactory(cl);

        PropertyValueFactory<Search, String> her = new PropertyValueFactory<>("herbarium");
        colHerbarium.setText("Herbarium");
        colHerbarium.setCellValueFactory(her);

        PropertyValueFactory<Search, String> hb = new PropertyValueFactory<>("habitat");
        colHabitat.setText("Habitat");
        colHabitat.setCellValueFactory(hb);
    }

    private void loadTable() {
//        seedDataList = FXCollections.observableArrayList(dao.seedByModel(searchModel));
//        mainTable.setItems(seedDataList);
    }

//    public boolean isIsNew() {
//        return isNew;
//    }
//
//    public void setIsNew(boolean isNew) {
//        this.isNew = isNew;
//    }
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void editForRegularUser(Number seedId) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Seed.class.getResource("view/userEdit.fxml"));
        AnchorPane formPane = (AnchorPane) loader.load();
        dialogStage = new Stage();
        dialogStage.initStyle(StageStyle.UTILITY);
        dialogStage.setTitle("Seed Database");
        dialogStage.setResizable(false);
        Scene scene = new Scene(formPane);
        dialogStage.setScene(scene);
        dialogStage.initModality(Modality.WINDOW_MODAL);
        EditRegularUserController controller = loader.getController();
//        controller.isPlantNew = false;
//        controller.isCollectionNew = false;
//        controller.isLocationNew = false;
//        controller.isHabitatNew = false;
//        controller.isSamplingNew = false;
//        controller.isHerbariumNew = false;
//        controller.isSeedMorphologyNew = false;
//        controller.isSeedWeightNew = false;
        controller.loadBySeedId(seedId);
//        controller.setIsNew(false);
//        controller.setDialogStage(dialogStage);
        dialogStage.show();
    }

    @FXML
    private void edit() throws IOException {

        Search model = (Search) mainTable.getSelectionModel().getSelectedItem();
        if (model != null) {
            if (UserController.isRegularUser) {
                try {
                    editForRegularUser(model.getSeedId());
                } catch (Exception ex) {
                    Logger.save(ex.getMessage());
                }
            } else {

                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(Seed.class.getResource("view/mainTabMenu.fxml"));
                AnchorPane formPane = (AnchorPane) loader.load();
                dialogStage = new Stage();
                dialogStage.initStyle(StageStyle.UTILITY);
                dialogStage.setTitle("Seed Database");
                dialogStage.setResizable(false);
                Scene scene = new Scene(formPane);
                dialogStage.setScene(scene);
                dialogStage.initModality(Modality.WINDOW_MODAL);
                MainController controller = loader.getController();
                controller.isPlantNew = false;
                controller.isCollectionNew = false;
                controller.isLocationNew = false;
                controller.isHabitatNew = false;
                controller.isSamplingNew = false;
                controller.isHerbariumNew = false;
                controller.isSeedMorphologyNew = false;
                controller.isSeedWeightNew = false;
                controller.loadBySeedId(model.getSeedId());
//            controller.setIsNew(false);
//            controller.setDialogStage(dialogStage);
                dialogStage.show();
//            dialogStage.setOnCloseRequest((WindowEvent we) -> {
//                try {
//                    loadFirstPage();
//                } catch (IOException ex) {
//                    Logger.getLogger(SearchController.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            });
//            Stage oldStage = (Stage) mainTable.getScene().getWindow();
//            oldStage.close();
//            loadTable();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
//            alert.initOwner(primaryStage);
//            alert.setTitle("No Selection");
            alert.setHeaderText("No Selection");
            alert.setContentText("Please select a item in the table.");

            alert.showAndWait();

        }
    }

    private void loadFirstPage() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Seed.class.getResource("view/access_first.fxml"));
        AnchorPane anchorLayout = (AnchorPane) loader.load();
        Scene scene = new Scene(anchorLayout);
        dialogStage = new Stage();
        dialogStage.setScene(scene);
        dialogStage.getIcons().add(new LocalIcon().getIcon());
        dialogStage.setResizable(false);
        dialogStage.show();
    }

    private Integer checkInputField(String value) {
        if ((value != null) && (!"".equals(value))) {
            return Integer.valueOf(value);
        }
        return -1;
    }

    @FXML
    private void search() {
        Logger.save("started search");
        searchModel = new SearchModel();

        searchModel.setSeedId(checkInputField(idTextField.getText()));
        searchModel.setCollectionNumber((collectionNumberText.getText()));
        searchModel.setAccesssionNumber((accessionNumberText.getText()));
        searchModel.setBankedNumber(checkInputField(bankedNumberText.getText()));
        searchModel.setFamily(familyText.getText());
        searchModel.setGenus(genusText.getText());
        searchModel.setSpecies(speciesText.getText());
        searchModel.setRegion(regionText.getText());
        searchModel.setCollector(collectorText.getText());
//        searchModel.setColDate(collectedDate.getValue());
        searchModel.setCollectedDate(new DefaultDate(collectedDate.getValue()).toDate());
        if (isSearchable()) {
            searchList = FXCollections.observableArrayList(dao.search(searchModel));
            mainTable.setItems(searchList);
            mainTable.refresh();
        }
//        loadStatusBar();

    }

    private boolean isSearchable() {
        return (!searchModel.getSeedId().equals(-1))
                || (!searchModel.getCollectionNumber().equals(""))
                || (!searchModel.getAccesssionNumber().equals(-1))
                || (!searchModel.getBankedNumber().equals(-1))
                || (!searchModel.getFamily().equals(""))
                || (!searchModel.getGenus().equals(""))
                || (!searchModel.getSpecies().equals(""))
                || (!searchModel.getRegion().equals(""))
                || (!searchModel.getCollector().equals(""));
    }

    @FXML
    private void export() throws FileNotFoundException, IOException {

        ec.export();

//        if (!mainTable.getItems().isEmpty()) {
//             if (!isTableEmpty()) {
//        DirectoryChooser dirChooser = new DirectoryChooser();
//        File selectedDirectory = dirChooser.showDialog(dialogStage);
//
//        if (selectedDirectory != null) {
//            System.out.println("ssdadasd");
////                exportTable(table());
////        }
//        } else {
//            Alert alert = new Alert(Alert.AlertType.INFORMATION);
//            alert.initOwner(dialogStage);
//            alert.setContentText("Table is empty");
//            alert.showAndWait();
//        }
////
//        System.out.println("Done");
//        XSSFWorkbook workbook = new XSSFWorkbook();
//        XSSFSheet sheet = workbook.createSheet("Data");
//        sheet.addMergedRegion(CellRangeAddress.valueOf("$A$2:$H$2"));
//        CellStyle style = workbook.createCellStyle();
//        style.setAlignment(HorizontalAlignment.CENTER);
//        style.setVerticalAlignment(VerticalAlignment.CENTER);
//        style.setFillForegroundColor(IndexedColors.LIGHT_ORANGE.getIndex());
//        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
//        Row row = sheet.createRow(1);
//
//        Cell cell = row.createCell(0);
//        cell.setCellValue("COLLECTION DATA");
//
//        row.getCell(0).setCellStyle(style);
//        CellStyle style1 = workbook.createCellStyle();
//        style1.setAlignment(HorizontalAlignment.CENTER);
//        style1.setVerticalAlignment(VerticalAlignment.CENTER);
//        style1.setFillForegroundColor(IndexedColors.LIGHT_ORANGE.getIndex());
//        style1.setFillPattern(FillPatternType.SOLID_FOREGROUND);
//        sheet.addMergedRegion(CellRangeAddress.valueOf("$I$2:$AB$2"));
//
//        style.setAlignment(HorizontalAlignment.CENTER);
//        style.setVerticalAlignment(VerticalAlignment.CENTER);
//        style.setFillForegroundColor(IndexedColors.LIGHT_ORANGE.getIndex());
//        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
//
//        Row row1 = sheet.createRow(2);
//        Cell cell1 = row.createCell(0);
//        cell1.setCellValue("PLANT NAME & IDENTIFICATION DATA");
//        row1.getCell(0).setCellStyle(style1);
//        for (int j = 0; j < 10; j++) {
//            row.createCell(j).setCellValue("asjgfjsdgfsdg"); //getText()
//        }
//            for (int i = 0; i < tableView.getItems().size(); i++) {
//                row = sheet.createRow(i + 1);
//                for (int j = 0; j < tableView.getColumns().size(); j++) {
//                    if (tableView.getColumns().get(j) != null) { //.getCellData(i) 
//                        row.createCell(j).setCellValue(tableView.getColumns().get(j).toString()); //.getCellData(i) 
//                    } else {
//                        row.createCell(j).setCellValue("");
//                    }
//                }
//            }
//        String fileName = fileName();
//        FileOutputStream fileOut = new FileOutputStream(fileName);
//        workbook.write(fileOut);
//        fileOut.close();
//
//        try {
//            Desktop.getDesktop().open(new File(fileName));
//        } catch (IOException e) {
//        }
//        } else {
//            Alert alert = new Alert(Alert.AlertType.INFORMATION);
//            alert.initOwner(dialogStage);
//            alert.setContentText("Table is empty");
//            alert.showAndWait();
//        }
//    }
//    private Number countryId() {
//        if (countryCb.getSelectionModel().getSelectedIndex() == -1) {
//            return -1;
//        }
//        return ((Country) countryCb.getSelectionModel().getSelectedItem()).getId();
//    }
//
//    private Number stateId() {
//        if (stateCb.getSelectionModel().getSelectedIndex() == -1) {
//            return -1;
//        }
//        return ((Region) stateCb.getSelectionModel().getSelectedItem()).getId();
    }

    @FXML
    private void clear() {
//        countryCb.getSelectionModel().clearSelection();
//        stateCb.getSelectionModel().clearSelection();
        idTextField.clear();
        collectionNumberText.clear();
        accessionNumberText.clear();
        bankedNumberText.clear();
        familyText.clear();
        genusText.clear();
        speciesText.clear();
        collectedDate.setValue(null);
        regionText.clear();
        collectorText.clear();
    }

    private long genId() {
        return System.currentTimeMillis();
    }

    private String fileName() {
        return "c:/test/" + genId() + ".xlsx";
    }

}
