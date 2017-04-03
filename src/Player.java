/**
 * Created by matthew on 3/29/17.
 */
public class Player {
  private Hand hand;
  private int bank;
  private double defaultBet;
  private double currentBet;
  private int totalCardValue;

  /**
   * set a default bet value
   * @param bank
   */
  public Player(int bank){
    hand = new Hand();
    setBank(bank);
    setDefaultBet(50);
    totalCardValue =0;
  }
  public Player(int bank,int defaultBet){
    hand= new Hand();
    setBank(bank);
    setDefaultBet(defaultBet);
    totalCardValue =0;
  };

  /** sets the bet */
  public void setBank(int bank) {
    this.bank = bank;
  }

  /**
   * the following deals with dealing with bet
   */
  public void removeBet(){bank-=defaultBet;}
  public void addBet(){bank+=defaultBet;}
  public void blackjack(){bank+=(defaultBet*1.5);}

  /**
   * setts the default bet
   * @param defaultBet
   */
  public void setDefaultBet(int defaultBet) {
    if(defaultBet>0) this.defaultBet = defaultBet;
  }


  public Hand getCardsInHand() {
    return hand;
  }

  public void addCardToHand(Card card) {
    hand.addCard(card);
    totalCardValue +=card.getValue();
  }

  public int getTotalCardValue(){return totalCardValue;}

}
