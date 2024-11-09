package com.calvinnordstrom.cnmacro.controller;

import com.calvinnordstrom.cnmacro.macro.MacroModel;
import com.calvinnordstrom.cnmacro.util.ServiceLocator;
import com.calvinnordstrom.cnmacro.view.MainView;
import javafx.application.Platform;
import javafx.scene.Parent;

public class MainController {
    private final MacroModel model;
    private final MainView view;

    public MainController(MacroModel model, MainView view) {
        this.model = model;
        this.view = view;

        init();
        initEventHandlers();
    }

    private void init() {
        view.setMacros(model.getMacros());
    }

    private void initEventHandlers() {
        ServiceLocator serviceLocator = ServiceLocator.getInstance();

        serviceLocator.getMenuItem("exit").setOnAction(_ -> exit());
    }

    public void exit() {
        Platform.exit();
    }

    public Parent getView() {
        return view;
    }
}