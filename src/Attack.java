import java.util.ArrayList;

public class Attack {
    private Player player;
    protected ArrayList<Projectile> projectiles;
    protected int ticks;

    public Attack(Player player) {
        this.player = player;
        ticks = 0;
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
        ticks++;
        for (Projectile proj : projectiles) {
            proj.update(getPlayer());
        }
    }
}
