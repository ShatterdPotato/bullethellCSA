import java.util.ArrayList;

public class SpinningLaserAttack extends Attack{
    int angleCounter;
    int rotationSpeed;
    public SpinningLaserAttack(Player player) {
        super(player);
        projectiles.add(new Laser(400, 300, 800, 300, 200));
        angleCounter = 0;
        rotationSpeed = 1;
    }

    @Override
    public void update() {
        super.update();
        Laser laser = (Laser) projectiles.getFirst();
        if (ticks == 100)
            rotationSpeed = 2;
        else if (ticks == 150)
            rotationSpeed = 3;
        else if (ticks == 175)
            rotationSpeed = 4;
        angleCounter += rotationSpeed;
        laser.setX2(400 + 500 * Math.cos(Math.toRadians(angleCounter)));
        laser.setY2(300 + 500 * Math.sin(Math.toRadians(angleCounter)));
    }


}
