import java.util.Random;
public class ChanceCard {
    private String description;
    private Player player;
   

    Random random = new Random();

    public ChanceCard(String description, Player player){
        this.description = description;
        this.player = player;
    
    }

    public String getName(){
        return description;
    }
    
   
    public void performCardAction(){
        switch(description){
            case "Advance to Start":
                advanceToGo();
                break;
            case "Move 5 tiles forward":
                move5TilesForward();
                break;
            case "Move to Orange":
                moveToOrange();
                break;
            case "Move 1 tile forward or draw again":
                moveOneTileForwardOrDrawAgain();
                break;
            case "To much candy":
                toMuchCandy();
                break;
            case "Move to a orange or green tile":
                orangeOrGreen();
                break;
            case "Move to a light blue tile":
                lightBlueTile();
                break;
            case "Get out of jail free card":
                acquireGetOutOfJailFreeCard();
                break;
            case "Move to beachpromenade":
                beachPromenade();
                break;
            case "Birthday boy":
                birthday();
                break;
            case "Move to a pink or dark blue tile":
                pinkOrDarkBlue();
                break;
            case "homework done":
                homeworkDone();
                break;
            case "Move to a red tile":
                moveRed();
                break;
            case "Move to skatepark":
                skatePark();
                break;
            case "Move to a ligth blue or red tile":
                lightBlueOrRed();
                break;
            case "Move to a brown or yellow tile":
                brownOrYellow();
                break;
            default:
                System.out.println("unrecongized chance card " + description);
                break;
                }
    }
    
    private void advanceToGo(){
        player.setLocation(0);
    }

    private void move5TilesForward(){
        int steps = 5;
        int newPosition = (player.getLocation() + steps) % Tiles.getAllTiles().length;
        player.setLocation(newPosition);
    }

    private void moveOneTileForwardOrDrawAgain(){
        int steps = 1;
        int newPosition = (player.getLocation() + steps) % Tiles.getAllTiles().length;
        if (click.getSource() == move1Button){
            player.setLocation(newPosition);
        }// misses or draw again
    }

    private void moveToOrange(){
        Tiles[] tiles = Tiles.getAllTiles();
        Player player = Player.getCurrentPlayer();
        // make statement about player input.
        if(click.getSource() == poolButton){ // figure out how to implement player input with frame.
            player.setLocation(11);
        } else if (click.getSource() == skateparkButton) {
            player.setLocation(10);
        }

        Tiles currentTile = tiles[player.getLocation()];
        if (currentTile instanceof PropertyField){
            PropertyField propertyTile = (PropertyField) currentTile;
            if ( !propertyTile.isOwned()){
                propertyTile.makeFree();
            }
        }
    }

    private void toMuchCandy(){
        player.removeCoins(2);
    }

    private void orangeOrGreen(){
        Tiles[] tiles = Tiles.getAllTiles();
        Player player = Player.getCurrentPlayer();
        // statement about player input.
        if (player.input == "orange 1" ){
            player.setLocation(10);
        } else if(player.input == "oragne 2"){
            player.setLocation(11);
        } else if (player.input == "green 1"){
            player.setLocation(19);
        } else if (player.input == "green 2"){
            player.setLocation(20);
        }
         Tiles currentTile = tiles[player.getLocation()];
        if (currentTile instanceof PropertyField){
            PropertyField propertyTile = (PropertyField) currentTile;
            if ( !propertyTile.isOwned()){
                propertyTile.makeFree();
            }
        }
    }

    private void lightBlueTile(){
        Tiles[] tiles = Tiles.getAllTiles();
        Player player = Player.getCurrentPlayer();
        // input statement in frame
        if (player.input == "light blue 1"){
            player.setLocation(4);
        } else if (player.input == "light blue 2"){
            player.setLocation(5);
        }

         Tiles currentTile = tiles[player.getLocation()];
        if (currentTile instanceof PropertyField){
            PropertyField propertyTile = (PropertyField) currentTile;
            if ( !propertyTile.isOwned()){
                propertyTile.makeFree();
            }
        }
    }

