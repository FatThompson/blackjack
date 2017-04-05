import java.util.ArrayList;

public class Hand

{
  private ArrayList<Card> nonAceCards;
  private ArrayList<Card> aceCards;
  private int totalValue;
  private boolean bustedHand;


  public Hand() {
    nonAceCards = new ArrayList<Card>();
    aceCards = new ArrayList<Card>();
    totalValue=0;
    bustedHand=false;
  }

  /**
   * add a card to the hand
   * @param card
   */
  public void addCard(Card card)
  {
    //add an ace
    if(card.getValue()==1 || card.getValue()==11){
      totalValue++;
      if(!(checkbust(10+totalValue))) {
        totalValue+=10;
        card.setValue(14);
      }
      aceCards.add(card);
    }
    //add a non ace
    else{
      nonAceCards.add(card);
      totalValue+=card.value;			
    }
    //update the busting
    updateBust();
  }

  /**
   * updates the current isbustValue
   * @return
   */
  public boolean updateBust(){
    //if bust and there are aces
    if(checkbust(totalValue) && aceCards.size()>0){
      for (Card card : aceCards) {
        //iterate and find any high aces
        if(!checkbust(totalValue-10) && card.getValue()==14 ){
          card.setValue(1);
          totalValue-=10;
        }
      }
    }
    //return the result
    return checkbust(totalValue);
  }
  
  /**
   * Checks value is greater than 21;
   * @param value
   * @return
   */
  protected boolean checkbust(int value){
    //value based on blackjack rules
    return value>21;    
  }

  public int currentValue(){
    updateBust();
    return totalValue;
  }
  
  /**
   * returns the amount of cards in the hand
   * @return
   */
  public int numberOfCards() {
    return nonAceCards.size()+aceCards.size();
  }

  /**
   * get a single card
   * @param i
   * @return
   */
  public Card card(int i) {
    return cards().get(i);
  }
  /**
   * returns an ArrayList of cards in the current hand
   * @return
   */
  public ArrayList<Card> cards(){
    ArrayList<Card> cards = new ArrayList<Card>();
    
    for (Card nonace : nonAceCards) {
      cards.add((Card) nonace);
    }for (Card ace : aceCards) {
      cards.add((Card) ace);
    }
    return cards;
  }
  
  @Override
  public String toString(){
    String hand = "Hand Value: " + totalValue + "\t Cards: ";
    for (Card card : cards()) {
      hand+=card.toString()+", ";
    }
    
    return hand;    
  }


}









