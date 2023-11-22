
public class GameUtils {
    static Frame mainFrame;

    public static void runGame() {
        Tiles.createTiles();
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
        payRent();
        if(player.getCoin()<=0) {
            checkWinner();
        }
        if(player.getTile() instanceof ChanceField) {
            var card = new ChanceCard();
            String str = card.performCardAction();
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
    }
    public static void payRent() {
        var player = Player.getCurrentPlayer();
        if(player.getTile() instanceof PropertyField) {
            PropertyField tile = (PropertyField) player.getTile();
            System.out.println(tile.isOwned());
            if(tile.isOwned()) {
                mainFrame.setOwner(tile.getOwner().getName()); //sets the name label of the owner of the tile
            }
            if (tile.isOwned() && !tile.getOwner().equals(player)) {
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
    Player[] players = Player.getPlayers();
    var index = 0;
    winner[0] = Player.getPlayerNumb(0);
    for (var player : players) {        
        for (var i = 0; i<winner.length; i++) {
            if (winner[0].getCoin() < player.getCoin()) {
                    winner[0] = player;
                    index = 1;
            }
            else if (winner[0].getCoin() == player.getCoin() && (winner[1]==null)) {
                    winner[1] = player;
                    index = 2;
            }
            else if (winner[1].getCoin() == player.getCoin()) {
                    winner[2] = player;
                    index = 3;
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
    
    System.out.println(winnersText.toString() + " Won!");
    mainFrame.labelText(winnersText.toString() + " Won the game!");
    mainFrame.hideAll();
}
}
