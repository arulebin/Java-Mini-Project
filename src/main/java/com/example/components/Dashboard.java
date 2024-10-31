package com.example.components;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class Dashboard {
    private final String phoneNumber;
    private WebView webView;  // WebView to display URLs
    private VBox dashboardContent; // Content area for dynamic updates
    
    public Dashboard(String phoneNumber) {
        this.phoneNumber = phoneNumber;  // Store the phone number
    }

    public Scene getDashboardScene() {
        // Main layout
        BorderPane root = new BorderPane();

        MenuBar menuBar = new MenuBar();
        Menu homeMenu = new Menu("Home");
        Menu innovationMenu = new Menu("Innovation & Startup");
        Menu iqacMenu = new Menu("IQAC");
        Menu nirfMenu = new Menu("NIRF");
        Menu skillMenu = new Menu("Skill Development Program");
        Menu alumniMenu = new Menu("Alumni");
        Menu grievanceMenu = new Menu("Grievance");
        Menu contactMenu = new Menu("Contact Us");
        menuBar.getMenus().addAll(homeMenu, innovationMenu, iqacMenu, nirfMenu, skillMenu, alumniMenu, grievanceMenu, contactMenu);
        root.setTop(new VBox(menuBar, createHeader()));

        root.setLeft(createSidebar());
        dashboardContent = createDashboardContent();
        root.setCenter(dashboardContent);
        root.setBottom(createFooter());

        return new Scene(root, 1400, 800);
    }

    private HBox createHeader() {
        HBox header = new HBox();
        header.setPadding(new Insets(20));
        header.setSpacing(10);
        header.setStyle("-fx-background-color: #059cfa;");
        Label emptyLabel = new Label(" ");
        Label logoPlaceholder = new Label("St. Xavier's Catholic College of Engineering");
        logoPlaceholder.setFont(Font.font("Arial", 24));
        logoPlaceholder.setTextFill(Color.WHITE);
        HBox.setHgrow(logoPlaceholder, Priority.ALWAYS);
        logoPlaceholder.setAlignment(Pos.CENTER_RIGHT);
        header.getChildren().addAll(emptyLabel, logoPlaceholder);
        return header;
    }

    private VBox createSidebar() {
        VBox sidebar = new VBox();
        sidebar.setStyle("-fx-background-color: #d5dee3;");
        sidebar.setPrefWidth(250);
        sidebar.setPadding(new Insets(20, 10, 10, 10));
        sidebar.setSpacing(15);
        
        sidebar.getChildren().addAll(
            createSidebarButton("Home", "https://www.sxcce.edu.in/mobile/studview.php?ph=" + phoneNumber),
            createSidebarButton("Attendance Details", "https://www.sxcce.edu.in/mobile/absent.php?ph=" + phoneNumber),
            createSidebarButton("Student Details", "https://www.sxcce.edu.in/mobile/studview.php?ph=" + phoneNumber),
            createSidebarButton("Faculty Details", this::displayFacultyDetails), // Open faculty details on the same screen
            createSidebarButton("Discipline Details", "https://www.sxcce.edu.in/mobile/discipline.php?ph=" + phoneNumber),
            createSidebarButton("Fees Balance", "https://www.sxcce.edu.in/mobile/fees.php?ph=" + phoneNumber),
            createSidebarButton("College Events", "https://www.sxcce.edu.in/mobile/events.php?ph=" + phoneNumber),
            createSidebarButton("Internal Marks", "https://www.sxcce.edu.in/mobile/imarks.php?ph=" + phoneNumber),
            createSidebarButton("End Semester Marks", "https://www.sxcce.edu.in/mobile/emarks.php?ph=" + phoneNumber)
        );
        return sidebar;
    }

    private Button createSidebarButton(String text, Runnable action) {
        Button button = new Button(text);
        button.setMaxWidth(Double.MAX_VALUE);
        button.setStyle("-fx-background-color: #059cfa; -fx-text-fill: white;");
        button.setFont(new Font(20));
        button.setOnAction(e -> action.run());
        return button;
    }

    private Button createSidebarButton(String text, String url) {
        return createSidebarButton(text, () -> openLink(url));
    }

    private VBox createDashboardContent() {
        dashboardContent = new VBox();
        dashboardContent.setPadding(new Insets(20));
        dashboardContent.setSpacing(20);
        dashboardContent.setStyle("-fx-background-color: #f8f8f8;");

        Label announcementsLabel = new Label("College Announcements");
        announcementsLabel.setFont(Font.font("Arial", 20));
        announcementsLabel.setTextFill(Color.DARKBLUE);

        Label announcementContent = new Label("Announcements will be displayed here...");
        announcementContent.setFont(Font.font("Arial", 14));
        announcementContent.setWrapText(true);

        webView = new WebView();
        webView.setPrefHeight(500);

        dashboardContent.getChildren().addAll(webView, announcementsLabel, announcementContent);
        return dashboardContent;
    }

    @SuppressWarnings("unchecked")
    private void displayFacultyDetails() {
    TableView<Staff> table = new TableView<>();
    table.setPrefHeight(675);  // Set preferred height for the table
    table.setPrefWidth(1100);  // Set preferred width for the table (adjust as needed)

    TableColumn<Staff, ImageView> imageColumn = new TableColumn<>("Photo");
    imageColumn.setCellValueFactory(new PropertyValueFactory<>("image"));
    imageColumn.setPrefWidth(100);

    TableColumn<Staff, String> nameColumn = new TableColumn<>("Name");
    nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
    nameColumn.setPrefWidth(150);

    TableColumn<Staff, String> designationColumn = new TableColumn<>("Designation");
    designationColumn.setCellValueFactory(new PropertyValueFactory<>("designation"));
    designationColumn.setPrefWidth(150);

    TableColumn<Staff, String> departmentColumn = new TableColumn<>("Department");
    departmentColumn.setCellValueFactory(new PropertyValueFactory<>("department"));
    departmentColumn.setPrefWidth(275);

    TableColumn<Staff, String> subjectColumn = new TableColumn<>("Subject");
    subjectColumn.setCellValueFactory(new PropertyValueFactory<>("subject"));
    subjectColumn.setPrefWidth(250);

    TableColumn<Staff, String> emailColumn = new TableColumn<>("Email");
    emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
    emailColumn.setPrefWidth(200);

    table.getColumns().addAll(imageColumn, nameColumn, designationColumn, departmentColumn, subjectColumn, emailColumn);

    // Adding all staff details
    table.getItems().addAll(
        new Staff(new ImageView(new Image("file:src/main/java/com/example/assets/abvl.jpg", 80, 80, false, false)),
                  "Dr. A. Bamila Virgin Louis", "Assistant Professor", "Department of Computer Science and Engineering",
                  "bamilavirgin@sxcce.edu.in", "Object Oriented Programming\n(CS22301)"),
        
        new Staff(new ImageView(new Image("file:src/main/java/com/example/assets/subitha-final1-1.jpg", 80, 80, false, false)),
                  "Dr. A. Subitha", "Associate Professor", "Department of Computer Science and Engineering",
                  "subitha@sxcce.edu.in", "Data Structures\n(CS22302)"),
        
        new Staff(new ImageView(new Image("file:src/main/java/com/example/assets/sls.jpg", 80, 80, false, false)),
                  "Mrs. S. L. Soniya", "Assistant Professor", "Department of Computer Science and Engineering",
                  "soniya@yahoo.co.in", "Digital Principles and System Design\n(CS22303)"),
        
        new Staff(new ImageView(new Image("file:src/main/java/com/example/assets/simi.jpg", 80, 80, false, false)),
                  "Mrs. J.S. Simi Mole", "Assistant Professor", "Department of Computer Science and Engineering",
                  "jssree@yahoo.co.in", "Computer Organisation and Architecture\n(CS22304)"),
        
        new Staff(new ImageView(new Image("file:src/main/java/com/example/assets/ts193.jpg", 80, 80, false, false)),
                  "Mrs. P. Ajitha", "Assistant Professor", "Department of Computer Science and Engineering",
                  "ajithabose@sxcce.edu.in", "Constitution of India\n(AC22301)"),
        
        new Staff(new ImageView(new Image("file:src/main/java/com/example/assets/sxp.jpg", 80, 80, false, false)),
                  "Dr. Sobini X. Pushpa", "Assistant Professor", "Department of Computer Science and Engineering",
                  "sobinix@yahoo.com", "Value Education\n(HS22301)"),
        
        new Staff(new ImageView(new Image("file:src/main/java/com/example/assets/Adin-copy1.jpg", 80, 80, false, false)),
                  "Mrs. P. Adin Shiny", "Assistant Professor", "Department of Humanities and Sciences",
                  "adin.shiny@gmail.com", "Discrete Mathematics\n(MA22302)")
    );

    // Update dashboard content with the faculty table
    dashboardContent.getChildren().setAll(table);
}



    private HBox createFooter() {
        HBox footer = new HBox();
        footer.setAlignment(Pos.CENTER);
        footer.setPadding(new Insets(10));
        footer.setStyle("-fx-background-color: #f8f8f8;");

        Label footerLabel = new Label("St. Xavier's Catholic College of Engineering © 2024");
        footerLabel.setFont(Font.font("Arial", 12));
        footerLabel.setTextFill(Color.GRAY);

        footer.getChildren().add(footerLabel);
        return footer;
    }

    private void openLink(String url) {
        WebEngine webEngine = webView.getEngine();
        webEngine.load(url);
    }
}
