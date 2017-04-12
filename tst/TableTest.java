import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * Created by matthew on 3/29/17.
 */
public class TableTest {
  Table table;

  @BeforeEach
  public void preparestuff(){
    table = new Table();

    table.addPlayer();
    table.dealCards();
  }

  /**
   * test adding a plpayer
   */
  @Test
  public void testAddPlayer(){
    //need to reset the table
    table = new Table();
    table.addPlayer();

    Assertions.assertEquals(1,table.getPlayerCount());
    table.addPlayer(1000);
    Assertions.assertEquals(2,table.getPlayerCount());
    table.addPlayer(1000,40);
    Assertions.assertEquals(3,table.getPlayerCount());

  }

  /**
   * test the initial set up
   */
  @Test
  public void testDealCards(){
    //need to reset the table
    table = new Table();
    table.addPlayer();



    Assertions.assertEquals(new ArrayList<Card>(), table.player(0).cards());
    Assertions.assertEquals(new ArrayList<Card>().size(), table.player(0).cards().size());

    Assertions.assertEquals(new ArrayList<Card>(), table.getDealer().cards());
    Assertions.assertEquals(new ArrayList<Card>().size(), table.getDealer().cards().size());


    table.dealCards();
    Assertions.assertEquals(2, table.getDealer().cards().size());
    Assertions.assertEquals(2, table.player(0).cards().size());



  }

  /**
   * test removing a player
   */
  @Test
  public void testRemovePlayer(){

    Assertions.assertEquals(1, table.getPlayerCount());
    table.removePlayer(0);
    Assertions.assertEquals(0, table.getPlayerCount());
  }

  /**
   * Volital Test Case
   */
  @Test
  public void testDealerHandReset(){

    //It is 27 because that is the max a dealer can have <17 => + 10 hit


    Assertions.assertEquals(true,27>table.getDealer().getTotalCardValue(),"Actual Hand Value: "+table.getDealer().getTotalCardValue());
    table.dealCards();
    Assertions.assertEquals(true,27>table.getDealer().getTotalCardValue(),"Actual Hand Value: "+table.getDealer().getTotalCardValue());
    table.dealCards();
    Assertions.assertEquals(true,27>table.getDealer().getTotalCardValue(),"Actual Hand Value: "+table.getDealer().getTotalCardValue());
    table.dealCards();
    Assertions.assertEquals(true,27>table.getDealer().getTotalCardValue(),"Actual Hand Value: "+table.getDealer().getTotalCardValue());
    table.dealCards();
    Assertions.assertEquals(true,27>table.getDealer().getTotalCardValue(),"Actual Hand Value: "+table.getDealer().getTotalCardValue());

  }


  /**
   *  get the first card in dealers hand
   */
  @Test
  public void testDealerShowCard(){
    Assertions.assertEquals(table.getDealer().card(0).toString(),table.dealerShownCard().toString());
  }
  /**
   * get a single player
   */
  @Test
  public void testPlayer(){
    //we need to reset the table for this
    table = new Table();
    table.addPlayer();
    table.addPlayer();
    table.addPlayer(654321,123456);


    Assertions.assertEquals(new Player(654321,123456).toString(),table.player(2).toString());

  }

}
