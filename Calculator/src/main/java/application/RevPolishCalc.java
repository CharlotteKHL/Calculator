package application;

/**
 * Calculator responsible for handling calculations in Reverse Polish form.
 */
public class RevPolishCalc {

  NumStack stack = new NumStack();
  
  /**
   * Evaluates a calculation in Reverse Polish form.
   * 
   * @param calculation the string to be evaluated
   * @return float value of result of calculation
   */
  public float evaluate(String calculation) throws BadTypeException, EmptyStackException {
    
    String[] list = calculation.split(" ");
    
    for (int i = 0; i < list.length; i++) {
      
      switch(list[i]) {
        
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
          
        default:
          stack.push(Integer.valueOf(list[i]));
          break;
      }
      
    }
    return stack.pop();
  }
  
  /**
   * Pushes the result of adding the top two values on the stack.
   * 
   * @throws BadTypeException thrown if value getter called for stack does not match type
   * @throws EmptyStackException thrown if pop called on an empty stack
   */
  public void add() throws BadTypeException, EmptyStackException {
    float tempAdd = stack.pop() + stack.pop();
    stack.push(tempAdd);
  }
  
  /**
   * Pushes the result of the top value on the stack taken away from the value before it.
   * 
   * @throws BadTypeException thrown if value getter called for stack does not match type
   * @throws EmptyStackException thrown if pop called on an empty stack
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
   * @throws EmptyStackException thrown if pop called on an empty stack
   */
  public void multiply() throws BadTypeException, EmptyStackException {
    float tempMultiply = stack.pop() * stack.pop();
    stack.push(tempMultiply);
  }
  
  /**
   * Pushes the result of dividing the value before the top value on the stack by the top value.
   * 
   * @throws BadTypeException thrown if value getter called for stack does not match type
   * @throws EmptyStackException thrown if pop called on an empty stack
   */
  public void divide() throws BadTypeException, EmptyStackException {
    float secondDivide = stack.pop();
    float firstDivide = stack.pop();
    stack.push(firstDivide / secondDivide);
  }

}
