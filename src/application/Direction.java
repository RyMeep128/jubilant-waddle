package application;

import java.util.Random;

public enum Direction {
    UP(0,-1),
    DOWN(0,1),
    LEFT(-1,0),
    RIGHT(1,0),
	NONE(0,0);
    
	private final int xDir;
	private final int yDir;
	
    Direction(int x, int y) {
    	xDir = x;
    	yDir = y;
	}
    
    public int[] getXY() {
    	return new int[] {xDir,yDir};
    }

	public static Direction getRandomDirection() {
    	Random random = new Random();
    	switch(random.nextInt(0, 4)) {
    	case 0 ->{
    		return UP;
    	}
    	case 1 ->{
    		return DOWN;
    	}
    	case 2 ->{
    		return LEFT;
    	}
    	case 3 ->{
    		return RIGHT;
    	}
    	}
		return null;
    }

	public int getXDir() {
		// TODO Auto-generated method stub
		return xDir;
	}
	public int getYDir() {
		// TODO Auto-generated method stub
		return yDir;
	}
}