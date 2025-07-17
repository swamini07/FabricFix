package com.trial;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class SellerHome extends Application {

    Stage sellerStage;
    Scene homeScene, signUpScene;

    private VBox settingsSidebar = new VBox(10);

    @Override
    public void start(Stage primaryStage) {

        BorderPane root = new BorderPane();

        HBox topBar = new HBox(15);
        topBar.setPadding(new Insets(10));
        topBar.setStyle("-fx-background-color: #2C3E50;");

        Label logo = new Label("✂ FabricFix");
        logo.setStyle("-fx-text-fill: white; -fx-font-size: 16px;");

        Button locationBtn = new Button("");

        ChoiceBox<String> loginChoice = new ChoiceBox<>();
        loginChoice.getItems().addAll("New Customer ?", "Profile", "Orders", "Wishlist", "Rewards");
        loginChoice.setValue("User Login");

        Button signupBtn = new Button("Become a Seller");
        signupBtn.setOnAction(e -> {
           // initializeSignUp();
        });

        Button settingsBtn = new Button("⚙");

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        topBar.getChildren().addAll(logo, locationBtn, spacer, loginChoice, signupBtn, settingsBtn);

        settingsSidebar.setPadding(new Insets(15));
        settingsSidebar.setPrefWidth(200);
        // settingsSidebar.setStyle("-fx-background-color: #502929ff;");
        settingsSidebar.setVisible(false);

        Label settingsTitle = new Label(" ⚙ ");
        settingsTitle.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        Label l11 = new Label("");
        Label l1 = new Label("         Tailors      ");
        Label l2 = new Label("         Vendors      ");
        Label l3 = new Label("         Customers        ");
        VBox tailor = new VBox(l1);
        tailor.setStyle("-fx-background-color : #d7acacff;");
        tailor.setMaxHeight(100);
        tailor.setMaxWidth(120);

        VBox vendor = new VBox(l2);
        vendor.setStyle("-fx-background-color : #d7acacff;");
        vendor.setMaxHeight(100);
        vendor.setMaxWidth(120);

        VBox customer = new VBox(l3);
        customer.setStyle("-fx-background-color : #d7acacff;");
        customer.setMaxHeight(100);
        customer.setMaxWidth(120);

        VBox vb1 = new VBox(20, l11, tailor, vendor, customer);
        VBox vb2 = new VBox(20, l11, tailor, vendor, customer);


        root.setTop(topBar);
        root.setCenter(new HBox(500, vb1, vb2));
        root.setStyle("-fx-background-color: #c7dff0ff;");

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX Home Page");
        primaryStage.show();
    }


    // private void initializeSignUp() {
    //     SignUp signUp = new SignUp();
    //     signUp.setHomePageStage(sellerStage);
    //     signUpScene = new Scene(signUp.signupScene(this::handleBackButton), 800, 600);
    //     sellerStage.setScene();
    // }

    // private void handleBackButton() {
    //     sellerStage.setScene(homeScene);
    // }

}