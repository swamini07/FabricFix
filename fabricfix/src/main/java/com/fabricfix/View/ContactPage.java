package com.fabricfix.View;
import com.fabricfix.Order;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class ContactPage {

    Scene contactScene,orderScene;
    Stage contactStage;


    public void setOderScene(Scene oderScene) {
        this.orderScene = oderScene;
    }

    public void setContactStage(Stage stage) {
        this.contactStage = stage;
    }

    public void setContactScene(Scene scene){
        this.contactScene = scene;
    }

    public VBox createContactScene(Runnable back) {

        // Header
        Text header = new Text("Live Chat with Tailor");
        header.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        header.setFill(Color.web("#3a3a3a"));

        Button backBtn = new Button("← Back");
        backBtn.setStyle("-fx-background-color: #de8856; -fx-text-fill: white; -fx-background-radius: 6;");
        backBtn.setOnAction(e -> back.run());

        HBox topBar = new HBox(10, backBtn, header);
        topBar.setAlignment(Pos.CENTER_LEFT);
        topBar.setPadding(new Insets(10));
        topBar.setStyle("-fx-background-color: #f0f0f0;");

        

        // Chat area (scrollable)
        VBox messageBox = new VBox(10);
        messageBox.setPadding(new Insets(10));
        messageBox.setPrefWidth(550);

        ScrollPane chatScroll = new ScrollPane(messageBox);
        chatScroll.setFitToWidth(true);
        chatScroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        chatScroll.setStyle("-fx-background: #ffffff;");

        // Input area
        TextField messageInput = new TextField();
        messageInput.setPromptText("Type your message...");
        messageInput.setPrefWidth(400);

        Button sendButton = new Button("Send");
        sendButton.setStyle("-fx-background-color: #de8856; -fx-text-fill: white; -fx-background-radius: 6;");

        // Send message action
        sendButton.setOnAction(e -> {
            String text = messageInput.getText().trim();
            if (!text.isEmpty()) {
                Label userMessage = new Label("You: " + text);
                userMessage.setWrapText(true);
                userMessage.setStyle("-fx-background-color: #c26565; -fx-text-fill: white; -fx-padding: 8; -fx-background-radius: 8;");
                messageBox.getChildren().add(userMessage);
                messageInput.clear();

                // Simulated response from tailor
                Label tailorReply = new Label("Tailor: Thank you for your message. I’ll get back to you soon.");
                tailorReply.setWrapText(true);
                tailorReply.setStyle("-fx-background-color: #e6e6e6; -fx-padding: 8; -fx-background-radius: 8;");
                messageBox.getChildren().add(tailorReply);

                // Scroll to bottom
                chatScroll.layout();
                chatScroll.setVvalue(1.0);
            }
        });

        HBox inputArea = new HBox(10, messageInput, sendButton);
        inputArea.setPadding(new Insets(10));
        inputArea.setAlignment(Pos.CENTER_LEFT);

        Button placeOrderButton = new Button("Place Order");
placeOrderButton.setStyle("-fx-background-color: #F38762; -fx-text-fill: black; -fx-font-weight: bold;");
placeOrderButton.setMaxWidth(Double.MAX_VALUE);
placeOrderButton.setOnAction(e -> {
            initalizeOrderPage();
            contactStage.setScene(orderScene);
        });

        VBox root = new VBox(topBar, chatScroll, inputArea, placeOrderButton);
        root.setSpacing(5);
        root.setStyle("-fx-background-color: #ffffff;");
        root.setPrefSize(500, 500);

        return root;
    }

    public void initalizeOrderPage(){
        Order order = new Order();
        order.setOrderStage(contactStage);
        orderScene = new Scene(order.createOrderScene(this::handleBackButton), 800, 800);
        order.setOrderScene(orderScene);
    }

    private void handleBackButton() {
        contactStage.setScene(contactScene);
    }

}

