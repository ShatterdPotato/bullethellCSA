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

    public FightPanel() {
        addKeyListener(this);
        setFocusable(true);
        requestFocusInWindow();
        player = new Player();
        keys = new boolean[128];
        timer = new Timer(16, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (keys[87]) {
            player.moveUp();
        }

        if (keys[65]) {
            player.moveLeft();
        }

        if (keys[83]) {
            player.moveDown();
        }

        if (keys[68]) {
            player.moveRight();
        }
        g.drawImage(player.getSprite(), player.getX(),player.getY(), null);
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
