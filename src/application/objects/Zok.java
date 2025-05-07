package application.objects;

import application.Model;
import application.components.HealthComponent;
import application.terrain.Terrain;
import javafx.scene.paint.Color;

/**
 * Zok – a slow but resilient enemy, often found patrolling ancient ruins.
 */
public class Zok extends EnemyObject {
	private static int idCount = 0;
	
	public Zok(int x, int y, int w, int h, int health, Model model) {
		super(x, y, w, h,"Zok_"+idCount++,Terrain.ZOK,model);
		this.defaultColor = Color.DARKRED;
		setHealthComponent(health);
	}

	public Zok(int x, int y, int health,Model model) {
		super(x, y,"Zok_"+idCount++,Terrain.ZOK,model);
		this.defaultColor = Color.DARKRED;
		setHealthComponent(health);
		
	}
	
	public Zok(int x, int y,Model model) {
		super(x, y,"Zok_"+idCount++,Terrain.ZOK,model);
		this.defaultColor = Color.DARKRED;
		setHealthComponent(25);
		
	}
	
	protected void setHealthComponent(int health) {
		addComponent(new HealthComponent(health)); // Add health here
	}
	

	@Override
	public String getDesc() {
		return "Zok – a slow but resilient enemy, often found patrolling ancient ruins.";
	}



}
