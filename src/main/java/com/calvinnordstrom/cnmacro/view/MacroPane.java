package com.calvinnordstrom.cnmacro.view;

import com.calvinnordstrom.cnmacro.macro.Macro;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MacroPane extends VBox {
    private final Macro macro;
    private final TextField titleField = new TextField();
    private Runnable callback;

    public MacroPane(Macro macro) {
        this.macro = macro;

        init();
    }

    private void init() {
        Label label = new Label("Settings");
        HBox hBox = new HBox(label);

        titleField.textProperty().bindBidirectional(macro.titleProperty());

        Button save = new Button("Save");
        save.setOnMouseClicked(_ -> save());

        getChildren().addAll(hBox, titleField, save);
    }

    public void setOnSave(Runnable callback) {
        this.callback = callback;
    }

    private void save() {
        macro.titleProperty().set(titleField.getText());
        if (callback != null) {
            callback.run();
        }
    }
}
