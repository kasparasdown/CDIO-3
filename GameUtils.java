public class GameUtils {
    static Player[] players;
    static int playerNumbers = 0;
    private static int playerIndex = 0;

    public static void runGame() {

        new Frame();
        for (int i = 0; i < players.length; i++) {
            players[i] = new Player("Player " + (i + 1));
        }
    }
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
    
}
