public class Player {
    private String name;
    private int coin;
    static int playerNumbers = 0;
    private static Player[] players;
    private static int playerIndex = 0;
    private int location;
    private Tiles[] tiles;
    private Tiles currentTile;


    public Player(String name) {
        tiles = Tiles.getAllTiles();
        this.name = name;
        switch(playerNumbers) {
            case 2:
                this.coin = 20;
                break;
            case 3:
                this.coin = 18;
                break;
            case 4:
                this.coin = 16;
                break;
        }
        this.location = 0;
        this.tiles = tiles;
        this.currentTile = tiles[location];
    }

    public String getName() {
        return name;
    }

    public int getCoin() {
        return coin;
    }
    public int getLocation() {
        return currentTile.getPos();
    }
    public Tiles getTile() {
        return currentTile;
    }
    public void setLocation(int location) {
        this.location = location;
        this.currentTile = tiles[location];
    }

    public void addCoins(int value) {
        coin += value;
    }

    public static void totalPlayers(int numb) {
        playerNumbers = numb;
        players = new Player[playerNumbers]; // Initialize the players array
        System.out.println(playerNumbers + " Number of Players!"); // This is a test, remove later
    }

    public static Player[] createPlayers() {
        for (int i = 0; i < playerNumbers; i++) {
            players[i] = new Player("Player " + (i + 1));
        }
        return players;
    }

    public static Player getPlayerNumb(int number) {
        return players[number];
    }

    public static void switchPlayer() {
        playerIndex = (playerIndex + 1) % playerNumbers;
    }

    public static Player getCurrentPlayer() {
        return players[playerIndex];
    }

    public void payRent(int rent) {
        // gonna pay rent
    }
}
