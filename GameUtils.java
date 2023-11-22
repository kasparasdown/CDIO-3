
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
        System.out.println(player.getTile().getName());
        payRent();
        if(player.getCoin()<=0) {
            checkWinner();
        }
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
        var player = Player.getCurrentPlayer();
        if(player.getTile() instanceof PropertyField) {
            PropertyField tile = (PropertyField) player.getTile();
            System.out.println(tile.isOwned());
            if(tile.isOwned()) {
                mainFrame.setOwner(tile.getOwner().getName());
            }
            if (tile.isOwned()) {
                Player.getCurrentPlayer().addCoins(-tile.getRent());
                tile.getOwner().addCoins(+tile.getRent());
                System.out.println(Player.getCurrentPlayer().getName()+" paid "+tile.getOwner().getName());
                mainFrame.buyButtonVisible(false);
                System.out.println(Player.getCurrentPlayer().getName()+" paid 2M to "+tile.getOwner().getName());
            }
        }
    }

    public static void switchPlayer() {
        mainFrame.setChanceCard(false, null);
        Player.setPlayerIndex((Player.getPlayerIndex() + 1) % Player.playerNumbers);
        var player = Player.getCurrentPlayer();
        mainFrame.locationLabelText(player.getTile().getName());
        mainFrame.labelText(player.getName() + " it's your turn now, roll");
        mainFrame.setLogo(player.getLocation());
        mainFrame.setOwner("");
    }
    public static void checkWinner() {
    Player[] winner = new Player[Player.playerNumbers];
    Player nextPlayer = Player.getPlayerNumb(1);
    var index = 0;
    
    for (var i = 0; i < Player.playerNumbers - 1; i++) {
        try {
            nextPlayer = Player.getPlayerNumb(i + 1); // Checking next player
        } catch (Exception ignored) {
        }
        
        var player = Player.getPlayerNumb(i);
        
        if (player.getCoin() <= nextPlayer.getCoin()) {
            if (index < winner.length) {
                winner[index] = nextPlayer;
                index++;
            } else {
                break; // Exit the loop if the winner array is full
            }
        }
    }
    
    Player[] actualWinners = new Player[index]; // Create an array with the actual number of winners
    System.arraycopy(winner, 0, actualWinners, 0, index);
    
    StringBuilder winnersText = new StringBuilder();
    
    for (var i = 0; i < actualWinners.length; i++) {
        winnersText.append(actualWinners[i].getName());
        
        if (i < actualWinners.length - 1) {
            winnersText.append(", ");
        }
    }
    
    System.out.println(winnersText.toString() + " has won the game!");
    mainFrame.labelText(winnersText.toString() + " has won the game!");
    mainFrame.hideAll();
}
}
