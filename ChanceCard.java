abstract class ChanceCard {

    private String description;

    public ChanceCard() {
        this.description = description;

    }

    public String getDescription() {
        return description;
    }

    public abstract void perfrormAction(Player player) {

    }
}


class AdvanceToStart extends ChanceCard() {
    public AdvanceToStart(){
        super("Advance to start, recive 2M");
    }

}
@Override
public void perfrormAction(Player player) {
    player.addCoins(2);
    player.getLocation() = StartField(); 
    System.out.println(player.getName() + "advances to start. recive 2M");
}

