import java.util.ArrayList;
import java.util.Scanner;

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
    dealer = new Player(10000,0);
  }

  /**
   * add players/hands
   * @input defaulting to 100 be default
   */
  public void addPlayer() {
    players.add(new Player(1000));
  }

  /**
   * adds player with a bank
   * @param bank
   */
  public void addPlayer(int bank){
    players.add(new Player(bank));
  }

  /**
   * adds player with a bank and different bet
   * @param bank
   * @param defaultBet
   */
  public void addPlayer(int bank, int defaultBet){
    players.add(new Player(bank,defaultBet));
  }

  /**
   * accually running through the round
   *
   */
   public void playround(){
     //Add the cards in
     for(int card =0 ; card<2; card++){
       for(int player=players.size(); player>0;player--) {
         players.get(player).addCardToHand(deck.drawCard());
       }
       dealer.addCardToHand(deck.drawCard());
     }




     Scanner kb = new Scanner(System.in);



     for(int player=players.size(); player>0;player--){
       //check for blackjack
       if(players.get(player).getTotalCardValue()==21) {
         players.get(player).blackjack();

       } else {
         System.out.println("Player " + player + ", would you like to hit?");
         String input = kb.next();

         while (input.equalsIgnoreCase("hit")) {
           players.get(player).addCardToHand(deck.drawCard());
           if (players.get(player).getTotalCardValue() > 21) {
             players.get(player).removeBet();
             input = "stay";
           }
           //Add the 5card + win here
         }
       }


     }
   }

  /**
   * get the number of players, minus dealer
   * @return number of players
   */
  public int getPlayerCount() {
    return players.size();
  }
}
