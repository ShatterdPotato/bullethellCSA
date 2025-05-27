import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class FightPanel extends JPanel implements KeyListener, ActionListener {
    private Player player;
    private boolean[] keys;
    private Timer timer;
    private Attack currAttack;

    public FightPanel() {
        addKeyListener(this);
        setFocusable(true);
        requestFocusInWindow();
        player = new Player();
        keys = new boolean[128];
        timer = new Timer(16, this);
        timer.start();
        currAttack = new HomingAttack(player);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (keys[87])
            player.moveUp(keys[16]);

        if (keys[65])
            player.moveLeft(keys[16]);

        if (keys[83])
            player.moveDown(keys[16]);

        if (keys[68])
            player.moveRight(keys[16]);

        for (Projectile proj : currAttack.getProjectiles()) {
            if (proj.isActive())
                g.drawImage(Projectile.getSprite(), proj.getX(), proj.getY(), null);
        }
        for (int i = 1; i <= 3; i++) {
            g.drawImage(Projectile.getSprite(), 800 - (i * 20), 0, null);
        }
        if (!player.isDead()) {
            g.drawImage(player.getSprite(), player.getX(),player.getY(), null);
            System.out.println(player.getHearts());
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == timer) {
            repaint();
        }
    }
}
