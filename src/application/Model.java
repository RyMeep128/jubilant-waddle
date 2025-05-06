package application;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;


/**
 * Model – Contains the core game logic and state.
 * Manages player and enemy positions, terrain, and updates.
 * Notifies listeners (such as the Controller) of changes using PropertyChangeSupport.
 * 
 * @author Ryan Shafer
 */
public class Model {
	private PropertyChangeSupport support;           // Handles observer notification
	private PlayerObject player;                     // The player character
	private ArrayList<Enemy> enemyList;              // List of enemies in the game
	private Terrain[][] terrain;                     // 2D grid representing the game map
	private List<MoveRequest> moveQueue = new ArrayList<>();



	/**
	 * Constructs the model: initializes terrain, player, and enemy list.
	 */
	Model() {
		support = new PropertyChangeSupport(this);

		terrain = new Terrain[GridConfig.CELLS_WIDE][GridConfig.CELLS_TALL];
		makeBorder(); // Initialize terrain with a bordered wall

		player = new PlayerObject(400, 100);

		enemyList = new ArrayList<>();
		enemyList.add(new Zok(128, 128)); // Add a sample enemy for now
		this.moveObject(Direction.NONE, enemyList.get(0));

	}

	/**
	 * Creates a border of WALL terrain around the edge of the grid, leaving the interior EMPTY.
	 */
	private void makeBorder() {
		for (int i = 0; i < terrain.length; i++) {
			for (int j = 0; j < terrain[0].length; j++) {
				if (i == 0 || j == 0 || i == terrain.length - 1 || j == terrain[0].length - 1) {
					terrain[i][j] = Terrain.WALL;
				} else {
					terrain[i][j] = Terrain.EMPTY;
				}
			}
		}
	}

	/**
	 * Registers a listener to be notified of property changes (e.g., movement).
	 * 
	 * @param listener The listener to register
	 */
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		support.addPropertyChangeListener(listener);
	}

	/**
	 * Removes a registered property change listener.
	 * 
	 * @param listener The listener to remove
	 */
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		support.removePropertyChangeListener(listener);
	}

	// Model.java
	public void move(Direction dir) {
	    // current grid position of the player
	    int[] pos = player.getPostionOnGraph();

	    // only queue the move if it is legal
	    if (Terrain.canMove(terrain, dir, pos)) {
	        queueMove(player, dir);
	    }
	}


	/**
	 * Fires the "Loaded" event to notify the view that initial loading is complete.
	 * This includes player, terrain, and enemies.
	 */
	public void load() {
		support.firePropertyChange("Loaded", "NotNullButNull", player);
	}

	public void update(double deltaTime) {
		for (Enemy enemy : enemyList) {
			enemy.update(deltaTime, terrain, this);  // Only queues a move
		}

		processMoveQueue();  // Actually resolve the moves
		support.firePropertyChange("UpdateBoard", "NotNull", terrain);
	}	

	private void processMoveQueue() {
		int i =0;
		for (MoveRequest req : moveQueue) {
			MoveableObject obj = req.obj;
			Direction dir = req.dir;
			moveObject(dir, obj); 
		}
		moveQueue.clear();
	}

	/**
	 * @return the list of enemies currently in the game
	 */
	public ArrayList<Enemy> getEnemyList() {
		return enemyList;
	}

	/**
	 * @return the terrain grid representing the map
	 */
	public Terrain[][] getTerrain() {
		return terrain;
	}

	public void moveObject(Direction dir, MoveableObject obj) {
		int x = obj.getX();
		int y = obj.getY();
		int oldX = obj.getGridX();
		int oldY = obj.getGridY();
		int newX = x + (dir.getXDir()*GridConfig.CELL_WIDTH);
		int newY = y + (dir.getYDir()*GridConfig.CELL_HEIGHT);
		terrain[y / GridConfig.CELL_HEIGHT][x / GridConfig.CELL_WIDTH] = obj.getStandingOn();

		terrain[newY / GridConfig.CELL_HEIGHT][newX / GridConfig.CELL_WIDTH] = obj.getTerrainType();


		obj.setX(newX); // Don't forget to actually update the object's position
		obj.setY(newY);
		support.firePropertyChange("UpdateBoard", obj, terrain);
	}

	private void printTerrain() {
		// TODO Auto-generated method stub
		System.out.println("-----------");
		for (int i = 0; i < terrain.length; i++) {
			for (int j = 0; j < terrain[0].length; j++) {
				System.out.print(terrain[i][j].getCode()+" ");
			}
			System.out.println();
		}
		System.out.println("-----------");
	}

	public void queueMove(MoveableObject obj, Direction dir) {
		moveQueue.add(new MoveRequest(obj, dir));
	}


	private int toGridX(int pixelX) {
		return pixelX % GridConfig.getTotalWidth();
	}

	private int toGridY(int pixelY) {
		return pixelY % GridConfig.getTotalHeight();
	}
}
