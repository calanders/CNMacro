package com.calvinnordstrom.cnmacro.util;

import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseListener;

import java.util.HashSet;
import java.util.Set;

public class MouseListener implements NativeMouseListener {
    private static MouseListener instance;
    private final Set<Integer> pressedButtons = new HashSet<>();

    private MouseListener() {}

    @Override
    public void nativeMouseClicked(NativeMouseEvent e) {}

    @Override
    public void nativeMousePressed(NativeMouseEvent e) {
        pressedButtons.add(e.getButton());
    }

    @Override
    public void nativeMouseReleased(NativeMouseEvent e) {
        pressedButtons.remove(e.getButton());
    }

    public boolean isButtonPressed(int button) {
        return pressedButtons.contains(button);
    }

    public static MouseListener getInstance() {
        if (instance == null) {
            instance = new MouseListener();
        }
        return instance;
    }
}
