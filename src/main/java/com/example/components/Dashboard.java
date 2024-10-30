package com.example.components;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class Dashboard {
    private String phoneNumber;
    private WebView webView;  // WebView to display pages

    public Dashboard(String phoneNumber) {
        this.phoneNumber = phoneNumber;  // Store the phone number
    }

    public Scene getDashboardScene() {
        // Main layout
        BorderPane root = new BorderPane();

        // Top Menu Bar
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
        root.setCenter(createDashboardContent());
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
            createSidebarButton("Home", "https://www.sxcce.edu.in/mobile/studview.php?ph="+phoneNumber),
            createSidebarButton("Attendance Details", "https://www.sxcce.edu.in/mobile/absent.php?ph="+phoneNumber),
            createSidebarButton("Student Details", "https://www.sxcce.edu.in/mobile/studview.php?ph="+phoneNumber),
            createSidebarButton("Faculty Details", "https://www.sxcce.edu.in/mobile/discipline.php?ph="+phoneNumber),
            createSidebarButton("Discipline Details", "https://www.sxcce.edu.in/mobile/discipline.php?ph="+phoneNumber),
            createSidebarButton("Fees Balance", "https://www.sxcce.edu.in/mobile/fees.php?ph="+phoneNumber),
            createSidebarButton("College Events", "https://www.sxcce.edu.in/mobile/events.php?ph="+phoneNumber),
            createSidebarButton("Internal Marks", "https://www.sxcce.edu.in/mobile/imarks.php?ph="+phoneNumber),
            createSidebarButton("End Semester Marks", "https://www.sxcce.edu.in/mobile/emarks.php?ph="+phoneNumber)
        );
        return sidebar;
    }

    private Button createSidebarButton(String text, String url) {
        Button button = new Button(text);
        button.setMaxWidth(Double.MAX_VALUE);
        button.setStyle("-fx-background-color: #059cfa; -fx-text-fill: white;");
        button.setFont(new Font(20));
        button.setOnAction(e -> openLink(url));  // Open link in WebView
        return button;
    }

    private VBox createDashboardContent() {
        VBox dashboard = new VBox();
        dashboard.setPadding(new Insets(20));
        dashboard.setSpacing(20);
        dashboard.setStyle("-fx-background-color: #f8f8f8;");

        Label announcementsLabel = new Label("College Announcements");
        announcementsLabel.setFont(Font.font("Arial", 20));
        announcementsLabel.setTextFill(Color.DARKBLUE);

        Label announcementContent = new Label("Announcements will be displayed here...");
        announcementContent.setFont(Font.font("Arial", 14));
        announcementContent.setWrapText(true);

        // Initialize WebView and add it to the dashboard
        webView = new WebView();
        webView.setPrefHeight(500);  // Set height to fit the layout

        dashboard.getChildren().addAll(webView, announcementsLabel, announcementContent);
        return dashboard;
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
        webEngine.load(url);  // Load the URL within the WebView
    }
}
