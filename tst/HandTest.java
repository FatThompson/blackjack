import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Created by matthew on 3/29/17.
 */
public class HandTest {
 

  /**
   * check addCard method
   */
  @Test
  public void addCardTest(){
    Hand hand = new Hand();
    Card ace = new Card(1, "Spades");
    Card nonAce1 = new Card(9, "Spades");
    Card nonAce2 = new Card(8, "Heart");
    Card nonAce3 = new Card(7, "Diamonds");
    
    Assertions.assertEquals(0, hand.numberOfCards());
    hand.addCard(nonAce1);
    Assertions.assertEquals(1, hand.numberOfCards());
    hand.addCard(nonAce2);
    Assertions.assertEquals(2, hand.numberOfCards());
    hand.addCard(nonAce3);
    Assertions.assertEquals(3, hand.numberOfCards());
    
  }
  

  /**
   * check updateBustTest method
   */
  @Test
  public void updateBustTest(){
     Hand hand = new Hand();
     Card ace = new Card(1, "Spades");
     Card nonAce1 = new Card(9, "Spades");
     Card nonAce2 = new Card(8, "Heart");
     Card nonAce3 = new Card(7, "Diamonds");
     
     Assertions.assertEquals(false, hand.updateBust());
     
     hand.addCard(ace);
     Assertions.assertEquals(false, hand.updateBust());

     hand.addCard(nonAce1);
     Assertions.assertEquals(false, hand.updateBust());

     hand.addCard(nonAce2);
     Assertions.assertEquals(false, hand.updateBust());

     hand.addCard(nonAce3);
     Assertions.assertEquals(true, hand.updateBust());
     
  }

  /**
   * check numberOfCardsTest method
   */
  @Test
  public void numberOfCardsTest(){
    Hand hand = new Hand();
    Card ace = new Card(1, "Spades");
    Card nonAce = new Card(13, "Spades");

    Assertions.assertEquals(0, hand.numberOfCards());
    
    hand.addCard(ace);
    Assertions.assertEquals(1, hand.numberOfCards());
    
    hand.addCard(nonAce);
    Assertions.assertEquals(2, hand.numberOfCards());
  }

  /**
   * check cardsTest method
   */
  @Test
  public void cardsTest(){
    Hand hand = new Hand();
    Card ace = new Card(1, "Spades");
    Card nonAce = new Card(13, "Spades");
    
    hand.addCard(ace);
    hand.addCard(nonAce);
    
    ArrayList<Card> returnstatement = new ArrayList<Card>();
    returnstatement.add(nonAce);
    returnstatement.add(ace);
    
    Assertions.assertEquals(returnstatement, hand.cards());
    
  }
}



