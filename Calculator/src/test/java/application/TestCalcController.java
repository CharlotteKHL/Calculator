package application;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestCalcController {

  private CalcView testView;
  private CalcModel testModel;
  private CalcController testCalc;
  
  //Initialise Variables
  @BeforeEach
  void initialise() {
    testView = new CalcView();
    testModel = new CalcModel();
    testCalc = new CalcController(testModel, testView);
  }
  
  //Test1
  @Test
  void testConstructor() {
    assertNotNull(testCalc);
  }
  
  //Test2
  @Test
  void testParameterSet() {
    assertNotNull(testCalc.getModel(), "Test CalcModel defined");
    assertNotNull(testCalc.getView(), "Test CalcView defined");
  }

}
