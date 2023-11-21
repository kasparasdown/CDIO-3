import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        System.out.println(player.getTile().getName());
        if(player.getTile() instanceof ChanceField) {
            var card = new ChanceCard();
            String str = card.performCardAction();
            System.out.println(str);
            mainFrame.setChanceCard(true, str);
        }
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
                checkWinner();
            }
        }
        else {
            System.out.println("This is not a property");
        }
    }

    private static void drawChanceCard() {
        Random random = new Random();
        int randomIndex = random.nextInt(chanceCards.length);
        ChanceCard drawnCard = chanceCards[randomIndex];

        drawnCard.performCardAction();
    }

    public static void switchPlayer() {
        mainFrame.setChanceCard(false, null);
        Player.setPlayerIndex((Player.getPlayerIndex() + 1) % Player.playerNumbers);
        var player = Player.getCurrentPlayer();
        mainFrame.locationLabelText(player.getTile().getName());
        mainFrame.labelText(player.getName() + " it's your turn now, roll");
        mainFrame.setLogo(player.getLocation());
    }
    public static void checkWinner() {
        Player winner = Player.getPlayerNumb(0);
        for(var i=0; i<Player.playerNumbers; i++) {
            var nextPlayer = (i < Player.playerNumbers) ? Player.getPlayerNumb(i+1) : Player.getPlayerNumb(i);
            var player = Player.getPlayerNumb(i);
            if(player.getCoin()<=nextPlayer.getCoin()) {
                winner = nextPlayer;
            }
        }
        for( var i = 0; i<Player.playerNumbers; i++) {
            if(Player.getPlayerNumb(i).getCoin() <=0) {
                System.out.println(winner.getName()+ " has won the game!");
                mainFrame.labelText(winner.getName()+ " has won the game!");
                mainFrame.hideAll();
            }
        }
    }
}
