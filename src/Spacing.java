public class Spacing extends Attack{
    private int amt;
    public Spacing(Player player, int amt) {
        super(player);
        this.amt = amt;
    }

    @Override
    public boolean isActive() {
        return ticks < amt;
    }

    @Override
    public void update() {
        super.update();
    }
}
