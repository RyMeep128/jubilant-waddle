package application;

public class PlayerObject extends MoveableObject{

	PlayerObject(int x, int y, int w, int h) {
		super(x, y, w, h,Terrain.PLAYER);
	}
	
	PlayerObject(int x, int y) {
		super(x,y,Terrain.PLAYER);
	}

	@Override
	public String getDesc() {
		// TODO Auto-generated method stub
		return "The hero of our story. His name is Gleam. The light in our darkness";
	}

	public void setStandingOn(Terrain terrain) {
		this.type = terrain;
		
	}


	

}
