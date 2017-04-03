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




}