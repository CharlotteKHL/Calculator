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
  public float evaluate(String calculation) {
    float total = 0;
    String[] list = calculation.split(" ");
    
    for (int i = 0; i < list.length; i++) {
      
      switch(list[i]) {
        case "+":
          break;
        default:
          total = total + Integer.valueOf(list[i]);
          break;
      }
      
    }
    return total;
  }

}
