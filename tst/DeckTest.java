import org.junit.Assert;
import org.junit.Test;

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
        Assert.assertEquals(suite,deck.getCard(value+ (13*j)).getSuite());
        Assert.assertEquals(value+1,deck.getCard(value).getValue());
      }
    }
  }
}




