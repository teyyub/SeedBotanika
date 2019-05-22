package com.botanik.controller;

import com.botanik.Seed;
import com.botanik.dao.impl.UserDAOJDBC;
import com.botanik.dao.intf.UserDAO;
import com.botanik.model.LocalIcon;
import com.botanik.model.User;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

/**
 *
 * @author teyyub , Feb 13, 2018 , 4:17:12 PM
 */
public class UserController {

    private final UserDAO userDAO = new UserDAOJDBC();
    public static boolean isRegularUser = false;
    @FXML
    private TextField user_field;

    @FXML
    private PasswordField password_field;

    private BorderPane rootLayout;

    private AnchorPane anchorLayout;

    @FXML
    private AnchorPane anchorMain;
    private AnchorPane loginLayout;
    private Stage stage, dialogStage;//, primaryStage;

    private User user;
//    private Logger logger = LoggerFactory.getLogger("teyyub");

    @FXML
    private Button btnLogin, btnNew, btnImages, btnSearch, btnConfig, btnAdmin;
//
//    @FXML
//    private ImageView loginImage;

    @FXML
    public void initialize() {
//        loginImage.setImage(new Image("image/login.jpg"));
    }

    @FXML
    private void login() {
        try {
//             initAccessLayout();
            if (isInputValid()) {
                user = userDAO.user(user_field.getText().trim(), password_field.getText().trim());
                if (user == null) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.initOwner(dialogStage);
                    alert.setTitle("Information");
                    alert.setHeaderText("Username or password is incorrect");
                    alert.showAndWait();
                } else {
                    initAccessLayout();
                }
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Information");
            alert.setHeaderText("Error accurredd");
            alert.setContentText("Contact with admin " + user + " -- " + e.toString());

            alert.showAndWait();
        }

    }

    private boolean isInputValid() {
        String errorMessage = "";
        if (user_field.getText().trim() == null || user_field.getText().trim().length() == 0) {
            errorMessage += "Enter username ";
        }
        if (password_field.getText().trim() == null || password_field.getText().trim().length() == 0) {
            errorMessage += "Enter password!\n";
        }
        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }

