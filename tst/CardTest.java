/**
 * Created by matthew on 3/15/17.
 */

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;

public class CardTest  {
  public final String[] suites = {"hearts","spades","diamonds","clubs"};
  private ArrayList<Card> deck;

  public CardTest(){
    this.deck = new ArrayList<Card>();

    for (String suite: suites) {
      for (int value=1;value<14;value++){
        this.deck.add(new Card(value,suite));
      }
    }
  }

  @Test
  public void getValueTest(){
    Card card = new Card(1,"hearts");

    Assertions.assertEquals(1,card.getValue());

    for (int value=0;value<13;value++)
      Assertions.assertEquals(value+1, deck.get(value).getValue());
  }

}
