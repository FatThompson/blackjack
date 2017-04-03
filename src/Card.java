/**
 * Created by matthew on 3/15/17.
 */
public class Card {
  public final String[] suites = {"hearts","spades","diamonds","clubs"};
  public String suite;
  public int value;

  public Card(int value, String suite){
    setValue(value);
    setSuite(suite);
  }

  public void setValue(int value) {
    if(value < 14 && value > 0)
      this.value = value;
  }
  public void setSuite(String suite) {
    for (String s: suites) {
      if(suite.equals(s))
        this.suite = suite;
    }
  }
  public int getValue() {
    if (value <= 10)return value;

    else return 10;
  }
  public String getSuite() {
    return suite;
  }
  public String getCard(){

    return getValue() + "\t" + getSuite();
  }
}
