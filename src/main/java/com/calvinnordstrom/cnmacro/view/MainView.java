package com.calvinnordstrom.cnmacro.view;

import com.calvinnordstrom.cnmacro.macro.Macro;
import javafx.collections.ObservableList;
import javafx.scene.layout.BorderPane;

import java.util.HashMap;
import java.util.Map;

public class MainView extends BorderPane {
    private final ListPane listPane = new ListPane();
    private final Map<Macro, MacroPane> macroPaneMap = new HashMap<>();
//    private final MacroPane macroPane = new MacroPane();

    public MainView() {
        initTop();
        initLeft();
        initCenter();
        initRight();
        initBottom();
    }

    private void initTop() {
        MenuPane menuPane = new MenuPane();

        setTop(menuPane);
    }

    private void initLeft() {
        setLeft(listPane);
    }

    private void initCenter() {
        listPane.getListView().getSelectionModel().selectedItemProperty().addListener((_, _, newValue) -> {
            MacroPane macroPane;
            if (!macroPaneMap.containsKey(newValue)) {
                macroPane = new MacroPane(newValue);
                macroPaneMap.put(newValue, macroPane);
            } else {
                macroPane = macroPaneMap.get(newValue);
            }
            macroPane.setOnSave(listPane.getListView()::refresh);
            setCenter(macroPane);
        });
    }

    private void initRight() {

    }

    private void initBottom() {

    }

    public void setMacros(ObservableList<Macro> value) {
        listPane.getListView().setItems(value);
    }
}
