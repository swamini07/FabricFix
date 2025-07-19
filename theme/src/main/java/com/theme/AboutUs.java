package com.theme;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AboutUs {

    public static void load(Stage stage) {
        VBox root = new VBox(20);
        root.setPadding(new Insets(40));
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: #ffffff;");

        Label heading = new Label("About FabricFix");
        heading.setStyle("-fx-font-size: 28px; -fx-font-weight: bold; -fx-text-fill: #444;");

        Label content = new Label(
            "FabricFix is a modern tailoring solution.\n" +
            "We provide online booking, doorstep pickup, and delivery\n" +
            "of customized tailoring services with excellent quality and speed.\n\n" +
            "Why choose us?\n" +
            "• Smart booking system\n" +
            "• Verified tailors\n" +
            "• Trusted by thousands of users\n"
        );
        content.setWrapText(true);
        content.setStyle("-fx-font-size: 16px; -fx-text-fill: #555;");
        content.setMaxWidth(600);

        Button backBtn = new Button("← Back");
        backBtn.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 14px;");
        backBtn.setOnAction(e -> {
            try {
                new Theme().start(stage);
            } catch (Exception e1) {
                e1.printStackTrace();
            } 
        });

        root.getChildren().addAll(heading, content, backBtn);

        Scene scene = new Scene(root, 900, 800);
        stage.setScene(scene);
    }
}
