import java.util.ArrayList;

public class ExplodingAttack extends Attack {
    int speed;

    public ExplodingAttack(Player player) {
        super(player);
        speed = 1;
        projectiles.add(new ExplodingProjectile((int) (Math.random() * 700) + 100, 600, 600));
    }

    @Override
    public void update() {
        super.update();
        if (projectiles.getFirst() instanceof ExplodingProjectile) {
            if (!projectiles.getFirst().isActive()) {
                Projectile temp = projectiles.removeFirst();
                for (int i = 0; i <= 7; i++) {
                    int rad = 30;
                    projectiles.add(new ExplodingFragmentProjectile((temp.getX() +  (rad * Math.cos(i * Math.PI / 4))), temp.getY() +  (rad * Math.sin(i * Math.PI / 4)), 50, i));
                }
            }
        }
    }
}
