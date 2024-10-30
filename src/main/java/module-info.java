module com.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires java.desktop;
    requires transitive javafx.graphics;
    
    exports com.example;
    opens com.example.components to javafx.fxml;
    exports com.example.components;
    requires javafx.webEmpty;
}