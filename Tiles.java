// Tiles.java
public class Tiles {
    private int position;
    private String name;
    static private Tiles[] tiles;
    private Player owner;
    private int price;

    public Tiles(int position, String name) {
        this.position = position;
        this.name = name;
        this.owner = null;
        this.price = price;
    }
    public int getPrice() {
        return price;
    }
    public void setOwner(Player player) {
        if (this.owner == null || this.owner != player){
            this.owner = player;
        }
    }
    public Player getOwner() {
        return owner;
    }
    public boolean isOwned() {
        return owner != null;
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
        tiles[1] = new PropertyField(1, "Bowlinghallen", 2, 3);
        tiles[2] = new PropertyField(2, "Zoo2", 2, 3);
        tiles[3] = new PropertyField(3, "EMPTY", 2, 3);//CHANGE THIS
        tiles[4] = new PropertyField(2, "Zoo3", 2, 3);
        tiles[5] = new PropertyField(5, "Zoo4", 2, 3);
        tiles[6] = new PropertyField(6, "EMPTY", 2, 3);//CHANGE THIS
        tiles[7] = new PropertyField(7, "Zoo5", 2, 3);
        tiles[8] = new PropertyField(8, "Zoo6", 2, 3);
        tiles[9] = new PropertyField(9, "EMPTY", 2, 3);//CHANGE THIS
        tiles[10] = new PropertyField(10, "Zoo7", 2, 3);
        tiles[11] = new PropertyField(11, "Zoo8", 2, 3);
        tiles[12] = new PropertyField(12, "EMPTY", 2, 3);//CHANGE THIS
        tiles[13] = new PropertyField(13, "Zoo9", 2, 3);
        tiles[14] = new PropertyField(14, "Zoo10", 2, 3);
        tiles[15] = new PropertyField(15, "EMPTY", 2, 3);//CHANGE THIS
        tiles[16] = new PropertyField(16, "Zoo11", 2, 3);
        tiles[17] = new PropertyField(17, "Zoo12", 2, 3);
        tiles[18] = new PropertyField(18, "EMPTY", 2, 3);//CHANGE THIS
        tiles[19] = new PropertyField(19, "Zoo13", 2, 3);
        tiles[20] = new PropertyField(20, "Zoo14", 2, 3);
        tiles[21] = new PropertyField(21, "EMPTY", 2, 3);//CHANGE THIS
        tiles[22] = new PropertyField(22, "Zoo15", 2, 3);
        tiles[23] = new PropertyField(23, "Zoo16", 2, 3);
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
        super(position,name);
        this.rent = rent;
        this.owner = null;
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
}

class StartField extends Tiles {
    private int money;
    public StartField(int position, String name, int money) {
        super(0, "START");
        this.money = 2;
    }
}

// ChanceCard.java
class ChanceCard {
    private String description;

    public ChanceCard(String description) {
        this.description = description;
    }

    // Getters...

    @Override
    public String toString() {
        return "ChanceCard{" +
                "description='" + description + '\'' +
                '}';
    }
}