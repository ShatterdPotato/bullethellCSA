public class FloatingProjectile extends Projectile {
    private int speed;

    public FloatingProjectile(double x, double y, int lifespan) {
        super(x, y, lifespan);
        speed = 1;
    }

    @Override
    public void update(Player player) {
        super.update(player);
        speed++;
        setY(getY() - speed);
        if (getY() <= -50)
            active = false;
    }
}
