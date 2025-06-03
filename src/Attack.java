import java.util.ArrayList;

public class Attack {
    private Player player;
    protected ArrayList<Projectile> projectiles;

    public Attack(Player player) {
        this.player = player;
        projectiles = new ArrayList<>();
    }

    public ArrayList<Projectile> getProjectiles() {
        return projectiles;
    }

    public Player getPlayer() {
        return player;
    }

    public boolean isActive() {
        for (Projectile proj : projectiles) {
            if (proj.isActive()) {
                return true;
            }
        }
        return false;
    }

    public void update() {
        for (Projectile proj : projectiles) {
            proj.update(getPlayer());
        }
    }
}
