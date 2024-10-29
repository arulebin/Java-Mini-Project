package com.example.components;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StudentInfo extends Application {

    private String phoneNumber;

    public StudentInfo(String phoneNumber) {
        this.phoneNumber = phoneNumber;  // Store the phone number
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("sxcce student app");

        Label title = new Label("sxcce student app");
        title.setStyle("-fx-font-size: 28px; -fx-font-weight: bold;");

        VBox mainLayout = new VBox(20);
        mainLayout.setPadding(new Insets(20));
        mainLayout.getChildren().addAll(
                title,
                createLinkButton("Student Dashboard", "https://www.sxcce.edu.in/mobile/studview.php?ph=" + phoneNumber),
                createLinkButton("Attendance Details", "https://www.sxcce.edu.in/mobile/absent.php?ph=" + phoneNumber),
                createLinkButton("Disciplinary Details", "https://www.sxcce.edu.in/mobile/discipline.php?ph=" + phoneNumber),
                createLinkButton("Event Details", "https://www.sxcce.edu.in/mobile/events.php?ph=" + phoneNumber),
                createLinkButton("Fees Details", "https://www.sxcce.edu.in/mobile/fees.php?ph=" + phoneNumber),
                createLinkButton("Internal Mark", "https://www.sxcce.edu.in/mobile/imarks.php?ph=" + phoneNumber),
                createLinkButton("End Sem Mark", "https://www.sxcce.edu.in/mobile/emarks.php?ph=" + phoneNumber)
        );

        Scene scene = new Scene(mainLayout, 1366, 768);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private VBox createLinkButton(String title, String url) {
        VBox container = new VBox(10);
        container.setPadding(new Insets(10));
        container.setStyle("-fx-background-color: #23939F; -fx-background-radius: 10;");

        Label label = new Label(title);
        label.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        Button linkButton = new Button("Open");
        linkButton.setOnAction(e -> openLink(url));

        container.getChildren().addAll(label, linkButton);
        return container;
    }

    private void openLink(String url) {
        getHostServices().showDocument(url);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
