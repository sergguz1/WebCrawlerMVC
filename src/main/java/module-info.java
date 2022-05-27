module com.example.webcrawlermvc {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.webcrawlermvc to javafx.fxml;
    exports com.example.webcrawlermvc;
    exports com.example.webcrawlermvc.controller;
    opens com.example.webcrawlermvc.controller to javafx.fxml;
}