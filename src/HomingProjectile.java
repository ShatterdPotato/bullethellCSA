public class HomingProjectile extends Projectile{
    private int speedX;
    private int speedY;
    private int speedAbs = 3;
    private double angle;

    public HomingProjectile(double x, double y, int lifespan) {
        super(x, y, lifespan);
        angle = 0;
        speedX = speedAbs;
        speedY = speedAbs;
    }

    @Override
    public void update(Player player) {
        if (Math.random() < .1) {
            speedAbs++;
            if (speedAbs >= 8)
                speedAbs = 8;
        }
        super.update(player);
        if (getTicks() <= 12000) {
            double dx = player.getHitbox().getX() - getX();
            double dy = player.getHitbox().getY() - getY();
            angle = Math.atan(dy / dx);
            speedX = speedAbs;
            speedY = speedAbs;
            if (player.getX() < getX())
                speedX = -1 * speedAbs;
            if (player.getY() < getY())
                speedY = -1 * speedAbs;
        }
        setX(getX() + (speedX * Math.cos(angle)));
        setY(getY() + (speedY * Math.sin(angle)));

    }
}
