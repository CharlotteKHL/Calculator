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
    testView.setTypeToBeNotified.accept(OpType.REV_POLISH);
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
    assertEquals("4.00", testView.answer, "Test 2 + 2 = 4");
  }
  
  //Test5
  @Test
  void testManyCalculate() {
    testView.question = "2 3 +";
    testView.evaluateMethodToBeNotified.run();
    assertEquals("5.00", testView.answer, "Test 2 + 3 = 5");
    
    testView.question = "8 4 /";
    testView.evaluateMethodToBeNotified.run();
    assertEquals("2.00", testView.answer, "Test 8/4 = 2");
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
  
  //Test8
  @Test
  void testEmptyStack() {
    testView.question = "2 + 2";
    testView.evaluateMethodToBeNotified.run();
    assertEquals(testView.errorMessage, "Error: Not enough numbers to calculate with. Please check you are in the right calculation mode");
    
  }
  
  //Test9
  @Test
  void testDivideByZero() {
    testView.question = "2 0 /";
    testView.evaluateMethodToBeNotified.run();
    assertEquals(testView.errorMessage, "Error: Current input divides by 0");
    
  }
  
  //Test10
  @Test
  void testCalculationTypeChange() {
    testView.setTypeToBeNotified.accept(OpType.REV_POLISH);
    assertEquals(CalcController.getOpType(), false);

    testView.setTypeToBeNotified.accept(OpType.STANDARD);
    assertEquals(CalcController.getOpType(), true);

  }




}
