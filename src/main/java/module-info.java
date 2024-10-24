module org.example.javalabfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.javalabfx to javafx.fxml;
    exports org.example.javalabfx;
    exports org.example.javalabfx.restaurant;
    opens org.example.javalabfx.restaurant to javafx.fxml;
}