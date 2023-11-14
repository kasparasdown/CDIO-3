abstract class ChanceCard {
/* 
    private String description;

    public ChanceCard(String description) {
        this.description = description;

    }

    public String getDescription() {
        return description;
    }

   /*  public abstract void perfrormAction(Player player) {

    }

    public pullChanceCard() {

    }
    */
}

/* 
class AdvanceToStart extends ChanceCard() {
    public AdvanceToStart(){
        super("Advance to start, recive 2M");
    }

    @Override
    public void perfrormAction(Player player) {
        player.addCoins(2);
        player.location = StartField(); 
        System.out.println(player.getName() + "advances to start. recive 2M");
    }
}

class Move5 extends ChanceCard {
    public Move5(){
        super("Move 5 tiles forward.");
    }
    @Override
    public void perfrormAction(Player player) {
        player.location += 5;
        System.out.println("You moved forward 5 tiles.");
    }

}

class FreeOrangeTile extends ChanceCard {
    public FreeOrangeTile(){
        super("Advance to a Orange tile, if available you get it for free, if already owned you have to pay rent");
    }

    @Override
    public void perfrormAction(Player player) {
        //player.move() to any orange
        if(tile.isAvilable){
            tile.purchase;
        } else {
            player.payRent(2);
        }
    }
}

class MoveForward1 extends ChanceCard {
    public MoveForward1(){
        super("Move back one tile, or take another card");
    }

    @Override
    public void perfrormAction(Player player) {
        if(s.nexLine == move){
            player.location += 1;
        } else if (s.nextLine == ChanceCard) {
            player.getChanceCard;
        }
        
    }
}

class ToMuchCandy extends ChanceCard() {
    public ToMuchCandy(){
        super("you ate to much candy, pay 2M");
    }

    @Override
    public void perfrormAction(Player player) {
        player.removeCoins(2);
        System.out.println(player.getName() + "pays 2M");
    }
}

class FreeOrangeOrGreenTile extends ChanceCard {
    public FreeOrangeOrGreenTile(){
        super("Advance to a Orange or Green tile, if available you get it for free, if already owned you have to pay rent");
    }

    @Override
    public void perfrormAction(Player player) {
        //player.move() to any orange
        if(tile.isAvilable){
            tile.purchase;
        } else {
            player.payRent(2);
        }
    }
}

class FreeLightBlueTile extends ChanceCard {
    public FreeLightBlueTile(){
        super("Advance to a LightBlue tile, if available you get it for free, if already owned you have to pay rent");
    }

    @Override
    public void perfrormAction(Player player) {
        //player.move() to any orange
        if(tile.isAvilable){
            tile.purchase;
        } else {
            player.payRent(2);
        }
    }
}

class GetOutJailFree extends ChanceCard {
    public GetOutJailFree(){
        super("Get out of Jail free card, keep this card til you need it");

    }

    @Override
    public void perfrormAction(Player player) {
        player.GetOutJailFree();
    }
}

class MoveToBeachPromenade extends ChanceCard {
    public MoveToBeachPromenade(){
        super("Move to Beach Promenade");
    }

    @Override
    public void perfrormAction(Player player) {
        player.setCurrentLocation(new Location(BeachPromenade));
    }
}

class Birthday extends ChanceCard() {
    public Birthday(){
        super("its your birthday! recieve 1M");
    }

    @Override
    public void perfrormAction(Player player) {
        player.addCoins(1);
    }
}

class FreePinkOrDarkBlueTile extends ChanceCard {
    public FreePinkOrDarkBlueTile(){
        super("Advance to a Pink or Dark Blue tile, if available you get it for free, if already owned you have to pay rent");
    }

    @Override
    public void perfrormAction(Player player) {
        /*player.move() to any orange
        if(tile.isAvilable){
            tile.purchase;
        } else {
            player.payRent(2);
        }
    }
}

class HomeworkDone extends ChanceCard() {
    public HomeworkDone(){
        super("You finished all your homework! recieve 2M");
    }

    @Override
    public void perfrormAction(Player player) {
        player.addCoins(2);
    }
}

class FreeRedTile extends ChanceCard {
    public FreeRedTile(){
        super("Advance to a Red tile, if available you get it for free, if already owned you have to pay rent");
    }

    @Override
    public void perfrormAction(Player player) {
        //player.move() to any orange
        if(tile.isAvilable){
            tile.purchase;
        } else {
            player.payRent(2);
        }
    }
}

class FreeSkatepark extends ChanceCard {
    public FreeSkatepark(){
        super("Move to the skate park and hit the most gnarly grind, if available you get it for free! If already owned you have to pay rent");
    }

    @Override
    public void perfrormAction(Player player) {
        player.move() to any orange
        if(tile.isAvilable){
            tile.purchase;
        } else {
            player.payRent(2);
        }
    }
}

class FreeLightBlueOrRedTile extends ChanceCard {
    public FreeLightBlueOrRedTile(){
        super("Advance to a LightBlue or red tile, if available you get it for free, if already owned you have to pay rent");
    }

    @Override
    public void perfrormAction(Player player) {
        //player.move() to any orange
        if(tile.isAvilable){
            tile.purchase;
        } else {
            player.payRent(2);
        }
    }
}

class FreeBrownOrYellowTile extends ChanceCard {
    public FreeBrownOrYellowTile(){
        super("Advance to a brown or Yellow tile, if available you get it for free, if already owned you have to pay rent");
    }

    @Override
    public void perfrormAction(Player player) {
        //player.move() to any orange
        if(tile.isAvilable){
            tile.purchase;
        } else {
            player.payRent(2);
        }
    }
}*/