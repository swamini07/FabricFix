package com.theme;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Theme extends Application {

    private boolean sidebarVisible = false;
    private boolean themeBoxVisible = false;

    @Override
    public void start(Stage myStage) {

        VBox vb = new VBox(20);
        vb.setAlignment(Pos.TOP_RIGHT);
        vb.setStyle("-fx-background-color: lightpink;");
        vb.setPadding(new Insets(20));

        ImageView settingIcon = new ImageView(new Image("assets/images/setting.png"));
        settingIcon.setFitWidth(40);
        settingIcon.setFitHeight(40);
        vb.getChildren().add(settingIcon);

        VBox sidebar = new VBox(20);
        sidebar.setPrefWidth(225);
        sidebar.setStyle("-fx-background-color: #121212;");
        sidebar.setPadding(new Insets(20));
        sidebar.setAlignment(Pos.TOP_LEFT);
        sidebar.setTranslateX(900);

        Label backArrow = new Label("←");
        backArrow.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-cursor: hand; -fx-text-fill: white;");

        HBox hb = new HBox(backArrow);
        hb.setAlignment(Pos.TOP_LEFT);

        Label title = new Label("Settings");
        title.setFont(Font.font("Arial", 24));
        title.setTextFill(Color.WHITE);
        title.setPadding(new Insets(10, 0, 10, 0));

        Label themeLabel = createSidebarItem("Theme");
        Label aboutLabel = createSidebarItem("About Us");
        Label contactLabel = createSidebarItem("Contact Us");
        Label privacyLabel = createSidebarItem("Privacy Policy");
        Label termsLabel = createSidebarItem("Terms and Conditions");
        Label refundLabel = createSidebarItem("Refund Policy");

        sidebar.getChildren().addAll(hb, title, themeLabel, aboutLabel, contactLabel, privacyLabel, termsLabel, refundLabel);
    
        VBox themeBox = new VBox(10);
        themeBox.setAlignment(Pos.CENTER);
        themeBox.setStyle("-fx-background-color: white; -fx-border-color: gray; -fx-border-width: 1;");
        themeBox.setPadding(new Insets(15));
        themeBox.setVisible(false);
        themeBox.setMaxWidth(200);
        themeBox.setMaxHeight(50);
        themeBox.setLayoutX(350);
        themeBox.setLayoutY(200);

        Label themeTitle = new Label("Choose Theme");
        themeTitle.setFont(Font.font("Arial", 16));
        themeTitle.setTextFill(Color.BLACK);

        Label light = new Label("Light");
        Label dark = new Label("Dark");

        stylePopupItem(light);
        stylePopupItem(dark);

        themeBox.getChildren().addAll(themeTitle, light, dark);

        StackPane root = new StackPane();
        root.getChildren().addAll(vb, sidebar, themeBox);

        settingIcon.setOnMouseClicked(e -> {
            sidebarVisible = !sidebarVisible;
            sidebar.setTranslateX(sidebarVisible ? 675 : 900);
            themeBox.setVisible(false);
        });

        backArrow.setOnMouseClicked(e -> {
            sidebarVisible = false;
            sidebar.setTranslateX(900);
            themeBox.setVisible(false);
        });

        themeLabel.setOnMouseClicked(e -> {
            themeBoxVisible = !themeBoxVisible;
            themeBox.setVisible(themeBoxVisible);
        });

        light.setOnMouseClicked(e -> {
            vb.setStyle("-fx-background-color: #f2f2f2;");
            themeBox.setVisible(false);
        });

        dark.setOnMouseClicked(e -> {
            vb.setStyle("-fx-background-color: #2f2f2f;");
            themeBox.setVisible(false);
        });

        aboutLabel.setOnMouseClicked(e -> AboutUs.load(myStage));
        contactLabel.setOnMouseClicked(e -> ContactUs.load(myStage));

        Scene scene = new Scene(root, 900, 800);
        myStage.setScene(scene);
        myStage.setTitle("FabricFix");
        myStage.setMaxHeight(1920);
        myStage.setMaxWidth(1080);
        myStage.show();
    }

    private Label createSidebarItem(String text) {
        Label label = new Label(text);
        label.setTextFill(Color.WHITE);
        label.setFont(Font.font("Arial", 16));
        label.setOnMouseEntered(e -> label.setTextFill(Color.LIGHTGRAY));
        label.setOnMouseExited(e -> label.setTextFill(Color.WHITE));
        label.setCursor(javafx.scene.Cursor.HAND);
        return label;
    }

    private void stylePopupItem(Label label) {
        label.setFont(Font.font("Arial", 14));
        label.setTextFill(Color.DARKSLATEGRAY);
        label.setCursor(javafx.scene.Cursor.HAND);
        label.setOnMouseEntered(e -> label.setTextFill(Color.GRAY));
        label.setOnMouseExited(e -> label.setTextFill(Color.DARKSLATEGRAY));
    }
}
