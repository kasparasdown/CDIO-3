public class GameUtils {
    static Player[] players;
    static int playerNumbers = 0;
    static int playerIndex = 0;
    static Frame mainframe = new Frame();
    static int location = 0;
    Tiles[] tile = Tiles.getAllTiles();

    public static void runGame() {
        players = new Player[playerNumbers];
        tile = Tiles.getAllTiles();
        for (int i = 0; i < players.length; i++) {
            players[i] = new Player("Player " + (i + 1));
        }
    }

    public static void rollEffect() {
            int rollResult = Die.dieRoll();
            GameUtils.getCurrentPlayer().addCoins(rollResult);//Adding coins to player wallet. NEED CHANGE!
            mainframe.labelText(GameUtils.getCurrentPlayer().getName() + " rolled: " + rollResult);
            move(rollResult);
    }
    public static void skipEffect() {
            GameUtils.switchPlayer();
            mainframe.locationLabelText(getCurrentPlayer().getCurrentTileString()); //Tells the new player where they are standing. CHANGE INTEGER
            mainframe.labelText(getCurrentPlayer().getName() + " it's your turn now, roll");
    }
    public static void move(int roll) {
        Tiles[] allTiles = tile.getAllTiles(); 
        int newPosition = (getCurrentPlayer().getLocation() + roll) % allTiles.length; 
        getCurrentPlayer().setlocation(newPosition);
    
        Tiles currentTile = getCurrentPlayer().getCurrentTile(allTiles);
        mainframe.locationLabelText(currentTile.toString());
    }
    

    //Utility, to create and get the different players
    public static void totalPlayers(int numb) {
        playerNumbers = numb;
        players = new Player[playerNumbers]; // Initialize the players array
        System.out.println(playerNumbers + " Number of Players!"); // This is a test, remove later
    }
    public static Player getPlayerNumb(int number) {
        return players[number];
    }
    public static Player getCurrentPlayer() {
        return players[playerIndex];
    }
    public static void switchPlayer() {
        playerIndex = (playerIndex + 1) % playerNumbers;
    }
    // Player utility end.
    
}
