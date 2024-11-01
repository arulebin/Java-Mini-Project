package com.example;

import com.example.components.Dashboard;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Student Dashboard || SXCCE");
        primaryStage.getIcons().add(new Image("file:src\\main\\java\\com\\example\\LOGO.png"));
        
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20)); 
        grid.setVgap(20); 
        grid.setHgap(15); 
        grid.setAlignment(Pos.CENTER); 

        // Logo image
        Image logo = new Image("file:src\\main\\java\\com\\example\\LOGO.png"); 
        ImageView logoView = new ImageView(logo);
        logoView.setFitWidth(150); 
        logoView.setFitHeight(150); 
        GridPane.setConstraints(logoView, 0, 0, 2, 1);
        GridPane.setHalignment(logoView, HPos.CENTER);
        
        // Title Label
        Label titleLabel = new Label("Welcome to Student Dashboard");
        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 28)); 
        GridPane.setConstraints(titleLabel, 0, 1, 2, 1);
        GridPane.setHalignment(titleLabel, HPos.CENTER);

        // Username Label
        Label usernameLabel = new Label("Phone Number:");
        usernameLabel.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, 18)); 
        GridPane.setConstraints(usernameLabel, 0, 2);

        // Username Input
        TextField phnoInput = new TextField();
        phnoInput.setPromptText("Enter your Phone Number");
        phnoInput.setFont(Font.font(16)); 
        GridPane.setConstraints(phnoInput, 1, 2);

        // Password Label
        Label passwordLabel = new Label("Password:");
        passwordLabel.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, 18)); 
        GridPane.setConstraints(passwordLabel, 0, 3);

        // Password Input
        PasswordField passwordInput = new PasswordField();
        passwordInput.setPromptText("Enter your password");
        passwordInput.setFont(Font.font(16)); 
        GridPane.setConstraints(passwordInput, 1, 3);

        // Login Button
        Button loginButton = new Button("Login");
        loginButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 18px;"); 
        loginButton.setDefaultButton(true);
        loginButton.setMinWidth(120); 
        GridPane.setConstraints(loginButton, 1, 4);
        GridPane.setHalignment(loginButton, HPos.CENTER);

        // Message Label
        Label messageLabel = new Label();
        messageLabel.setFont(Font.font("Arial", 16)); 
        GridPane.setConstraints(messageLabel, 1, 5);
        GridPane.setHalignment(messageLabel, HPos.CENTER);

        // Login button action
        loginButton.setOnAction(e -> {
            String phno = phnoInput.getText();
            String password = passwordInput.getText();
            if (password.equals("admin")) {
                messageLabel.setText("Login successful!");
                messageLabel.setTextFill(Color.GREEN);
                openDashboard(primaryStage, phno);
            } else {
                messageLabel.setText("Invalid credentials. Try again.");
                messageLabel.setTextFill(Color.RED);
            }
        });

        // Add all nodes to the GridPane
        grid.getChildren().addAll(logoView, titleLabel, usernameLabel, phnoInput, passwordLabel, passwordInput, loginButton, messageLabel);

        // Wrap GridPane in a VBox to center the entire form
        VBox vbox = new VBox(grid);
        vbox.setAlignment(Pos.CENTER); 
        vbox.setPadding(new Insets(30, 30, 30, 30));

        // Set scene and show stage
        Scene scene = new Scene(vbox, 1400, 800);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void openDashboard(Stage primaryStage, String phno) {
        Dashboard dashboard = new Dashboard(phno);  // Pass the phone number to Dashboard
        Scene dashboardScene = dashboard.getDashboardScene();
        primaryStage.setScene(dashboardScene);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
