module com.example.oop_groupd_agario {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.oop_groupd_agario to javafx.fxml;
    exports com.example.oop_groupd_agario;
}