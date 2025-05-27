import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player {
    private int hearts;
    private int X;
    private int Y;
    private boolean invincible;
    private final int MOVE_SPEED = 8;
    private final int FOCUS_MOVE_SPEED = 5;

    private BufferedImage sprite;

    public Player() {
        hearts = 3;
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
        return hearts <= 0;
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

    public void setHearts(int amt) {
        if (amt < 0)
            invincible = true;
        hearts += amt;
        if (hearts < 0)
            hearts = 0;
        else if (hearts > 3)
            hearts = 3;
    }

    public void toggleInvincibility() {
        invincible = !invincible;
    }
    public Rectangle getHitbox() {
        return new Rectangle(X, Y, sprite.getWidth(), sprite.getHeight());
    }

    public void hit() {
        hearts--;
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
