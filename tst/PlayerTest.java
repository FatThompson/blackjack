import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Created by matthew on 3/29/17.
 */
public class PlayerTest {


  /**
   * test adding a card to the hand.
   */
  @Test
  public void addCardToHand(){
    Player player = new Player(1000);
    Card card = new Card(1,"hearts");
    player.addCardToHand(card);
    int numcardsinhand = player.getCardsInHand().getCards().size();
    Assertions.assertEquals(true,card.getCard().equals(player.getCardsInHand().getCards().get(numcardsinhand-1).getCard()));
  }

  /**
   * checks the last value added
   */
  @Test
  public void addCardsToHand(){
    Player player = new Player(1000);
    player.addCardToHand(new Card(4,"spade"));
    Card card = new Card(1,"hearts");
    player.addCardToHand(card);
    int numcardsinhand = player.getCardsInHand().getCards().size();
    Assertions.assertEquals(true,card.getCard().equals(player.getCardsInHand().getCards().get(numcardsinhand-1).getCard()));
  }

  /**
   * getting total card value
   */
}
