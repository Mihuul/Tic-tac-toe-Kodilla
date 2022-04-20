module com.example.first_project {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.first_project to javafx.fxml;
    exports com.first_project;
    exports com.first_project.game_functions;
    opens com.first_project.game_functions to javafx.fxml;
}