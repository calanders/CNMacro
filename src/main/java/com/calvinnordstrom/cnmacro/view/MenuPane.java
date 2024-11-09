package com.calvinnordstrom.cnmacro.view;

import com.calvinnordstrom.cnmacro.util.ServiceLocator;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;

public class MenuPane extends MenuBar {
    public MenuPane() {
        getStyleClass().add("menu-pane");

        init();
    }

    private void init() {
        Menu fileMenu = new Menu("File");
        add(fileMenu, "new", new MenuItem("New..."));
        fileMenu.getItems().add(new SeparatorMenuItem());
        add(fileMenu, "exit", new MenuItem("Exit"));

        getMenus().setAll(fileMenu);
    }

    private void add(Menu menu, String key, MenuItem value) {
        menu.getItems().add(value);
        ServiceLocator.getInstance().register(key, value);
    }
}
