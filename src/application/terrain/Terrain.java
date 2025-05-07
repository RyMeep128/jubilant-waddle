package application.terrain;

import application.Direction;
import javafx.scene.paint.Color;

/**
 * Enum representing different types of terrain on the map.
 * Each terrain type has a code, a display color, and walkability logic.
 */
public enum Terrain{
	EMPTY("e", Color.SANDYBROWN, true),
	WALL("w", Color.DARKGRAY, false),
	WATER("a", Color.BLUE, false),
	PLAYER("p", Color.GREEN, false, EMPTY),
	ZOK("v", Color.RED, false, EMPTY),
	SWORD("s",Color.WHITE,true, EMPTY);

	private final String code;
	private final Color color;
	private final boolean isWalkable;

	Terrain(String code, Color color, boolean isWalkable) {
		this.code = code;
		this.color = color;
		this.isWalkable = isWalkable;
	}
	
	Terrain(String code, Color color, boolean isWalkable, Terrain prevTerrain) {
		this.code = code;
		this.color = color;
		this.isWalkable = isWalkable;
	}

	public String getCode() {
		return code;
	}

	public Color getColor() {
		return color;
	}

	public boolean isWalkable() {
		return isWalkable;
	}

	public static Terrain fromCode(String code) {
		for (Terrain type : Terrain.values()) {
			if (type.code.equals(code)) return type;
		}
		return EMPTY; // default fallback
	}


	public static boolean canMove(Terrain[][] terrain, Direction direction, int[] currentPostion) {
		int xPos = currentPostion[0];
		int yPos = currentPostion[1];

		int xNew = xPos + direction.getXDir();
		int yNew = yPos + direction.getYDir();

		Terrain destination = terrain[yNew][xNew];
		if (!destination.isWalkable()) {
		    return false;
		}
		
		//Is it in bounds?
		if (xNew < 0 || yNew < 0 || xNew >= terrain.length || yNew >= terrain[0].length) {
			return false;
		}
		
		return destination.isWalkable();
	}



}
