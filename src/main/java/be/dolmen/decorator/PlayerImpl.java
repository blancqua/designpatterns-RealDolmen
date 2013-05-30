package be.dolmen.decorator;

// CONCRETE COMPONENT
public class PlayerImpl implements Player {

    private int xp;

    @Override
    public void hit() {
        System.out.println("SMASH");
    }

    @Override
    public void move() {
        System.out.println("ZOEF");
    }

    @Override
    public void sell() {
        System.out.println("TSJING TSJING");
    }

    @Override
    public void talk() {
        System.out.println("HELLO");
    }

    @Override
    public void increaseXP() {
        xp++;
    }

    @Override
    public int getLevel() {
        return xp / 10;
    }

}
