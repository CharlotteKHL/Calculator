package application;

/**
 * The controller that sits between the calculator model that does actual evaluation and the view
 * that is the part the user interfaces with.
 * 
 * @author Charlotte Lam
 */
public class CalcController {
  private CalcModel myModel;
  private ViewInterface myView;
  private static boolean isInfix = false;

  /**
   * Runs when an expression needs to be evaluated from the View.
   * 
   */
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

  /**
   * Runs when the View changes calculation type.
   * 
   * @param typeOfCalc is the type of calculator the View is now using
   */
  private void handleTypeChange(OpType typeOfCalc) {
    if (typeOfCalc == OpType.REV_POLISH) {
      isInfix = false;
    } else if (typeOfCalc == OpType.STANDARD) {
      isInfix = true;
    }
  }

  /**
   * Constructor for CalcController.
   * 
   * @param model is the model called to evaluate expression in the MVC pattern
   * @param view is the view being observed and displaying results in the MVC pattern
   */
  CalcController(CalcModel model, ViewInterface view) {
    myModel = model;
    myView = view;
    
    myView.addCalculateObserver(this::handleCalculation);
    myView.addTypeObserver(this::handleTypeChange);

  }
  
  /**
   * Getter for the model the controller is using.
   * 
   * @return the model the controller is using
   */
  public CalcModel getModel() {
    return myModel;
  }
  
  /**
   * Getter for the view the controller is using.
   * 
   * @return the view the controller is using
   */
  public ViewInterface getView() {
    return myView;
  }

  /**
   * Getter for the type of calculation the controller is using.
   * 
   * @return true if in standard form, false if in reverse polish form
   */
  public static boolean getOpType() {
    return isInfix;
  }

  
}
