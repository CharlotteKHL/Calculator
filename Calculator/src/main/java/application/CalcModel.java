package application;

/**
 * Evaluates an expression - the evaluation can be Standard (infix) or reverse polish.
 * 
 * @author Charlotte Lam
 */
public class CalcModel implements Calculator {

  private StandardCalc standardCalc = new StandardCalc();
  private RevPolishCalc revPolishCalc = new RevPolishCalc();

  /**
   * Evaluates an expression in Standard or Reverse polish form.
   * 
   * @param expression is the expression to be evaluated
   * @param infix is true if calculation done in Standard form, false if in Reverse polish form
   * @return the answer to evaluating the expression
   */
  @Override
  public float evaluate(String expression, Boolean infix)
      throws InvalidExpressionException, BadTypeException, EmptyStackException {

    float answer;

    if (infix) {
      answer = standardCalc.evaluate(expression);
    } else {
      answer = revPolishCalc.evaluate(expression);
    }

    return answer;
  }
}
