public class Player {
    String name;
    int coin;
    static int playernumbers = 0;
    private static Player[] players;
    private static int playerIndex = 0;

    public Player(String name) {
        this.name = name;
        this.coin = 0;
    }

    public String getName() {
        return name;
    }

    public int getCoin() {
        return coin;
    }

    public void addCoins(int value) {
        coin += value;
    }

    public static void totalPlayers(int numb) {
        playernumbers = numb;
        players = new Player[playernumbers]; // Initialize the players array
        System.out.println(playernumbers + " Number of Players!"); // This is a test, remove later
    }

    public static Player[] createPlayers() {
        for (int i = 0; i < playernumbers; i++) {
            players[i] = new Player("Player " + (i + 1));
        }
        return players;
    }

    public static Player[] getAllPlayers() {
        return players;
    }

    public static void switchPlayer() {
        playerIndex = (playerIndex + 1) % playernumbers;
    }

    public static Player getCurrentPlayer() {
        return players[playerIndex];
    }
}
