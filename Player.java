import java.util.Scanner;
public class Player{
    String name;
    int coin;
    static int playernumbers;

    public Player(String name, int coin) {
        this.name = name;
        this.coin = coin;
    }
    public String getName() {
        return name;
    }
    public int getCoin() {
        return coin;
    }
    public void addCoins(int value) {
            coin =+ value;
    }
    public static void totalPlayers() {
        var s = new Scanner(System.in);
        System.out.println("Write how many players you are");
        playernumbers = s.nextInt();
        s.close();
    }
}