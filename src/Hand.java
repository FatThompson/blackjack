import java.util.ArrayList;

public class Hand

{
	private ArrayList<Card> cards;

	public Hand() {
		cards = new ArrayList<Card>();
	}

  /**
   * add a card to the hand
   * @param c
   */
	public void addCard(Card c)
	{
    cards.add(c);
	}

  /**
   * returns the amount of cards in the hand
   * @return
   */
	public int size() {
		return cards.size();
	}

	public ArrayList<Card> getCards(){
	  return cards;
  }


  /**
   * this should be handed by table
   * so the game can change eiser
   * @return
   */
//	public int getScore()
//	{
//		int value = 0;
//		boolean ace = false;
//
//		for (int i = 0; i < cards.size(); i++)
//		{
//			Card c;
//			c = getCard(i);
////			value = value + c.getRankValue();
////
////			if(c.getRankValue() == 1)
//			{
//				ace = true;
//			}
//		}
//
//		if(ace == true && value + 10 <= 21)
//		{
//			value = value + 10;
//		}
//
//		return value;
//	}
}