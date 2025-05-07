package application.components;

/**
 * WeaponComponent – Grants attack capabilities to a GameObject.
 * Can be extended later for range, type, cooldowns, etc.
 */
public class WeaponComponent implements Component {
    private int damage;
    private long lastAttackTime = 0;
    private long attackCooldownMillis;

    public WeaponComponent(int damage, long cooldownMillis) {
        this.damage = damage;
        this.attackCooldownMillis = cooldownMillis;
    }

    public boolean canAttack() {
        long now = System.currentTimeMillis();
        return (now - lastAttackTime >= attackCooldownMillis);
    }

    public void triggerAttack() {
        lastAttackTime = System.currentTimeMillis();
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int dmg) {
        this.damage = dmg;
    }

    public void setCooldown(long cooldownMillis) {
        this.attackCooldownMillis = cooldownMillis;
    }

    public long getCooldown() {
        return attackCooldownMillis;
    }
}
