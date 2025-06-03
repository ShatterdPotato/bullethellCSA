import java.util.ArrayList;

public class RingAttack extends Attack{
    int rad;
    int counter;
    int flag;

    public RingAttack(Player player) {
        super(player);
        counter = 0;
        flag = (int) (Math.random() * 30);
        rad = 500;
        for (int i = 0; i <= 29; i++) {
            projectiles.add(new Projectile((400 +  (rad * Math.cos(i * Math.PI / 15))), 300 +  (rad * Math.sin(i * Math.PI / 15)), 125));
            if (i == flag || i - 1 == flag || i + 1 == flag)
                projectiles.get(i).active = false;
        }
    }

    @Override
    public void update() {
        super.update();
        rad -= 4;
        if (projectiles.getFirst().getTicks() % 5 == 0)
            counter++;
        for (int i = 0; i <= 29; i++) {
            projectiles.get(i).setX(400 + (rad * Math.cos((i + counter) * Math.PI / 15)));
            projectiles.get(i).setY(300 + (rad * Math.sin((i + counter) * Math.PI / 15)));
        }
    }
}
