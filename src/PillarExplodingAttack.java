public class PillarExplodingAttack extends Attack{
    public PillarExplodingAttack(Player player) {
        super(player);
        for (int i = 2; i < 6; i++) {
            projectiles.add(new Projectile(i * 100, 0, 30));
        }
    }

    @Override
    public boolean isActive() {
        return ticks < 200;
    }

    @Override
    public void update() {
        if (ticks < 30) {
            for (Projectile p : projectiles) {
                p.setY(p.getY() + 1);
            }
        } else if (ticks == 30) {
            for (int i = 0; i < projectiles.size(); i++) {
                Projectile temp = projectiles.remove(i);
                projectiles.add(i, new Laser(temp.getX(), 0, temp.getX(), 600, 100));
            }
        }
        super.update();
    }
}
