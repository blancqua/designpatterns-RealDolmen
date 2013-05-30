package be.dolmen.decorator;

public class Game {

    public Player createPlayer() {
        return new PlayerImpl();
    }

    public Player sendOnQuest(Player player) {
        return new OnQuestPlayer(player);
    }

    public Player level20(Player player) {
        return new FlyingPlayer(player);
    }

}
