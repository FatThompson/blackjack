import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Created by matthew on 3/29/17.
 */
public class TableTest {
  @Test
  public void testAddPlayer(){
    Table table = new Table();

    table.addPlayer();
    Assertions.assertEquals(1,table.getPlayerCount());
  }

  @Test
  public void testRemovePlayer(){
    Table table = new Table();
    table.addPlayer();
    Assertions.assertEquals(1, table.getPlayerCount());
    table.removePlayer(0);
    Assertions.assertEquals(0, table.getPlayerCount());
  }

  /**
   * Volital Test Case
   */
  @Test
  public void testDealerHandReset(){
    Table table = new Table();
    //It is 27 because that is the max a dealer can have <17 => + 10 hit
    table.addPlayer();

    table.dealCards(); Assertions.assertEquals(true,27>table.getDealer().getTotalCardValue(),"Actual Hand Value: "+table.getDealer().getTotalCardValue());
    table.dealCards(); Assertions.assertEquals(true,27>table.getDealer().getTotalCardValue(),"Actual Hand Value: "+table.getDealer().getTotalCardValue());
    table.dealCards(); Assertions.assertEquals(true,27>table.getDealer().getTotalCardValue(),"Actual Hand Value: "+table.getDealer().getTotalCardValue());
    table.dealCards(); Assertions.assertEquals(true,27>table.getDealer().getTotalCardValue(),"Actual Hand Value: "+table.getDealer().getTotalCardValue());
    table.dealCards(); Assertions.assertEquals(true,27>table.getDealer().getTotalCardValue(),"Actual Hand Value: "+table.getDealer().getTotalCardValue());

  }
}
