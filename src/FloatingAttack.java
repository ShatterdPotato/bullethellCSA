import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FloatingAttack extends Attack {
    public FloatingAttack(Player player) {
        super(player);
        for (int i = 0; i < (int) (Math.random() * 20) + 5; i++) {
            projectiles.add(new FloatingProjectile((int) (Math.random() * 700) + 100, 600, 40));
        }
    }

    @Override
    public void update() {
        super.update();
    }
}
