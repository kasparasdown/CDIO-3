// Tiles.java
public class Tiles {
    private int position;
    private String name;
    static private Tiles[] tiles;
    Player owner;

    public Tiles(int position, String name) {
        this.position = position;
        this.name = name;
        this.owner = null;
    }
    public String getName() {
        return name;
    }
    public int getPos() {
        return position;
    }
    public void setPos(int pos){
        this.position=pos;
    }
    public void handleTileAction() {
        //empty, gonna override
    }
    public static void createTiles() {
        tiles = new Tiles[24];
        tiles[0] = new StartField(0,"Start");
        tiles[1] = new PropertyField(1, "Burger Joint 1", 2, 3, null);
        tiles[2] = new PropertyField(2, "Pizza House 2", 2, 3, null);
        tiles[3] = new ChanceField(3, "Chancefield");//CHANGE THIS
        tiles[4] = new PropertyField(4, "Candy Store 4", 2, 3, null);
        tiles[5] = new PropertyField(5, "Ice Cream Parlour 5", 2, 3, null);
        tiles[6] = new NoAction(6, "Jail visit 6");
        tiles[7] = new PropertyField(7, "Museum 7", 2, 3, null);
        tiles[8] = new PropertyField(8, "Library 8", 2, 3, null);
        tiles[9] = new ChanceField(9, "Chancefield");
        tiles[10] = new PropertyField(10, "Skate Park 10", 2, 3, null);
        tiles[11] = new PropertyField(11, "Swimming Pool 11", 2, 3, null);
        tiles[12] = new NoAction(12, "Free Parking 12");
        tiles[13] = new PropertyField(13, "Video Game Arcade 13", 2, 3, null);
        tiles[14] = new PropertyField(14, "Movie Theater 14", 2, 3, null);
        tiles[15] = new ChanceField(15, "Chancefield");
        tiles[16] = new PropertyField(16, "Toy Store 16", 2, 3, null);
        tiles[17] = new PropertyField(17, "Pet Store 17", 2, 3, null);
        tiles[18] = new NoAction(18, "Jail visit 18"); //Change to go to prison later
        tiles[19] = new PropertyField(19, "Bowling Alley 19", 2, 3, null);
        tiles[20] = new PropertyField(20, "The Zoo 20", 2, 3, null);
        tiles[21] = new ChanceField(21, "Chancefield");
        tiles[22] = new PropertyField(22, "Park Place 22", 2, 3, null);
        tiles[23] = new PropertyField(23, "Broadwalk 23", 2, 3, null);
    }
    public static Tiles[] getAllTiles() {
        return tiles;
    }
    public String toString() {
        return "Field: "+position+" "+name;
    }
    public Player getOwner() {
        return this.owner;
    }

    public void setOwner(Player player) {
        if (this.owner == null) {
        this.owner = player;
        } 
    }
    public boolean isOwned() {
        return this.owner != null;
    }
}

class PropertyField extends Tiles {
    private int rent;
    private int price;
    private Player owner;

    public PropertyField(int position, String name, int rent, int price, Player owner) {
        super(position, name);
        this.rent = rent;
        this.price = price;
        this.owner = owner;
    }
    //ownerCode for the property objects
    public Player getOwner() {
        return this.owner;
    }

    public void setOwner(Player player) {
        if (this.owner == null) {
        this.owner = player;
        } 
    }

    public int getRent() {
        return this.rent;
    }
    public int getPrice() {
        return this.price;
    }

    public void makeFree() {
        if(!this.isOwned()) {
            this.price = 0;
        }
    }

    public boolean isOwned() {
        return this.owner != null;
    }
    @Override
    public void handleTileAction(){
    
    }
    public String toString() {
        var str = "";
        if(!isOwned()) {
             str = super.toString() + " rent: " + rent;
        }
        else {
            str = "you paid "+getOwner()+" "+rent+"$";
        }
        return str;
    }
}
class ChanceField extends Tiles {
    public ChanceField(int position, String name) {
        super(position, name);
    }
}

class StartField extends Tiles {
    //private int money;
    public StartField(int position, String name) {
        super(0, "START");
    }
}
class GoPrison extends Tiles {
    public GoPrison(int position, String name) {
        super(position, name);
    }
    public static void setInPrison(Player player) {

    }
}
class NoAction extends Tiles { //free parking and visit jail
    //private int money;
    public NoAction(int position, String name) {
        super(position, name);
    }
}