import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Projectile {
    private static BufferedImage sprite;
    private double X;
    private double Y;
    protected boolean active;
    private int ticks;
    private int lifespan;

    public Projectile(double x, double y, int lifespan) {
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

    public double getX() {
        return X;
    }

    public void setX(double x) {
        X = x;
    }

    public double getY() {
        return Y;
    }

    public int getTicks() {
        return ticks;
    }

    public void setY(double y) {
        Y = y;
    }

    public Shape getHitbox() {
        return new Rectangle((int) X, (int) Y, sprite.getWidth(), sprite.getHeight());
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
        if (!player.isInvincible() && active && getHitbox().intersects(player.getHitbox())) {
            player.setHearts(-1);
            if (!(this instanceof Laser))
                active = false;
        }
    }

}
