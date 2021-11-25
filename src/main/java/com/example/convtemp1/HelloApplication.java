package com.example.convtemp1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    Stage window;
    Scene scene;
    @Override
    public void start(Stage stage) throws IOException {
        window = stage;

        Glow glow1 = new Glow(), glow2 = new Glow(); glow1.setLevel(0); glow2.setLevel(0);
        Button but1 = new Button("EXIT"),  calcBut = new Button("Calculate");
        TextField input = new TextField(), output = new TextField();
        Label fromLabel = new Label("From"), toLabel = new Label("To");
        ComboBox<String> fromc = new ComboBox<>(), toc = new ComboBox<>();
        Image image = new Image(getClass().getResourceAsStream("temperature-icon.png"));

        //setting effects
        but1.setEffect(glow2); calcBut.setEffect(glow1);

        //handling internal processes
        window.setOnCloseRequest(e -> {
            e.consume();
            ExitEventHandler.exit(window);
        });

        output.setEditable(false);

        calcBut.setOnAction(e -> ProjectProcessHandler.calculate(fromc, toc, input, output));
        but1.hoverProperty().addListener(e -> {
            glow2.setLevel(0.3);
            if(!but1.isHover()) glow2.setLevel(0);
        });
        calcBut.hoverProperty().addListener(e -> {
            glow1.setLevel(0.3);
            if(!calcBut.isHover()) glow1.setLevel(0);
        });
        but1.setOnAction(e -> ExitEventHandler.exit(window));

        toc.getSelectionModel().selectedItemProperty().addListener((v, oldVal, newVal) -> {
            if(oldVal != newVal) output.setText("");
        });



        GridPane layout = new GridPane();
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.setHgap(10); layout.setVgap(8);
        //fromc.setPromptText("Enter unit"); toc.setPromptText("Enter unit");
        fromc.getItems().addAll("Celsius", "Fahrenheit", "Kelvin");
        toc.getItems().addAll("Celsius", "Fahrenheit", "Kelvin");
        fromc.setValue("Celsius"); toc.setValue("Kelvin");
        input.setPromptText("Enter");


        //putting objects in the grid
        GridPane.setConstraints(fromLabel,1,0);
        GridPane.setConstraints(toLabel,3,0);
        GridPane.setConstraints(fromc,1,1);
        GridPane.setConstraints(toc,3,1);
        GridPane.setConstraints(input,1,2);
        GridPane.setConstraints(output,3,2);
        GridPane.setConstraints(calcBut,1,4);
        GridPane.setConstraints(but1,3,4);
//        GridPane.setConstraints(rotImgView,2,6);
        layout.getChildren().addAll(fromLabel, toLabel, fromc, toc, calcBut, but1, input, output);

        scene = new Scene(layout, 600, 400);
        //css
        but1.setStyle(" -fx-text-fill: white; -fx-background-color: #FF2E63; -fx-font-size: 10pt; -fx-font-family: Tahoma, sans-serif; -fx-background-radius: 5pt;");
        calcBut.setStyle("-fx-background-color: #FF2E63; -fx-text-fill: white; -fx-font-size: 10pt; -fx-font-family: Tahoma, sans-serif; -fx-background-radius: 5pt;");
        fromc.setStyle("-fx-background-color: #88E0EF; -fx-font-size: 10pt; -fx-font-family: Tahoma, sans-serif; -fx-background-radius: 5pt;");
        toc.setStyle("-fx-background-color: #88E0EF; -fx-font-size: 10pt; -fx-font-family: Tahoma, sans-serif; -fx-background-radius: 5pt;");
        input.setStyle("-fx-background-color: whitesmoke; -fx-font-size: 10pt; -fx-font-family: Tahoma, sans-serif; -fx-background-radius: 5pt;");
        output.setStyle("-fx-background-color: whitesmoke; -fx-font-size: 10pt; -fx-font-family: Tahoma, sans-serif; -fx-background-radius: 5pt;");
        fromLabel.setStyle("-fx-font-size: 10pt; -fx-font-family: Tahoma, sans-serif;");
        toLabel.setStyle("-fx-font-size: 10pt; -fx-font-family: Tahoma, sans-serif;");
        layout.setStyle("-fx-background-color: #CAB8FF;");




        //main
        window.setTitle("ConvTemp");
        window.setScene(scene);
        window.setResizable(false);
        window.getIcons().add(image);
        window.show();

    }

    public static void main(String[] args) {
        launch();
    }


}