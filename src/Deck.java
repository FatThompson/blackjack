import java.util.ArrayList;
import java.util.Collections;

public class Deck 
{
	public final String[] suites = {"hearts", "spades", "diamonds", "clubs"};
	ArrayList<Card> deck;
	public Deck()
	{
		shuffleNewDeck();
		
	}

	/**
	 * shuffles the deck
	 */
	public void shuffle()
	{
		Collections.shuffle(deck);
	}

	/**
	 * creates a new deck of 52 cards
	 */
	public void newDeck(){
		deck = new ArrayList<Card>();
		for(String suite: suites)
		{
			for(int value = 1; value < 14; value++)
			{

				deck.add(new Card(value, suite));
			}
		}
	}

	/**
	 * create new deck and shuffles
	 */
	public void shuffleNewDeck()
	{
		newDeck();
		shuffle();
	}

  /**
   * clones the values, but not the memory address
   *
   * @return
   */
	public Deck clone(){
	  Deck clone = new Deck();
	  clone.getDeck().clear();
	  for (int i =0 ; i < deck.size();i++){
	    clone.getDeck().add(deck.get(i));
    }

	  return clone;
  }
	/**
	 * returns entire deck
	 * @return
	 */
	public ArrayList<Card> getDeck()
	{
		return this.deck;
	}

  /**
   * returns the size of the deck
   * @return
   */
	public int size(){
		return getDeck().size();
	}

  /**
   * get a specific card object
   * @param index
   * @return
   */
	public Card getCard(int index)
	{
		return deck.get(index);
	}

	public Card drawCard() {
    if(getDeck().size() > 0) {
			Card tempcard = new Card(deck.get(0).getValue(),deck.get(0).getSuite());
			deck.remove(0);
			return tempcard;
		}
		return null;
	}

	private class CardNotFoundException extends Exception {
		public CardNotFoundException(){
			super();
			System.out.println("Card not found exception");

		}
	}
}
