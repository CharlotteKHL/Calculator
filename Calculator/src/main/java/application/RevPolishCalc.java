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
    
    for (int i = 0; i < calculation.length(); i++) {
      
      String temp = calculation.substring(i, i + 1);
      switch(temp) {
        case "+":
          break;
        case " ":
          break;
        default:
          total = total + Integer.valueOf(temp);
          break;
      }
    }
    return total;
  }

}
