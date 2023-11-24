public class Player {
    private String name;
    private int coin;
    static int playerNumbers = 0;
    private static Player[] players;
    private static int playerIndex = 0;
    private int location;
    private Tiles[] tiles = Tiles.getAllTiles();
    private Tiles currentTile;
    private boolean hasGetOutOfJailFreeCard;
    private boolean isInJail;


    public Player(String name) {
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
        this.currentTile = tiles[location];
        this.hasGetOutOfJailFreeCard = false;
        this.isInJail = false;
    }
    public boolean isInJail() {
        return this.isInJail;
    }

    public void setInJail(boolean status) {
        this.hasGetOutOfJailFreeCard = status;
    }
    public boolean hasgetOutOfJailFreeCard() {
        return this.hasGetOutOfJailFreeCard;
    }

    public void useGetOutOfJailFreeCard() {
        this.hasGetOutOfJailFreeCard = false;
    }

    public void acquireGetOutOfJailFreeCard() {
        this.hasGetOutOfJailFreeCard = true;
    }

    public String getName() {
        return this.name;
    }

    public int getCoin() {
        return this.coin;
    }
    public int getLocation() {
        return this.currentTile.getPos();
    }
    public Tiles getTile() {
        return tiles[this.location];
    }
    public void setLocation(int location) {
        this.location = location;
        this.currentTile = tiles[location];
    }

    public void addCoins(int value) {
        this.coin += value;
    }

    public void removeCoins(int value) {
        this.coin -= value;
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
    public static Player[] getPlayers() {
        return players;
    }

    public static Player getPlayerNumb(int number) {
        return players[number];
    }

    public static Player getCurrentPlayer() {
        return players[playerIndex];
    }
    //Checking current player in the array
    public static int getPlayerIndex() {
        return playerIndex;
    }
    public static void setPlayerIndex(int i) {
        playerIndex = i;
    }
}
