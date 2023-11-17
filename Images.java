import javax.swing.*;
import java.awt.*;
public class Images {
    static ImageIcon logo;

    private static ImageIcon chooseIcon(int logoNum) {
        try{ 
            switch (logoNum) {
                case 1:
                    logo = new ImageIcon("CDIO\\CDIO3\\CDIO-3\\Image\\burger.png");
                    return logo;
                case 2:
                    logo = new ImageIcon("CDIO\\CDIO3\\CDIO-3\\Image\\2.png");
                    return logo;
                case 3:
                    logo = new ImageIcon("CDIO\\CDIO3\\CDIO-3\\Image\\3.png");
                    return logo;
                case 4:
                    logo = new ImageIcon("CDIO\\CDIO3\\CDIO-3\\Image\\4.png");
                    return logo;
                case 5:
                    logo = new ImageIcon("CDIO\\CDIO3\\CDIO-3\\Image\\5.png");
                    return logo;
                default:
                    logo = new ImageIcon("CDIO\\CDIO3\\CDIO-3\\Image\\start.png");
                    return logo;
            }
        }
        catch(Exception e){
            System.out.println("something wrent wrong setting logo");
            return new ImageIcon("CDIO\\CDIO3\\CDIO-3\\Image\\start.png");
        }


    }

    public static ImageIcon getImageIcon(int number) {
    try {
        logo = chooseIcon(number);
        Image image = logo.getImage(); // transform it 
        Image newimg = image.getScaledInstance(200, 200,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        logo = new ImageIcon(newimg);
    }
    catch (Exception e) {
        System.out.println("something wrent wrong with logo");
    }
    
    return logo;
    }
}
