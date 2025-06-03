public class ExplodingProjectile extends Projectile {
    private int speed;

    public ExplodingProjectile(int x, int y, int lifespan) {
        super(x, y, lifespan);
        speed = (int) (Math.random() * 20) + 10;
    }

    @Override
    public void update(Player player) {
        super.update(player);
        if (getTicks() % 2 == 0) {
            speed--;
            setY(getY() - speed);
            if (speed == -1) {
                active = false;
            }
        }
    }

}
