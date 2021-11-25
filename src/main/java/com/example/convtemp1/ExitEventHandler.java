package com.example.convtemp1;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class ExitEventHandler {

    public static void exit(Stage window) {
        boolean ans = ConfirmBox.confirm("Exiting window", "Are you sure you want to exit?");
        if(ans) window.close();
    }
}
