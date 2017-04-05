import java.util.Scanner;

/**
 * Created by matthew on 3/15/17.
 */
public class main {
  private static Table table;

  public static void main(String[] args){
    table = new Table();
    Scanner kb = new Scanner(System.in);
    boolean run = true;
    while (true) {
      System.out.println("What do you want to do? \n1: add player \n2: remove player \n3: play a round \n4: close table \n\n");
      String input = kb.next();

      if (input.equalsIgnoreCase("4")) {
        run = false;
        System.out.println("Good bye");
        System.exit(0);
      }
      else if (input.equalsIgnoreCase("3")) playround();
      else if (input.equalsIgnoreCase("2")) removePlayerMenu();
      else if (input.equalsIgnoreCase("1")) addPlayerMenu();
      else System.out.println("Invalid input. Please try again.\n\n");
    }
  }

  /**
   * accually running through the round
   *
   */
  private static void playround(){
    if(table.dealCards()) {
      //Process the hitting and not hiting
      Scanner kb = new Scanner(System.in);
      for (int player = table.players().size(); player > 0; player -= 0) {player--;

        displayCardsOnTable();

        //check for black jack
        if (table.player(player).getTotalCardValue() == 21) {
          System.out.println("You got blackjack!");
          table.player(player).blackjack();
        }
        //run through other studd
        else {

          System.out.println("\nPlayer " + player + ", would you like to hit?");
          String input = kb.next();
          while (input.equalsIgnoreCase("hit") || input.equalsIgnoreCase("yes")) {

            dealCardToPlayer(player);

            //check card
            if (table.player(player).hand().updateBust()) {
              table.player(player).betRemoveFromBank();
              input = "stay";
              System.out.println("Player " + player + " busted with " + table.player(player).getTotalCardValue());
            }

            //display cards on table
            displayCardsOnTable();

            // ask for update
            System.out.println("\nPlayer " + player + ", would you like to hit?");
            input = kb.next();
          }
        }
      }
      System.out.println("Caclulate Dealer hand here ");

      table.dealerHitCycle();
      System.out.println(table.getDealer().hand());

      for (int player = table.players().size(); player > 0; player -= 0) {player--;
        if(table.player(player).getTotalCardValue() > table.getDealer().getTotalCardValue()){
          System.out.println("Player "+player+" Wins! ");


        }
      }


    } else System.out.println("Too many players to play a round");
  }

  private static void dealCardToPlayer(int player) {
    Card drawnCard = table.drawCardfromDeck();
    System.out.println("you got a " + drawnCard.getCard());
    //add card
    table.player(player).addCardToHand(drawnCard);
  }

  /**
   * adding a new player
   */
  private static void addPlayerMenu() {
    Scanner kb = new Scanner(System.in);

    System.out.println("How much money does the user have? - no error checking ");
    int bank = kb.nextInt();

    System.out.println("What is the default? - no error checking ");
    int defaultBet = kb.nextInt();
    table.addPlayer(bank,defaultBet);
  }

  /**
   * outputs the cats on table
   */
  public static void displayCardsOnTable() {
    System.out.println("the current cards on table");
    for(int player=table.getPlayerCount(); player>0;player-=0) { player--;
      System.out.print( "\nPlayer " + (player) + ": " );
      System.out.println(table.player(player).hand());
    }
    System.out.println("dealer has: "+table.dealerShownCard());
  }
  /**
   * menu for selecting the player
   */
  public static void removePlayerMenu() {
    System.out.println("Who needs to be removed? - no eror checking");
    for(int player=table.players().size(); player>0;player-=0) { player--;
      System.out.println("Player "+player+ ": " +table.player(player).toString());
    }
    Scanner kb = new Scanner(System.in);
    int player = kb.nextInt();
    table.removePlayer(player--);
  }
}
