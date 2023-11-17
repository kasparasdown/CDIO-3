import java.util.Random;
public class ChanceCard {
    private String description;
    private Player player;
   

    Random rand = new Random();

    public ChanceCard(){
        //this.description = description;
        //this.player = player;
    }

    public String getName(){
        return description;
    }
    
   
    public String performCardAction(){
        int index = rand.nextInt(16)+1;
        switch(index){
            case 1:
                advanceToGo();
                return "Advance to Start";
            case 2:
                move5TilesForward();
                return "Move 5 tiles forward";
            case 3:
                moveToOrange();
                return "Move to Orange";
            case 4:
                moveOneTileForwardOrDrawAgain();
                return "Move 1 tile forward or draw again";
            case 5:
                toMuchCandy();
                return "To much candy";
            case 6:
                orangeOrGreen();
                return "Move to a orange or green tile";
            case 7:
                lightBlueTile();
                return "Move to a light blue tile";
            case 8:
                acquireGetOutOfJailFreeCard();
                return "Get out of jail free card";
            case 9:
                beachPromenade();
                return "Advance to Start";
            case 10:
                birthday();
                return "Birthday boy";
            case 11:
                pinkOrDarkBlue();
                return "Move to a pink or dark blue tile";
            case 12:
                homeworkDone();
                return "homework done";
            case 13:
                moveRed();
                return "Move to a red tile";
            case 14:
                skatePark();
                return "Move to skatepark";
            case 15:
                lightBlueOrRed();
                return "Move to a ligth blue or red tile";
            case 16:
                brownOrYellow();
                return "Move to a brown or yellow tile";
            default:
                System.out.println("unrecongized chance card " + description);
                return "Advance to Start";
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
        //Only move
        int steps = 1;
        int newPosition = (player.getLocation() + steps) % Tiles.getAllTiles().length;
            player.setLocation(newPosition);
    }

    private void moveToOrange(){
        Player player = Player.getCurrentPlayer();
            player.setLocation(10);
        Tiles currentTile = player.getTile();
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
        //We only moving to green tile
        Player player = Player.getCurrentPlayer();
            player.setLocation(19);
         Tiles currentTile = player.getTile();
        if (currentTile instanceof PropertyField){
            PropertyField propertyTile = (PropertyField) currentTile;
            if ( !propertyTile.isOwned()){
                propertyTile.makeFree();
            }
        }
    }

    private void lightBlueTile(){
        Player player = Player.getCurrentPlayer();
        // input statement in frame
            player.setLocation(4);

         Tiles currentTile = player.getTile();
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
        Player player = Player.getCurrentPlayer();
        player.setLocation(23);

         Tiles currentTile = player.getTile();
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
        //Only moving to pink
        Player player = Player.getCurrentPlayer();
            player.setLocation(7);

         Tiles currentTile = player.getTile();
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
        Player player = Player.getCurrentPlayer();
            player.setLocation(13);
         Tiles currentTile = player.getTile();
        if (currentTile instanceof PropertyField){
            PropertyField propertyTile = (PropertyField) currentTile;
            if ( !propertyTile.isOwned()){
                propertyTile.makeFree();
            }
        }
    }
    

    public void skatePark(){
        Player player = Player.getCurrentPlayer();

        player.setLocation(10);
         Tiles currentTile = player.getTile();
        if (currentTile instanceof PropertyField){
            PropertyField propertyTile = (PropertyField) currentTile;
            if ( !propertyTile.isOwned()){
                propertyTile.makeFree();
            }
        }
    }

    public void lightBlueOrRed(){
        //only lightBlue
        Player player = Player.getCurrentPlayer();
        player.setLocation(4);

        Tiles currentTile = player.getTile();
        if (currentTile instanceof PropertyField){
            PropertyField propertyTile = (PropertyField) currentTile;
            if ( !propertyTile.isOwned()){
                propertyTile.makeFree();
            }
        }
    }

    public void brownOrYellow(){
        //only brown
        Player player = Player.getCurrentPlayer();

            player.setLocation(1);
         Tiles currentTile = player.getTile();
        if (currentTile instanceof PropertyField){
            PropertyField propertyTile = (PropertyField) currentTile;
            if ( !propertyTile.isOwned()){
                propertyTile.makeFree();
            }
        }
    }

}