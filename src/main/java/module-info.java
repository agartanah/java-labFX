module org.example.javalabfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.javalabfx to javafx.fxml;
    exports org.example.javalabfx;
}