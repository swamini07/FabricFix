package com.trial;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SignUp {

    Stage homePageStage;
    Scene homeScene;

    public void setHomePageStage(Stage homePageStage) {
        this.homePageStage = homePageStage;
    }

    public void setHomeScene(Scene homeScene) {
        this.homeScene = homeScene;
    }

    public static VBox signupScene(Runnable onBack) {

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
        backBtn.setOnAction(e -> {
            if (onBack != null) {
            onBack.run();  
        }  });
        VBox vBox = new VBox(20,label1, nameField, mobileField, passwordField, conformPassword);
        
        Button signUp = new Button("Sign Up");
        Label label = new Label("Already have an account ? Log in");
        Label label2 = new Label("OR");
        Button withGoogle = new Button("Sign Up with Google");
        Button withFacebook = new Button("Sign Up with Facebook");

        VBox vBox2 = new VBox(20, signUp, label, label2, withFacebook, withGoogle, backBtn);
        // vBox.setAlignment(Pos.CENTER);

        HBox hBox = new HBox(50, vBox, vBox2);
        VBox root = new VBox(hBox);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-padding: 50; -fx-background-color: #f8f8f8;");
        
        return root;
    }
}
