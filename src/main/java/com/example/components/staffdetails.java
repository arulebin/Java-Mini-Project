package com.example.components;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class staffdetails extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Staff Details");

        // TableView to display staff details
        TableView<Staff> table = new TableView<>();

        // Image Column
        TableColumn<Staff, ImageView> imageColumn = new TableColumn<>("Photo");
        imageColumn.setCellValueFactory(new PropertyValueFactory<>("image"));
        imageColumn.setPrefWidth(100);

        // Name Column
        TableColumn<Staff, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        nameColumn.setPrefWidth(200);

        // Designation Column
        TableColumn<Staff, String> designationColumn = new TableColumn<>("Designation");
        designationColumn.setCellValueFactory(new PropertyValueFactory<>("designation"));
        designationColumn.setPrefWidth(150);

        // Department Column
        TableColumn<Staff, String> departmentColumn = new TableColumn<>("Department");
        departmentColumn.setCellValueFactory(new PropertyValueFactory<>("department"));
        departmentColumn.setPrefWidth(250);

        // Subject Column
        TableColumn<Staff, String> subjectColumn = new TableColumn<>("Subject");
        subjectColumn.setCellValueFactory(new PropertyValueFactory<>("subject"));
        subjectColumn.setPrefWidth(300);
        
        // Email Column
        TableColumn<Staff, String> emailColumn = new TableColumn<>("Email");
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        emailColumn.setPrefWidth(250);

        // Adding columns to the table
        table.getColumns().addAll(imageColumn, nameColumn, designationColumn, departmentColumn, subjectColumn, emailColumn);

        // Sample data
        table.getItems().add(new Staff(
                new ImageView(new Image("file:src/main/java/com/example/assets/abvl.jpg", 80, 80, false, false)),
                "Dr. A. Bamila Virgin Louis",
                "Assistant Professor",
                "Department of Computer Science and Engineering",
                "bamilavirgin@sxcce.edu.in",
                "Object Oriented Programming- CS22301"
        ));

        table.getItems().add(new Staff(
                new ImageView(new Image("file:src/main/java/com/example/assets/subitha-final1-1.jpg", 80, 80, false, false)),
                "Dr. A. Subitha",
                "Associate Professor",
                "Department of Computer Science and Engineering",
                "subitha@sxcce.edu.in",
                "Data Structures- CS22302"
        ));

        table.getItems().add(new Staff(
                new ImageView(new Image("file:src/main/java/com/example/assets/sls.jpg", 80, 80, false, false)),
                "Mrs. S. L. Soniya",
                "Assistant Professor",
                "Department of Computer Science and Engineering",
                "soniya@yahoo.co.in",
                "Digital Principles and System Design- CS22303"
        ));

        table.getItems().add(new Staff(
                new ImageView(new Image("file:src/main/java/com/example/assets/simi.jpg", 80, 80, false, false)),
                "Mrs. J.S. Simi Mole",
                "Assistant Professor",
                "Department of Computer Science and Engineering",
                "jssree@yahoo.co.in",
                "Computer Organisation and Architecture- CS22304"
        ));

        table.getItems().add(new Staff(
                new ImageView(new Image("file:src/main/java/com/example/assets/ts193.jpg", 80, 80, false, false)),
                "Mrs. P. Ajitha",
                "Assistant Professor",
                "Department of Computer Science and Engineering",
                "ajithabose@sxcce.edu.in",
                "Constitution of India- AC22301"
        ));

        table.getItems().add(new Staff(
                new ImageView(new Image("file:src/main/java/com/example/assets/sxp.jpg", 80, 80, false, false)),
                "Dr. Sobini X. Pushpa",
                "Assistant Professor",
                "Department of Computer Science and Engineering",
                "sobinix@yahoo.com",
                "Value Education- HS22301"
        ));

        table.getItems().add(new Staff(
                new ImageView(new Image("file:src/main/java/com/example/assets/Adin-copy1.jpg", 80, 80, false, false)),
                "Mrs. P. Adin Shiny",
                "Assistant Professor",
                "Department of Humanities and Sciences",
                "adin.shiny@gmail.com",
                "Discrete Mathematics- MA22302"
        ));

        // Layout
        VBox vbox = new VBox(table);
        vbox.setPadding(new Insets(20));
        vbox.setSpacing(10);

        Scene scene = new Scene(vbox, 1400, 800);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
