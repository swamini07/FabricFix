package com.trial.Home;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import java.net.URI;
import java.net.http.*;

public class LocationAccess {

    public void requestLocation(Stage ownerStage, Button locationBtn) {
        Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(ownerStage);
        dialog.setTitle("Permission Required");

        Label prompt = new Label("This app needs your location. Allow access?");
        Button allow = new Button("Allow");
        Button deny = new Button("Deny");

        allow.setOnAction(e -> {
            dialog.close();
            fetchLocation(locationBtn);
        });

        deny.setOnAction(e -> {
            dialog.close();
            Platform.exit();
        });

        VBox box = new VBox(10, prompt, new HBox(10, allow, deny));
        box.setStyle("-fx-padding: 20;");
        dialog.setScene(new Scene(box));
        dialog.showAndWait();
    }

    private void fetchLocation(Button locationBtn) {
        new Thread(() -> {
            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create("http://ip-api.com/json"))
                        .build();
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                JsonObject json = JsonParser.parseString(response.body()).getAsJsonObject();
                String city = json.get("city").getAsString();
                String country = json.get("country").getAsString();

                String location = "📍 " + city + ", " + country;
                Platform.runLater(() -> locationBtn.setText(location));
            } catch (Exception e) {
                Platform.runLater(() -> locationBtn.setText("📍 Location Failed"));
                e.printStackTrace();
            }
        }).start();
    }

}
