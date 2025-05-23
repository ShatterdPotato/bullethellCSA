import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class HomingAttack implements ActionListener {
    private Graphics g;
    private Timer timer;
    private Player player;
    private ArrayList<Projectile> projectiles;
    private int speed;

    public HomingAttack(Graphics g) {
        this.g = g;
        speed = 1;
        timer = new Timer(16, this);
        initialize();
    }

    private void initialize() {
        projectiles = new ArrayList<>();
        for (int i = 0; i < (int) (Math.random() * 5) + 1; i++) {
            projectiles.add(new Projectile((int) (Math.random() * 700) + 100, 600));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        speed++;
        for (int i = 0; i < projectiles.size(); i++) {
            projectiles.get(i).setY(speed * -1);
            if (projectiles.get(i).isActive()) {
                g.drawImage(Projectile.getSprite(), projectiles.get(i).getX(), projectiles.get(i).getY(), null);
            }
        }

    }
}
