package application.components;

import javafx.scene.input.KeyCode;
import java.util.HashSet;
import java.util.Set;

/**
 * InputComponent – Stores currently pressed keys for a GameObject.
 */
public class InputComponent implements Component {
    private final Set<KeyCode> pressedKeys = new HashSet<>();

    public void press(KeyCode key) {
        pressedKeys.add(key);
    }

    public void release(KeyCode key) {
        pressedKeys.remove(key);
    }

    public boolean isPressed(KeyCode key) {
        return pressedKeys.contains(key);
    }

    public Set<KeyCode> getPressedKeys() {
        return Set.copyOf(pressedKeys);
    }

    public void clear() {
        pressedKeys.clear();
    }
}
