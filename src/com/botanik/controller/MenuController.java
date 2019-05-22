package com.botanik.controller;

import com.botanik.Seed;
import com.botanik.model.Menu;
 
import com.botanik.model.User;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Window;

/**
 *
 * @author teyyub , Feb 1, 2018 , 5:00:03 PM
 */
public class MenuController {
    
    private AnchorPane mainLayout;
    private BorderPane rootLayout;
    
    @FXML
    private UserController userController;
    ButtonController buttonController = new ButtonController();
    @FXML
    private TableColumn<User, String> userNameColumn;
    @FXML
    private TableColumn<User, String> passwordColumn;
    @FXML
    private TableColumn<User, String> createDateColumn;
    

//    @FXML
//    private TableColumn<Specimen, String> collectionColumn;
    @FXML
    private void configButton(ActionEvent event) {
        try {
            
            Node source = (Node) event.getSource();
            Window theStage = source.getScene().getWindow();
            Scene scene = theStage.getScene();
            
            rootLayout = (BorderPane) scene.getRoot();
            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Seed.class.getResource("view/UserPreference.fxml"));
            mainLayout = (AnchorPane) loader.load();
            
            rootLayout.setCenter(mainLayout);
            
        } catch (IOException e) {
            System.out.println("exception in " + e.getLocalizedMessage());
        }
        
    }
    
    @FXML
    private void plantNamesButton(ActionEvent event) {
        try {
            
            Node source = (Node) event.getSource();
            Window theStage = source.getScene().getWindow();
            Scene scene = theStage.getScene();
            
            rootLayout = (BorderPane) scene.getRoot();
            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Seed.class.getResource("view/PlandAndIdentificationData.fxml"));
             mainLayout = (AnchorPane) loader.load();
            
            rootLayout.setCenter(mainLayout);
            Seed.getMenu().setName("PlandAndIdentificationData.fxml");
            
        } catch (IOException e) {
            System.out.println("exception in " + e.getLocalizedMessage());
        }
        
    }
    
    @FXML
    private void collectionDataButton(ActionEvent event) {
        try {
            
            Node source = (Node) event.getSource();
            Window theStage = source.getScene().getWindow();
            Scene scene = theStage.getScene();
            
            rootLayout = (BorderPane) scene.getRoot();
            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Seed.class.getResource("view/collectionData.fxml"));
            mainLayout = (AnchorPane) loader.load();
            rootLayout.setCenter(mainLayout);
            Seed.getMenu().setName("collectionData.fxml");
        } catch (IOException e) {
            System.out.println("could not load collectionData " + e.getLocalizedMessage());
        }
        
    }
    
    @FXML
    private void locationDataButton(ActionEvent event) {
        try {
            
            Node source = (Node) event.getSource();
            Window theStage = source.getScene().getWindow();
            Scene scene = theStage.getScene();
            
            rootLayout = (BorderPane) scene.getRoot();
            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Seed.class.getResource("view/locationData.fxml"));
            mainLayout = (AnchorPane) loader.load();
            
            rootLayout.setCenter(mainLayout);
            Seed.getMenu().setName("locationData.fxml");
        } catch (IOException e) {
            System.out.println("exception in " + e.getLocalizedMessage());
        }
        
    }
    
    @FXML
    private void habitatDataButton(ActionEvent event) {
        try {
            
            Node source = (Node) event.getSource();
            Window theStage = source.getScene().getWindow();
            Scene scene = theStage.getScene();
            
            rootLayout = (BorderPane) scene.getRoot();
            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Seed.class.getResource("view/habitatData.fxml"));
            mainLayout = (AnchorPane) loader.load();
            
            rootLayout.setCenter(mainLayout);
            Seed.menu.setName("habitatData.fxml");
            
        } catch (IOException e) {
            System.out.println("exception in " + e.getLocalizedMessage());
        }
        
    }
    
    @FXML
    private void samplingDataButton(ActionEvent event) {
        try {
            
            Node source = (Node) event.getSource();
            Window theStage = source.getScene().getWindow();
            Scene scene = theStage.getScene();
            
            rootLayout = (BorderPane) scene.getRoot();
            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Seed.class.getResource("view/samplingData.fxml"));
            mainLayout = (AnchorPane) loader.load();
            
            rootLayout.setCenter(mainLayout);
            Seed.getMenu().setName("samplingData.fxml");
        } catch (IOException e) {
            System.out.println("exception in " + e.getLocalizedMessage());
        }
        
    }
    
    @FXML
    private void herbariumSpecimenButton(ActionEvent event) {
        try {
            
            Node source = (Node) event.getSource();
            Window theStage = source.getScene().getWindow();
            Scene scene = theStage.getScene();
            
            rootLayout = (BorderPane) scene.getRoot();
            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Seed.class.getResource("view/herbariumSpecimen.fxml"));
            mainLayout = (AnchorPane) loader.load();
            
            rootLayout.setCenter(mainLayout);          
            Seed.getMenu().setName("herbariumSpecimen.fxml");
            
        } catch (IOException e) {
            System.out.println("exception in " + e.getLocalizedMessage());
        }
        
    }
    
    @FXML
    private void germinationDataButton(ActionEvent event) {
        try {
            
            Node source = (Node) event.getSource();
            Window theStage = source.getScene().getWindow();
            Scene scene = theStage.getScene();
            
            rootLayout = (BorderPane) scene.getRoot();
            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Seed.class.getResource("view/UserPreference.fxml"));
            mainLayout = (AnchorPane) loader.load();
            
            rootLayout.setCenter(mainLayout);
            
        } catch (IOException e) {
            System.out.println("exception in " + e.getLocalizedMessage());
        }
        
    }
    
    @FXML
    private void researchDataButton(ActionEvent event) {
        try {
            
            Node source = (Node) event.getSource();
            Window theStage = source.getScene().getWindow();
            Scene scene = theStage.getScene();
            
            rootLayout = (BorderPane) scene.getRoot();
            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Seed.class.getResource("view/UserPreference.fxml"));
            mainLayout = (AnchorPane) loader.load();
            
            rootLayout.setCenter(mainLayout);
            
        } catch (IOException e) {
            System.out.println("exception in " + e.getLocalizedMessage());
        }
        
    }
    
    @FXML
    private void seedContentButton(ActionEvent event) {
        try {
            
            Node source = (Node) event.getSource();
            Window theStage = source.getScene().getWindow();
            Scene scene = theStage.getScene();
            
            rootLayout = (BorderPane) scene.getRoot();
            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Seed.class.getResource("view/UserPreference.fxml"));
            mainLayout = (AnchorPane) loader.load();
            
            rootLayout.setCenter(mainLayout);
            
        } catch (IOException e) {
            System.out.println("exception in " + e.getLocalizedMessage());
        }
        
    }
    
    @FXML
    private void seedWeightsButton(ActionEvent event) {
        try {
            
            Node source = (Node) event.getSource();
            Window theStage = source.getScene().getWindow();
            Scene scene = theStage.getScene();
            
            rootLayout = (BorderPane) scene.getRoot();
            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Seed.class.getResource("view/UserPreference.fxml"));
            mainLayout = (AnchorPane) loader.load();
            
            rootLayout.setCenter(mainLayout);
            
        } catch (IOException e) {
            System.out.println("exception in " + e.getLocalizedMessage());
        }
        
    }
    
    @FXML
    private void seedMorphologyButton(ActionEvent event) {
        try {
            
            Node source = (Node) event.getSource();
            Window theStage = source.getScene().getWindow();
            Scene scene = theStage.getScene();
            
            rootLayout = (BorderPane) scene.getRoot();
            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Seed.class.getResource("view/UserPreference.fxml"));
            mainLayout = (AnchorPane) loader.load();
            
            rootLayout.setCenter(mainLayout);
            
        } catch (IOException e) {
            System.out.println("exception in " + e.getLocalizedMessage());
        }
        
    }
    
    @FXML
    private void imageAndMapButton(ActionEvent event) {
        try {
            
            Node source = (Node) event.getSource();
            Window theStage = source.getScene().getWindow();
            Scene scene = theStage.getScene();
            
            rootLayout = (BorderPane) scene.getRoot();
            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Seed.class.getResource("view/UserPreference.fxml"));
            mainLayout = (AnchorPane) loader.load();
            
            rootLayout.setCenter(mainLayout);
            
        } catch (IOException e) {
            System.out.println("exception in " + e.getLocalizedMessage());
        }
        
    }
    
    @FXML
    private void storageBehaviourButton(ActionEvent event) {
        try {
            
            Node source = (Node) event.getSource();
            Window theStage = source.getScene().getWindow();
            Scene scene = theStage.getScene();
            
            rootLayout = (BorderPane) scene.getRoot();
            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Seed.class.getResource("view/UserPreference.fxml"));
            mainLayout = (AnchorPane) loader.load();
            
            rootLayout.setCenter(mainLayout);
            
        } catch (IOException e) {
            System.out.println("exception in " + e.getLocalizedMessage());
        }
        
    }
    
    @FXML
    private void literatureCitedButton(ActionEvent event) {
        try {
            
            Node source = (Node) event.getSource();
            Window theStage = source.getScene().getWindow();
            Scene scene = theStage.getScene();
            
            rootLayout = (BorderPane) scene.getRoot();
            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Seed.class.getResource("view/UserPreference.fxml"));
            mainLayout = (AnchorPane) loader.load();
            
            rootLayout.setCenter(mainLayout);
            
        } catch (IOException e) {
            System.out.println("exception in " + e.getLocalizedMessage());
        }
        
    }
    
    @FXML
    private void specimenButton(ActionEvent event) {
        try {
            System.out.println("specimenButton");
            
            Node source = (Node) event.getSource();
            Window theStage = source.getScene().getWindow();
            Scene scene = theStage.getScene();
            
            rootLayout = (BorderPane) scene.getRoot();
            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Seed.class.getResource("view/SpecimenOverview.fxml"));
            mainLayout = (AnchorPane) loader.load();
            rootLayout.setCenter(mainLayout);

//            FXMLLoader loader = new FXMLLoader();
//            loader.setLocation(Seed.class.getResource("view/UserPreference.fxml"));
//            mainLayout = (AnchorPane) loader.load();
//
//            FXMLLoader rootLoader = new FXMLLoader();
//            rootLoader.setLocation(Seed.class.getResource("view/mainLayout.fxml"));
//
//            rootLayout = (BorderPane) rootLoader.load();
//
//            rootLayout.setCenter(mainLayout);
        } catch (IOException e) {
            System.out.println("exception in " + e.getLocalizedMessage());
        }
        
    }
    
    private void loadUI(String ui) {
        Parent root = null;
        try {
//            root = FXMLLoader.load(getClass().getResource(ui + ".fxml"));
//bunu arasdirmaq lazimdir
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Seed.class.getResource("view/" + ui + ".fxml"));
            root = (AnchorPane) loader.load();
        } catch (IOException e) {
            System.out.println("exception in loadUI " + e.getMessage());
        }
        
    }
    
}
