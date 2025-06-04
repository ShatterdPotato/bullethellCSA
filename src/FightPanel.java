import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FightPanel extends JPanel implements KeyListener, ActionListener {
    private Player player;
    private boolean[] keys;
    private Timer timer;
    private Attack currAttack;
    private BufferedImage heart;
    private int attackTracker;

    public FightPanel() {
        addKeyListener(this);
        setFocusable(true);
        requestFocusInWindow();
        player = new Player();
        keys = new boolean[128];
        timer = new Timer(16, this);
        timer.start();
        attackTracker = 0;
        currAttack = new FilterAttack(player);
        try {
            heart = ImageIO.read(new File("src\\heart.png"));
        }   catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        ((Graphics2D) g).setStroke(new BasicStroke(20));
        if (keys[87])
            player.moveUp(keys[16]);

        if (keys[65]) {
            player.faceLeft();
            player.moveLeft(keys[16]);
        }

        if (keys[83])
            player.moveDown(keys[16]);

        if (keys[68]) {
            player.faceRight();
            player.moveRight(keys[16]);
        }

        if (currAttack != null) {
            for (Projectile proj : currAttack.getProjectiles()) {
                if (proj.isActive()) {
                    if (proj instanceof Laser) {
                        Line2D laser = ((Line2D) proj.getHitbox());
                        g.setColor(Color.RED);
                        g.drawLine((int) laser.getX1(), (int) laser.getY1(), (int) laser.getX2(), (int) laser.getY2());
                        g.setColor(Color.DARK_GRAY);
                    }   else
                        g.drawImage(Projectile.getSprite(), (int) proj.getX(), (int) proj.getY(), null);

                }
            }
        }

        if (!player.isDead()) {
            g.drawImage(player.getSprite(), player.getX(),player.getY(), player.getWidth(), player.getHeight(), null);
            if (keys[16])
                g.fillRect(player.getHitbox().x, player.getHitbox().y, player.getHitbox().width, player.getHitbox().height);
        }   else
            Frame.cycleScreen(new MainPanel());


        for (int i = 1; i <= player.getHearts(); i++) {
            g.drawImage(heart, 800 - (i * 50), 0, null);
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {}

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
            if (currAttack != null) {
                currAttack.update();
                if (!currAttack.isActive()) {
                    attackTracker++;
                    switch (attackTracker) {
                        case 1:
                            currAttack = new RingAttack(player);
                            break;
                        case 2, 3:
                            currAttack = new FloatingAttack(player);
                            break;
                        case 4, 5:
                            currAttack = new ExplodingAttack(player);
                            break;
                        case 6, 7:
                            currAttack = new ExplodingHomingAttack(player);
                            break;
                        case 8:
                            currAttack = new FilterAttack(player);
                            break;
                    }
                }
            }
            repaint();
        }
    }
}
