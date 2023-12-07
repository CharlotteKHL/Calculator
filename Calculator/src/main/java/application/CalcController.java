package application;

/**
 * The controller that sits between the calculator model that does actual evaluation and the view
 * that is the part the user interfaces with.
 */
public class CalcController {
  private CalcModel myModel;
  private ViewInterface myView;
  private boolean isInfix = false;

  private void handleCalculation() {
    String expression = myView.getExpression();
    try {
      float answer = myModel.evaluate(expression, isInfix);
      myView.setAnswer("" + answer);
    } catch (InvalidExpressionException e) {
      e.printStackTrace();
    } 
    catch (EmptyStackException e) {
      e.printStackTrace();
    } 
    catch (BadTypeException e) {
      e.printStackTrace();
    } 

  }

  private void handleTypeChange(OpType typeOfCalc) {}

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

  
}
