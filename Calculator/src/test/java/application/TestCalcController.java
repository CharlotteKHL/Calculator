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
  
  //Test5
  @Test
  void testManyCalculate() {
    testView.question = "2 3 +";
    testView.evaluateMethodToBeNotified.run();
    assertEquals("5.0", testView.answer, "Test 2 + 3 = 5");
    
    testView.question = "8 4 /";
    testView.evaluateMethodToBeNotified.run();
    assertEquals("2.0", testView.answer, "Test 8/4 = 2");
  }
  
  //Test6
  @Test
  void testInvalidExpression() {
    testView.question = "";
    testView.evaluateMethodToBeNotified.run();
    assertEquals(testView.errorMessage, "Error: Current input contains too many empty spaces, please leave one space between numbers and symbols");

    testView.question = "Hello +";
    testView.evaluateMethodToBeNotified.run();
    assertEquals(testView.errorMessage, "Error: Current input contains invalid characters, please only use *,/,+,-");

  }
  
  //Test7
  @Test
  void testNullExpression() {
    testView.question = null;
    testView.evaluateMethodToBeNotified.run();
    assertEquals(testView.errorMessage, "Error: Current input is null");
  
  }



}
