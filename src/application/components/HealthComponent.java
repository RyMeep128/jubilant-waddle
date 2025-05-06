package application.components;

/**
 * HealthComponent – Gives GameObjects health, damage, and death tracking.
 */
public class HealthComponent implements Component {
    private int currentHealth;
    private final int maxHealth;

    public HealthComponent(int maxHealth) {
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
    }

    public void takeDamage(int amount) {
        currentHealth = Math.max(0, currentHealth - amount);
    }

    public void heal(int amount) {
        currentHealth = Math.min(maxHealth, currentHealth + amount);
    }

    public boolean isDead() {
        return currentHealth <= 0;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    @Override
    public String toString() {
        return "Health: " + currentHealth + "/" + maxHealth;
    }
}
