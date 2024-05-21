package runner;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.Objects;

public class Runner extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception{
        URL url = new File("C:\\Users\\AKav\\IdeaProjects\\taxiBusiness\\src\\main\\java\\LogInWindow\\fxml\\loginWindow.fxml").toURL();
        Parent root = FXMLLoader.load(url);
        Stage newStage = new Stage();
        newStage.setTitle("Administrator");
        newStage.setScene(new Scene(root));
        newStage.show();
    }

    public static void main(String[] args) {
        launch(args);

    }
}
