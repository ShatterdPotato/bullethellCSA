public class FilterAttack extends Attack {
    private boolean push;
    private boolean draw;

    public FilterAttack(Player player) {
        super(player);
        projectiles.add(new Laser(-10, 0, -10, 800, 500));
        if (player.getX() > 50)
            push = true;
        else
            push = false;
    }

    @Override
    public boolean isActive() {
        return ((Laser) (projectiles.getFirst())).getX1() < 625;
    }

    @Override
    public void update() {
        if (push) {
            getPlayer().moveLeft(15);
            if (getPlayer().getX() <= 50) {
                push = false;
                draw = true;
            }
            return;
        }   else if (draw) {
            for (int i = 1; i <= 5; i++) {
                int offset = (int) (Math.random() * 201) + 800;
                projectiles.add(new Projectile(150 + (i * 100), offset, 1000));
                for (int j = 1; j <= 15; j++) {
                    offset -= 75;
                    projectiles.add(new Projectile(100 + (i * 100), offset, 1000));
                }
            }
            draw = false;
            return;
        }
        super.update();
        Laser laser = (Laser) projectiles.getFirst();
        if (laser.getTicks() > 200) {
            laser.setX2(laser.getX2() + 5);
            laser.setX1(laser.getX1() + 5);
        }
        else if (laser.getTicks() > 125) {
            laser.setX2(laser.getX2() + 3);
            laser.setX1(laser.getX1() + 3);
        }
        else {
            laser.setX2(laser.getX2() + 1);
            laser.setX1(laser.getX1() + 1);
        }
        for (Projectile proj : projectiles) {
            if (proj.getX() % 200 == 0)
                proj.setY(proj.getY() - 1);
            else
                proj.setY(proj.getY() + 1);
        }
    }
}
