// Tiles.java
public class Tiles {
    private int position;
    private String name;

    public Tiles(int position, String name) {
        this.position = position;
        this.name = name;
    }
    public String toString() {
        return "pos: "+position+", name: "+name;
    }
}

class PropertyField extends Tiles {
    private int rent;
    private PropertyField[] prop;

    public PropertyField(int position, String name, int rent) {
        super(position,name);
        this.rent = rent;
    }
    public PropertyField[] getProperties(){
        prop[0] = new PropertyField(1, "Bowlinghallen", 4);
        prop[1] = new PropertyField(2, "Zoo2", 4);
        prop[2] = new PropertyField(4, "Zoo3", 4);
        prop[3] = new PropertyField(5, "Zoo4", 4);
        prop[4] = new PropertyField(7, "Zoo5", 4);
        prop[5] = new PropertyField(8, "Zoo6", 4);
        prop[6] = new PropertyField(10, "Zoo7", 4);
        prop[7] = new PropertyField(11, "Zoo8", 4);
        prop[8] = new PropertyField(13, "Zoo9", 4);
        prop[9] = new PropertyField(14, "Zoo10", 4);
        prop[10] = new PropertyField(16, "Zoo11", 4);
        prop[11] = new PropertyField(17, "Zoo12", 4);
        prop[12] = new PropertyField(19, "Zoo13", 4);
        prop[13] = new PropertyField(20, "Zoo14", 4);
        prop[14] = new PropertyField(22, "Zoo15", 4);
        prop[15] = new PropertyField(23, "Zoo16", 4);
        return prop;
    }
    public String toString() {
        return super.toString() + ", rent=" + rent;
    }
}
class ChanceField extends Tiles {
    public ChanceField(int position, String name) {
        super(position, name);
    }
}

class StartField extends Tiles {
    public StartField(int position, String name) {
        super(0, "START");
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

    public String toString() {
        for (Tiles s : tiles) {
            
        }
        return "";
    }
}
