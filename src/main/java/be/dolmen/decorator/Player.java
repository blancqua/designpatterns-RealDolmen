package be.dolmen.decorator;

// COMPONENT
public interface Player {

    void hit();
    void move();
    void sell();
    void talk();

    void increaseXP();
    int getLevel();

}
