package application.objects;

import application.Model;
import application.components.HealthComponent;
import application.components.InputComponent;
import application.components.WeaponComponent;
import application.terrain.Terrain;

public class PlayerObject extends MoveableObject{
	
	private static final int DEFAULT_WIDTH = 50;
    private static final int DEFAULT_HEIGHT = 50;
    private static final int DEFAULT_HEALTH = 100;

    public PlayerObject(int x, int y, int w, int h, int health,Model model) {
        super(x, y, w, h, Terrain.PLAYER,model);
        addComponent(new HealthComponent(health));
        addComponent(new InputComponent());
        addComponent(new WeaponComponent(20, 500)); // 20 damage, 500ms cooldown
        
    }

    public PlayerObject(int x, int y, int health,Model model) {
        this(x, y, DEFAULT_WIDTH, DEFAULT_HEIGHT, health,model);
    }

    public PlayerObject(int x, int y,Model model) {
        this(x, y, DEFAULT_WIDTH, DEFAULT_HEIGHT, DEFAULT_HEALTH,model);
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
