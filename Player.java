public class Player {
    String name;
    int coin;
    static int playerNumbers = 0;
    private static Player[] players;
    private static int playerIndex = 0;
    private int location;

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
    public void move(int roll) {
        location = (location + roll) %24;
    }

    public void payRent(int rent) {
        // gonna pay rent
    }
}
