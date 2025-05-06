package application;
public enum GridConfig {
    INSTANCE;

    public static final int CELL_WIDTH = 32;
    public static final int CELL_HEIGHT = 32;
    public static final int CELLS_WIDE = 20;
    public static final int CELLS_TALL = 20;
    
    public static int getTotalWidth() {
    	return CELL_WIDTH * CELLS_WIDE;
    }
    
    public static int getTotalHeight() {
    	return CELL_HEIGHT * CELLS_TALL;
    }
}
