package com.calvinnordstrom.cnmacro.macro;

import com.calvinnordstrom.cnmacro.util.KeyListener;

public record KeyTrigger(int key) implements Trigger {
    @Override
    public boolean isTriggered() {
        return KeyListener.getInstance().isKeyPressed(key);
    }
}
