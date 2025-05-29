public class ExplodingProjectile extends Projectile {

    private int speed;
    private boolean exploded;

    public ExplodingProjectile(int x, int y, int lifespan) {
        super(x, y, lifespan);
        speed = 20;
    }

    @Override
    public void update(Player player) {
        super.update(player);
        if (getTicks() % 2 == 0) {
            speed--;
            setY(getY() - speed);
            if (speed == 0) {
                exploded = true;
            }
        }
    }

    public boolean isExploded() {
        return exploded;
    }
}
