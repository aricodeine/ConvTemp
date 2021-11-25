package com.example.convtemp1;

import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class AlertBox {
    public static void displayAlert(String title, String message) {
        Stage window = new Stage();
        Button closeButton = new Button("Close");
        Label label = new Label(message);
        VBox layout = new VBox(20);
        Glow glow1 = new Glow(); glow1.setLevel(0);
        closeButton.setEffect(glow1);
        closeButton.hoverProperty().addListener(e -> {
            glow1.setLevel(0.3);
            if(!closeButton.isHover()) glow1.setLevel(0);
        });

        //what everything will do
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setWidth(250);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(label, closeButton);
        closeButton.setOnAction(e -> window.close());
        Scene scene = new Scene(layout,350,150);

        //css
        closeButton.setStyle(" -fx-text-fill: white; -fx-background-color: #FF2E63; -fx-font-size: 10pt; -fx-font-family: Tahoma, sans-serif; -fx-background-radius: 5pt;");
        label.setStyle("-fx-font-size: 10pt; -fx-font-family: Tahoma, sans-serif;");
        layout.setStyle("-fx-background-color: #CAB8FF;");

        Image image = new Image(AlertBox.class.getResourceAsStream("temperature-icon.png"));
        window.setScene(scene);
        window.setResizable(false);
        window.getIcons().add(image);
        window.showAndWait();

    }
}
