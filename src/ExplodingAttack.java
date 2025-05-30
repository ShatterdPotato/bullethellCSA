import java.util.ArrayList;

public class ExplodingAttack extends Attack {
    int speed;

    public ExplodingAttack(Player player) {
        super(player);
        speed = 1;
        projectiles = new ArrayList<>();
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
                    projectiles.add(new Projectile((temp.getX() + (int) (rad * Math.cos(i * Math.PI / 4))), temp.getY() + (int) (rad * Math.sin(i * Math.PI / 4)), 100));
                }
            }
        } else {
            speed++;
            for (int i = 0; i <= 7; i++) {
                Projectile temp = projectiles.get(i);
                if (i == 0 || i == 1 || i == 7)
                    temp.setX(temp.getX() + speed);
                if (i == 3 || i == 4 || i == 5)
                    temp.setX(temp.getX() - speed);
                if (i == 1 || i == 2 || i == 3)
                    temp.setY(temp.getY() + speed);
                if (i == 5 || i == 6 || i == 7)
                    temp.setY(temp.getY() - speed);

            }
        }

    }
}
