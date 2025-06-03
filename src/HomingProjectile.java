public class HomingProjectile extends ExplodingFragmentProjectile{
    private double dx;
    private double dy;
    private double speed;

    public HomingProjectile(double x, double y, int lifespan, int location) {
        super(x, y, lifespan, location);
        speed = .001;
    }

    @Override
    public void update(Player player) {
        if (getTicks() < 10)
            super.update(player);
        else {
            super.parentUpdate(player);
            if (getTicks() < 45) {
                if (getTicks() % 5 == 0) {
                    speed += 0.01;
                    dx = speed * (player.getHitbox().getX() - getX()) + Math.random() * 3;
                    dy = speed * (player.getHitbox().getY() - getY()) + Math.random() * 2;
                }
            }
            setX(getX() + dx);
            setY(getY() + dy);
        }
    }

}
