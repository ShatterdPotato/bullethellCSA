public class Player {
    private int hearts;
    private int X;
    private int Y;
    public boolean dead;

    public Player() {
        hearts = 3;
        dead = false;
        X = 400;
        Y = 300;
    }

    public int getHearts() {
        return hearts;
    }

    public boolean isDead() {
        return dead;
    }

    public void hit() {
        hearts--;
        if (hearts == 0) {
            dead = true;
        }
    }


}
