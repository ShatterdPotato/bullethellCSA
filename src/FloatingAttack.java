import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FloatingAttack extends Attack implements ActionListener {
    private Timer timer;
    private int speed;
    private int resets;

    public FloatingAttack(Player player) {
        super(player);
        speed = 1;
        timer = new Timer(16, this);
        timer.start();
        initialize();
        resets = 0;
    }



    private void initialize() {
        resets++;
        if (resets > 3) {
            timer.stop();
            return;
        }
        projectiles = new ArrayList<>();
        for (int i = 0; i < (int) (Math.random() * 6) + 1; i++) {
            projectiles.add(new Projectile((int) (Math.random() * 700) + 100, 600));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        speed++;
        for (int i = 0; i < projectiles.size(); i++) {
            projectiles.get(i).setY(projectiles.get(i).getY() - speed);
            if (!getPlayer().isInvincible() && projectiles.get(i).getHitbox().intersects(getPlayer().getHitbox()))
                getPlayer().setHearts(-1);
        }
        if (projectiles.getFirst().getY() < -100) {
            initialize();
            speed = 0;
        }
    }
}
