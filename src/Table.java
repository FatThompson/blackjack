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

  public Table() {
    current_hand_count = 0;
    deck = new Deck();
    players = new ArrayList<Player>();
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
     Scanner kb = new Scanner(System.in);
     for(int i=0; i<players.size();i++){
       String input = kb.next();
     }
   }
}
