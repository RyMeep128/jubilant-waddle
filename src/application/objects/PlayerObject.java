package application.objects;

import application.components.HealthComponent;
import application.components.InputComponent;
import application.terrain.Terrain;

public class PlayerObject extends MoveableObject{
	
	private int defaultHealth = 100;

	PlayerObject(int x, int y, int w, int h,int health) {
		super(x, y, w, h,Terrain.PLAYER);
		addComponent(new HealthComponent(health)); // Add health here
		addComponent(new InputComponent());
	}
	
	public PlayerObject(int x, int y,int health) {
		super(x,y,Terrain.PLAYER);
		addComponent(new HealthComponent(health)); // Add health here
		addComponent(new InputComponent());
	}
	
	public PlayerObject(int x, int y) {
		super(x,y,Terrain.PLAYER);
		addComponent(new HealthComponent(defaultHealth)); // Add health here
		addComponent(new InputComponent());
	}

	@Override
	public String getDesc() {
		// TODO Auto-generated method stub
		return "The hero of our story. His name is Gleam. The light in our darkness";
	}

	public void setStandingOn(Terrain terrain) {
		this.type = terrain;
	}
	
	private void setHealthComponent(int health) {
		addComponent(new HealthComponent(health)); // Add health here
	}
	
	public void loseHealth(int dmg) {
	    HealthComponent hp = getComponent(HealthComponent.class);
	    if (hp != null) hp.takeDamage(dmg);
	}
	
	public void heal(int health) {
	    HealthComponent hp = getComponent(HealthComponent.class);
	    if (hp != null) hp.heal(health);
	}


	

}
