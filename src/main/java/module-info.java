module com.example.bettersudoku {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.bettersudoku to javafx.fxml;
    exports com.example.bettersudoku;
}