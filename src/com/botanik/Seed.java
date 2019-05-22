package com.botanik;

import com.botanik.model.LocalIcon;
import com.botanik.model.Menu;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Expression teyyub is undefined on line 18, column 14 in
 * Templates/javafx/FXML.java. Jan 7, 2018 10:47:29 AM
 */
public class Seed extends Application {
    
    private AnchorPane loginLayout;
    public static boolean isGuest = false;
    public static Menu menu = new Menu();
    
    public static Menu getMenu() {
        return menu;
    }
    
    public static void setMenu(Menu menu) {
        Seed.menu = menu;
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            
            FXMLLoader loader = new FXMLLoader();
//            loader.setLocation(Seed.class.getResource("view/Login.fxml"));

//            FXMLLoader loader = new FXMLLoader(getClass().getResource("view/splash.fxml"));
            loader.setLocation(Seed.class.getResource("view/splash.fxml"));
            loginLayout = (AnchorPane) loader.load();
            
            primaryStage.setTitle("Welcome");
            primaryStage.setResizable(false);
            Scene scene = new Scene(loginLayout);
            primaryStage.setScene(scene);
            
            primaryStage.initStyle(StageStyle.UTILITY);            
            primaryStage.setAlwaysOnTop(true);
            primaryStage.show();
            
        } catch (IOException e) {
            System.out.println("Could not load file " + e.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
