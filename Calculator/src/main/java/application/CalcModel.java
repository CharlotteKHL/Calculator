package application;

/**
 * Evaluates an expression - the evaluation can be Standard (infix) or reverse polish.
 */
public class CalcModel implements Calculator {
  @Override
  public float evaluate(String expression, Boolean infix) 
      throws InvalidExpressionException, BadTypeException, EmptyStackException {
    RevPolishCalc calculator = new RevPolishCalc();
    return calculator.evaluate(expression);
  }
}