    private void acquireGetOutOfJailFreeCard(){
        Player.getCurrentPlayer().acquireGetOutOfJailFreeCard();
    }

    private void beachPromenade(){
        Tiles[] tiles = Tiles.getAllTiles();
        Player player = Player.getCurrentPlayer();
        player.setLocation(23);

         Tiles currentTile = tiles[player.getLocation()];
        if (currentTile instanceof PropertyField){
            PropertyField propertyTile = (PropertyField) currentTile;
            if ( !propertyTile.isOwned()){
                propertyTile.makeFree();
            }
        }
    }

    private void birthday(){
        //text needed
        player.addCoins(1);
    }

    private void pinkOrDarkBlue(){
        Tiles[] tiles = Tiles.getAllTiles();
        Player player = Player.getCurrentPlayer();

        if (player.input == "pink 1" ){
            player.setLocation(7);
        } else if(player.input == "pink 2"){
            player.setLocation(8);
        } else if (player.input == "dark blue 1"){
            player.setLocation(22);
        } else if (player.input == "dark blue 2"){
            player.setLocation(23);
        }
         Tiles currentTile = tiles[player.getLocation()];
        if (currentTile instanceof PropertyField){
            PropertyField propertyTile = (PropertyField) currentTile;
            if ( !propertyTile.isOwned()){
                propertyTile.makeFree();
            }
        }
    }

    public void homeworkDone(){
        player.addCoins(2);
    }

    public void moveRed(){
        Tiles[] tiles = Tiles.getAllTiles();
        Player player = Player.getCurrentPlayer();

        if (player.input == "red 1"){
            player.setLocation(13);
        } else if (player.input == "red 2"){
            player.setLocation(14);    
        }
         Tiles currentTile = tiles[player.getLocation()];
        if (currentTile instanceof PropertyField){
            PropertyField propertyTile = (PropertyField) currentTile;
            if ( !propertyTile.isOwned()){
                propertyTile.makeFree();
            }
        }
    }
    

    public void skatePark(){
        Tiles[] tiles = Tiles.getAllTiles();
        Player player = Player.getCurrentPlayer();

        player.setLocation(10);
         Tiles currentTile = tiles[player.getLocation()];
        if (currentTile instanceof PropertyField){
            PropertyField propertyTile = (PropertyField) currentTile;
            if ( !propertyTile.isOwned()){
                propertyTile.makeFree();
            }
        }
    }

    public void lightBlueOrRed(){
        Tiles[] tiles = Tiles.getAllTiles();
        Player player = Player.getCurrentPlayer();

        if (player.input == "light blue 1" ){
            player.setLocation(4);
        } else if(player.input == "light blue 2"){
            player.setLocation(5);
        } else if (player.input == "red 1"){
            player.setLocation(13);
        } else if (player.input == "red 2"){
            player.setLocation(14);
        }
         Tiles currentTile = tiles[player.getLocation()];
        if (currentTile instanceof PropertyField){
            PropertyField propertyTile = (PropertyField) currentTile;
            if ( !propertyTile.isOwned()){
                propertyTile.makeFree();
            }
        }
    }

    public void brownOrYellow(){
        Tiles[] tiles = Tiles.getAllTiles();
        Player player = Player.getCurrentPlayer();

         if (player.input == "brown 1" ){
            player.setLocation(1);
        } else if(player.input == "brown 2"){
            player.setLocation(2);
        } else if (player.input == "yellow 1"){
            player.setLocation(16);
        } else if (player.input == "yellow 2"){
            player.setLocation(17);
        }
         Tiles currentTile = tiles[player.getLocation()];
        if (currentTile instanceof PropertyField){
            PropertyField propertyTile = (PropertyField) currentTile;
            if ( !propertyTile.isOwned()){
                propertyTile.makeFree();
            }
        }
    }

}