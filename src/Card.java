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
    if(value < 15 && value > 0)
      this.value = value;
  }
  public void setSuite(String suite) {
    for (String s: suites) {
      if(suite.equalsIgnoreCase(s))
        this.suite = suite.toLowerCase();
    }
    if(this.suite==null) this.suite="nullSuite";
  }
  public int getValue() {
    if (value <= 10 || value == 14)return value;

    else return 10;
  }
  public String getSuite() {
    return suite;
  }
  public String getCard(){

    return getValue() + "\t" + getSuite();
  }
  @Override
  public String toString(){
    String valuestr = getValue()+"";
    if(getValue()==1 || getValue()==14) valuestr = "Ace";
    else if(getValue()==11) valuestr="Jack";
    else if(getValue()==12) valuestr="Queen";
    else if(getValue()==13) valuestr="King";


    return  valuestr+ " of " + getSuite();
  }
}
