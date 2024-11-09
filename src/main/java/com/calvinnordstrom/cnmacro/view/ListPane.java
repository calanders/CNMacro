package com.calvinnordstrom.cnmacro.view;

import com.calvinnordstrom.cnmacro.macro.Macro;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.CheckBoxListCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ListPane extends VBox {
    private final ListView<Macro> listView = new ListView<>();

    public ListPane() {

        init();
    }

    private void init() {
        Label label = new Label("Macros");
        HBox hBox = new HBox(label);

        listView.setCellFactory(_ -> new CheckBoxListCell<>(Macro::activeProperty) {
            @Override
            public void updateItem(Macro macro, boolean empty) {
                super.updateItem(macro, empty);
                if (empty || macro == null) {
                    setText(null);
                } else {
                    setText(macro.titleProperty().get());
                }
            }
        });
        getChildren().addAll(hBox, listView);
    }

    public ListView<Macro> getListView() {
        return listView;
    }
}
