package application;

/**
 * Evaluates an expression - the evaluation can be Standard (infix) or reverse polish.
 */
public class CalcModel implements Calculator {

  private StandardCalc standardCalc = new StandardCalc();
  private RevPolishCalc revPolishCalc = new RevPolishCalc();
  
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
