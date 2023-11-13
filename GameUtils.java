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
    public static void buyProperty() {
        var money = Player.getCurrentPlayer().getCoin();
        Tiles tile = Player.getCurrentPlayer().getTile();
        System.out.println(tile.getPrice());
        if (money>tile.getPrice() && !tile.isOwned()) {
            Player.getCurrentPlayer().addCoins(-tile.getPrice());
            tile.setOwner(Player.getCurrentPlayer());
            System.out.println(tile.getName()+" is now owned by"+tile.getOwner().getName());
        }
    }
}
