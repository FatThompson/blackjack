import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Created by matthew on 3/29/17.
 */
public class PlayerTest {
  @Test
  public void PlayerTest(){

    Assertions.assertEquals(1,1);
  }

  @Test
  public void addCardToHand(){
    Player player = new Player(1000);
    Card card = new Card(1,"hearts");
    player.addCardToHand(card);
    Assertions.assertEquals(true,card.getCard().equals(player.getCardsInHand().getCards()));
  }
}
