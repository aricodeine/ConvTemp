package com.example.convtemp1;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class ProjectProcessHandler {

    public static void calculate(ComboBox<String> fromc, ComboBox<String> toc, TextField ip, TextField answer) {
        if(ip.getText()=="") AlertBox.displayAlert("Error", "No value entered");
        else if(!isNum(ip)) return;
        else if(fromc.getValue()==toc.getValue()) {
            answer.setText(ip.getText());
            AlertBox.displayAlert("Error", "Similar Unit Conversion Error");
        }
        else if(isNum(ip)) {
            String to = toc.getValue(), from = fromc.getValue();
            Double value = Double.parseDouble(ip.getText()), ans;
            switch(to) {
                case "Celsius":
                    if(from=="Fahrenheit") {
                        ans = (value-32)*5/9;
                    }else {
                        ans = value - 273.15;
                    }
                    answer.setText(Double.toString(ans));
                    break;
                case "Fahrenheit":
                    if(from=="Celsius") {
                        ans = value*9/5 + 32;
                    }else {
                        ans = (value - 273.15)*9/5 + 32;
                    }
                    answer.setText(Double.toString(ans));
                    break;
                case "Kelvin":
                    if(from=="Celsius") {
                        ans = value + 273.15;
                    }else {
                        ans = (value - 32)*5/9 + 273.15;
                    }
                    answer.setText(Double.toString(ans));
                    break;
            }
        }
    }

    public static boolean isNum(TextField input) {
        try {
            Double n = Double.parseDouble(input.getText());
//            System.out.println("Number is " + input.getText());
            return true;
        }catch(NumberFormatException e) {
//            System.out.println("Entered text is not a number");
            AlertBox.displayAlert("Error", "Entered value is not a number");
        }
        return false;
    }
}
