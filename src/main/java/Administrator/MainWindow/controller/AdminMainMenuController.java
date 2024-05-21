package Administrator.MainWindow.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AdminMainMenuController {


    @FXML
    private Button newCarBtn;

    @FXML
    private Button sendNewDriverBtn;

    @FXML
    private Button showCarBtn;

    @FXML
    private Button exitBtn;

    @FXML
    private Button loginBtn;

    @FXML
    private Button showDriversBtn;


    @FXML
    void initialize() {
        loginBtn.setOnAction(event -> {
            Stage LogInStage = (Stage) loginBtn.getScene().getWindow();
            LogInStage.close();
            try {
                URL url = new File("C:\\Users\\AKav\\IdeaProjects\\taxiBusiness\\src\\main\\java\\LogInWindow\\fxml\\loginWindow.fxml").toURL();
                Parent root = FXMLLoader.load(url);
                //Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/taxiBusiness/LogInWindow/fxml/loginWindow.fxml")));
                Stage primaryStage = new Stage();
                primaryStage.setTitle("Authorization");
                primaryStage.setScene(new Scene(root));
                primaryStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        newCarBtn.setOnAction(event -> {
            Stage mainStage = (Stage) newCarBtn.getScene().getWindow();
            mainStage.close();
            try {
                URL url = new File("C:\\Users\\AKav\\IdeaProjects\\taxiBusiness\\src\\main\\java\\Administrator\\CreateNewCarWindow\\fxml\\CreateNewCarWindow.fxml").toURL();
                Parent root = FXMLLoader.load(url);
               // Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/taxiBusiness/Administrator/CreateNewCarWindow/fxml/CreateNewCarWindow.fxml")));
                Stage primaryStage = new Stage();
                primaryStage.setTitle("New Car");
                primaryStage.setScene(new Scene(root));
                primaryStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        sendNewDriverBtn.setOnAction(event -> {
            Stage mainStage = (Stage) sendNewDriverBtn.getScene().getWindow();
            mainStage.close();
            try {
                URL url = new File("C:\\Users\\AKav\\IdeaProjects\\taxiBusiness\\src\\main\\java\\Administrator\\SendDriverWindow\\fxml\\SendDriverWindow.fxml").toURL();
                Parent root = FXMLLoader.load(url);
                //Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/taxiBusiness/Administrator/SendDriverWindow/fxml/SendDriverWindow.fxml")));
                Stage primaryStage = new Stage();
                primaryStage.setTitle("Send Driver");
                primaryStage.setScene(new Scene(root));
                primaryStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        showDriversBtn.setOnAction(event -> {
            Stage mainStage1 = (Stage) showDriversBtn.getScene().getWindow();
            mainStage1.close();
            try {
                URL url = new File("C:\\Users\\AKav\\IdeaProjects\\taxiBusiness\\src\\main\\java\\Administrator\\ShowDriversWindow\\fxml\\ShowDriversWindow.fxml").toURL();
                Parent root1= FXMLLoader.load(url);

                //Parent root1 = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/taxiBusiness/Administrator/ShowDriversWindow/fxml/ShowDriversWindow.fxml")));
                Stage primaryStage = new Stage();
                primaryStage.setTitle("Show Driver");
                primaryStage.setScene(new Scene(root1));
                primaryStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        showCarBtn.setOnAction(event -> {
            Stage mainStage1 = (Stage) showCarBtn.getScene().getWindow();
            mainStage1.close();
            try {
                URL url = new File("C:\\Users\\AKav\\IdeaProjects\\taxiBusiness\\src\\main\\java\\Administrator\\ShowCarsWindow\\fxml\\ShowCarsWindow.fxml").toURL();
                Parent root2 = FXMLLoader.load(url);
               // Parent root2 = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/taxiBusiness/Administrator/ShowCarsWindow/fxml/ShowCarsWindow.fxml")));
                Stage primaryStage = new Stage();
                primaryStage.setTitle("Show Cars");
                primaryStage.setScene(new Scene(root2));
                primaryStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        exitBtn.setOnAction(event -> {
            Stage LogInStage = (Stage) exitBtn.getScene().getWindow();
            LogInStage.close();
        });
    }
}
