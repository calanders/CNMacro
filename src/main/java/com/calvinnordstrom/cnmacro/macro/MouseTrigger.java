package com.calvinnordstrom.cnmacro.macro;

import com.calvinnordstrom.cnmacro.util.MouseListener;

public record MouseTrigger(int button) implements Trigger {
    @Override
    public boolean isTriggered() {
        return MouseListener.getInstance().isButtonPressed(button);
    }
}
