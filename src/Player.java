import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Player implements ActionListener {
    private int hearts;
    private int X;
    private int Y;
    private boolean invincible;
    private final int MOVE_SPEED = 8;
    private final int FOCUS_MOVE_SPEED = 4;
    private Animation animation;
    private boolean facingRight;
    private Timer iframe;
    private Rectangle hitbox;

    public Player() {
        hearts = 3;
        X = 400;
        Y = 300;
        ArrayList<BufferedImage> images = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            String filename = "src\\player00" + i + ".png";
            try {
                images.add(ImageIO.read(new File(filename)));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            animation = new Animation(images, 100);
        }
        facingRight = true;
        iframe = new Timer(1000, this);
        hitbox = new Rectangle(X + 40, Y + 20, 20, 20);
    }

    public void faceRight() {
        facingRight = true;
    }

    public void faceLeft() {
        facingRight = false;
    }

    public int getHearts() {
        return hearts;
    }

    public boolean isDead() {
        return hearts <= 0;
    }

    public BufferedImage getSprite() {
        return animation.getActiveFrame();
    }

    public int getX() {
        if (facingRight) {
            return X;
        }
        return X + getSprite().getWidth();
    }
    public int getHeight() {
        return getSprite().getHeight();
    }

    public int getWidth() {
        if (facingRight) {
            return getSprite().getWidth();
        } else {
            return getSprite().getWidth() * -1;
        }
    }

    public int getY() {
        return Y;
    }

    public void setHearts(int amt) {
        if (amt < 0)
            invincible = true;
        iframe.start();
        hearts += amt;
        if (hearts < 0)
            hearts = 0;
        else if (hearts > 3)
            hearts = 3;
    }

    public void toggleInvincibility() {
        invincible = !invincible;
    }

    public boolean isInvincible() {
        return invincible;
    }

    public Rectangle getHitbox() {
        return hitbox;
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
        hitbox.y = Y + 20;
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
        hitbox.y = Y + 20;
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
        hitbox.x = X + 40;
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
        hitbox.x = X + 25;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        iframe.stop();
        invincible = false;
    }
}
