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
        tiles[0] = new StartField(0,"Start");
        tiles[1] = new PropertyField(1, "Bowlinghallen1", 2, 3, null);
        tiles[2] = new PropertyField(2, "Zoo2", 2, 3, null);
        tiles[3] = new ChanceField(3, "Chancefield");//CHANGE THIS
        tiles[4] = new PropertyField(4, "Zoo4", 2, 3, null);
        tiles[5] = new PropertyField(5, "Zoo5", 2, 3, null);
        tiles[6] = new PropertyField(6, "Zoo6", 2, 3, null);//CHANGE THIS
        tiles[7] = new PropertyField(7, "Zoo7", 2, 3, null);
        tiles[8] = new PropertyField(8, "Zoo8", 2, 3, null);
        tiles[9] = new ChanceField(9, "Chancefield");
        tiles[10] = new PropertyField(10, "Zoo10", 2, 3, null);
        tiles[11] = new PropertyField(11, "Zoo11", 2, 3, null);
        tiles[12] = new PropertyField(12, "Zoo12", 2, 3, null);//CHANGE THIS
        tiles[13] = new PropertyField(13, "Zoo13", 2, 3, null);
        tiles[14] = new PropertyField(14, "Zoo14", 2, 3, null);
        tiles[15] = new ChanceField(15, "Chancefield");
        tiles[16] = new PropertyField(16, "Zoo16", 2, 3, null);
        tiles[17] = new PropertyField(17, "Zoo17", 2, 3, null);
        tiles[18] = new PropertyField(18, "Zoo18", 2, 3, null);//CHANGE THIS
        tiles[19] = new PropertyField(19, "Zoo19", 2, 3, null);
        tiles[20] = new PropertyField(20, "Zoo20", 2, 3, null);
        tiles[21] = new ChanceField(21, "Chancefield");
        tiles[22] = new PropertyField(22, "Zoo22", 2, 3, null);
        tiles[23] = new PropertyField(23, "Zoo23", 2, 3, null);
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

    public PropertyField(int position, String name, int rent, int price, Player owner) {
        super(position, name);
        this.rent = rent;
        this.owner = null;
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
        else if (this.owner != player) {
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
        this.price = 0;
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