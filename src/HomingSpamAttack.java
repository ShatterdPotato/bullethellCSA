public class HomingSpamAttack extends Attack{
    public HomingSpamAttack(Player player) {
        super(player);
    }

    @Override
    public boolean isActive() {
        return ticks < 200;
    }

    @Override
    public void update() {
        super.update();
        if (ticks % 7 == 0 && ((ticks < 50) || (ticks < 150 && ticks > 100))) {
            projectiles.add(new ExplodingProjectile((int) (Math.random() * 700) + 100, 600, 30));
        }

        for (int p = 0; p < projectiles.size(); p++) {
            Projectile projectile = projectiles.get(p);
            if (projectile instanceof ExplodingProjectile) {
                if (!projectile.isActive()) {
                    for (int i = 0; i <= 7; i++) {
                        int rad = 30;
                        projectiles.add(new HomingProjectile((projectile.getX() +  (rad * Math.cos(i * Math.PI / 4))), projectile.getY() +  (rad * Math.sin(i * Math.PI / 4)), 75, i));
                    }
                    projectiles.remove(p);
                    p--;
                }
            }
        }
    }
}
