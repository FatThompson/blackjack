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
    hand= new Hand();
    setBank(bank);
    setDefaultBet(defaultBet);

  };

  public void setBank(int bank) {
    this.bank = bank;
  }
  public void setDefaultBet(int defaultBet) {
    this.defaultBet = defaultBet;
  }


  public Hand getCardsInHand() {
    return hand;
  }

  public void addCardToHand(Card card) {
    hand.addCard(card);
  }


}
