package application;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestCalcModel {
  
  private CalcModel testCalc;

  //Test1
  @BeforeEach
  void testConstructor() {
    testCalc = new CalcModel();
  }
  
  //Test2
  @Test
  void testEvaluateRPE() throws InvalidExpressionException, BadTypeException, EmptyStackException {
    assertEquals(5f, testCalc.evaluate("0 5 +", false), "Test 0 + 5 = 5 in Reverse Polish form");
  }
  
  //Test3
  @Test
  void testEvaluateManyRPE() throws InvalidExpressionException, BadTypeException, EmptyStackException {
    assertEquals(5f, testCalc.evaluate("0 5 +", false), "Test 0+5 = 5 in Reverse Polish form");
    assertEquals(2f, testCalc.evaluate("10 5 /", false), "Test 10/5 = 2 in Reverse Polish form");
    assertEquals(15f, testCalc.evaluate("3 5 *", false), "Test 3*5 = 15 in Reverse Polish form");
    assertEquals(7f, testCalc.evaluate("10 3 -", false), "Test 10-3 = 10 in Reverse Polish form");
  
    assertEquals(29f, testCalc.evaluate("3 7 + 2 / 5 * 6 8 - 2 * -", false), "Test (5((3+7)/2)) - 2(6-8) = 29");
  }
  
  //Test4
  @Test
  void invalidRevPolishExpression() throws InvalidExpressionException, BadTypeException, EmptyStackException {
    InvalidExpressionException e = assertThrows(InvalidExpressionException.class, () -> testCalc.evaluate("------ +", false));
    assertEquals(e.getMessage(), "Error: Current input contains invalid characters, please only use *,/,+,-");
  
    EmptyStackException E = assertThrows(EmptyStackException.class, () -> testCalc.evaluate("2 + 2 + 4", false));

  }

}
