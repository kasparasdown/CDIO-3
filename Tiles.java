// Tiles.java
public class Tiles {
    private int position;
    private String name;

    public Tiles(int position, String name) {
        this.position = position;
        this.name = name;
    }

    // Getters and setters...

    public String toString() {
        return "Tiles{" +
                "position=" + position +
                ", name='" + name + '\'' +
                '}';
    }
}

class PropertyField extends Tiles {
    private int rent;

    public PropertyField(int position, String name, int rent) {
        super(position, name);
        this.rent = rent;
    }

    // Getters and setters...

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
        super(position, name);
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
        StringBuilder boardString = new StringBuilder("GameBoard:\n");
        for (Tiles field : tiles) {
            boardString.append(field.toString()).append("\n");
        }
        return boardString.toString();
    }
}
