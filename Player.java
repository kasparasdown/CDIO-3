import java.util.Scanner;
public class Player{
    String name;
    int coin;
    static int playernumbers = 0;

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
    public static void totalPlayers(int numb) {
        while ((playernumbers<2 || playernumbers>4)) {
        System.out.println("Write how many players you are");
        playernumbers = numb;
        }
        System.out.println(playernumbers+" players confirmed");
    }
}