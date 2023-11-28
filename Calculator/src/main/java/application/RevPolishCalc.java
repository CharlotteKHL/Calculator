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
          for (int j = 0; j < numCount; j++) {
            total = total + stack.pop();
          }
          break;
        default:
          stack.push(Integer.valueOf(list[i]));
          numCount++;
          break;
      }
      
    }
    return total;
  }

}
