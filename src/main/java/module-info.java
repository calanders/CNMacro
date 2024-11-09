module com.calvinnordstrom.cnmacro {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    requires jnativehook;
    requires java.desktop;


    opens com.calvinnordstrom.cnmacro to javafx.fxml;
    exports com.calvinnordstrom.cnmacro;
    exports com.calvinnordstrom.cnmacro.controller;
    exports com.calvinnordstrom.cnmacro.macro;
    exports com.calvinnordstrom.cnmacro.view;
    opens com.calvinnordstrom.cnmacro.controller to javafx.fxml;
    exports com.calvinnordstrom.cnmacro.util;
}