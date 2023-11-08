import java.util.Random;

public class Die{
    
        static int n = 6;
        static Random rand = new Random();
    public static int dieRoll() {
        return rand.nextInt(n) + 1;
}
}

