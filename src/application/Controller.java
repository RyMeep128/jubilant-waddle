package application;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;


/**
 * Controller – Manages the interaction between the Model and the View in a JavaFX-based game.
 * Handles key inputs, updates game logic via an AnimationTimer loop, and listens for property changes from the Model.
 * 
 * @author Ryan Shafer
 */
public class Controller implements PropertyChangeListener {

	private Model model;         // The game's logic and state
	private View view;           // The game's UI elements

	private AnimationTimer gameLoop; // The game's main update loop

	/**
	 * Constructor initializes the model and view, set up data binding.
	 */
	Controller() {
		model = new Model();
		view = new View();

		// Register this controller to listen for model property changes
		model.addPropertyChangeListener(this);

		// Load model data (e.g., terrain, player, enemies)
		model.load();
	}

	/**
	 * Binds keyboard input events to corresponding player movement or actions.
	 * 
	 * @param scene The JavaFX scene to attach key listeners to
	 */
	public void setKeys(Scene scene) {
		scene.setOnKeyPressed(event -> {	
			if (compareKeyCode(event.getCode(), KeyCode.UP) || compareKeyCode(event.getCode(), KeyCode.W)) {
				model.move(Direction.UP);
			}
			if (compareKeyCode(event.getCode(), KeyCode.DOWN) || compareKeyCode(event.getCode(), KeyCode.S)) {
				model.move(Direction.DOWN);
			}
			if (compareKeyCode(event.getCode(), KeyCode.LEFT) || compareKeyCode(event.getCode(), KeyCode.A)) {
				model.move(Direction.LEFT);
			}
			if (compareKeyCode(event.getCode(), KeyCode.RIGHT) || compareKeyCode(event.getCode(), KeyCode.D)) {
				model.move(Direction.RIGHT);
			}
			if (compareKeyCode(event.getCode(), KeyCode.ESCAPE)) {
				// Future functionality for escape key
			}
			if (compareKeyCode(event.getCode(), KeyCode.SPACE)) {
				// Future functionality for attacking
			}
		});
	}

	/**
	 * Utility method for comparing two KeyCode objects.
	 * 
	 * @param key The actual key pressed
	 * @param pressed The key to compare against
	 * @return true if the keys match
	 */
	private boolean compareKeyCode(KeyCode key, KeyCode pressed) {
		return key.equals(pressed);
	}		

	/** @return the width of the view */
	public int getWidth() {
		return view.getWidth();
	}

	/** @return the height of the view */
	public int getHeight() {
		return view.getHeight();
	}

	/** @return the root VBox container of the view */
	public VBox getRoot() {
		return view.getRoot();
	}

	/**
	 * Responds to property changes emitted by the model.
	 * This is the main event-driven link from Model to View.
	 * 
	 * @param evt The property change event
	 */
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		switch (evt.getPropertyName()) {
		case "UpdateBoard":
			Terrain[][] terrain = (Terrain[][]) evt.getNewValue();
			view.updateBoard(terrain);
			break;
		case "Loaded":
			view.makeTerrain(model.getTerrain());
			view.updateBoard(model.getTerrain());
			break;
		}
	}

	/**
	 * Starts the main game loop using an AnimationTimer, which updates the model
	 * at regular intervals (roughly 60 FPS).
	 */
	public void startGameLoop() {
		gameLoop = new AnimationTimer() {
			private long lastUpdate = 0;

			@Override
			public void handle(long now) {
				if (lastUpdate > 0) {
					double deltaTime = (now - lastUpdate) / 1_000_000_000.0;
					model.update(deltaTime); // Run game logic update
				}
				lastUpdate = now;
			}
		};
		gameLoop.start();
	}
}
