import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Projectile {
    private static BufferedImage sprite;
    private int X;
    private int Y;
    private boolean active;
    private int ticks;

    public Projectile(int x, int y) {
        X = x;
        Y = y;
        active = true;
        try {
            sprite = ImageIO.read(new File("src\\projectile.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int getX() {
        return X;
    }

    public void setX(int x) {
        X = x;
    }

    public int getY() {
        return Y;
    }

    public void setY(int y) {
        Y = y;
    }

    public Rectangle getHitbox() {
        return new Rectangle(X, Y, sprite.getWidth(), sprite.getHeight());
    }

    public static BufferedImage getSprite() {
        return sprite;
    }

    public boolean isActive() {
        return active;
    }



    public void update() {
        ticks++;
        if (ticks == 240) {
            active = false;
        }
    }

}
