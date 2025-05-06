package application;

public abstract class MoveableObject extends GameObject{

	protected Terrain type;
	private Terrain standingOn;
	private Direction facing;
	
		
	MoveableObject(int x, int y, Terrain type) {
		super(x, y);
		this.type = type;
		facing = Direction.RIGHT;	
		standingOn = Terrain.EMPTY;
	}

	MoveableObject(int x, int y, int w,int h, Terrain type) {
		super(x, y,w,h);
		this.type = type;
		facing = Direction.RIGHT;	
		standingOn = Terrain.EMPTY;
	}


	public int[] move(Direction direction, Terrain[][] terrain, Model model) {
		//TODO: Set up the getY to be terrain[[][] based, not pixel based
		if(Terrain.canMove(terrain, direction, this.getPostionOnGraph())) {
			int gx = getGridX() + direction.getXDir();
			int gy = getGridY() + direction.getYDir();
			standingOn = terrain[gy][gx];
			model.moveObject(direction, this);
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
	


}
