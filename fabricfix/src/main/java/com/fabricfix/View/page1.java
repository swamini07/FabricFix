package com.fabricfix.View;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class page1 extends Application {

    Scene p1Scene, p2Scene,contactScene;
    Stage primaryStage;

    @Override
    public void start(Stage Mystage) {
        Text t1 = new Text("Find Your Artisan");
        t1.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 18));
        t1.setFill(Color.DARKORANGE);
        Text t2 = new Text("Browse our network of skilled tailors");
        t2.setStyle("-fx-font-size : 12");

        VBox allRows = new VBox(10);
        allRows.setPadding(new Insets(20));

        HBox row1 = new HBox(20,
                createCard("#84361", "Custom Linen Blazer", "June 15, 2024", "Eleanor Vance", "$450.00"),
                createCard("#84362", "Silk Kurta Set", "June 16, 2024", "Ravi Tailors", "$320.00"),
                createCard("#84363", "Wedding Sherwani", "June 17, 2024", "Zoya Khan", "$700.00"),
                createCard("#84364", "Casual Shirt", "June 18, 2024", "Tailor Mani", "$180.00")
        );

        allRows.getChildren().addAll(t1, t2, row1);

        ScrollPane scrollPane = new ScrollPane(allRows);
        scrollPane.setFitToWidth(true);
        scrollPane.setPannable(true);

        Scene scene = new Scene(scrollPane, 900, 800);
        Mystage.setScene(scene);
        Mystage.setMaxHeight(500);
        Mystage.setMaxWidth(1080);
        Mystage.setTitle("Order Cards");

        p1Scene = scene;
        primaryStage = Mystage;
        Mystage.show();
    }

    private VBox createCard(String orderId, String title, String date, String tailor, String price) {
        VBox card = new VBox(10);
        card.setPadding(new Insets(15));
        card.setStyle("-fx-background-color: #180f0fff; -fx-background-radius: 15;");
        card.setPrefWidth(250);

        Text orderText = new Text("Order " + orderId);
        orderText.setFill(Color.LIGHTGRAY);
        orderText.setFont(Font.font("Arial", FontWeight.NORMAL, 12));

        Text status = new Text("In Production");
        status.setFill(Color.WHITE);
        HBox statusBox = new HBox(status);
        statusBox.setStyle("-fx-background-color: #2d4739; -fx-padding: 4 10 4 10; -fx-background-radius: 10;");
        statusBox.setAlignment(Pos.CENTER_LEFT);

        Text titleText = new Text(title);
        titleText.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        titleText.setFill(Color.WHITE);

        Text dateText = new Text("Placed on " + date);
        dateText.setFill(Color.LIGHTGRAY);
        dateText.setFont(Font.font(12));

        Region imagePlaceholder = new Region();
        imagePlaceholder.setPrefSize(200, 200);
        imagePlaceholder.setStyle("-fx-background-color: #cccccc; -fx-background-radius: 10;");

        Text tailorText = new Text("Tailor: ");
        Text tailorName = new Text(tailor);
        tailorName.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        tailorText.setFont(Font.font(14));
        tailorText.setFill(Color.WHITE);
        tailorName.setFill(Color.WHITE);

        Text totalText = new Text("Total: ");
        Text priceText = new Text(price);
        priceText.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        totalText.setFont(Font.font(14));
        totalText.setFill(Color.WHITE);
        priceText.setFill(Color.WHITE);

        HBox tailorBox = new HBox(5, tailorText, tailorName);
        HBox priceBox = new HBox(5, totalText, priceText);
        VBox detailsBox = new VBox(5, tailorBox, priceBox);

        Button viewBtn = new Button("View Details");
        viewBtn.setStyle("-fx-background-color: #de8856; -fx-text-fill: white; -fx-background-radius: 8;");
        viewBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                initalizePage2(orderId, title, date, tailor, price);
                primaryStage.setScene(p2Scene);
            }
        });

        Button msgBtn = new Button("Message");
        msgBtn.setStyle("-fx-background-color: transparent; -fx-border-color: white; -fx-text-fill: white; -fx-border-radius: 8;");
        HBox buttons = new HBox(10, viewBtn, msgBtn);
        buttons.setAlignment(Pos.CENTER_LEFT);
       

        card.getChildren().addAll(orderText, statusBox, titleText, dateText, imagePlaceholder, detailsBox, buttons);
        return card;
    }

    private void initalizePage2(String orderId, String title, String date, String tailor, String price) {
        Page2 Page2 = new Page2(orderId, title, date, tailor, price);
        Page2.setStage(primaryStage);
        primaryStage.setMaxHeight(500);
        primaryStage.setMaxWidth(1080);
        p2Scene = new Scene(Page2.createScene(this::handleBackButton), 800, 800);
    }

    private void handleBackButton() {
        primaryStage.setScene(p1Scene);
    }
}



