package com.calvinnordstrom.cnmacro.macro;

import javafx.beans.property.*;

import java.util.ArrayList;
import java.util.List;

public class Macro {
    private final StringProperty title = new SimpleStringProperty();
    private final ObjectProperty<Trigger> trigger = new SimpleObjectProperty<>();
    private final ObjectProperty<MacroType> macroType = new SimpleObjectProperty<>();
    private final List<MacroAction> actions;
    private final BooleanProperty activeProperty = new SimpleBooleanProperty(false);

    public Macro(String title, Trigger trigger, MacroType macroType) {
        this.title.set(title);
        this.trigger.set(trigger);
        this.macroType.set(macroType);
        actions = new ArrayList<>();
    }

    public StringProperty titleProperty() {
        return title;
    }

    public ObjectProperty<Trigger> triggerProperty() {
        return trigger;
    }

    public ObjectProperty<MacroType> macroTypeProperty() {
        return macroType;
    }

    public void addAction(MacroAction action) {
        actions.add(action);
    }

    public void removeAction(MacroAction action) {
        actions.remove(action);
    }

    public void clearActions() {
        actions.clear();
    }

    public BooleanProperty activeProperty() {
        return activeProperty;
    }
}
