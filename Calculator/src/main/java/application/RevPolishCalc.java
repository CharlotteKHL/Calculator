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
  
  public void add() throws BadTypeException, EmptyStackException{
    float tempAdd = stack.pop() + stack.pop();
    stack.push(tempAdd);
  }
  
  public void minus() throws BadTypeException, EmptyStackException{
    float secondMinus = stack.pop();
    float firstMinus = stack.pop();
    stack.push(firstMinus - secondMinus);
  }
  
  public void multiply() throws BadTypeException, EmptyStackException{
    float tempMultiply = stack.pop() * stack.pop();
    stack.push(tempMultiply);
  }
  
  public void divide() throws BadTypeException, EmptyStackException{
    float secondDivide = stack.pop();
    float firstDivide = stack.pop();
    stack.push(firstDivide / secondDivide);
  }

}
