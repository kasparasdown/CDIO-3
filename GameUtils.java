

public class GameUtils {
    static Frame mainFrame;

    public static void runGame() {
        mainFrame = new Frame();
    }
    public static void move(int roll) {
        var player = Player.getCurrentPlayer();
        var rollLocation = player.getLocation() + roll;
        if (rollLocation >= 24) {
            player.addCoins(2);
        }
        var newlocation = (rollLocation) %24;
        player.setLocation(newlocation);
        mainFrame.locationLabelText(player.getTile().getName());
        mainFrame.setLogo(player.getLocation());
    }
    public static void buyProperty() {
        if(Player.getCurrentPlayer().getTile() instanceof PropertyField) {
            var money = Player.getCurrentPlayer().getCoin();
            PropertyField tile = (PropertyField) Player.getCurrentPlayer().getTile();
            System.out.println(tile.getPrice());
            if (money>tile.getPrice() && !tile.isOwned()) {
                Player.getCurrentPlayer().addCoins(-tile.getPrice());
                tile.setOwner(Player.getCurrentPlayer());
                System.out.println(tile.getName()+" is now owned by"+tile.getOwner().getName());
                mainFrame.buyButtonVisible(false);
            }
        }
        else {
            System.out.println("This is not a property");
        }
    }

    public static void switchPlayer() {
        var player = Player.getCurrentPlayer();
        Player.setPlayerIndex((Player.getPlayerIndex() + 1) % Player.playerNumbers);
        mainFrame.locationLabelText(player.getTile().getName());
        mainFrame.labelText(player.getName() + " it's your turn now, roll");
        mainFrame.setLogo(player.getLocation());
    }
}
