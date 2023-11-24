import java.util.Random;
public class ChanceCard {
    private String description;
   

    Random rand = new Random();
    int index;

    public String getName(){
        return description;
    }
    
   
    public String performCardAction(){
        index = rand.nextInt(16)+1; //random select of action
        switch(index){
            case 1:
                advanceToGo();
                return "Advance to Start";
            case 2:
                move5TilesForward();
                return "Move 5 tiles forward";
            case 3:
                moveToSwimmingPool();
                return "Move to Swimming Pool";
            case 4:
                moveOneTileForwardOrDrawAgain();
                return "Move 1 tile forward";
            case 5:
                toMuchCandy();
                return "To much candy -2";
            case 6:
                bowlingAlley();
                return "Move to the Bowling Alley";
            case 7:
                lightBlueTile();
                return "Move to the Candy Store";
            case 8:
                acquireGetOutOfJailFreeCard();
                return "Get out of jail free card";
            case 9:
                beachPromenade();
                return "Move to the Beachpromenade";
            case 10:
                birthday();
                return "Birthday boy +1";
            case 11:
                pinkOrDarkBlue();
                return "Move to Library";
            case 12:
                homeworkDone();
                return "homework done +2";
            case 13:
                moveRed();
                return "Move to a red tile";
            case 14:
                skatePark();
                return "Move to skatepark";
            case 15:
                lightBlueOrRed();
                return "Move to a light blue tile";
            case 16:
                brownOrYellow();
                return "Move to a brown";
            default:
                System.out.println("unrecongized chance card " + description);
                return "Advance to Start";
                }
    }
    public int getIndex() {
        return index;
    }
    //following methods do specific tasks related to the drawn card
    private void advanceToGo(){
        Player.getCurrentPlayer().setLocation(0);
        GameUtils.changeLogo(0);
    }

    private void move5TilesForward(){
        int steps = 5;
        var player = Player.getCurrentPlayer();
        int newPosition = (player.getLocation() + steps) % Tiles.getAllTiles().length;
        player.setLocation(newPosition);
        GameUtils.changeLogo(player.getLocation());
    }

    private void moveOneTileForwardOrDrawAgain(){
        //Only move
        int steps = 1;
        var player = Player.getCurrentPlayer();
        int newPosition = (player.getLocation() + steps) % Tiles.getAllTiles().length;
            player.setLocation(newPosition);
            GameUtils.changeLogo(newPosition);
    }

    private void moveToSwimmingPool(){
        Player player = Player.getCurrentPlayer();
            player.setLocation(11);
            GameUtils.changeLogo(player.getLocation());
        Tiles currentTile = player.getTile();
        if (currentTile instanceof PropertyField){
            PropertyField propertyTile = (PropertyField) currentTile;
            if ( !propertyTile.isOwned()){
                propertyTile.makeFree();
            }
        }
    }

    private void toMuchCandy(){
        var player = Player.getCurrentPlayer();
        player.removeCoins(2);
    }

    private void bowlingAlley(){
        //We only moving to green tile
        Player player = Player.getCurrentPlayer();
            player.setLocation(19);
            GameUtils.changeLogo(player.getLocation());
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
            GameUtils.changeLogo(player.getLocation());

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
        GameUtils.changeLogo(player.getLocation());

         Tiles currentTile = player.getTile();
        if (currentTile instanceof PropertyField){
            PropertyField propertyTile = (PropertyField) currentTile;
            if ( !propertyTile.isOwned()){
                propertyTile.makeFree();
            }
        }
    }

    private void birthday(){
        Player.getCurrentPlayer().addCoins(1);
    }

    private void pinkOrDarkBlue(){
        //Only moving to pink
        Player player = Player.getCurrentPlayer();
            player.setLocation(8);
            GameUtils.changeLogo(player.getLocation());

         Tiles currentTile = player.getTile();
        if (currentTile instanceof PropertyField){
            PropertyField propertyTile = (PropertyField) currentTile;
            if ( !propertyTile.isOwned()){
                propertyTile.makeFree();
            }
        }
    }

    public void homeworkDone(){
        var player = Player.getCurrentPlayer();
        player.addCoins(2);
    }

    public void moveRed(){
        Player player = Player.getCurrentPlayer();
            player.setLocation(13);
            GameUtils.changeLogo(player.getLocation());
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
        GameUtils.changeLogo(player.getLocation());
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
        GameUtils.changeLogo(player.getLocation());

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
            GameUtils.changeLogo(player.getLocation());
         Tiles currentTile = player.getTile();
        if (currentTile instanceof PropertyField){
            PropertyField propertyTile = (PropertyField) currentTile;
            if ( !propertyTile.isOwned()){
                propertyTile.makeFree();
            }
        }
    }

}