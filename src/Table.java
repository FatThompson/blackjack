import java.util.ArrayList;

/**
 * Created by matthew on 3/29/17.
 */
public class Table {
  private static final int MAX_PLAYER_SIZE = 5;
  private int current_hand_count;
  private ArrayList<Player> players;
  private Deck deck;
  private Player dealer;

  public Table() {
    current_hand_count = 0;
    deck = new Deck();
    players = new ArrayList<Player>();
    //Add the dealer
    dealer = new Dealer(10000);
  }

  /**
   * add players/hands
   * @input defaulting to 100 be default
   */
  public void addPlayer() {
    addPlayer(1000);
  }

  /**
   * adds player with a bank
   * @param bank
   */
  public void addPlayer(int bank){
    addPlayer(bank,50);
  }

  /**
   * adds player with a bank and different bet
   * @param bank
   * @param defaultBet
   */
  public void addPlayer(int bank, int defaultBet){
    if(getPlayerCount()<5)
      players.add(new Player(bank,defaultBet));
    else System.out.println("You have too many people");
  }

  /**
   * removes a specific player
   * @param player
   */
  public void removePlayer(int player){

    players.remove(player);
  }

  /**
   *
   * @param player
   * @return
   */
  public Player player(int player){
    return players.get(player);
  }

  /**
   *
   * @return
   */
  public ArrayList<Player> players(){
    return players;
  }

  /**
   * get the number of players, minus dealer
   * @return number of players
   */
  public int getPlayerCount() {
    return players.size();
  }

  /**
   * shows dealers first card
   * @return
   */
  public Card dealerShownCard() {
    return dealer.card(0);
  }
  /**
   * get all of dealers cards
   * @return
   */
  public ArrayList<Card> dealerCards() {
    return dealer.cards();
  }

  public Player getDealer() {
    return dealer;
  }

  /**
   * get a card
   * @return
   */
  public Card drawCardfromDeck() {
    return deck.drawCard();
  }

  /**
   * deals dealer his first two cards
   */
  public void dealDealer() {
    dealer.addCardToHand(deck.drawCard());
    dealer.addCardToHand(deck.drawCard());
  }

  /**
   * deals cards to players
   * @return
   */
  public boolean dealCards() {
    if(deck.size()>((getPlayerCount()+1)*3)) {
      //Add the cards in
      for (int card = 0; card < 2; card++) {
        for (int player = getPlayerCount(); player > 0; player -= 0) {
          player--;
          player(player).addCardToHand(drawCardfromDeck());
        }
        dealDealer();
      }
    } else {
      deck.shuffleNewDeck();

      if (deck.size() > ((getPlayerCount() + 1) * 3)) dealCards();
      else {
        System.out.println("Too many players. can not continue with the round");
        return false;
      }
    }
    return true;
  }

  /**
   * deal all of dealers stuff
   */
  public void dealerHitCycle() {
    while(dealer.getTotalCardValue() <17){
      dealer.addCardToHand(drawCardfromDeck());
    }

  }
}
