import java.util.ArrayList;

/**
 * Created by matthew on 3/29/17.
 */
public class Player {
  private Hand hand;
  private int bank;
  private double defaultBet;
  private double currentBet;

  /**
   * set a default bet value
   * @param bank
   */
  public Player(int bank){
    hand = new Hand();
    setBank(bank);
    setDefaultBet(50);
  }
  public Player(int bank,int defaultBet){
    hand = new Hand();
    setBank(bank);
    setDefaultBet(defaultBet);
  };

  /**
   * sets the bet
   */
  public void setBank(int bank) {
    this.bank = bank;
  }
  /**
   * setts the default bet
   * @param defaultBet
   */
  public void setDefaultBet(int defaultBet) {
    if(defaultBet>0) this.defaultBet = defaultBet;
  }

  /**
   * add card to hand
   * @param card
   */
  public void addCardToHand(Card card) {
    hand.addCard(card);
  }
  /**
   * the following deals with dealing with bet
   */
  public void betRemoveFromBank(){
    bank-=defaultBet;
    currentBet=defaultBet;
  }

  /**
   * add the victory to bank
   */
  public void betAddToBank(){
    bank+=currentBet;
    currentBet=0;
  }

  /**
   * for blackjacks
   */
  public void blackjack(){
    currentBet*=1.5;
  }

  /**
   * returns hand
   * @return
   */
  public Hand hand(){
    return hand;
  }

  /**
   * get a single card from the hand
   * @param i
   * @return
   */
  public Card card(int i) {
    return hand.card(i);
  }
  /**
   * returns hards from hand
   * @return
   */
  public ArrayList<Card> cards() {
    return hand.cards();
  }

  /**
   * get card value from hand
   * @return
   */
  public int getTotalCardValue(){return hand.currentValue();}

  public void newHand(){this.hand = null; this.hand = new Hand();}
  /**
   *
   * @return
   */
  @Override
  public String toString(){

    return "Bank: "+bank+", Default Bet: " + defaultBet;
  }


}
