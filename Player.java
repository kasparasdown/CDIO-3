public class Player {
    String name;
    int coin;
    private int location;
    private Tiles tile;

    public Player(String name) {
        this.name = name;
        switch(GameUtils.playerNumbers) {
            case 2:
                this.coin = 20;
                break;
            case 3:
                this.coin = 18;
                break;
            case 4:
                this.coin = 16;
                break;
        }
        this.location = 0;
        this.tile = new Tiles(0, "Start"); // Initialize the tile variable with the starting tile
    }

    public String getName() {
        return name;
    }

    public int getCoin() {
        return coin;
    }
    public int getLocation() {
        return location;
    }
    public void setlocation(int pos) {
        this.location = pos;
    }

    public void addCoins(int value) {
        coin += value;
    }
    public Tiles getCurrentTile(Tiles[] tiles) {
        return tiles[location];
    }
    public Tiles getTile() {
        return tile;
    }

    public String getCurrentTileString() {
        Tiles[] allTiles = tile.getAllTiles();
        Tiles currentTile = getCurrentTile(allTiles);
        return currentTile.toString();
    }

    public void payRent(int rent) {
        // gonna pay rent
    }
    public void buyProperty() {
        Tiles currentTile = getCurrentTile(tile.getAllTiles());

        if (currentTile instanceof PropertyField) {
            PropertyField property = (PropertyField) currentTile;

            if (!property.isOwned()) {
                if (coin >= property.getRent()) {
                    property.setOwner(this);
                    coin -= property.getRent();
                    System.out.println(name + " bought " + property.getName());
                    //Frame.locationLabelText(name + " bought " + property.getName());
                } else {
                    System.out.println(name + " does not have enough coins to buy " + property.getName());
                    //Frame.locationLabelText(name + " does not have enough coins to buy " + property.getName());
                }
            } else {
                System.out.println(property.getName() + " is already owned by " + property.getOwner().getName());
                //Frame.locationLabelText(property.getName() + " is already owned by " + property.getOwner().getName());
            }
        } 
    }

}
