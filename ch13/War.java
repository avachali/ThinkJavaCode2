import java.util.ArrayList;

/**
 * Simulates a simple card game.
 */
public class War {

    public static void main(String[] args) {

        // create and shuffle the deck
        Deck deck = new Deck();
        System.out.println(deck.toString());

        deck.shuffle();

        System.out.println(deck.toString());

        // divide the deck into piles
        Pile p1 = new Pile();
        p1.addDeck(deck.subdeck(0, 25));
        Pile p2 = new Pile();
        p2.addDeck(deck.subdeck(26, 51));

        ArrayList<Card> warList = new ArrayList<>();

        // while both piles are not empty
        while (!p1.isEmpty() && !p2.isEmpty()) {
            Card c1 = p1.popCard();
            Card c2 = p2.popCard();

            System.out.println("C1: "+ c1.toString());
            System.out.println("C2: "+ c2.toString());


            // compare the cards
            int diff = c1.getRank() - c2.getRank();
            if (diff > 0) {
                p1.addCard(c1);
                p1.addCard(c2);
                if (warList.size() > 0) {
                    for (Card card : warList) {
                        p1.addCard(card);
                        
                        
                    }
                    warList.clear();
                }
            } else if (diff < 0) {
                p2.addCard(c1);
                p2.addCard(c2);
                if (warList.size() > 0) {
                    for (Card card : warList) {
                        p1.addCard(card);
                        
                        
                    }
                    warList.clear();
                }
            } else {
                // it's a tie...draw four more cards
                System.out.println("WAR");
                if(p1.size() < 4 || p2.size() <4) {
                    System.out.println("Game ended! No winner");
                    break;
                }
                warList.add(c1);
                warList.add(c2);
                for (int i = 0; i < 3; i++) {
                    warList.add(p1.popCard());
                    
                    warList.add(p2.popCard());
                    
                }

            }
            System.out.println("size of p1: "+p1.size());
            System.out.println("size of p2: "+p2.size());
        }

        // display the winner
        if (p2.isEmpty()) {
            System.out.println("Player 1 wins!");
        } else {
            System.out.println("Player 2 wins!");
        }
    }

}
