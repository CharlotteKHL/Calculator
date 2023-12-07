package application;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestCalcController {

  private MockView testView;
  private CalcModel testModel;
  private CalcController testCalc;
  
  //Initialise Variables
  @BeforeEach
  void initialise() {
    testView = new MockView();
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
  
  //Test3
  @Test
  void testObserverSet() {
    assertNotNull(testView.evaluateMethodToBeNotified, "Test evaluate method set");
    assertNotNull(testView.setTypeToBeNotified, "Test type change method set");
  }

  //Test4
  @Test
  void testSimpleCalculation() {
    testView.evaluateMethodToBeNotified.run();
    assertEquals("4.0", testView.answer, "Test 2 + 2 = 4");
  }


}
