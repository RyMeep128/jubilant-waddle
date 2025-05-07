package application;

import java.util.Random;

public enum Direction {
    UP(0,-1,"UP"),
    DOWN(0,1,"DOWN"),
    LEFT(-1,0,"LEFT"),
    RIGHT(1,0,"RIGHT"),
	NONE(0,0,"NONE");
    
	private final int xDir;
	private final int yDir;
	private final String direction;
	
    Direction(int x, int y,String dir) {
    	xDir = x;
    	yDir = y;
    	direction = dir;
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
	
	public String getDirection() {
		return direction;
	}
}