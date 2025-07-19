package com.fabricfix.View;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

public class Page2 {

    private String orderId, title, date, tailor, price;
    private Stage p2Stage;
    private Scene p2Scene, contactScene;

    public Page2(String orderId, String title, String date, String tailor, String price) {
        this.orderId = orderId;
        this.title = title;
        this.date = date;
        this.tailor = tailor;
        this.price = price;
    }

    public void setStage(Stage stage) {
        this.p2Stage = stage;
    }

    public void setScene(Scene scene) {
        this.p2Scene = scene;
    }

    public VBox createScene(Runnable back) {

        VBox leftPane = new VBox(15);
        leftPane.setPadding(new Insets(20));
        leftPane.setPrefWidth(300);
        leftPane.setAlignment(Pos.TOP_CENTER);
        leftPane.setStyle("-fx-background-color: #c26565ff;");

        ImageView profilePic = new ImageView(new Image("image3.jpeg"));
        profilePic.setFitWidth(200);
        profilePic.setFitHeight(200);

        Text name = new Text(tailor);
        name.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        name.setFill(Color.WHITE);
        Text rating = new Text("⭐ 4.9 (124 reviews)");
        rating.setFont(Font.font("Arial", FontPosture.ITALIC, 14));
        rating.setFill(Color.LIGHTGRAY);

        HBox tags = new HBox(10, tag("Bespoke Suits"), tag("Formal Wear"), tag("Vintage"));
        tags.setAlignment(Pos.CENTER);

        Button contactBtn = new Button("📩 Contact " + tailor.split(" ")[0]);
        contactBtn.setStyle("-fx-background-color: #de8856; -fx-text-fill: white; -fx-background-radius: 6;");
        contactBtn.setMaxWidth(Double.MAX_VALUE);
        contactBtn.setOnAction(e -> {
            initalizeContactpage();
            p2Stage.setScene(contactScene);
        });

        leftPane.getChildren().addAll(profilePic, name, rating, tags, contactBtn);

        VBox rightPane = new VBox(20);
        rightPane.setPadding(new Insets(20));

        Text workHeader = new Text("About Me");
        workHeader.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        workHeader.setFill(Color.WHITE);
        Text tx = new Text("With over 20 years of experience in Savile Row, Eleanor specializes in classic menswear with a modern twist.");
        tx.setFont(Font.font("Arial", FontWeight.THIN, 10));
        tx.setFill(Color.WHITE);

        TilePane workGrid = new TilePane();
        workGrid.setHgap(15);
        workGrid.setVgap(15);
        workGrid.setPrefColumns(2);
        workGrid.setPadding(new Insets(10));

        ImageView workImg1 = new ImageView(new Image("image.png"));
        workImg1.setFitWidth(250); workImg1.setFitHeight(333);

        ImageView workImg2 = new ImageView(new Image("image1.jpeg"));
        workImg2.setFitWidth(250); workImg2.setFitHeight(333);

        ImageView workImg3 = new ImageView(new Image("images.jpeg"));
        workImg3.setFitWidth(250); workImg3.setFitHeight(333);

        ImageView workImg4 = new ImageView(new Image("image2.jpeg"));
        workImg4.setFitWidth(250); workImg4.setFitHeight(333);

        workGrid.getChildren().addAll(workImg1, workImg2, workImg3, workImg4);

        VBox reviews = new VBox(10);
        Text reviewHeader = new Text("Reviews");
        reviewHeader.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        reviewHeader.setFill(Color.WHITE);

        Text review1 = new Text("Absolutely Perfect\n“I couldn’t be happier with the suit Eleanor made for me.” - Alex R.");
        review1.setWrappingWidth(500);
        review1.setFill(Color.BLACK);

        reviews.getChildren().addAll(reviewHeader, review1);
        rightPane.getChildren().addAll(workHeader, tx, workGrid, reviews);
        rightPane.setStyle("-fx-background-color: #d4a7a7ff;");

        HBox mainContent = new HBox(leftPane, rightPane);
        mainContent.setStyle("-fx-background-color: #ebdbdbff;");

        ScrollPane scrollPane = new ScrollPane(mainContent);
        scrollPane.setFitToWidth(true);
        scrollPane.setStyle("-fx-background: #e6dbdbff;");

        Button backBtn = new Button("← Back");
        backBtn.setStyle("-fx-background-color: #de8856; -fx-text-fill: white; -fx-background-radius: 6;");
        backBtn.setOnAction(e -> back.run());

        HBox backBox = new HBox(backBtn);
        backBox.setAlignment(Pos.CENTER_LEFT);
        backBox.setPadding(new Insets(10, 0, 5, 10));
        backBox.setStyle("-fx-background-color: #e3d9d9ff;");

        VBox root = new VBox(backBox, scrollPane);
        root.setStyle("-fx-background-color: #111111;");
        return root;
    }

    private HBox tag(String text) {
        Text label = new Text(text);
        label.setFill(Color.WHITE);
        label.setFont(Font.font("Arial", 12));

        HBox box = new HBox(label);
        box.setPadding(new Insets(4, 8, 4, 8));
        box.setStyle("-fx-background-color: #333333; -fx-background-radius: 8;");
        return box;
    }

    public void initalizeContactpage() {
        ContactPage contactPage = new ContactPage();
        contactPage.setContactStage(p2Stage);

        Scene contactSceneLocal = new Scene(contactPage.createContactScene(() -> {
            p2Stage.setScene(p2Scene); // ← Back to Page2
        }), 800, 800);

        this.contactScene = contactSceneLocal;
        contactPage.setContactScene(contactSceneLocal);
    }
}
