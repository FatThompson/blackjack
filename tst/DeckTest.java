import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Created by matthew on 3/15/17.
 */
public class DeckTest {

  /**
   * creates a new deck and checks for it in the default order
   */
  @Test
  public void newDeckTest() {
    Deck deck = new Deck();
    deck.newDeck();
    Assertions.assertEquals(52,deck.size());

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

  /**
   * shuffles the deck
   */
  @Test
  public void shuffleTest(){
    Deck deck = new Deck();
    Deck deckCompare = deck.clone();

    deck.shuffle();
    Assertions.assertEquals(deckCompare.size(),deck.size());
    int totalsame=0;
    for(int i=0;i<deck.size();i++){
      if(deckCompare.getCard(i).getCard().equals(deck.getCard(i)))totalsame++;
    }

    Assertions.assertNotEquals(totalsame,deck.size());
  }

  /**
   * shuffles a new deck
   */
  @Test
  public void shuffleNewDeckTest(){
    Deck deck = new Deck();
    Deck deckCompare = deck.clone();
    deck.shuffleNewDeck();

    int totalsame=0;
    for(int i=0;i<deck.size();i++){
      if(deckCompare.getCard(i).getCard().equals(deck.getCard(i)))totalsame++;
    }

    Assertions.assertNotEquals(totalsame,deck.size());
  }

  /**
   * test the cloning of the deck.
   */
  @Test
  public void cloneTest(){
    Deck deck = new Deck();
    Deck deckCompare = deck.clone();
    int totalsame=0;
    for(int i=0;i<deck.size();i++){
      if(deckCompare.getCard(i).getCard().equals(deck.getCard(i).getCard())) totalsame++;
    }

    Assertions.assertEquals(totalsame,deck.size());
  }


}




