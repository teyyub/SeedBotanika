package com.botanik.controller;

import com.botanik.Seed;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author teyyub , Feb 21, 2018 , 12:25:50 PM
 */
public class FirstPageController {

    private AnchorPane loginLayout;
    private BorderPane rootLayout;
    @FXML
    private Button btnOpenLogin, btnDatabase;
    

    @FXML
    public void loginButton() {
        try {
            System.out.println("open login page");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Seed.class.getResource("view/Login.fxml"));

            loginLayout = (AnchorPane) loader.load();

            Stage stage = new Stage();

            Scene scene = new Scene(loginLayout);
            stage.setScene(scene);
            stage.setResizable(false);
 
            stage.show();
            Stage oldStage = (Stage) btnOpenLogin.getScene().getWindow();
            oldStage.close();

        } catch (Exception e) {
            System.out.println("exception in openin login page");
        }
    }

    @FXML
    public void databaseButton() {
        initRootLayout();
//        showSpecimenOverview();
    }

    public void initRootLayout() {
        try {
            System.out.println("open login page");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Seed.class.getResource("view/mainLayout.fxml"));
            
            rootLayout = (BorderPane) loader.load();
            
            Stage stage = new Stage();

            Scene scene = new Scene(rootLayout);
            stage.setScene(scene);
            
            ToolBar tb = (ToolBar) scene.lookup("#toolBar");
            tb.setDisable(true);
            stage.setMaximized(true);
            stage.setMinHeight(1000);
            stage.setMinWidth(1000);

            stage.show();
            
            showSpecimenOverview();

            Stage oldStage = (Stage) btnDatabase.getScene().getWindow();
            oldStage.close();

        } catch (Exception e) {
            System.out.println("exception in openin login page");
        }
    }

    public void showSpecimenOverview() {
        try {
            System.out.println("11111111111111111");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Seed.class.getResource("view/SpecimenOverview.fxml"));
            AnchorPane specimenOverview = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(specimenOverview);
//            SpecimenOverviewController controller = loader.getController();
//            controller.disableAddSpecimenButton();
//            Seed.isGuest = true;
//            controller.setBotanik(this);
        } catch (IOException e) {
            e.getLocalizedMessage();
        }
    }
}
