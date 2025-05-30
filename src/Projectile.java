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
    protected boolean active;
    private int ticks;
    private int lifespan;

    public Projectile(int x, int y, int lifespan) {
        X = x;
        Y = y;
        active = true;
        ticks = 0;
        this.lifespan = lifespan;
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

    public int getTicks() {
        return ticks;
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


    public void update(Player player) {
        ticks++;
        if (ticks >= lifespan) {
            active = false;
            return;
        }
        if (!player.isInvincible() && getHitbox().intersects(player.getHitbox()))
            player.setHearts(-1);
    }

}
