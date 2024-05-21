package Administrator.CreateNewCarWindow.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;

import controller.Controller;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CreateNewCarController {


    @FXML
    private Button goToMainMenuBtn;

    @FXML
    private Label statusLabel;

    @FXML
    private TextField carNameTextField;

    @FXML
    private Button crtCarBtn;

    @FXML
    private TextField mileageNumberTextField;

    private Controller controller = new Controller();


    @FXML
    void initialize() {
        String regex = "\\d+";

        crtCarBtn.setOnAction(event -> {
            if (!carNameTextField.getText().trim().equals("") && !mileageNumberTextField.getText().trim().equals("") &&
                    mileageNumberTextField.getText().matches(regex)){

                controller.createCar(carNameTextField.getText().trim(), Integer.parseInt(mileageNumberTextField.getText()));
                statusLabel.setTextFill(Color.GREEN);
                statusLabel.setText("Cохранено!");

                carNameTextField.setText("");
                mileageNumberTextField.setText("");

            } else {
                statusLabel.setTextFill(Color.RED);
                if (carNameTextField.getText().trim().equals("") || mileageNumberTextField.getText().trim().equals("")) {
                    statusLabel.setText("Заполните все ячейки!");
                } else if (!mileageNumberTextField.getText().matches(regex)) {
                    statusLabel.setText("Пробег должен быть указан в цифрах!");
                }
            }
        });

        goToMainMenuBtn.setOnAction(event -> {
            Stage LogInStage = (Stage) goToMainMenuBtn.getScene().getWindow();
            LogInStage.close();
            try {
                URL url = new File("C:\\Users\\AKav\\IdeaProjects\\taxiBusiness\\src\\main\\java\\Administrator\\MainWindow\\fxml\\adminMainWindow.fxml").toURL();
                Parent root = FXMLLoader.load(url);
               // Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/taxiBusiness/Administrator/MainWindow/fxml/adminMainWindow.fxml")));
                Stage newStage = new Stage();
                newStage.setTitle("Administrator");
                newStage.setScene(new Scene(root));
                newStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });


    }
}
