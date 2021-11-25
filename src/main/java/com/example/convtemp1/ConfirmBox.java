package com.example.convtemp1;

import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class ConfirmBox {
    static boolean ans;
    public static boolean confirm(String title, String message) {
        Stage window = new Stage();
        Button yesButton = new Button("YES"), noButton = new Button("NO");
        Label label = new Label(message);
        VBox layout = new VBox(20);
        Image image = new Image(ConfirmBox.class.getResourceAsStream("temperature-icon.png"));
        Glow glow1 = new Glow(), glow2 = new Glow(); glow1.setLevel(0); glow2.setLevel(0);
        yesButton.setEffect(glow1); noButton.setEffect(glow2);
        yesButton.hoverProperty().addListener(e -> {
            glow1.setLevel(0.3);
            if(!yesButton.isHover()) glow1.setLevel(0);
        });

        noButton.hoverProperty().addListener(e -> {
            glow2.setLevel(0.3);
            if(!noButton.isHover()) glow2.setLevel(0);
        });


        //what everything will do
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(label, yesButton, noButton);
        yesButton.setOnAction(e -> {
            ans = true;
            window.close();
        });
        noButton.setOnAction(e -> {
            ans = false;
            window.close();
        });
        Scene scene = new Scene(layout,350,150);

        //css
        yesButton.setStyle(" -fx-text-fill: white; -fx-background-color: #FF2E63; -fx-font-size: 10pt; -fx-font-family: Tahoma, sans-serif; -fx-background-radius: 5pt;");
        noButton.setStyle("-fx-background-color: #FF2E63; -fx-text-fill: white; -fx-font-size: 10pt; -fx-font-family: Tahoma, sans-serif; -fx-background-radius: 5pt;");
        label.setStyle("-fx-font-size: 10pt; -fx-font-family: Tahoma, sans-serif;");
        layout.setStyle("-fx-background-color: #CAB8FF;");



        window.setScene(scene);
        window.setResizable(false);
        window.getIcons().add(image);
        window.showAndWait();
        return ans;
    }
}
