module com.example.servidorproyecto {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.servidorproyecto to javafx.fxml;
    exports com.example.servidorproyecto;
}