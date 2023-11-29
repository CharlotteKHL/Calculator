package application;

/**
 * Calculator responsible for handling calculations in Reverse Polish form.
 */
public class RevPolishCalc {

  /**
   * Evaluates a calculation in Reverse Polish form.
   * 
   * @param calculation the string to be evaluated
   * @return float value of result of calculation
   */
  public float evaluate(String calculation) throws BadTypeException, EmptyStackException {
    
    float total = 0;
    int numCount = 0;
    String[] list = calculation.split(" ");
    NumStack stack = new NumStack();
    
    for (int i = 0; i < list.length; i++) {
      
      switch(list[i]) {
        
        case "+":
          float tempAdd = stack.pop() + stack.pop();
          stack.push(tempAdd);
          numCount = numCount - 2;
          break;
          
        case "-":
          
          float secondMinus = stack.pop();
          float firstMinus = stack.pop();
          stack.push(firstMinus-secondMinus);
          break;
          
        case "*":
          float tempMultiply = stack.pop() * stack.pop();
          stack.push(tempMultiply);
          break;
          
        case "/":
          
          float secondDivide = stack.pop();
          float firstDivide = stack.pop();
          stack.push(firstDivide / secondDivide);
          break;
          
        default:
          stack.push(Integer.valueOf(list[i]));
          numCount++;
          break;
      }
      
    }
    return stack.pop();
  }

}
