public class ExplodingFragmentProjectile extends Projectile {
    int location;
    int speed;
    public ExplodingFragmentProjectile(double x, double y, int lifespan, int location) {
        super(x, y, lifespan);
        this.location = location;
    }

    @Override
    public void update(Player player) {
        super.update(player);
        speed++;
        if (location == 0 || location == 1 || location == 7)
            setX(getX() + speed);
        if (location == 3 || location == 4 || location == 5)
            setX(getX() - speed);
        if (location == 1 || location == 2 || location == 3)
            setY(getY() + speed);
        if (location == 5 || location == 6 || location == 7)
            setY(getY() - speed);

    }

    //solely for use by HomingProjectile
    protected void parentUpdate(Player player) {
        super.update(player);
    }
}
