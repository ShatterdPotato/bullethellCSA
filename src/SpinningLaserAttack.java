import java.util.ArrayList;

public class SpinningLaserAttack extends Attack{
    int angleCounter;
    public SpinningLaserAttack(Player player) {
        super(player);
        projectiles = new ArrayList<>();
        projectiles.add(new Laser(0, 300, 800, 300, 3000));
        angleCounter = 0;
    }

    @Override
    public void update() {
        super.update();
        angleCounter++;
        Laser laser = (Laser) projectiles.getFirst();
        laser.setY1(laser.getY1() - 1);
        laser.setY2(laser.getY2() - 1);
    }


}
