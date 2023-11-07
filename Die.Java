import java.utils.Random;
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
            die = rand.nextInt(this.dieSize) + 1;
            System.out.println("Die 1: " + die);
            var dieResult = die;
            
            return dieResult;
        }
}

