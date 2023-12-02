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
  void testEvaluateRPE() throws InvalidExpressionException {
    assertEquals(5f, testCalc.evaluate("0 5 +", false), "Test 0 + 5 = 5 in Reverse Polish form");
  }

}
