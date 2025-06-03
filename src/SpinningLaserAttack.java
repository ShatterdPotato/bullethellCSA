import java.util.ArrayList;

public class SpinningLaserAttack extends Attack{
    int angleCounter;
    public SpinningLaserAttack(Player player) {
        super(player);
        projectiles.add(new Laser(400, 300, 800, 300, 400));
        angleCounter = 0;
    }

    @Override
    public void update() {
        super.update();
        angleCounter++;
        Laser laser = (Laser) projectiles.getFirst();
        laser.setX2(400 + 500 * Math.cos(Math.toRadians(angleCounter)));
        laser.setY2(300 + 500 * Math.sin(Math.toRadians(angleCounter)));
    }


}
