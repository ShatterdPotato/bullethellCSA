import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FloatingAttack extends Attack implements ActionListener {
    private Timer timer;
    private int speed;

    public FloatingAttack(Player player) {
        super(player);
        speed = 1;
        timer = new Timer(16, this);
        timer.start();
        initialize();
    }



    private void initialize() {
        projectiles = new ArrayList<>();
        for (int i = 0; i < (int) (Math.random() * 10) + 1; i++) {
            projectiles.add(new Projectile((int) (Math.random() * 700) + 100, 600));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        speed++;
        for (int i = 0; i < projectiles.size(); i++) {
            projectiles.get(i).setY(projectiles.get(i).getY() - speed);
            if (projectiles.get(i).getHitbox().intersects(getPlayer().getHitbox()))
                getPlayer().setHearts(-1);
        }
        if (projectiles.get(0).getY() < -100) {
            initialize();
            speed = 0;
        }
    }
}
