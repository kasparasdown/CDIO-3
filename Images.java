import javax.swing.*;
import java.awt.*;

public class Images {
    private static final String IMAGE_DIRECTORY = "Image/"; // Assuming images are stored in a directory named "Image"

    public static ImageIcon getImageIcon(int number) {
        try {
            String imagePath = getImagePath(number);
            ImageIcon logo = new ImageIcon(Images.class.getClassLoader().getResource(imagePath));
            Image image = logo.getImage(); // Transform it
            Image newimg = image.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH); // Scale it the smooth way
            return new ImageIcon(newimg);
        } catch (Exception e) {
            System.out.println("Something went wrong with logo with input"+ number+ "   :" + e.getMessage());
            return getDefaultImageIcon();
        }
    }
    public static ImageIcon getMap() {
        try {
            String imagePath = getImagePath(24);
            ImageIcon logo = new ImageIcon(Images.class.getClassLoader().getResource(imagePath));
            Image image = logo.getImage(); // Transform it
            Image newimg = image.getScaledInstance(165, 165, java.awt.Image.SCALE_SMOOTH); // Scale it the smooth way
            return new ImageIcon(newimg);
            } 
        catch (Exception e) {
            System.out.println("Something went wrong with MAP" + e.getMessage());
            return getDefaultImageIcon();
        }
    }

    private static String getImagePath(int logoNum) {
        switch (logoNum) {
            case 0:
                return IMAGE_DIRECTORY + "tStart.png";
            case 1:
                return IMAGE_DIRECTORY + "tBurgerJoint.png";
            case 2:
                return IMAGE_DIRECTORY + "tPizza.png";
            case 3:
                return IMAGE_DIRECTORY + "tChance.png";
            case 4:
                return IMAGE_DIRECTORY + "tCandyStore.png";
            case 5:
                return IMAGE_DIRECTORY + "tIceCreamParlour.png";
            case 6:
                return IMAGE_DIRECTORY + "tJail.png";
            case 7:
                return IMAGE_DIRECTORY + "tMuseum.png";
            case 8:
                return IMAGE_DIRECTORY + "tLibrary.png";
            case 9:
                return IMAGE_DIRECTORY + "tChance.png";
            case 10:
                return IMAGE_DIRECTORY + "tSkatePark.png";
            case 11:
                return IMAGE_DIRECTORY + "tSwimmingPool.png";
            case 12:
                return IMAGE_DIRECTORY + "tFreeParking.png";
            case 13:
                return IMAGE_DIRECTORY + "tMovieTheatre.png";
            case 14:
                return IMAGE_DIRECTORY + "tVideoGameArcade.png";
            case 15:
                return IMAGE_DIRECTORY + "tChance.png";
            case 16:
                return IMAGE_DIRECTORY + "tToyStore.png";
            case 17:
                return IMAGE_DIRECTORY + "tPetStore.png";
            case 18:
                return IMAGE_DIRECTORY + "tGoToJail.png";
            case 19:
                return IMAGE_DIRECTORY + "tBowlingAlley.png";
            case 20:
                return IMAGE_DIRECTORY + "tTheZoo.png";
            case 21:
                return IMAGE_DIRECTORY + "tChance.png";
            case 22:
                return IMAGE_DIRECTORY + "tParkPlace.png";
            case 23:
                return IMAGE_DIRECTORY + "tBoardWalk.png";
            //Board
            case 24:
                return IMAGE_DIRECTORY + "board.png";
            //Chancecards from here
            case 31:
                return IMAGE_DIRECTORY + "CmoveToStart.png";
            case 32:
                return IMAGE_DIRECTORY + "Cmove5TilesForward.png";
            case 33:
                return IMAGE_DIRECTORY + "CmoveToSwimmingPool.png";
            case 34:
                return IMAGE_DIRECTORY + "CmoveOneTileForwardOrDrawAgain.png";
            case 35:
                return IMAGE_DIRECTORY + "CtoMuchCandy.png";
            case 36:
                return IMAGE_DIRECTORY + "CbowlingAlley.png";
            case 37:
                return IMAGE_DIRECTORY + "ClightBlueOrRed.png";
            case 38:
                return IMAGE_DIRECTORY + "CacquireGetOutOfJailFreeCard.png";
            case 39:
                return IMAGE_DIRECTORY + "CBeachPromenade.png";
            case 40:
                return IMAGE_DIRECTORY + "CBirthday.png";
            case 41:
                return IMAGE_DIRECTORY + "CpinkOrDarkBlue.png";
            case 42:
                return IMAGE_DIRECTORY + "ChomeworkDone.png";
            case 43:
                return IMAGE_DIRECTORY + "CmoveRed.png";
            case 44:
                return IMAGE_DIRECTORY + "CskatePark.png";
            case 45:
                return IMAGE_DIRECTORY + "ClightBlueOrRed.png";
            case 46:
                return IMAGE_DIRECTORY + "CbrownOrYellow.png";
            default:
                return IMAGE_DIRECTORY + "tstart.png";
        }
    }

    private static ImageIcon getDefaultImageIcon() {
        return new ImageIcon(Images.class.getClassLoader().getResource(IMAGE_DIRECTORY + "Monopoly.jpg"));
    }
}
