package com.theme;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ContactUs {

    public static void load(Stage stage) {
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: #f1f3f6;");

        VBox container = new VBox(20);
        container.setPadding(new Insets(50));
        container.setAlignment(Pos.TOP_CENTER);

        Label heading = new Label("Contact Us");
        heading.setFont(Font.font("Arial", 28));
        heading.setTextFill(Color.web("#2874F0"));

        GridPane form = new GridPane();
        form.setVgap(25);
        form.setHgap(20);
        form.setAlignment(Pos.CENTER_LEFT);
        form.setPadding(new Insets(40));
        form.setMaxWidth(700);
        form.setStyle("-fx-background-color: white; -fx-background-radius: 10;");

        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField();
        nameField.setPromptText("Enter your name");
        nameField.setPrefWidth(400);

        Label emailLabel = new Label("Email:");
        TextField emailField = new TextField();
        emailField.setPromptText("Enter your email");
        emailField.setPrefWidth(400);

        Label msgLabel = new Label("Message:");
        TextArea messageArea = new TextArea();
        messageArea.setPromptText("Type your message...");
        messageArea.setPrefWidth(400);
        messageArea.setPrefRowCount(5);

        Button submitBtn = new Button("Submit");
        submitBtn.setStyle("-fx-background-color: #2874F0; -fx-text-fill: white;");
        submitBtn.setPrefWidth(120);

        submitBtn.setOnMouseEntered(e -> submitBtn.setStyle("-fx-background-color: #0b60d1; -fx-text-fill: white;"));
        submitBtn.setOnMouseExited(e -> submitBtn.setStyle("-fx-background-color: #2874F0; -fx-text-fill: white;"));

        submitBtn.setOnAction(e -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Submitted");
            alert.setHeaderText("Thank you for reaching out!");
            alert.setContentText("We will respond to your query soon.");
            alert.showAndWait();
            nameField.clear();
            emailField.clear();
            messageArea.clear();
        });

        Button backBtn = new Button("← Back");
        backBtn.setStyle("-fx-background-color: #e0e0e0; -fx-text-fill: black;");
        backBtn.setPrefWidth(120);
        backBtn.setOnMouseEntered(e -> backBtn.setStyle("-fx-background-color: #d5d5d5; -fx-text-fill: black;"));
        backBtn.setOnMouseExited(e -> backBtn.setStyle("-fx-background-color: #e0e0e0; -fx-text-fill: black;"));

        backBtn.setOnAction(e -> {
            try {
                new Theme().start(stage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        form.add(nameLabel, 0, 0);
        form.add(nameField, 1, 0);
        form.add(emailLabel, 0, 1);
        form.add(emailField, 1, 1);
        form.add(msgLabel, 0, 2);
        form.add(messageArea, 1, 2);
        form.add(submitBtn, 1, 3);
        form.add(backBtn, 1, 4);

        container.getChildren().addAll(heading, form);
        root.setTop(container);

        Scene scene = new Scene(root, 900, 800);
        stage.setScene(scene);
    }
}
