import java.util.ArrayList;

/**
 * Created by matthew on 3/29/17.
 */
public class Table {
  private static final int MAX_PLAYER_SIZE = 5;
  private int current_hand_count;
  private ArrayList<Hand> players;

  public Table() {
    current_hand_count = 0;
    players = new ArrayList<Hand>();
  }

  /**
   * add players/hands
   * defers to add hand for now
   */
  public void addPlayer() {addHand();}

  /**
   *
   */
  public void addHand(){
    players.add(new Hand());
  }
}
