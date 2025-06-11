import java.util.ArrayList;

public class SpinningLaserAttack extends Attack{
    private int angleCounter;
    private int rotationSpeed;
    private boolean drawLaser;
    public SpinningLaserAttack(Player player) {
        super(player);
        projectiles.add(new Laser(400, 300, 400, 300, 200));
        angleCounter = 0;
        rotationSpeed = 1;
        drawLaser = true;
    }

    @Override
    public void update() {
        super.update();
        Laser laser = (Laser) projectiles.getFirst();
        if (drawLaser) {
            laser.setX2(laser.getX2() + 10);
            if (laser.getX2() == 800)
                drawLaser = false;
        }   else {
            if (ticks == 100)
                rotationSpeed = 3;
            else if (ticks == 150)
                rotationSpeed = 4;
            else if (ticks == 175)
                rotationSpeed = 6;
            angleCounter += rotationSpeed;
            laser.setX2(400 + 500 * Math.cos(Math.toRadians(angleCounter)));
            laser.setY2(300 + 500 * Math.sin(Math.toRadians(angleCounter)));
        }

    }


}
