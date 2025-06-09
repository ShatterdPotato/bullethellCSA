public class LaserExplodingAttack extends Attack{
    private int angleCounter;

    public LaserExplodingAttack(Player player) {
        super(player);
        projectiles.add(new Laser(400, 300, 800, 300, 600));
        angleCounter = 0;
    }

    @Override
    public boolean isActive() {
        return ticks < 300;
    }

    @Override
    public void update() {
        super.update();
        if (ticks != 0 && ticks % 30 == 0) {
            projectiles.add(new ExplodingProjectile((int) (Math.random() * 700) + 100, 600, 50));
        }

        for (int p = 0; p < projectiles.size(); p++) {
            Projectile projectile = projectiles.get(p);
            if (projectile instanceof Laser) {
                Laser laser = (Laser) projectiles.getFirst();
                angleCounter++;
                laser.setX2(400 + 500 * Math.cos(Math.toRadians(angleCounter)));
                laser.setY2(300 + 500 * Math.sin(Math.toRadians(angleCounter)));
            } else if (projectile instanceof ExplodingProjectile) {
                if (!projectile.isActive()) {
                    if (Math.random() < .2) {
                        for (int i = 0; i <= 7; i++) {
                            int rad = 30;
                            projectiles.add(new HomingProjectile((projectile.getX() +  (rad * Math.cos(i * Math.PI / 4))), projectile.getY() +  (rad * Math.sin(i * Math.PI / 4)), 75, i));
                        }
                    }   else {
                        for (int i = 0; i <= 7; i++) {
                            int rad = 30;
                            projectiles.add(new ExplodingFragmentProjectile((projectile.getX() +  (rad * Math.cos(i * Math.PI / 4))), projectile.getY() +  (rad * Math.sin(i * Math.PI / 4)), 50, i));
                        }
                    }
                    projectiles.remove(p);
                    p--;
                }
            }
        }
    }
}
