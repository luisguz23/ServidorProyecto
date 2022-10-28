module com.example.servidorproyecto {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.pdfbox;
    requires org.apache.poi.ooxml;


    opens com.example.servidorproyecto to javafx.fxml;
    exports com.example.servidorproyecto;
}