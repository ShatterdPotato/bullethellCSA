import java.util.ArrayList;

public class Attack {
    private Player player;
    protected ArrayList<Projectile> projectiles;

    public Attack(Player player) {
        this.player = player;
    }

    public ArrayList<Projectile> getProjectiles() {
        return projectiles;
    }

    public Player getPlayer() {
        return player;
    }
}
