import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player {
    private int hearts;
    private int X;
    private int Y;
    public boolean dead;
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

    public void moveUp() {
        Y--;
    }

    public void moveDown() {
        Y++;
    }


    public void moveRight() {
        X++;
    }

    public void moveLeft() {
       X--;
    }


}
