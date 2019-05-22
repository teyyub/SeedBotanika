package com.botanik.controller;

import com.botanik.Seed;
import com.botanik.model.Menu;
import com.botanik.model.SeedModel;
 
import com.jfoenix.controls.JFXButton;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author teyyub , Mar 25, 2018 , 1:38:14 PM
 */
public class ButtonController implements Initializable {

    private static final String FILE_NAME = "Specimens.xlsx";
    private final String delimiter = "/";
    private Stage dialogStage, primaryStage;
//    SpecimenOverviewController controller;
    private AnchorPane formPane;
   
//    TableView table;
    private Seed botanika;

    private SeedModel mainModel = new SeedModel();

    private Menu menu;

    @FXML
    private JFXButton btn_plant, btn_collec, btn_local, btn_habitat, btn_sample, btn_herbarium, btn_seedMorphology, btn_seedWeight;

    @FXML
    private AnchorPane mainAnchor, plantAnchor, collectionAnchor, locationAnchor, habitatAnchor, sampleAnchor, herbariumAnchor, seedMorphologyAnchor;

    private boolean isCollection;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("init");
        createPages();

    }

    @FXML
    private void handleButton(ActionEvent event) {
        System.out.println("clicked");
        if (event.getSource() == btn_plant) {
            plantAnchor.setVisible(true);
            collectionAnchor.setVisible(false);
            locationAnchor.setVisible(false);
            habitatAnchor.setVisible(false);
            sampleAnchor.setVisible(false);
            herbariumAnchor.setVisible(false);
            seedMorphologyAnchor.setVisible(false);
        } else if (event.getSource() == btn_collec) {
            plantAnchor.setVisible(false);
            collectionAnchor.setVisible(true);
            locationAnchor.setVisible(false);
            habitatAnchor.setVisible(false);
            sampleAnchor.setVisible(false);
            herbariumAnchor.setVisible(false);
            seedMorphologyAnchor.setVisible(false);

            isCollection = true;

        } else if (event.getSource() == btn_local) {
            plantAnchor.setVisible(false);
            collectionAnchor.setVisible(false);
            locationAnchor.setVisible(true);
            habitatAnchor.setVisible(false);
            sampleAnchor.setVisible(false);
            herbariumAnchor.setVisible(false);
            seedMorphologyAnchor.setVisible(false);
        } else if (event.getSource() == btn_habitat) {
            plantAnchor.setVisible(false);
            collectionAnchor.setVisible(false);
            locationAnchor.setVisible(false);
            habitatAnchor.setVisible(true);
            sampleAnchor.setVisible(false);
            herbariumAnchor.setVisible(false);
            seedMorphologyAnchor.setVisible(false);
        } else if (event.getSource() == btn_sample) {
            plantAnchor.setVisible(false);
            collectionAnchor.setVisible(false);
            locationAnchor.setVisible(false);
            habitatAnchor.setVisible(false);
            sampleAnchor.setVisible(true);
            herbariumAnchor.setVisible(false);
            seedMorphologyAnchor.setVisible(false);
        } else if (event.getSource() == btn_herbarium) {
            plantAnchor.setVisible(false);
            collectionAnchor.setVisible(false);
            locationAnchor.setVisible(false);
            habitatAnchor.setVisible(false);
            sampleAnchor.setVisible(false);
            herbariumAnchor.setVisible(true);
            seedMorphologyAnchor.setVisible(false);
        } else if (event.getSource() == btn_seedMorphology) {
            plantAnchor.setVisible(false);
            collectionAnchor.setVisible(false);
            locationAnchor.setVisible(false);
            habitatAnchor.setVisible(false);
            sampleAnchor.setVisible(false);
            herbariumAnchor.setVisible(false);
            seedMorphologyAnchor.setVisible(true);
        }
    }

    @FXML
    private void save() {
        if (isCollection) {
            saveCollection();
        }
    }

    private void saveCollection() {
        System.out.println("save collection");
    }

    private void setNode(Node node) {
        mainAnchor.getChildren().clear();
        mainAnchor.getChildren().add((Node) node);
    }

    private void createPages() {
        try {

            plantAnchor = FXMLLoader.load(Seed.class.getResource("view/addPlandAndIdentificationData.fxml"));
            setNode(plantAnchor);
        } catch (IOException ex) {
            System.out.println("exception");

        }

    }

    @FXML
    private void plant() {
        try {

            plantAnchor = FXMLLoader.load(Seed.class.getResource("view/addPlandAndIdentificationData.fxml"));
            setNode(plantAnchor);
        } catch (IOException ex) {
            System.out.println("exception");
//            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void collection() {
        try {

            plantAnchor = FXMLLoader.load(Seed.class.getResource("view/addCollectionData.fxml"));
            setNode(plantAnchor);
        } catch (IOException ex) {
            System.out.println("exception");
//            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void location() {
        try {

            plantAnchor = FXMLLoader.load(Seed.class.getResource("view/addLocationData.fxml"));
            setNode(plantAnchor);
        } catch (IOException ex) {
            System.out.println("exception");
//            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void sampling() {
        try {

            plantAnchor = FXMLLoader.load(Seed.class.getResource("view/addSamplingData.fxml"));
            setNode(plantAnchor);
        } catch (IOException ex) {
            System.out.println("exception");
//            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void herbarium() {
        try {

            plantAnchor = FXMLLoader.load(Seed.class.getResource("view/addHerbariumSpecimen.fxml"));
            setNode(plantAnchor);
        } catch (IOException ex) {
            System.out.println("exception");
//            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void habitat() {
        try {

            plantAnchor = FXMLLoader.load(Seed.class.getResource("view/addHabitatData.fxml"));
            setNode(plantAnchor);
        } catch (IOException ex) {
            System.out.println("exception");
//            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void seed_mor() {
        try {

            plantAnchor = FXMLLoader.load(Seed.class.getResource("view/addHerbariumSpecimen.fxml"));
            setNode(plantAnchor);
        } catch (IOException ex) {
            System.out.println("exception");
//            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void seed_weight() {
        try {

            plantAnchor = FXMLLoader.load(Seed.class.getResource("view/addHerbariumSpecimen.fxml"));
            setNode(plantAnchor);
        } catch (IOException ex) {
            System.out.println("exception");
//            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public void setSeed(Seed botanika) {
        this.botanika = botanika;
    }

    @FXML
    public void init() {
        System.out.println(" init");
    }

//    public void init(SpecimenOverviewController controller) {
//        specimenController = controller;
//    }
    @FXML
    private void exportToExcel() throws IOException {
        System.out.println("Action exportToExcel()");
        loadControllerTable();
//        if (!isTableEmpty()) {
//            DirectoryChooser dirChooser = new DirectoryChooser();
//            File selectedDirectory = dirChooser.showDialog(dialogStage);
//
//            if (selectedDirectory != null) {
//                exportTable(table());
//            }
//        } else {
//            Alert alert = new Alert(Alert.AlertType.INFORMATION);
//            alert.initOwner(dialogStage);
//            alert.setContentText("Table is empty");
//            alert.showAndWait();
//        }
//
//        System.out.println("Done");
    }

//    private TableView table() {
//        return controller.getSearchTable();
//    }

    private void loadControllerTable() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Seed.class.getResource("view/SpecimenOverview.fxml"));
            Parent root = loader.load();
//            controller = loader.getController();

//            System.out.println(controller.specimenList);
//        
        } catch (IOException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setContentText("Exception is occurred " + ex.getMessage());
            alert.showAndWait();
        }
    }

//    private void SaveFile(String destination) {
//        XSSFWorkbook workbook = new XSSFWorkbook();
//        XSSFSheet sheet = workbook.createSheet("Datatypes in Java");
//
//        Object[][] datatypes = {
//            {"Datatype", "Type", "Size(in bytes)"},
//            {"int", "Primitive", 2},
//            {"float", "Primitive", 4},
//            {"double", "Primitive", 8},
//            {"char", "Primitive", 1},
//            {"String", "Non-Primitive", "No fixed size"}
//        };
//
//        int rowNum = 0;
//        System.out.println("Creating excel");
//
//        for (Object[] datatype : datatypes) {
//            Row row = sheet.createRow(rowNum++);
//            int colNum = 0;
//            for (Object field : datatype) {
//                Cell cell = row.createCell(colNum++);
//                if (field instanceof String) {
//                    cell.setCellValue((String) field);
//                } else if (field instanceof Integer) {
//                    cell.setCellValue((Integer) field);
//                }
//            }
//        }
//        try {
//            //        try {
//            FileOutputStream outputStream = new FileOutputStream(destination + delimiter + FILE_NAME);
//            workbook.write(outputStream);
//            workbook.close();
//
//        } catch (IOException ex) {
//
//        }
//
//    }
//    private boolean isTableEmpty() {
//        return table().getItems().isEmpty();
//    }

    private void exportTable(TableView tableView) throws FileNotFoundException {
        if (!tableView.getItems().isEmpty()) {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Datatypes in Java");
            Row row = sheet.createRow(0);
            for (int j = 0; j < tableView.getColumns().size(); j++) {
                row.createCell(j).setCellValue(tableView.getColumns().get(j).toString()); //getText()
            }

            for (int i = 0; i < tableView.getItems().size(); i++) {
                row = sheet.createRow(i + 1);
                for (int j = 0; j < tableView.getColumns().size(); j++) {
                    if (tableView.getColumns().get(j) != null) { //.getCellData(i) 
                        row.createCell(j).setCellValue(tableView.getColumns().get(j).toString()); //.getCellData(i) 
                    } else {
                        row.createCell(j).setCellValue("");
                    }
                }
            }
//            FileOutputStream fileOut = new FileOutputStream(d);
//            workbook.write(fileOut);
//            fileOut.close();

        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.initOwner(dialogStage);
            alert.setContentText("Table is empty");
            alert.showAndWait();
        }
    }

    @FXML
    private void newButton() throws IOException {
        System.out.println("newButton action ");

        switch (Seed.getMenu().getName()) {
            case "herbariumSpecimen.fxml": {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(Seed.class.getResource("view/addHerbariumSpecimen.fxml"));
                formPane = (AnchorPane) loader.load();
                primaryStage = new Stage();
                primaryStage.initStyle(StageStyle.UTILITY);
                primaryStage.setTitle("Add Herbarium Specimen");
                primaryStage.setResizable(false);
                Scene scene = new Scene(formPane);
                primaryStage.setScene(scene);
                primaryStage.initModality(Modality.WINDOW_MODAL);
                primaryStage.show();
                break;
            }
            case "samplingData.fxml": {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(Seed.class.getResource("view/addSamplingData.fxml"));
                formPane = (AnchorPane) loader.load();
                primaryStage = new Stage();
                primaryStage.initStyle(StageStyle.UTILITY);
                primaryStage.setTitle("Add Sampling Data");
                primaryStage.setResizable(false);
                Scene scene = new Scene(formPane);
                primaryStage.setScene(scene);
                primaryStage.initModality(Modality.WINDOW_MODAL);
                primaryStage.show();
                break;
            }
            case "habitatData.fxml": {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(Seed.class.getResource("view/addHabitatData.fxml"));
                formPane = (AnchorPane) loader.load();
                primaryStage = new Stage();
                primaryStage.initStyle(StageStyle.UTILITY);
                primaryStage.setTitle("Add Habitat Data");
                primaryStage.setResizable(false);
                Scene scene = new Scene(formPane);
                primaryStage.setScene(scene);
                primaryStage.initModality(Modality.WINDOW_MODAL);
                primaryStage.show();
                break;
            }
            case "locationData.fxml": {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(Seed.class.getResource("view/addLocationData.fxml"));
                formPane = (AnchorPane) loader.load();
                primaryStage = new Stage();
                primaryStage.initStyle(StageStyle.UTILITY);
                primaryStage.setTitle("Add Location Data");
                primaryStage.setResizable(false);
                Scene scene = new Scene(formPane);
                primaryStage.setScene(scene);
                primaryStage.initModality(Modality.WINDOW_MODAL);
                primaryStage.show();
                break;
            }
            case "collectionData.fxml": {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(Seed.class.getResource("view/collectionData.fxml"));
                formPane = (AnchorPane) loader.load();
                primaryStage = new Stage();
                primaryStage.initStyle(StageStyle.UTILITY);
                primaryStage.setTitle("Add Collection Data");
                primaryStage.setResizable(false);
                Scene scene = new Scene(formPane);
                primaryStage.setScene(scene);
                primaryStage.initModality(Modality.WINDOW_MODAL);
                primaryStage.show();
                break;
            }
            case "plantNames.fxml": {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(Seed.class.getResource("view/PlandAndIdentificationData.fxml"));
                formPane = (AnchorPane) loader.load();
                primaryStage = new Stage();
                primaryStage.initStyle(StageStyle.UTILITY);
                primaryStage.setTitle("Add Pland And Identification Data");
                primaryStage.setResizable(false);
                Scene scene = new Scene(formPane);
                primaryStage.setScene(scene);
                primaryStage.initModality(Modality.WINDOW_MODAL);
                primaryStage.show();
                break;
            }
            default:
                break;
        }
    }

    @FXML
    private void editButton() {
        System.out.println("editButton action");
    }

    private void deleteHerbarium() {

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.initOwner(dialogStage);
        alert.setTitle("Delete");
        alert.setHeaderText("Please correct invalid fields");
        alert.setContentText("Doy you want to delte this item?");

        alert.showAndWait();
    }

    @FXML
    private void deleteButton() throws IOException {
        System.out.println("deleteButton action");
        switch (Seed.getMenu().getName()) {
            case "herbariumSpecimen.fxml": {
                deleteHerbarium();
                break;
            }
            case "samplingData.fxml": {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(Seed.class.getResource("view/addSamplingData.fxml"));
                formPane = (AnchorPane) loader.load();
                primaryStage = new Stage();
                primaryStage.initStyle(StageStyle.UTILITY);
                primaryStage.setTitle("Add Sampling Data");
                primaryStage.setResizable(false);
                Scene scene = new Scene(formPane);
                primaryStage.setScene(scene);
                primaryStage.initModality(Modality.WINDOW_MODAL);
                primaryStage.show();
                break;
            }
            case "habitatData.fxml": {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(Seed.class.getResource("view/addHabitatData.fxml"));
                formPane = (AnchorPane) loader.load();
                primaryStage = new Stage();
                primaryStage.initStyle(StageStyle.UTILITY);
                primaryStage.setTitle("Add Habitat Data");
                primaryStage.setResizable(false);
                Scene scene = new Scene(formPane);
                primaryStage.setScene(scene);
                primaryStage.initModality(Modality.WINDOW_MODAL);
                primaryStage.show();
                break;
            }
            case "locationData.fxml": {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(Seed.class.getResource("view/addLocationData.fxml"));
                formPane = (AnchorPane) loader.load();
                primaryStage = new Stage();
                primaryStage.initStyle(StageStyle.UTILITY);
                primaryStage.setTitle("Add Location Data");
                primaryStage.setResizable(false);
                Scene scene = new Scene(formPane);
                primaryStage.setScene(scene);
                primaryStage.initModality(Modality.WINDOW_MODAL);
                primaryStage.show();
                break;
            }
            case "collectionData.fxml": {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(Seed.class.getResource("view/collectionData.fxml"));
                formPane = (AnchorPane) loader.load();
                primaryStage = new Stage();
                primaryStage.initStyle(StageStyle.UTILITY);
                primaryStage.setTitle("Add Collection Data");
                primaryStage.setResizable(false);
                Scene scene = new Scene(formPane);
                primaryStage.setScene(scene);
                primaryStage.initModality(Modality.WINDOW_MODAL);
                primaryStage.show();
                break;
            }
            case "plantNames.fxml": {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(Seed.class.getResource("view/PlandAndIdentificationData.fxml"));
                formPane = (AnchorPane) loader.load();
                primaryStage = new Stage();
                primaryStage.initStyle(StageStyle.UTILITY);
                primaryStage.setTitle("Add Pland And Identification Data");
                primaryStage.setResizable(false);
                Scene scene = new Scene(formPane);
                primaryStage.setScene(scene);
                primaryStage.initModality(Modality.WINDOW_MODAL);
                primaryStage.show();
                break;
            }
            default:
                break;
        }
    }

    @FXML 
    private void saveHandle(){
        
    }
    
    @FXML
    private void handleExit() {
        System.exit(0);
    }
}
