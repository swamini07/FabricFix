package com.fabricfix;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;

public class Order {

    Scene orderScene;
    Stage orderStage;

    public void setOrderScene(Scene orderScene) {
        this.orderScene = orderScene;
    }

    public void setOrderStage(Stage orderStage) {
        this.orderStage = orderStage;
    }

    public ScrollPane createOrderScene(Runnable obj) {
        VBox root = new VBox(20);
        root.setPadding(new Insets(20));
        root.setStyle("-fx-background-color: #0D1B1E;");

        HBox topFields = new HBox(20);
        topFields.setAlignment(Pos.CENTER_LEFT);

        VBox fabricBox = new VBox(5);
        Label fabricLabel = new Label("Fabric Type");
        fabricLabel.setStyle("-fx-text-fill: white;");
        TextField fabricField = new TextField();
        fabricField.setPromptText("e.g., Silk, Cotton, Wool, Linen");
        fabricBox.getChildren().addAll(fabricLabel, fabricField);

        VBox photoBox = new VBox(5);
        Label photoLabel = new Label("Design Photo (Optional)");
        photoLabel.setStyle("-fx-text-fill: white;");
        Button fileButton = new Button("Choose File");
        Label fileNameLabel = new Label("No file chosen");
        fileNameLabel.setStyle("-fx-text-fill: white; -fx-font-size: 11;");
        fileButton.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showOpenDialog(orderStage);
            if (file != null) {
                fileNameLabel.setText(file.getName());
            }
        });
        photoBox.getChildren().addAll(photoLabel, fileButton, fileNameLabel);
        topFields.getChildren().addAll(fabricBox, photoBox);

        Label measurementsLabel = new Label("Measurements");
        measurementsLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");

        HBox measurementAssist = new HBox(5);
        ImageView icon = new ImageView("https://cdn-icons-png.flaticon.com/512/1828/1828911.png");
        icon.setFitWidth(16);
        icon.setFitHeight(16);
        Label assistLabel = new Label("Don't know your measurements? Use our AI Assistant");
        assistLabel.setStyle("-fx-text-fill: white;");
        measurementAssist.getChildren().addAll(icon, assistLabel);

        TextArea measurementArea = new TextArea();
        measurementArea.setPromptText("e.g., Chest: 40in, Waist: 32in, Inseam: 30in. Or use the assistant below.");
        measurementArea.setPrefRowCount(3);

        HBox inputRow = new HBox(15);
        inputRow.setAlignment(Pos.CENTER_LEFT);

        VBox heightBox = new VBox(5);
        Label heightLabel = new Label("Height (cm)");
        heightLabel.setStyle("-fx-text-fill: white;");
        TextField heightField = new TextField();
        heightField.setPromptText("e.g., 175");
        heightBox.getChildren().addAll(heightLabel, heightField);

        VBox weightBox = new VBox(5);
        Label weightLabel = new Label("Weight (kg)");
        weightLabel.setStyle("-fx-text-fill: white;");
        TextField weightField = new TextField();
        weightField.setPromptText("e.g., 70");
        weightBox.getChildren().addAll(weightLabel, weightField);

        VBox ageBox = new VBox(5);
        Label ageLabel = new Label("Age");
        ageLabel.setStyle("-fx-text-fill: white;");
        TextField ageField = new TextField();
        ageField.setPromptText("e.g., 30");
        ageBox.getChildren().addAll(ageLabel, ageField);

        inputRow.getChildren().addAll(heightBox, weightBox, ageBox);

        VBox photoUploadBox = new VBox(5);
        Label fullBodyLabel = new Label("Full Body Photo (Optional)");
        fullBodyLabel.setStyle("-fx-text-fill: white;");
        Button fullBodyButton = new Button("Choose File");
        Label fullBodyFileName = new Label("No file chosen");
        fullBodyFileName.setStyle("-fx-text-fill: white; -fx-font-size: 11;");
        fullBodyButton.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showOpenDialog(orderStage);
            if (file != null) {
                fullBodyFileName.setText(file.getName());
            }
        });
        photoUploadBox.getChildren().addAll(fullBodyLabel, fullBodyButton, fullBodyFileName);

        Button estimateButton = new Button("Estimate My Measurements");
        estimateButton.setMaxWidth(Double.MAX_VALUE);
        estimateButton.setStyle("-fx-background-color: #F38762; -fx-text-fill: black; -fx-font-weight: bold;");

        Label designLabel = new Label("Design Details");
        designLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");
        TextArea designArea = new TextArea();

        designArea.setPromptText("Describe your vision. What style is it? Are there any specific details like buttons, collars, or embroidery?");
        designArea.setPrefRowCount(5);
        designArea.setStyle("-fx-text-fill :#A2E1DB");

        Button submitButton = new Button("Find Your Tailor");
        submitButton.setMaxWidth(Double.MAX_VALUE);
        submitButton.setStyle("-fx-background-color: #F38762; -fx-text-fill: black; -fx-font-weight: bold;");
        submitButton.setOnAction(e -> {
        // Define what happens when you click this button
        System.out.println("Design submitted: " + designArea.getText());
        obj.run(); 
        });

        root.getChildren().addAll(
                topFields,
                measurementsLabel,
                measurementAssist,
                measurementArea,
                inputRow,
                photoUploadBox,
                estimateButton,
                designLabel,
                designArea,
                submitButton
        );

         ScrollPane scrollPane = new ScrollPane(root);
         scrollPane.setFitToWidth(true);
         scrollPane.setStyle("-fx-background: #0D1B1E;");

        return scrollPane;
    }
}


