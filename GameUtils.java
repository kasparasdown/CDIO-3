
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
        ownerName();
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
                mainFrame.buyButtonVisible(false);
                ownerName();
            }
        }
    }
    public static void payRent() {
        var player = Player.getCurrentPlayer();
        if(player.getTile() instanceof PropertyField) {
            PropertyField tile = (PropertyField) player.getTile();
            ownerName();
            if (tile.isOwned() && !tile.getOwner().equals(player)) {
                Player.getCurrentPlayer().addCoins(-tile.getRent());
                tile.getOwner().addCoins(+tile.getRent());
                mainFrame.buyButtonVisible(false);
                mainFrame.setChanceCard(true, Player.getCurrentPlayer().getName()+" paid M2 to "+tile.getOwner().getName());
            }
        }
    }

    public static void switchPlayer() {
        mainFrame.setChanceCard(false, null);
        Player.setPlayerIndex((Player.getPlayerIndex() + 1) % Player.playerNumbers);
        var player = Player.getCurrentPlayer();
        mainFrame.locationLabelText(player.getTile().getName());
        mainFrame.labelText(player.getName() + "'s' turn. Roll!");
        mainFrame.setLogo(player.getLocation());
        mainFrame.setOwner("");
        ownerName();
    }
    public static void ownerName() {
        var tile = Player.getCurrentPlayer().getTile();
        if(tile.isOwned()) {
            mainFrame.setOwner(tile.getOwner().getName());
        }
        else {
            mainFrame.setOwner("");
        }
    }


    public static void checkWinner() {
        Player[] winner = new Player[Player.playerNumbers];
        Player[] players = Player.getPlayers();
        var index = 1;
        winner[0] = Player.getPlayerNumb(0);
            for (var player : players) {        
                if (winner[0].getCoin() < player.getCoin()) {
                        winner[0] = player;
                        index = 1;
                }
            }

        
        Player[] actualWinners = new Player[index]; // Create an array with the actual number of winners
        var n = 0;
        for(var i=0; i<winner.length; i++) {
            if(winner[i] != null) {
                actualWinners[n] = winner[i];
                n++;
            }
        }
        //For now using try catch, to ignore out of bounds. Should be changed later.
        try {
            if(index == 0) {
            mainFrame.labelText(actualWinners[0].getName() + " Won the game!");
            }
        }
        catch(ArrayIndexOutOfBoundsException ignore) {
        }
        try {
            if (index == 1) {
            mainFrame.labelText(actualWinners[0].getName() + " Won the game!");
            mainFrame.locationLabelText(actualWinners[1].getName() + " Won the game!");
            }
        }
        catch(ArrayIndexOutOfBoundsException ignore) {
        }
        try {
            if (index ==2 ) {
            mainFrame.labelText(actualWinners[0].getName() + " Won the game!");
            mainFrame.locationLabelText(actualWinners[1].getName() + " Won the game!");
            mainFrame.setChanceCard(true, actualWinners[3].getName() + " Won the game!");
            }
        }
        catch(ArrayIndexOutOfBoundsException ignore) {
        }
        mainFrame.hideAll();
    }
    public static void changeLogo(int logoNum) {
        mainFrame.setLogo(logoNum);
    }
}
