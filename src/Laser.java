import java.awt.*;
import java.awt.geom.Line2D;

public class Laser extends Projectile {
    private double x1;
    private double x2;
    private double y1;
    private double y2;
    private Line2D line;

    public Laser(double x1, double y1, double x2, double y2,int lifespan) {
        super(x1, y1, lifespan);
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;

        line = new Line2D.Double(x1, y1, x2, y2);
    }

    public double getX1() {
        return x1;
    }

    public double getX2() {
        return x2;
    }

    public double getY1() {
        return y1;
    }

    public double getY2() {
        return y2;
    }

    public void setX1(double x1) {
        this.x1 = x1;
        line.setLine(x1, y1, x2, y2);
    }

    public void setX2(double x2) {
        this.x2 = x2;
        line.setLine(x1, y1, x2, y2);
    }

    public void setY1(double y1) {
        this.y1 = y1;
        line.setLine(x1, y1, x2, y2);
    }

    public void setY2(double y2) {
        this.y2 = y2;
        line.setLine(x1, y1, x2, y2);
    }

    @Override
    public Shape getHitbox() {
        return line;
    }

    @Override
    public void update(Player player) {
        super.update(player);
    }
}
