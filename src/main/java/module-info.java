module com.example.convtemp1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.convtemp1 to javafx.fxml;
    exports com.example.convtemp1;
}