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
   * the main config method
   */
  public void start() {

  }

  /**
   * adding a new player
   */
  private void addPlayerMenu() {
    Scanner kb = new Scanner(System.in);

    System.out.println("How much money does the user have? - no error checking ");
    int bank = kb.nextInt();

    System.out.println("What is the default? - no error checking ");
    int defaultBet = kb.nextInt();
    addPlayer(bank,defaultBet);
  }

  /**
   * menu for selecting the player
   */
  public void removePlayerMenu() {
    System.out.println("Who needs to be removed? - no eror checking");
    for(int player=players.size(); player>0;player-=0) { player--;
      System.out.println("Player "+player+ ": " +players.get(player).toString());
    }
    Scanner kb = new Scanner(System.in);
    int player = kb.nextInt();
    removePlayer(player--);
  }

  /**
   * removes a specific player
   * @param player
   */
  public void removePlayer(int player){

    players.remove(player);
  }
  /**
   * accually running through the round
   *
   */
   public void playround(){
     //Add the cards in
     for(int card =0 ; card<2; card++){
       for(int player=players.size(); player>0;player-=0) { player--;
         players.get(player).addCardToHand(deck.drawCard());
       }
       dealer.addCardToHand(deck.drawCard());
     }


     //Process the hitting and not hiting
     Scanner kb = new Scanner(System.in);
     for(int player=players.size(); player>0;player-=0){ player--;
       //check for blackjack

       displayCardsOnTable();
       if(players.get(player).getTotalCardValue()==21) {
         System.out.println("You got blackjack!");
         players.get(player).blackjack();


       } else {
         System.out.println("\nPlayer " + player + ", would you like to hit?");
         String input = kb.next();
         while (input.equalsIgnoreCase("hit")) {


           Card drawnCard = deck.drawCard();
           System.out.println("you got a " + drawnCard.getCard());
           //add card
           players.get(player).addCardToHand(drawnCard);

           //check card
           if (players.get(player).getTotalCardValue() > 21) {
             players.get(player).removeBet();
             input = "stay";
             System.out.println("Player "+player+" busted with " + players.get(player).getTotalCardValue());
           }
           //Add the 5card + win here
           //display cards on table
           displayCardsOnTable();
           System.out.println("\nPlayer " + player + ", would you like to hit?");
           input = kb.next();
         }
       }


     }
   }

private void displayCardsOnTable() {
    System.out.println("the current cards on table");
    for(int player=players.size(); player>0;player-=0) { player--;
      System.out.print( "\nPlayer " + (player) + ": " );
      ArrayList<Card> cards=players.get(player).cards();
        for (Card card:cards) {
          System.out.print(card.getCard()+", ");
        }


    }
    System.out.println("dealer has: "+dealer.cards().get(0));
  }

  /**
   * get the number of players, minus dealer
   * @return number of players
   */
  public int getPlayerCount() {
    return players.size();
  }


}
