import javax.swing.*;

public class Frame {
    private static JFrame frame;

    public Frame() {
        frame = new JFrame("idk what to call this");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(815, 640);
        frame.setLocationRelativeTo(null);
        frame.add(new MainPanel());
        frame.setVisible(true);
    }

    public static void quit() {
        frame.setVisible(false);
        frame.dispose();
    }

    public static void cycleScreen(JPanel newScreen) {
        frame.getContentPane().removeAll();
        frame.add(newScreen);
        newScreen.requestFocusInWindow();
        frame.validate();
        frame.repaint();
    }
}
