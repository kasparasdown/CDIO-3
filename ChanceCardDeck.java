import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChanceCardDeck {
    private List<ChanceCard> cards;

    public ChanceCardDeck() {
        cards = new ArrayList<>();

        cards.add(new ChanceCard("Advance to a brown or Yellow tile, if available you get it for free, if already owned you have to pay rent")); 
        cards.add(new ChanceCard("Advance to a LightBlue or red tile, if available you get it for free, if already owned you have to pay rent")); 
        cards.add(new ChanceCard("Move to the skate park and hit the most gnarly grind, if available you get it for free! If already owned you have to pay rent"));
        cards.add(new ChanceCard("Advance to a Red tile, if available you get it for free, if already owned you have to pay rent"));
        cards.add(new ChanceCard("You finished all your homework! recieve 2M"));
        cards.add(new ChanceCard("Advance to a Pink or Dark Blue tile, if available you get it for free, if already owned you have to pay rent"));
        cards.add(new ChanceCard("its your birthday! recieve 1M"));
        cards.add(new ChanceCard("Move to Beach Promenade"));
        cards.add(new ChanceCard("Get out of Jail free card, keep this card til you need it"));
        cards.add(new ChanceCard("Advance to a LightBlue tile, if available you get it for free, if already owned you have to pay rent"));
        cards.add(new ChanceCard("Advance to a Orange or Green tile, if available you get it for free, if already owned you have to pay rent"));
        cards.add(new ChanceCard("you ate to much candy, pay 2M"));
        cards.add(new ChanceCard("Move back one tile, or take another card"));
        cards.add(new ChanceCard("Advance to a Orange tile, if available you get it for free, if already owned you have to pay rent"));
        cards.add(new ChanceCard("Move 5 tiles forward."));
        cards.add(new ChanceCard("Advance to start, recive 2M"));
       
        Collections.shuffle(cards);
    }
    public ChanceCard drawCard() {
        if(cards.isEmpty()) {
            Collections.shuffle(cards);
        }
        return cards.remove(0);
    }
    }


}