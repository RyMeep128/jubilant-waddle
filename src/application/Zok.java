package application;

import javafx.scene.paint.Color;

/**
 * Zok – a slow but resilient enemy, often found patrolling ancient ruins.
 */
public class Zok extends Enemy {
	private static int idCount = 0;
	
	public Zok(int x, int y, int w, int h) {
		super(x, y, w, h,"Zok_"+idCount++,Terrain.ZOK);
		this.defaultColor = Color.DARKRED;
	}

	public Zok(int x, int y) {
		super(x, y,"Zok_"+idCount++,Terrain.ZOK);
		this.defaultColor = Color.DARKRED;
	}
	

	@Override
	public String getDesc() {
		return "Zok – a slow but resilient enemy, often found patrolling ancient ruins.";
	}



}
