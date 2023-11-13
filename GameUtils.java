public class GameUtils {

    public static void runGame() {
        new Frame();
    }
    public static void move(int roll) {
        var newlocation = (Player.getCurrentPlayer().getLocation() + roll) %24;
        Player.getCurrentPlayer().setLocation(newlocation);
        Frame.locationLabelText(Player.getCurrentPlayer().getTile().getName()); //Changes the label in GUI to the location. CHANGE INT TO A TILE!
    }
}
