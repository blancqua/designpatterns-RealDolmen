package be.dolmen.decorator;

// CONCRETE DECORATOR
public class FlyingPlayer extends PlayerDecorator {

    public FlyingPlayer(Player player) {
        super(player);
    }

    public void fly() {
        System.out.println("WIIII");
    }

}
