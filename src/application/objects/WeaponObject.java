package application.objects;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * A base class for all weapon objects.
 * Can be equipped by an entity or exist independently in the world.
 */
public abstract class WeaponObject extends GameObject {

    protected boolean isEquipped = false;
    protected MoveableObject owner;

    public WeaponObject(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public void equip(MoveableObject own) {
        this.owner = own;
        this.isEquipped = true;
    }

    public void unequip() {
        this.owner = null;
        this.isEquipped = false;
    }

    public boolean isEquipped() {
        return isEquipped;
    }

    public MoveableObject getOwner() {
        return owner;
    }

    /**
     * Override in subclasses for behavior on attack/swing/etc.
     */
    public void use() {
        // Default behavior (e.g., log swing)
    }

	@Override
	public String getDesc() {
		// TODO Auto-generated method stub
		return null;
	}
}
