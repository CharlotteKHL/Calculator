package application;

/**
 * The controller that sits between the calculator model that does actual evaluation and the view
 * that is the part the user interfaces with.
 */
public class CalcController {
  private CalcModel myModel;
  private ViewInterface myView;
  private static boolean isInfix = false;

  private void handleCalculation() {
    myView.setErrorMessage("");
    
    String expression = myView.getExpression();
    try {
      float answer = myModel.evaluate(expression, isInfix);
      myView.setAnswer("" + answer);
    } catch (InvalidExpressionException e) {
      myView.setErrorMessage(e.getMessage());
    } 
    catch (EmptyStackException e) {
      myView.setErrorMessage(e.getMessage());
    } 
    catch (BadTypeException e) {
      e.printStackTrace();
    } 

  }

  private void handleTypeChange(OpType typeOfCalc) {
    if (typeOfCalc == OpType.REV_POLISH) {
      isInfix = false;
    } else if (typeOfCalc == OpType.STANDARD) {
      isInfix = true;
    }
  }

  CalcController(CalcModel model, ViewInterface view) {
    myModel = model;
    myView = view;
    
    myView.addCalculateObserver(this::handleCalculation);
    myView.addTypeObserver(this::handleTypeChange);

  }
  
  public CalcModel getModel() {
    return myModel;
  }
  
  public ViewInterface getView() {
    return myView;
  }

  public static boolean getOpType() {
    return isInfix;
  }

  
}
