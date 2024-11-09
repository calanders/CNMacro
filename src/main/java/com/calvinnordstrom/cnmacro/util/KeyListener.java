package com.calvinnordstrom.cnmacro.util;

import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import java.util.HashSet;
import java.util.Set;

public class KeyListener implements NativeKeyListener {
    private static KeyListener instance;
    private final Set<Integer> pressedKeys = new HashSet<>();

    private KeyListener() {}

    @Override
    public void nativeKeyTyped(NativeKeyEvent e) {}

    @Override
    public void nativeKeyPressed(NativeKeyEvent e) {
        pressedKeys.add(e.getKeyCode());
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent e) {
        pressedKeys.remove(e.getKeyCode());
    }

    public boolean isKeyPressed(int keyCode) {
        return pressedKeys.contains(keyCode);
    }

    public static KeyListener getInstance() {
        if (instance == null) {
            instance = new KeyListener();
        }
        return instance;
    }
}
