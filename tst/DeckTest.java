import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Created by matthew on 3/15/17.
 */
public class DeckTest {

  @Test
  public void newDeckTest() {
    Deck deck = new Deck();
    deck.newDeck();


    String[] suites = {"hearts", "spades", "diamonds", "clubs"};
    for (int j = 0; j < 4; j++) {
      String suite = suites[j];
      for (int value = 0; value < 13; value++) {

//        System.out.println(value+1 + "\t" + suite);
//        System.out.println(deck.getCard(value+ (13*j)).getCard());
        Assertions.assertEquals(suite,deck.getCard(value+ (13*j)).getSuite());
        Assertions.assertEquals(value+1,deck.getCard(value).getValue());
      }
    }
  }
}




