// Tiles.java
public class Tiles {
    private int position;
    private String name;
    private Tiles[] tiles;

    public Tiles(int position, String name) {
        this.position = position;
        this.name = name;
    }
    public int getPos() {
        return position;
    }
    public void setPos(int pos){
        position=pos;
    }
    public Tiles[] getAllTiles() {
        tiles = new Tiles[24];
        tiles[0] = new StartField(0,"Start", 2);
        tiles[1] = new PropertyField(1, "Bowlinghallen", 4);
        tiles[2] = new PropertyField(2, "Zoo2", 4);
        tiles[4] = new PropertyField(4, "Zoo3", 4);
        tiles[5] = new PropertyField(5, "Zoo4", 4);
        tiles[7] = new PropertyField(7, "Zoo5", 4);
        tiles[8] = new PropertyField(8, "Zoo6", 4);
        tiles[10] = new PropertyField(10, "Zoo7", 4);
        tiles[11] = new PropertyField(11, "Zoo8", 4);
        tiles[13] = new PropertyField(13, "Zoo9", 4);
        tiles[14] = new PropertyField(14, "Zoo10", 4);
        tiles[16] = new PropertyField(16, "Zoo11", 4);
        tiles[17] = new PropertyField(17, "Zoo12", 4);
        tiles[19] = new PropertyField(19, "Zoo13", 4);
        tiles[20] = new PropertyField(20, "Zoo14", 4);
        tiles[22] = new PropertyField(22, "Zoo15", 4);
        tiles[23] = new PropertyField(23, "Zoo16", 4);
        return tiles;
    }
    public String toString() {
        return "Field: "+position+" "+name;
    }
}

class PropertyField extends Tiles {
    private int rent;

    public PropertyField(int position, String name, int rent) {
        super(position,name);
        this.rent = rent;
    }
    public String toString() {
        return super.toString() + "\n rent: " + rent;
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
class Board {
    private Tiles[] tiles;

    public Board(Tiles[] tiles) {
        this.tiles = tiles;
    }

    public Tiles[] getAllTiles() {
        tiles = new Tiles[15];
        tiles[0] = new StartField(0,"Start", 2);
        tiles[1] = new PropertyField(1, "Bowlinghallen", 4);
        tiles[2] = new PropertyField(2, "Zoo2", 4);
        tiles[4] = new PropertyField(4, "Zoo3", 4);
        tiles[5] = new PropertyField(5, "Zoo4", 4);
        tiles[7] = new PropertyField(7, "Zoo5", 4);
        tiles[8] = new PropertyField(8, "Zoo6", 4);
        tiles[10] = new PropertyField(10, "Zoo7", 4);
        tiles[11] = new PropertyField(11, "Zoo8", 4);
        tiles[13] = new PropertyField(13, "Zoo9", 4);
        tiles[14] = new PropertyField(14, "Zoo10", 4);
        tiles[16] = new PropertyField(16, "Zoo11", 4);
        tiles[17] = new PropertyField(17, "Zoo12", 4);
        tiles[19] = new PropertyField(19, "Zoo13", 4);
        tiles[20] = new PropertyField(20, "Zoo14", 4);
        tiles[22] = new PropertyField(22, "Zoo15", 4);
        tiles[23] = new PropertyField(23, "Zoo16", 4);
        return tiles;
    }
}
