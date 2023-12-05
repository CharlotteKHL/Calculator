package application;

/**
 * The controller that sits between the calculator model that does actual evaluation and the view
 * that is the part the user interfaces with.
 */
public class CalcController {
  private CalcModel myModel;
  private ViewInterface myView;
  private boolean isInfix = false;

  private void handleCalculation() {}

  private void handleTypeChange() {}

  CalcController(CalcModel model, ViewInterface view) {
    myModel = model;
    myView = view;
  }
  
  public CalcModel getModel() {
    return myModel;
  }
  
  public ViewInterface getView() {
    return myView;
  }

  
}
