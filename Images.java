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
            System.out.println("Something went wrong with logo: " + e.getMessage());
            return getDefaultImageIcon();
        }
    }

    private static String getImagePath(int logoNum) {
        switch (logoNum) {
            case 1:
                return IMAGE_DIRECTORY + "burger.png";
            case 2:
                return IMAGE_DIRECTORY + "2.png";
            case 3:
                return IMAGE_DIRECTORY + "3.png";
            case 4:
                return IMAGE_DIRECTORY + "4.png";
            case 5:
                return IMAGE_DIRECTORY + "5.png";
            default:
                return IMAGE_DIRECTORY + "start.png";
        }
    }

    private static ImageIcon getDefaultImageIcon() {
        return new ImageIcon(Images.class.getClassLoader().getResource(IMAGE_DIRECTORY + "start.png"));
    }
}
