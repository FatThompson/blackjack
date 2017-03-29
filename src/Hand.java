import java.util.ArrayList;

public class Hand

{
	private ArrayList<Card> hand;

	public Hand()
	{
		hand = new ArrayList<Card>();
	}

	public void addCard(Card c)
	{

		hand.add(c);
	}

	public void displayCardsinHand()
	{
		for (int card = 0; card < hand.size(); card++)
		{
			System.out.println(hand.get(card));
		}
	}

	public int getCardsinHand()
	{
		return hand.size();
	}

	public Card getCard(int position)
	{
		if(position >= 0 && position < hand.size())
			return (Card)hand.get(position);
		else
			return null;
	}
	
	public int getRankValue()
	{
		for(int j = 0; j <=11; j++)
		{
			
		}
		return 0;
	}

	public int getScore()
	{
		int value = 0;
		boolean ace = false;

		for (int i = 0; i < hand.size(); i++)
		{
			Card c;
			c = getCard(i);
//			value = value + c.getRankValue();
//
//			if(c.getRankValue() == 1)
			{
				ace = true;
			}
		}

		if(ace == true && value + 10 <= 21)
		{
			value = value + 10;
		}

		return value;   
	}
}