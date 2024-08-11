module com.calvinnordstrom.cnmacro {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.calvinnordstrom.cnmacro to javafx.fxml;
    exports com.calvinnordstrom.cnmacro;
}