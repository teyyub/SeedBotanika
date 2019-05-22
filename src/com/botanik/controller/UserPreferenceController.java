package com.botanik.controller;

import com.botanik.Seed;
import com.botanik.dao.impl.UserDAOJDBC;
import com.botanik.dao.intf.UserDAO;
 
import com.botanik.model.User;
import java.util.List;
import java.util.Observable;
import java.util.Optional;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author teyyub , Apr 8, 2018 , 4:14:22 PM
 */
public class UserPreferenceController {

    private AnchorPane createUserLayout;
    private Stage dialogStage;
    private User user;
    private UserDAO userDAO = new UserDAOJDBC();
    @FXML
    private TextField userNameField;
    @FXML
    private PasswordField passwordTextField, passwordAgainField;

    ObservableList<User> userList;
    List<User> users;

    @FXML
    private TableView usersTable;

    @FXML
    private TableColumn<User, Integer> idColumn;
    @FXML
    private TableColumn<User, String> usernameColumn;
    @FXML
    private TableColumn<User, String> statusColumn;

    @FXML
    private void initialize() {
        System.out.println("initialize");
        loadUserTable();

        idColumn.setCellValueFactory(new PropertyValueFactory<>("user_id"));
        usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

    }

    private void loadUsers() {
        users = userDAO.loadUsers();
    }

    private void loadUserTable() {
        loadUsers();
        userList = FXCollections.observableArrayList(users);
        usersTable.setItems(userList);
        usersTable.refresh();
    }

    @FXML
    private void refreshTableAction() {
        loadUserTable();
    }

    @FXML
    private void changePasswordAction() {
        User selectedItem = (User) usersTable.getSelectionModel().getSelectedItem();
        if (selectedItem == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.initOwner(dialogStage);
            alert.setContentText("User is not selected");
            alert.showAndWait();
        } else {
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Password reset ");
//            dialog.setHeaderText("Look, a Text Input Dialog");
            dialog.setContentText("Please enter password:");

            Optional<String> result = dialog.showAndWait();
            if (result.isPresent()) {
                try {
                    userDAO.resetPassword(selectedItem.getUser_id(), result.get().trim());
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.initOwner(dialogStage);
                    alert.setContentText("User password is resetted");
                    alert.showAndWait();

                } catch (Exception e) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.initOwner(dialogStage);
                    alert.setContentText("User password is not resetted");
                    alert.showAndWait();

                }

            }
        }
    }

    @FXML
    private void createUserDialog() {
        try {
            System.out.println("create user dialog");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Seed.class.getResource("view/CreateUser.fxml"));

            createUserLayout = (AnchorPane) loader.load();

            Stage stage = new Stage();

            Scene scene = new Scene(createUserLayout);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();

            System.out.println("salam");

        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setContentText("Error is accurred " + e.getMessage());
            alert.showAndWait();

        }
    }

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
                    user = new User(userNameField.getText().trim(), passwordTextField.getText().trim());
                    userDAO.createUser(user);
                    if (user.getDaoStatus().equals("1")) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.initOwner(dialogStage);
                        alert.setContentText("User saved");
                        alert.showAndWait();
                        loadUserTable();
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

    @FXML
    public void deleteUser() {
        System.out.println("deleteUser");
        User selectedItem = (User) usersTable.getSelectionModel().getSelectedItem();
        if (selectedItem == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.initOwner(dialogStage);
            alert.setContentText("User is not selected");
            alert.showAndWait();
        } else {
            if (isDeleteOk()) {
                try {
                    userDAO.deleteUser(selectedItem.getUser_id());
                    loadUserTable();
                } catch (Exception e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.initOwner(dialogStage);
                    alert.setContentText("Error is accurred " + e.getMessage());
                    alert.showAndWait();
                }
            }
        }
    }

    private boolean isDeleteOk() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.initOwner(dialogStage);
        alert.setContentText("Do you want to delete this user? ");
        Optional<ButtonType> result = alert.showAndWait();
        return result.get() == ButtonType.OK;
    }

    @FXML
    public void changePassword() {

    }

    private boolean isInputValid() {
        String errorMessage = "";
        if (userNameField.getText() == null || userNameField.getText().length() == 0) {
            errorMessage += "Enter username!\n";
        }

        if ((passwordTextField.getText() == null || passwordTextField.getText().length() == 0)
                || (passwordAgainField.getText() == null || passwordAgainField.getText().length() == 0)) {
            errorMessage += "Enter password!\n";
        } //        if (passwordAgainField.getText() == null || passwordAgainField.getText().length() == 0) {
        //            errorMessage += "Enter password again!\n";
        //        }
        else if (passwordTextField.getText() == null ? passwordAgainField.getText() != null : !passwordTextField.getText().equals(passwordAgainField.getText())) {
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
}
