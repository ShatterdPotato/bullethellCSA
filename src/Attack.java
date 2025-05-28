import java.util.ArrayList;

public class Attack {
    private Player player;
    protected ArrayList<Projectile> projectiles;
    private boolean active;

    public Attack(Player player) {
        this.player = player;
        active = true;
    }

    public ArrayList<Projectile> getProjectiles() {
        return projectiles;
    }

    public Player getPlayer() {
        return player;
    }

    public boolean isActive() {return active;}
}
