package application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Random;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Test class for Entry object.
 * 
 * @author Charlotte Lam
 */
class TestEntry {

  private static Entry number;
  private static Entry numberCopy;
  private static Entry string;
  private static Entry stringCopy;
  private static Entry symbol;
  private static Entry symbolCopy;
  private static float rdNum;
  private static String rdStr;
  private static Symbol rdSym;

  /*
   * Test1 create a new Entry with a float, symbol and string. Modified to use as initialisation for
   * other tests. 
   * Constructors for a float, symbol and string created here.
   */

  @BeforeAll
  static void testNewEntry() {
    Random rd = new Random();

    rdNum = rd.nextFloat();
    number = new Entry(rdNum);
    numberCopy = new Entry(rdNum);

    rdStr = "Hello";
    rdStr = rdStr.substring(0, rd.nextInt(5));
    string = new Entry(rdStr);
    stringCopy = new Entry(rdStr);

    Symbol[] listSymbol = Symbol.values();
    rdSym = listSymbol[rd.nextInt(6)];
    symbol = new Entry(rdSym);
    symbolCopy = new Entry(rdSym);

  }

  /*
   * Test2 check initialisation of fields number, str, other and type with getters returning
   * expected values. Getters coded to return values that was expected.
   * 
   * Modified Test1 and Test2 to test for multiple values using random numbers, strings and symbols
   * for initialisation. 
   * Fields made and initialised in constructors, with getters returning fields.
   */

  @Test
  void testGetters() throws BadTypeException {

    assertEquals(rdNum, number.getValue(), "Number is equal");
    assertEquals(rdStr, string.getString(), "String is equal");
    assertEquals(rdSym, symbol.getSymbol(), "Symbol is equal");

    assertEquals(Type.NUMBER, number.getType(), "Type is number");
    assertEquals(Type.STRING, string.getType(), "Type is string");
    assertEquals(Type.SYMBOL, symbol.getType(), "Type is symbol");
  }

  /*
   * Test3 check for a BadTypeException thrown when types do not match in getters. 
   * If statements used to check for same type.
   */

  @Test
  void testBadTypeException() {
    BadTypeException e = assertThrows(BadTypeException.class, () -> number.getString());
    assertEquals(e.getMessage(), "Error: The entry is not of this type",
        "Getters exception message correct");

    assertThrows(BadTypeException.class, () -> number.getSymbol(),
        "Throw exception, number != symbol");

    assertThrows(BadTypeException.class, () -> symbol.getValue(),
        "Throw exception, symbol != String");
  }

  /*
   * Test4 hashCode and Equals true if both the type and value are the same. Test1 edited to
   * initialise copies to use for comparison. 
   * Equals returns true. 
   * hashCode auto-generated using eclipse.
   */

  @Test
  void testEqual() {
    assertEquals(true, symbol.equals(symbolCopy), "symbol = symbolCopy");

    assertEquals(true, number.equals(numberCopy), "number = numberCopy");

    assertEquals(true, string.equals(stringCopy), "string = stringCopy");

    assertEquals(symbol.hashCode(), symbolCopy.hashCode(),
        "Hashcode determines symbol = symbolCopy");
  }

  // Test5 extends Test4, hashCode and Equals false cases. Equals auto-generated using eclipse.


  @Test
  void testEqualsFalse() {
    Entry notEqual = new Entry(5.3f);
    assertEquals(false, notEqual.equals(symbol), "number != symbol");

    notEqual = new Entry("Hi");
    assertEquals(false, notEqual.equals(number), "string != number");

    notEqual = new Entry(Symbol.LEFT_BRACKET);
    assertEquals(false, notEqual.equals(string), "symbol != string");

    assertEquals(false, notEqual.equals(null), "Entry != null");
    assertEquals(false, notEqual.equals(21), "Entry != int, type not the same");

  }


  /*
   * Test6 check toString methods for enums Symbol and Type, and Entry classes print as expected.
   * toString() methods added in enums and Entry to override default. 
   * Returns message that is expected.
   */

  @Test
  void testPrint() {
    Type printType = Type.SYMBOL;
    assertEquals("Type: Symbol", printType.toString(), "Print Type SYMBOL correctly");

    Symbol printSymbol = Symbol.DIVIDE;
    assertEquals("Symbol: Divide", printSymbol.toString(), "Print Symbol DIVIDE correctly");

    Entry printEntry = new Entry(Symbol.DIVIDE);
    assertEquals("Type: Symbol, Symbol: Divide", printEntry.toString(), "Print Entry correctly");

  }

  /*
   * Test7 extends Test6 and tests all values print as expected for all Types and Symbols. 
   * toString() methods changed to use fields to print formatted message for any Type and Symbol.
   */
  
  @Test
  void testPrintRandom() {
    Type printTypeNumber = Type.NUMBER;
    assertEquals("Type: Number", printTypeNumber.toString(), "Print Type NUMBER correctly");
    Type printTypeString = Type.STRING;
    assertEquals("Type: String", printTypeString.toString(), "Print Type STRING correctly");

    String symbolPrint = "";
    switch (rdSym) {
      case DIVIDE:
        symbolPrint = "Divide";
        break;
      case TIME:
        symbolPrint = "Multiply";
        break;
      case MINUS:
        symbolPrint = "Minus";
        break;
      case PLUS:
        symbolPrint = "Plus";
        break;
      case LEFT_BRACKET:
        symbolPrint = "Left bracket";
        break;
      case RIGHT_BRACKET:
        symbolPrint = "Right bracket";
        break;
      case INVALID:
        symbolPrint = "Invalid";
        break;
      default:
        break;
    }
    assertEquals("Symbol: " + symbolPrint, rdSym.toString(), "Print a random Symbol correctly");

  }
  
  /*
   * Test8 tests any Entry is printed correctly.
   * Initially tested for a symbol, returned message expected
   * Modified Test8 to test for other Entry types.
   */
  
  @Test
  void testPrintRandomEntry() throws BadTypeException {
    
    assertEquals(symbol.getType() + ", " + symbol.getSymbol(), symbol.toString(),
        "Print a random Symbol Entry correctly");
    
    assertEquals(number.getType() + ", Value: " + number.getValue(), number.toString(), 
        "Print a random number Entry correctly");
    assertEquals(string.getType() + ", String: " + string.getString(), string.toString(), 
        "Print a random string Entry correctly");
    
  }

}