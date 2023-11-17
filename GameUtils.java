import java.util.Random;

public class GameUtils {
    static Frame mainFrame;
    private static ChanceCard[] chanceCards;

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
    public static void payRent() {
        if(Player.getCurrentPlayer().getTile() instanceof PropertyField) {
            var money = Player.getCurrentPlayer().getCoin();
            PropertyField tile = (PropertyField) Player.getCurrentPlayer().getTile();
            System.out.println(tile.isOwned());
            System.out.println(tile.getOwner().getName());
            System.out.println();
            if (money>tile.getRent() && tile.isOwned() && tile.getOwner() != tile.getOwner() ) {
                Player.getCurrentPlayer().addCoins(-tile.getRent());
                tile.getOwner().addCoins(+tile.getRent());
                System.out.println(Player.getCurrentPlayer().getName()+" paid "+tile.getOwner().getName());
                mainFrame.buyButtonVisible(false);
            }
        }
        else {
            System.out.println("This is not a property");
        }
    }

    private static void initializeChanceCards() {
        chanceCards = new ChanceCard[]{
            new ChanceCard("Advance to Start", null),
            new ChanceCard("Move 5 tiles forward", null),
            new ChanceCard("Move to Orange", null),
            new ChanceCard("Move 1 tile or draw again", null),
            new ChanceCard("To much candy", null),
            new ChanceCard("Move to a orange or green tile", null),
            new ChanceCard("Move to a light blue tile", null),
            new ChanceCard("Get out of jail free card", null),
            new ChanceCard("Move to beachpromenade", null),
            new ChanceCard("Birthday boy", null),
            new ChanceCard("Move to a pink or dark blue tile", null),
            new ChanceCard("Homework done", null),
            new ChanceCard("Move to a red tile", null),
            new ChanceCard("Move to skatepark", null),
            new ChanceCard("Move to a light blue or red tile", null),
            new ChanceCard("Move to a brown or yellow tile", null),
            
        };
    }

    private static void drawChanceCard() {
        Random random = new Random();
        int randomIndex = random.nextInt(chanceCards.length);
        ChanceCard drawnCard = chanceCards[randomIndex];

        drawnCard.performCardAction();
    }

    public static void switchPlayer() {
        var player = Player.getCurrentPlayer();
        Player.setPlayerIndex((Player.getPlayerIndex() + 1) % Player.playerNumbers);
        mainFrame.locationLabelText(player.getTile().getName());
        mainFrame.labelText(player.getName() + " it's your turn now, roll");
        mainFrame.setLogo(player.getLocation());
    }
}
