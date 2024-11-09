package com.calvinnordstrom.cnmacro.macro;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.mouse.NativeMouseEvent;

public class MacroModel {
    private final ObservableList<Macro> macros = FXCollections.observableArrayList();

    public MacroModel() {
        Macro test1 = new Macro("Test macro", new KeyTrigger(NativeKeyEvent.VC_L), MacroType.REPEAT_WHILE_HOLDING);
        test1.activeProperty().set(true);
        addMacro(test1);
        addMacro(new Macro("Example", new KeyTrigger(NativeMouseEvent.BUTTON1), MacroType.REPEAT_WHILE_HOLDING));
    }

    public ObservableList<Macro> getMacros() {
        return macros;
    }

    public void addMacro(Macro macro) {
        macros.add(macro);
    }

    public void removeMacro(Macro macro) {
        macros.remove(macro);
    }
}
