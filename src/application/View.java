package application;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class View {
	private VBox root;
	private int width, height;
	private BorderPane gameWindow;
	private Rectangle[][] terrain;

	View(){
		width = GridConfig.getTotalWidth();
		height = GridConfig.getTotalHeight();

		root = new VBox(); // 10 is spacing between children

		gameWindow = new BorderPane();
		root.getChildren().addAll(gameWindow);
	}

	public VBox getRoot() {
		return root;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public void makeTerrain(Terrain[][] terrainCopy) {
		terrain = new Rectangle[terrainCopy.length][terrainCopy[0].length];

		for (int i = 0; i < terrain.length; i++) {
			for (int j = 0; j < terrain[0].length; j++) {
				terrain[i][j] = new Rectangle(GridConfig.CELL_WIDTH,GridConfig.CELL_HEIGHT);
				terrain[i][j].setX(j * GridConfig.CELL_WIDTH);
				terrain[i][j].setY(i * GridConfig.CELL_HEIGHT);

				terrain[i][j].setFill(terrainCopy[i][j].getColor());
				terrain[i][j].setStroke(Color.BLACK);          
				terrain[i][j].setStrokeWidth(.5);               
				gameWindow.getChildren().add(terrain[i][j]);
			}
		}
	}

	public void updateBoard(Terrain[][] terrain2) {
		for (int i = 0; i < terrain2.length; i++) {
			for (int j = 0; j < terrain2[0].length; j++) {
				terrain[i][j].setFill(terrain2[i][j].getColor());
			}
		}
		
	}


}
