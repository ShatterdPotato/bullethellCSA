public class PillarExplodingAttack extends Attack{
    public PillarExplodingAttack(Player player) {
        super(player);
        for (int i = 1; i < 5; i++) {
            projectiles.add(new Projectile(i * 150, 0, 60));
        }
    }

    @Override
    public boolean isActive() {
        return ticks < 300;
    }

    @Override
    public void update() {
        if (ticks < 60) {
            for (Projectile p : projectiles) {
                p.setY(p.getY() + 1);
            }
        } else if (ticks == 60) {
            for (int i = 0; i < 4; i++) {
                projectiles.add(new Laser(projectiles.get(i).getX(), 0, projectiles.get(i).getX(), 600, 300));
            }
        } else if (ticks >= 120 && ticks % 20 == 0) {
            projectiles.add(new ExplodingProjectile((int) (Math.random() * 700) + 100, 600, 50));
        }
        for (int p = 0; p < projectiles.size(); p++) {
            Projectile projectile = projectiles.get(p);
            if (projectile instanceof ExplodingProjectile && !projectile.isActive()) {
                for (int i = 0; i <= 7; i++) {
                    int rad = 30;
                    projectiles.add(new ExplodingFragmentProjectile((projectile.getX() +  (rad * Math.cos(i * Math.PI / 4))), projectile.getY() +  (rad * Math.sin(i * Math.PI / 4)), 75, i));
                }
                projectiles.remove(p);
                p--;
            }
        }
        super.update();
    }
}