    @FXML
    private void openNewData() {
        try {

            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();

            loader.setLocation(Seed.class.getResource("view/mainTabMenu.fxml"));

            anchorLayout = (AnchorPane) loader.load();

            Scene scene = new Scene(anchorLayout);
            stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Seed Database");
            stage.getIcons().add(new LocalIcon().getIcon());
            stage.show();

            stage.setOnCloseRequest((WindowEvent we) -> {
                try {
                    loadFirstPage();
                } catch (IOException ex) {
                    Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            Stage oldStage = (Stage) btnNew.getScene().getWindow();
            oldStage.close();

        } catch (IOException e) {
            showmessage("xeta " + e.getMessage());
        }
    }

    @FXML
    private void search() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Seed.class.getResource("view/seedSearch.fxml"));
            isRegularUser = false;
            anchorLayout = (AnchorPane) loader.load();
            Scene scene = new Scene(anchorLayout);
            stage = new Stage();
            stage.setScene(scene);
            stage.getIcons().add(new LocalIcon().getIcon());
            stage.show();
            stage.setOnCloseRequest((WindowEvent we) -> {
                try {
                    loadFirstPage();
                } catch (IOException ex) {
                    Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            Stage oldStage = (Stage) btnSearch.getScene().getWindow();
            oldStage.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    @FXML
    private void searchView() throws IOException {
//        final String dir = System.getProperty("user.dir");
//        Logger logger = Logger.getLogger("Mylog");
//        FileHandler fh = new FileHandler(dir + "/slog.txt");
        try {

            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Seed.class.getResource("view/seedSearch.fxml"));
            isRegularUser = true;
            anchorLayout = (AnchorPane) loader.load();
            Scene scene = new Scene(anchorLayout);
            stage = new Stage();
            stage.setScene(scene);
            stage.getIcons().add(new LocalIcon().getIcon());
            stage.show();
            stage.setOnCloseRequest((WindowEvent we) -> {
                try {
                    loadFirstPage();
                } catch (IOException ex) {
                    Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            Stage oldStage = (Stage) btnSearch.getScene().getWindow();
            oldStage.close();
        } catch (IOException e) {

//            logger.addHandler(fh);
//            logger.info(e.getMessage());
//            System.err.println(e.getMessage());
        }
//        logger.addHandler(fh);
//        logger.info("end of procedure ");

    }

    public void adminAccess() throws Exception {
        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Seed.class.getResource("view/Login.fxml"));
            loginLayout = (AnchorPane) loader.load();
//            primaryStage.setTitle("Welcome");
//            primaryStage.setResizable(false);
            Scene scene = new Scene(loginLayout);
            stage = new Stage();
            stage.setScene(scene);
            stage.getIcons().add(new LocalIcon().getIcon());
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
            stage.setOnCloseRequest((WindowEvent we) -> {
                try {
                    loadFirstPage();
                } catch (IOException ex) {
                    Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            Stage oldStage = (Stage) btnAdmin.getScene().getWindow();
            oldStage.close();

        } catch (IOException e) {
            System.out.println("Could not load file " + e.getMessage());
        }
    }

    @FXML
    private void images() throws Exception {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Seed.class.getResource("view/SearchImages.fxml"));

//            anchorMain = (AnchorPane) loader.load();
            anchorLayout = (AnchorPane) loader.load();
            Scene scene = new Scene(anchorLayout);

            stage = new Stage();
            stage.setScene(scene);
            stage.getIcons().add(new LocalIcon().getIcon());
            stage.show();
            stage.setOnCloseRequest((WindowEvent we) -> {
                try {
                    loadFirstPage();
                } catch (IOException ex) {
                    Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            Stage oldStage = (Stage) btnImages.getScene().getWindow();
            oldStage.close();

        } catch (IOException e) {
            throw new Exception("Could not load file " + e.getMessage());
//            System.out.println("exception in file load \t" + e.getMessage());
        }
    }

    @FXML
    private void config() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Seed.class.getResource("view/UserPreference.fxml"));
//            AnchorPane searchPane = (AnchorPane) loader.load();
            anchorLayout = (AnchorPane) loader.load();
            Scene scene = new Scene(anchorLayout);

            stage = new Stage();
            stage.setScene(scene);

            stage.show();
            stage.setOnCloseRequest((WindowEvent we) -> {
                try {
                    loadFirstPage();
                } catch (IOException ex) {
                    Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            Stage oldStage = (Stage) btnConfig.getScene().getWindow();
            oldStage.close();

        } catch (IOException e) {
            e.getLocalizedMessage();
        }
    }

    private void loadFirstPage() throws IOException {
        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(Seed.class.getResource("view/access_first.fxml"));
        loader.setLocation(Seed.class.getResource("view/splash.fxml"));
        anchorLayout = (AnchorPane) loader.load();
        Scene scene = new Scene(anchorLayout);
        stage = new Stage();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public void initAccessLayout() throws Exception {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Seed.class.getResource("view/access_first.fxml"));

//            loader.setLocation(Seed.class.getResource("view/splash.fxml"));
            anchorLayout = (AnchorPane) loader.load();
            Scene scene = new Scene(anchorLayout);

            stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.getIcons().add(new LocalIcon().getIcon());
            stage.show();

            Stage oldStage = (Stage) btnLogin.getScene().getWindow();
            oldStage.close();

        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);

            alert.setHeaderText("Information");
            alert.setContentText(e.getMessage());

            alert.showAndWait();
        }
    }

    @FXML
    public void onEnter() {
        login();
    }

    public void createUser() {
        System.out.println("createUser");
    }

    public BorderPane getRootLayout() {
        return rootLayout;
    }

    public Stage getStage() {
        return stage;
    }

    private void showmessage(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.initOwner(dialogStage);
        alert.setHeaderText(message);
        alert.showAndWait();
    }

}
