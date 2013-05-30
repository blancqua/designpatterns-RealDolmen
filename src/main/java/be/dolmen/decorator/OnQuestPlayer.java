package be.dolmen.decorator;

// CONCRETE DECORATOR
public class OnQuestPlayer extends PlayerDecorator {

    public OnQuestPlayer(Player player) {
        super(player);
    }

    @Override
    public void hit() {
        increaseXP();
        super.hit();
    }

    @Override
    public void move() {
        increaseXP();
        super.move();
    }

    @Override
    public void sell() {
        increaseXP();
        super.sell();
    }

    @Override
    public void talk() {
        increaseXP();
        super.talk();
    }

}
