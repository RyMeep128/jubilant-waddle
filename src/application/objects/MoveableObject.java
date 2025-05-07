package application.objects;

import application.Direction;
import application.Model;
import application.terrain.Terrain;

public abstract class MoveableObject extends GameObject{

	protected Terrain type;
	private Terrain standingOn;
	private Direction facing;
	
		
	MoveableObject(int x, int y, Terrain type,Model model) {
		super(x, y);
		this.type = type;
		facing = Direction.RIGHT;	
		standingOn = Terrain.EMPTY;
		//This is for making the objects appear on the terrain
		model.queueMove(this, Direction.NONE);
	}

	MoveableObject(int x, int y, int w,int h, Terrain type,Model model) {
		super(x, y,w,h);
		this.type = type;
		facing = Direction.RIGHT;	
		standingOn = Terrain.EMPTY;
		//This is for making the objects appear on the terrain
		model.queueMove(this, Direction.NONE);
	}


	public int[] move(Direction direction, Terrain[][] terrain, Model model) {
		if(Terrain.canMove(terrain, direction, this.getPostionOnGraph())) {
			int gx = getGridX() + direction.getXDir();
			int gy = getGridY() + direction.getYDir();
			standingOn = terrain[gy][gx];
			model.queueMove(this, direction);
			facing = direction;
		}else return null;
		
		return this.getPostion();
	}
	
	public Terrain getTerrainType() {
		return type;
	}
	
	public Terrain getStandingOn() {
		return this.standingOn;
	}
	
	public Direction getFacing() {
		return facing;
	}
	


}
