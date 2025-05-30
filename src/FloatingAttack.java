import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FloatingAttack extends Attack {
    private int resets;

    public FloatingAttack(Player player) {
        super(player);
        initialize();
    }

    private void initialize() {
        resets++;
        if (resets > 3) {
            return;
        }
        projectiles = new ArrayList<>();
        for (int i = 0; i < (int) (Math.random() * 20) + 1; i++) {
            projectiles.add(new FloatingProjectile((int) (Math.random() * 700) + 100, 600, 100));
        }
    }

    @Override
    public void update() {
        super.update();
        if (projectiles.getFirst().getY() < -100) {
            initialize();
        }
    }
}
