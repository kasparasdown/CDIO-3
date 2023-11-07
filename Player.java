public class Player{
   
    String name;
    int coin;
    
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
}