package application;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TestCalcController {

  //Test1
  @Test
  void testConstructor() {
    CalcView testView = new CalcView();
    CalcModel testModel = new CalcModel();
    CalcController testCalc = new CalcController(testModel, testView);
    assertNotNull(testCalc);
  }

}
