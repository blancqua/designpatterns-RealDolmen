package be.dolmen.decorator;

// DECORATOR
public abstract class PlayerDecorator implements Player {

    private Player player;

    public PlayerDecorator(Player player) {
        this.player = player;
    }

    @Override
    public void hit() {
        player.hit();
    }

    @Override
    public void move() {
        player.move();
    }

    @Override
    public void sell() {
        player.sell();
    }

    @Override
    public void talk() {
        player.talk();
    }

    @Override
    public void increaseXP() {
        player.increaseXP();
    }

    @Override
    public int getLevel() {
        return player.getLevel();
    }

}
