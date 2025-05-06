package application;

import java.util.Random;

import javafx.scene.paint.Color;

public abstract class Enemy extends MoveableObject {


	protected Color defaultColor;
	
	private final String tag;
	
	private double moveTimer = 0;
	private Random random = new Random();
		
	Enemy(int x, int y, int w, int h, String tag, Terrain type) {
		super(x, y, w, h, type);
		this.tag = tag;
		this.defaultColor = Color.RED;
		// TODO Auto-generated constructor stub
	}
	
	Enemy(int x, int y, String tag,Terrain type) {
		super(x, y, type);
		this.defaultColor = Color.RED;
		this.tag = tag;
		}
	
	public int[] moveRandomly(Terrain[][] terrain,Model model){
		return this.move(Direction.getRandomDirection(),terrain, model);
	}
	

	/**
	 * @return the defaultColor
	 */
	public Color getDefaultColor() {
		return defaultColor;
	}
	

	public void update(double deltaTime,Terrain[][] terrain,Model model) {
		moveTimer += deltaTime;
		if (moveTimer >= 1.0) {
			this.moveRandomly(terrain,model);
//			this.move(Direction.RIGHT, terrain, model);
			moveTimer = 0;
		}
	}
	
	public String getTag() {
		return tag;
	}


}
