package com.botanik.controller;

import com.botanik.dao.impl.UserDAOJDBC;
import com.botanik.dao.intf.UserDAO;
import com.botanik.model.User;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author teyyub , Feb 13, 2018 , 4:17:12 PM
 */
public class UserCreateController {

    private final UserDAO userDAO = new UserDAOJDBC();
    
    @FXML
    private TextField userNameField;

    @FXML
    private PasswordField passwordField ,passwordAgainField;
//    
//    private BorderPane rootLayout;
//     
    private Stage stage, dialogStage;
//    
    private User user;
// 
//
//    @FXML
//    private Button btnLogin;
//
//    @FXML
//    private ImageView loginImage;

    @FXML
    public void initialize() {
//        loginImage.setImage(new Image("image/login.jpg"));
    }

//    @FXML
//    private void login() {
//        try {
//            if (isInputValid()) {
//                user = userDAO.user(user_field.getText().trim(), password_field.getText().trim());
//
//                if (user == null) {
//                    Alert alert = new Alert(Alert.AlertType.ERROR);
//                    alert.initOwner(dialogStage);
//                    alert.setTitle("Information");
//                    alert.setHeaderText("Username or password is incorrect");
//                    alert.showAndWait();
//                } else {
//                    System.out.println("login");
//                    initRootLayout();
//                    showSpecimenOverview();
//                    loadLeftMenu();
//                }
//            }
//        } catch (Exception e) {
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.initOwner(dialogStage);
//            alert.setTitle("Information");
//            alert.setHeaderText("Error accurredd");
//            alert.setContentText("Contact with admin" + e.toString());
//
//            alert.showAndWait();
//        }
//
//    }

    @FXML
    private void createUser() {
        System.out.println("createUser");
        try {
            if (isInputValid()) {
                if (userDAO.checkUser(userNameField.getText().trim())) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.initOwner(dialogStage);
                    alert.setContentText("This user is exist");
                    alert.showAndWait();
                } else {
                    user = new User(userNameField.getText().trim(), passwordField.getText().trim());
                    userDAO.createUser(user);
                    if (user.getDaoStatus().equals("1")) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.initOwner(dialogStage);
                        alert.setContentText("User saved");
                        alert.showAndWait();
//                        loadUserTable();
                    } else {
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.initOwner(dialogStage);
                        alert.setContentText("User is not saved");
                        alert.showAndWait();
                    }
                }
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setContentText("Error is accurred " + e.getMessage());
            alert.showAndWait();
        }

    }

    
     private boolean isInputValid() {
        String errorMessage = "";
        if (userNameField.getText() == null || userNameField.getText().length() == 0) {
            errorMessage += "Enter username!\n";
        }

        if ((passwordField.getText() == null || passwordField.getText().length() == 0)
                || (passwordAgainField.getText() == null || passwordAgainField.getText().length() == 0)) {
            errorMessage += "Enter password!\n";
        }  
        else if (passwordField.getText() == null ? passwordAgainField.getText() != null : !passwordField.getText().equals(passwordAgainField.getText())) {
            errorMessage += "Password is not same!\n";
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
//
//    public void initRootLayout() {
//        try {
//            // Load root layout from fxml file.
//            FXMLLoader loader = new FXMLLoader();
//            loader.setLocation(Seed.class.getResource("view/mainLayout.fxml"));
//
//            rootLayout = (BorderPane) loader.load();
//            stage = new Stage();
//            // Show the scene containing the root layout.
////            primaryStage.close();
//            Scene scene = new Scene(rootLayout);
//            stage.setScene(scene);
//            stage.setMaximized(true);
//            stage.setMinHeight(1000);
//            stage.setMinWidth(1000);
//            stage.show();
//            Stage oldStage = (Stage) btnLogin.getScene().getWindow();
//            oldStage.close();
//        } catch (IOException e) {
//            System.out.println("exception in file load \t" + e.getLocalizedMessage());
//        }
//    }
//
//    public void showSpecimenOverview() {
//        try {
//            // Load person overview.
//            FXMLLoader loader = new FXMLLoader();
//            loader.setLocation(Seed.class.getResource("view/SpecimenOverview.fxml"));
//            AnchorPane specimenOverview = (AnchorPane) loader.load();
//
//            // Set person overview into the center of root layout.
//            rootLayout.setCenter(specimenOverview);
//            SpecimenOverviewController controller = loader.getController();
////            controller.setBotanik(this);
//        } catch (IOException e) {
//            e.getLocalizedMessage();
//        }
//    }
//
//    @FXML
//    public void onEnter() {
//        login();
//    }
//
//    public void loadLeftMenu() {
//        try {
//            // Load person overview.
//            FXMLLoader loader = new FXMLLoader();
//            loader.setLocation(Seed.class.getResource("view/LeftMenu1.fxml"));
//            AnchorPane leftMenu = (AnchorPane) loader.load();
//
//            // Set person overview into the center of root layout.
//            rootLayout.setLeft(leftMenu);
////            SpecimenOverviewController controller = loader.getController();
////            controller.setBotanik(this);
//        } catch (IOException e) {
//            e.getLocalizedMessage();
//        }
//    }
//
//    public void createUser() {
//        System.out.println("createUser");
//    }
//
//    public BorderPane getRootLayout() {
//        return rootLayout;
//    }
//
//    public Stage getStage() {
//        return stage;
//    }
    
    
}
