import javax.swing.*;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class MainPanel extends JPanel implements MouseListener {
    private ArrayList<JLabel> labels;
    private JLabel play;
    private JLabel settings;
    private JLabel quit;

    public MainPanel() {
        setFocusable(true);
        requestFocusInWindow();

        play = new JLabel("Play");
        play.setFocusable(false);
        play.setBackground(new Color(0, 0, 0, 0));
        play.setFont(new Font("Arial", Font.BOLD, 40));
        play.addMouseListener(this);

        settings = new JLabel("Settings");
        settings.setFocusable(false);
        settings.setBackground(new Color(0, 0, 0, 0));
        settings.setFont(new Font("Arial", Font.BOLD, 40));
        settings.addMouseListener(this);

        quit = new JLabel("Quit");
        quit.setFocusable(false);
        quit.setBackground(new Color(0, 0, 0, 0));
        quit.setFont(new Font("Arial", Font.BOLD, 40));
        quit.addMouseListener(this);


        add(play);
        add(settings);
        add(quit);
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        play.setLocation(50, 150);
        settings.setLocation(50, 300);
        quit.setLocation(50, 450);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == play)
            Frame.cycleScreen(new FightPanel());
        else if (e.getSource() == settings)
            Frame.cycleScreen(new SettingPanel());
        else if (e.getSource() == quit)
            Frame.quit();
        repaint();
        revalidate();
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
