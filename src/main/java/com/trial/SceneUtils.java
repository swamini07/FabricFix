package com.trial;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class SceneUtils {
    public static Scene createBack(String title, Node content, Runnable backAction) {
        Button backBtn = new Button(" ← ");
        backBtn.setOnAction(e -> backAction.run());

        VBox layout = new VBox(15, backBtn, content);
        layout.setPadding(new Insets(20));

        return new Scene(layout, 800, 600);
    }
}
