package application;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestRevPolishCalc {
  private RevPolishCalc testCalc;

  //Test1
  @BeforeEach
  void testConstructor() {
    testCalc = new RevPolishCalc();
  }
  
  //Test2
  @Test
  void testEvaluate() {
    assertEquals(5, testCalc.evaluate("0 5"));
  }

}
