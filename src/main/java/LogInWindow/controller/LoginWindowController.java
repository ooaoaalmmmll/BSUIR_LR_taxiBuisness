package LogInWindow.controller;

import Driver.controller.DriverWindowController;
import Driver.entity.Driver;
import controller.Controller;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class LoginWindowController {

    @FXML
    private Button setAdminBtn;

    @FXML
    private Button exitBtn;

    @FXML
    private Label statusLabel;

    @FXML
    private VBox VBoxLayer;

    public Controller controller = new Controller();


    private int updateList(){
        int counter = 0;
        for (Driver driver: controller.getDrivers()) {
            if (!driver.getApplication().getFinished()) {
                counter++;
                Button chooseBtn = new Button("Водитель: " + driver.getFirstName());
                chooseBtn.setFont(Font.font("Georgia", null, null, 23));
                chooseBtn.setWrapText(true);
                chooseBtn.setMinWidth(382.0);
                chooseBtn.setMaxWidth(382.0);
                chooseBtn.setMaxHeight(60.0);
                chooseBtn.setMinHeight(60.0);
                VBoxLayer.getChildren().add(chooseBtn);
                chooseBtn.setOnAction(event -> {
                    try {
                        Stage LogInStage = (Stage) chooseBtn.getScene().getWindow();
                        LogInStage.close();
                        URL url = new File("C:\\Users\\AKav\\IdeaProjects\\taxiBusiness\\src\\main\\java\\Driver\\fxml\\DriverMainWindow.fxml").toURL();
                        Parent root = FXMLLoader.load(url);
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Driver/fxml/DriverMainWindow.fxml"));

                        DriverWindowController driverWindowController = new DriverWindowController(controller.getDrivers().indexOf(driver));
                        loader.setController(driverWindowController);
                        Stage newStage = new Stage();
                        newStage.setTitle("Driver");
                        newStage.setScene(new Scene(root));
                        newStage.show();
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                });
            }
        }
        return counter;
    }


    @FXML
    void initialize(){
        if (updateList() == 0){
            statusLabel.setText("Водителей нет");
        }
        setAdminBtn.setOnAction(event -> {
            Stage LogInStage = (Stage) setAdminBtn.getScene().getWindow();
            LogInStage.close();
            try {
                URL url = new File("C:\\Users\\AKav\\IdeaProjects\\taxiBusiness\\src\\main\\java\\Administrator\\MainWindow\\fxml\\adminMainWindow.fxml").toURL();
                Parent root = FXMLLoader.load(url);
                //Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/Administrator/MainWindow/fxml/adminMainWindow.fxml")));
                Stage newStage = new Stage();
                newStage.setTitle("Administrator");
                newStage.setScene(new Scene(root));
                newStage.show();
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
