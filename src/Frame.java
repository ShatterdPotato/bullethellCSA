import javax.swing.*;

public class Frame {
    public Frame() {
        JFrame frame = new JFrame("idk what to call this");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        FightPanel panel = new FightPanel();
        frame.add(panel);
        frame.setVisible(true);
    }
}
