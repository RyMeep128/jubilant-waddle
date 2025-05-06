package application;

public abstract class GameObject {
	
	private int x;
	private int y;
	private int width;
	private int height;
	
	
	GameObject(int x, int y, int w, int h){
		this.x = x % GridConfig.getTotalWidth();
		this.y = y % GridConfig.getTotalHeight();
		this.width = w;
		this.height = h;
	}
	
	GameObject(int x, int y){
		this(x,y,GridConfig.CELL_WIDTH,GridConfig.CELL_HEIGHT);
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	public int[] setXY(int x, int y) {
		// TODO Auto-generated method stub
		this.x = x;
		this.y = y;
		return new int[] {x,y};
	}
	
	public int[] getPostion() {
		return new int[] {x,y};
	}
	
	protected int[] getPostionOnGraph() {
		int xpos = x / GridConfig.CELL_WIDTH;
		int ypos = y / GridConfig.CELL_HEIGHT;
		return new int[] {xpos,ypos};
	}
	
	public int getGridX() {
		return x / GridConfig.CELL_WIDTH;
	}

	public int getGridY() {
		return y / GridConfig.CELL_HEIGHT;
	}

	
	
	
	public abstract String getDesc();
	
}
