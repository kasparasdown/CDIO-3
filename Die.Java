import java.util.Random;
public class Die{
    
    Random rand = new Random();
        int die = 0;
        int dieSize;
    
        public Die(int dieSize) {
            this.dieSize = dieSize; 
        }
        public int getDie() {
             return dieSize;
        }
        public int dieRoll() {
            return rand.nextInt(this.dieSize) + 1;
        }
}

