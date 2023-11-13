public class GameUtils {

    public static void runGame() {
        new Frame();
    }
    public static void move(int roll) {
        var rollLocation = Player.getCurrentPlayer().getLocation() + roll;
        if (rollLocation >= 24) {
            Player.getCurrentPlayer().addCoins(2);
        }
        var newlocation = (rollLocation) %24;
        Player.getCurrentPlayer().setLocation(newlocation);
        Frame.locationLabelText(Player.getCurrentPlayer().getTile().getName());
    }
}
