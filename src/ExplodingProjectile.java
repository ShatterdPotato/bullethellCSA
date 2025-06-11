import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class ExplodingProjectile extends Projectile {
    private int speed;

    public ExplodingProjectile(int x, int y, int lifespan) {
        super(x, y, lifespan);
        speed = (int) (Math.random() * 20) + 10;
        try {
            setSprite(ImageIO.read(new File("src\\exploding_projectile.png")));
        }   catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Player player) {
        super.update(player);
        if (getTicks() % 2 == 0) {
            speed--;
            setY(getY() - speed);
            if (speed == -1) {
                active = false;
            }
        }
    }

}
