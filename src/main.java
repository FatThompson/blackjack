import java.util.Scanner;

/**
 * Created by matthew on 3/15/17.
 */
public class main {
  public static void main(String[] args){
    Table table = new Table();
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
      else if (input.equalsIgnoreCase("3")) table.playround();
      else if (input.equalsIgnoreCase("2")) table.removePlayerMenu();
      else if (input.equalsIgnoreCase("1")){
        System.out.println("Currently not implemented.");
        //table.addPlayerMenu();
      }
      else System.out.println("Invalid input. Please try again.\n\n");
    }


  }

}
