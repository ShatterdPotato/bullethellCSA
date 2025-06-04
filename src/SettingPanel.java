import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SettingPanel extends JPanel implements MouseListener {
    private JLabel back;

    public SettingPanel() {
        setFocusable(true);
        requestFocusInWindow();

        back = new JLabel("<- Back");
        back.setFocusable(false);
        back.setBackground(new Color(0, 0, 0, 0));
        back.setFont(new Font("Arial", Font.BOLD, 40));
        back.addMouseListener(this);

        add(back);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        back.setLocation(10, 10);

    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == back)
            Frame.cycleScreen(new MainPanel());
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
