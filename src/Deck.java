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
	
	public void shuffle()
	{
		Collections.shuffle(deck);
		
	}
	
	public void newDeck()
	{
		deck = new ArrayList<Card>();
		for(int value = 1; value < 14; value++)
		{
			for(String suite: suites)
			{
				deck.add(new Card(value, suite));
			}
		}
	}
	
	public void shuffleNewDeck()
	{
		newDeck();
		shuffle();
	}
	public ArrayList<Card> getDeck()
	{
		return getDeck();
	}
	
	public Card getCard(int index)
	{
		return deck.get(index);
	}
}
