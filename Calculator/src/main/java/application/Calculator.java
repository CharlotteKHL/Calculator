package application;

/**
 * A calculator capable of decoding a String as an arithmetic expression and evaluating the answer.
 */
public interface Calculator {

  /**
   * Does an actual calculation to evaluate a given expression. The calculation depends on the value
   * of the infix parameter which can be True to indicate that an INFOX expression with brackets is
   * to be evaluated, like standard arithmetic. If the infix parameter is FALSE then the calculator
   * treats the expression as a reverse polish expression and does the calculation. In either case a
   * badly formed expression is notified to the caller by throwing an exception.
   * 
   * @param expression the question to be answered
   * @param infix how to evaluate the question: true means infix, false means reverse polish
   * @return the calculated value
   * @throws InvalidExpression when the expression cannot be evaluated
   */
  public float evaluate(String expression, Boolean infix) throws InvalidExpression;
}
