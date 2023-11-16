package application;

/**
 * The controller that sits between the calculator model that does actual evaluation and the view
 * that is the part the user interfaces with.
 */
public class CalcController {
  private CalcModel myModel;
  private ViewInterface myView;

  private void handleCalculation() {}

  private void handleTypeChange() {}

  CalcController(CalcModel model, ViewInterface view) {}
}
