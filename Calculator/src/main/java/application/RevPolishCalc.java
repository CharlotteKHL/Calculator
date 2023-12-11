package application;

/**
 * Calculator responsible for handling calculations in Reverse Polish form.
 */
public class RevPolishCalc {

  private NumStack stack = new NumStack();
  private static final String EMPTY_CALCULATION_EXCEPTION = 
      "Error: Current input contains too many empty spaces, "
      + "please leave one space between numbers and symbols";
  private static final String INVALID_SYMBOL_EXCEPTION = 
      "Error: Current input contains invalid characters, please only use *,/,+,-";
  private static final String DIVIDE_BY_ZERO_EXCEPTION = 
      "Error: Current input divides by 0";
  private static final String NULL_EXCEPTION = 
      "Error: Current input is null";
  
  /**
   * Evaluates a calculation in Reverse Polish form.
   * 
   * @param calculation the string to be evaluated
   * @return float value of result of calculation
   * @throws BadTypeException thrown if value getter called for stack does not match type
   * @throws EmptyStackException thrown if pop or top called on an empty stack
   * @throws InvalidExpressionException if parameter includes an invalid symbol, 
   *     character or is empty
   */
  public float evaluate(String calculation) 
      throws BadTypeException, EmptyStackException, InvalidExpressionException {
    
    if (calculation == null) {
      throw new InvalidExpressionException(NULL_EXCEPTION);
    }
    
    while (stack.size() != 0) {
      stack.pop();
    }
    
    String[] list = calculation.split(" ");
    
    for (int index = 0; index < list.length; index++) {
      
      switch(list[index]) {
        
        case "+":
          add();
          break;
          
        case "-":
          minus();
          break;
          
        case "*":
          multiply();
          break;
          
        case "/":
          divide();
          break;
          
        case "":
          throw new InvalidExpressionException(EMPTY_CALCULATION_EXCEPTION);
          
        default:
          
          for (int j = 0; j < list[index].length(); j++) {
            
            if (!((list[index].charAt(j) >= '0') && (list[index].charAt(j) <= '9'))) {
              throw new InvalidExpressionException(INVALID_SYMBOL_EXCEPTION);
            }
          }
          
          stack.push(Integer.valueOf(list[index]));
          break;
      }
      
    }
    return stack.pop();
  }
  
  /**
   * Pushes the result of adding the top two values on the stack.
   * 
   * @throws BadTypeException thrown if value getter called for stack does not match type
   * @throws EmptyStackException thrown if pop or top called on an empty stack
   */
  public void add() throws BadTypeException, EmptyStackException {
    float tempAdd = stack.pop() + stack.pop();
    stack.push(tempAdd);
  }
  
  /**
   * Pushes the result of the top value on the stack taken away from the value before it.
   * 
   * @throws BadTypeException thrown if value getter called for stack does not match type
   * @throws EmptyStackException thrown if pop or top called on an empty stack
   */
  public void minus() throws BadTypeException, EmptyStackException {
    float secondMinus = stack.pop();
    float firstMinus = stack.pop();
    stack.push(firstMinus - secondMinus);
  }
  
  /**
   * Pushes the result of multiplying the top two values on the stack to the stack.
   * 
   * @throws BadTypeException thrown if value getter called for stack does not match type
   * @throws EmptyStackException thrown if pop or top called on an empty stack
   */
  public void multiply() throws BadTypeException, EmptyStackException {
    float tempMultiply = stack.pop() * stack.pop();
    stack.push(tempMultiply);
  }
  
  /**
   * Pushes the result of dividing the value before the top value on the stack by the top value.
   * 
   * @throws BadTypeException thrown if value getter called for stack does not match type
   * @throws EmptyStackException thrown if pop or top called on an empty stack
   */
  public void divide() throws InvalidExpressionException, BadTypeException, EmptyStackException {
    float secondDivide = stack.pop();
    float firstDivide = stack.pop();
    if (secondDivide == 0) {
      throw new InvalidExpressionException(DIVIDE_BY_ZERO_EXCEPTION);
    }
    stack.push(firstDivide / secondDivide);
  }

}
