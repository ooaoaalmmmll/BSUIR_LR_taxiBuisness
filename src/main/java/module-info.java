module com.example.taxiBusiness {
    requires javafx.controls;
    requires javafx.fxml;

    opens LogInWindow.controller to javafx.fxml;
    //opens Administrator.CreateNewCarWindow.controller to javafx.graphics;
    opens Administrator.SendDriverWindow.controller to javafx.fxml;
    //opens Administrator.ShowCarsWindow.controller to javafx.graphics;
    //opens Administrator.ShowDriversWindow.controller to javafx.graphics;
    opens Administrator.MainWindow.controller to javafx.fxml;
    opens Administrator.CreateNewCarWindow.controller to javafx.fxml;
    opens Administrator.ShowCarsWindow.controller to javafx.fxml;
    opens Administrator.ShowDriversWindow.controller to javafx.fxml;


    exports Administrator.CreateNewCarWindow.controller to javafx.fxml;
    exports Administrator.SendDriverWindow.controller to javafx.fxml;
    exports Administrator.ShowCarsWindow.controller to javafx.fxml;
    exports Administrator.ShowDriversWindow.controller to javafx.fxml;
    exports runner to javafx.graphics;
    exports LogInWindow.controller to javafx.fxml;
    exports Administrator.MainWindow.controller to javafx.fxml;

    //opens Client to javafx.fxml;

    //exports com.example.CreateNewController to javafx.graphics;


}