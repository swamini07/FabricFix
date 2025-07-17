package com.trial;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Choice {

    private final Stage stage;
    private final Runnable backHandler;

    public Choice(Stage stage, Runnable backHandler) {
        this.stage = stage;
        this.backHandler = backHandler;
    }

    public void newCustomer() {
        // VBox content = new VBox(new Label(" Welcome New Customer!"));
        // VBox scene = SignUp.signupScene(backHandler);
        // // stage.setScene(scene);
        // // Scene scene = new Scene(new SignUp.signUpScene(), 800, 600);
        Label label1 = new Label("Sign UP");
        TextField nameField = new TextField();
        nameField.setPromptText("Full Name");

        TextField mobileField = new TextField();
        mobileField.setPromptText("Enter Mobile Number");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        PasswordField conformPassword = new PasswordField();
        conformPassword.setPromptText("Enter Name");


        Button backBtn = new Button("Back");
        // backBtn.setOnAction(e -> {
        //     if (onBack != null) {
        //     onBack.run();  
        // }  });
        VBox vBox = new VBox(20,label1, nameField, mobileField, passwordField, conformPassword);
        
        Button signUp = new Button("Sign Up");
        Label label = new Label("Already have an account ? Log in");
        Label label2 = new Label("OR");
        Button withGoogle = new Button("Sign Up with Google");
        Button withFacebook = new Button("Sign Up with Facebook");

        VBox vBox2 = new VBox(20, signUp, label, label2, withFacebook, withGoogle);
        // vBox.setAlignment(Pos.CENTER);

        HBox hBox = new HBox(50, vBox, vBox2);
        VBox root = new VBox(hBox);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-padding: 50; -fx-background-color: #f8f8f8;");
        Scene scene = SceneUtils.createBack("Profile", root, backHandler);
        stage.setScene(scene);
        // Scene scene = new Scene(root,800, 600);
        // stage.setScene(scene);

    }

    public void openProfilePage() {

        Label label1 = new Label("Update your Profile");
        TextField nameField = new TextField();
        nameField.setPromptText("Full Name");

        TextField mobileField = new TextField();
        mobileField.setPromptText("Enter Mobile Number");

        TextField emailField = new TextField();
        emailField.setPromptText("Email Address");

        TextField address = new PasswordField();
        address.setPromptText("Enter Your permanent Address");

        Button submitBtn = new Button("Submit");

        VBox content = new VBox(20,label1, nameField, mobileField, emailField, address, submitBtn);
        content.setAlignment(Pos.CENTER);
        Scene scene = SceneUtils.createBack("Profile", content, backHandler);
        stage.setScene(scene);
    }

    public void openOrdersPage() {
        ImageView imageview = new ImageView("https://img.freepik.com/premium-vector/shopping-cart-with-cross-mark-wireless-paymant-icon-shopping-bag-failure-paymant-sign-online-shopping-vector_662353-912.jpg");
        imageview.setFitHeight(200);
        imageview.setFitWidth(200);
        Label l1 = new Label("Your cart is Empty !");
        Label l2 = new Label("Must add items on cart before you proceed to check out");

        VBox content = new VBox(20, imageview, l1, l2);
        content.setAlignment(Pos.CENTER);
        Scene scene = SceneUtils.createBack("Orders", content, backHandler);
        stage.setScene(scene);
    }

    public void openWishlistPage() {
        ImageView imageview = new ImageView("https://png.pngtree.com/png-clipart/20230926/original/pngtree-online-store-wishlist-icon-a-minimalist-linear-design-ideal-for-templates-png-image_12789545.png");
        imageview.setFitHeight(200);
        imageview.setFitWidth(200);
        Label l1 = new Label("Your wishList is Empty !");
        Label l2 = new Label("Must add items on wishlist before you proceed to check out");

        VBox content = new VBox(20, imageview, l1, l2);
        content.setAlignment(Pos.CENTER);
        Scene scene = SceneUtils.createBack("Orders", content, backHandler);
        stage.setScene(scene);
    }

    public void openRewardsPage() {
        ImageView imageview = new ImageView("https://cdn1.vectorstock.com/i/1000x1000/10/20/rewards-vector-36571020.jpg");
        imageview.setFitHeight(200);
        imageview.setFitWidth(200);
        Label l1 = new Label("Your wishList is Empty !");
        Label l2 = new Label("Must add items on wishlist before you proceed to check out");

        VBox content = new VBox(20, imageview, l1, l2);
        content.setAlignment(Pos.CENTER);
        Scene scene = SceneUtils.createBack("Orders", content, backHandler);
        stage.setScene(scene);
    }
}