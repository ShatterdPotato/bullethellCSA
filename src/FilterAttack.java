import java.util.ArrayList;

public class FilterAttack extends Attack {

    public FilterAttack(Player player) {
        super(player);
        projectiles.add(new Laser(0, 0, 0, 800, 1000));
        while (player.getX() > 50)
            player.moveLeft(false);
        for (int i = 1; i <= 5; i++) {
            int offset = (int) (Math.random() * 201) + 800;
            projectiles.add(new Projectile(150 + (i * 100), offset, 1000));
            for (int j = 1; j <= 20; j++) {
                offset -= 75;
                projectiles.add(new Projectile(100 + (i * 100), offset, 1000));
            }
        }
    }

    @Override
    public boolean isActive() {
        return ((Laser) projectiles.getFirst()).getX1() <= 700 || getPlayer().getX() <= 700;
    }
    @Override
    public void update() {
        super.update();
        Laser laser = (Laser) projectiles.getFirst();
        laser.setX2(laser.getX2() + 1);
        laser.setX1(laser.getX1() + 1);
        for (Projectile proj : projectiles) {
            proj.setY(proj.getY() + 1);
        }
    }
}
