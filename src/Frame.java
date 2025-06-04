import javax.swing.*;

public class Frame {
    private static JFrame frame;
    private static JPanel currScreen;

    public Frame() {
        frame = new JFrame("idk what to call this");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(815, 640);
        frame.setLocationRelativeTo(null);
        currScreen = new MainPanel(frame);
        frame.add(currScreen);
        frame.setVisible(true);
    }

    public static void quit() {
        frame.setVisible(false);
        frame.dispose();
    }

    public static void cycleScreen(JPanel newScreen) {
        currScreen = newScreen;
        frame.getContentPane().removeAll();
        frame.add(currScreen);
        currScreen.requestFocusInWindow();
        frame.validate();
        frame.repaint();
    }
}
