package application;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TestStandardCalc {

  //Test1
  @Test
  void testConstructor() {
    StandardCalc testCalc = new StandardCalc();
    assertNotNull(testCalc);
  }

}
