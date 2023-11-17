// Tiles.java
public class Tiles {
    private int position;
    private String name;
    static private Tiles[] tiles;

    public Tiles(int position, String name) {
        this.position = position;
        this.name = name;
    }
    public String getType() {
        return "Tile";
    }
    public String getName() {
        return name;
    }
    public int getPos() {
        return position;
    }
    public void setPos(int pos){
        position=pos;
    }
    public void handleTileAction() {
        //empty, gonna override
    }
    public static Tiles[] getAllTiles() {
        tiles = new Tiles[24];
        tiles[0] = new StartField(0,"Start", 2);
        tiles[1] = new PropertyField(1, "Bowlinghallen1", 2, 3);
        tiles[2] = new PropertyField(2, "Zoo2", 2, 3);
        tiles[3] = new ChanceField(3, "Chancefield");//CHANGE THIS
        tiles[4] = new PropertyField(4, "Zoo4", 2, 3);
        tiles[5] = new PropertyField(5, "Zoo5", 2, 3);
        tiles[6] = new PropertyField(6, "Zoo6", 2, 3);//CHANGE THIS
        tiles[7] = new PropertyField(7, "Zoo7", 2, 3);
        tiles[8] = new PropertyField(8, "Zoo8", 2, 3);
        tiles[9] = new ChanceField(9, "Chancefield");
        tiles[10] = new PropertyField(10, "Zoo10", 2, 3);
        tiles[11] = new PropertyField(11, "Zoo11", 2, 3);
        tiles[12] = new PropertyField(12, "Zoo12", 2, 3);//CHANGE THIS
        tiles[13] = new PropertyField(13, "Zoo13", 2, 3);
        tiles[14] = new PropertyField(14, "Zoo14", 2, 3);
        tiles[15] = new ChanceField(15, "Chancefield");
        tiles[16] = new PropertyField(16, "Zoo16", 2, 3);
        tiles[17] = new PropertyField(17, "Zoo17", 2, 3);
        tiles[18] = new PropertyField(18, "Zoo18", 2, 3);//CHANGE THIS
        tiles[19] = new PropertyField(19, "Zoo19", 2, 3);
        tiles[20] = new PropertyField(20, "Zoo20", 2, 3);
        tiles[21] = new ChanceField(21, "Chancefield");
        tiles[22] = new PropertyField(22, "Zoo22", 2, 3);
        tiles[23] = new PropertyField(23, "Zoo23", 2, 3);
        return tiles;
    }
    public String toString() {
        return "Field: "+position+" "+name;
    }
}

class PropertyField extends Tiles {
    private int rent;
    private int price;
    private Player owner;

    public PropertyField(int position, String name, int rent, int price) {
        super(position, name);
        this.rent = rent;
        this.owner = null;
        this.price = price;
    }
    //ownerCode for the property objects
    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player player) {
        if (this.owner == null || this.owner != player){
            this.owner = player;
        }
    }

    public int getRent() {
        return rent;
    }
    public int getPrice() {
        return price;
    }

    public void makeFree() {
        this.price = 0;
        
    }

    public boolean isOwned() {
        return owner != null;
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
    //call a random card, from the chancecard class
    public void handleTileAction() {
    }
}

class StartField extends Tiles {
    //private int money;
    public StartField(int position, String name, int money) {
        super(0, "START");
        //this.money = 2;
    }
}