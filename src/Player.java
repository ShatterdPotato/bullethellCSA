import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player {
    private int hearts;
    private int X;
    private int Y;
    public boolean dead;
    private final int MOVE_SPEED = 5;
    private final int FOCUS_MOVE_SPEED = 3;

    private BufferedImage sprite;

    public Player() {
        hearts = 3;
        dead = false;
        X = 400;
        Y = 300;
        try {
            sprite = ImageIO.read(new File("src\\player.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public int getHearts() {
        return hearts;
    }

    public boolean isDead() {
        return dead;
    }

    public BufferedImage getSprite() {
        return sprite;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public void hit() {
        hearts--;
        if (hearts == 0) {
            dead = true;
        }
    }

    public void moveUp(boolean slow) {
        if (!slow) {
            Y -= MOVE_SPEED;
        }   else {
            Y -= FOCUS_MOVE_SPEED;
        }
        if (Y < 0) {
            Y = 0;
        }
    }

    public void moveDown(boolean slow) {
        if (!slow) {
            Y += MOVE_SPEED;
        }   else {
            Y += FOCUS_MOVE_SPEED;
        }
        if (Y >= 567) {
            Y = 567;
        }
    }

    public void moveRight(boolean slow) {
        if (!slow) {
            X += MOVE_SPEED;
        }   else {
            X += FOCUS_MOVE_SPEED;
        }
        if (X >= 752) {
            X = 752;
        }
    }

    public void moveLeft(boolean slow) {
        if (!slow) {
            X -= MOVE_SPEED;
        }   else {
            X -= FOCUS_MOVE_SPEED;
        }
        if (X < 0) {
            X = 0;
        }
    }


}
