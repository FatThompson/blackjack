import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by matthew on 3/15/17.
 */
public class Deck {
  public final String[] suites = {"hearts","spades","diamonds","clubs"};
  ArrayList<Card> deck;

  public Deck(){
    shuffleNewDeck();
  }

  /**
   * shuffles through collections
   */
  public void shuffle(){
    Collections.shuffle(deck);
  }

  /**
   * creates a new deck in order
   */
  public void newDeck(){
    this.deck = new ArrayList<Card>();

    for (String suite: suites) {
      for (int value=1;value<14;value++){
        this.deck.add(new Card(value,suite));
      }
    }
  }

  public void shuffleNewDeck(){
    newDeck();
    shuffle();
  }

  public ArrayList<Card> getDeck(){

    return deck;
  }

  public Card getCard(int index){
    return deck.get(index);
  }
}
